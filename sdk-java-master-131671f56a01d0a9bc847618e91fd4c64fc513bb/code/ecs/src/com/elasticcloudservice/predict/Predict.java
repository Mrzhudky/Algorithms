package com.elasticcloudservice.predict;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Predict {



    public static String[] predictVm(String[] ecsContent, String[] inputContent) {

        int cpuNumber;
        int  memorySize =0;
        int flavorNum = 1;
        int resourceFlag; //0--CPU 1--Memory
        int predictDays;


        List<String> history = new ArrayList<String>();

        //分离input文件数据
        String[] split = inputContent[0].split(" ");
        cpuNumber = Integer.valueOf(split[0]);
        memorySize = Integer.valueOf(split[1]);
        flavorNum = Integer.valueOf(inputContent[2]);

        memorySize *= 1024;

        Flavor[] flavor = new Flavor[flavorNum];

        for (int i = 0; i < flavorNum; i++) {
            flavor[i] = new Flavor();
            split = inputContent[i + 3].split(" ");
            if (inputContent[i + 3].contains(" ")&& inputContent[i + 3].split(" ").length == 3) {
                flavor[i].SetFlavorInfo(split[0], Integer.valueOf(split[1]), Integer.valueOf(split[2]));
            }
        }
        if (inputContent[flavorNum + 4].equals("CPU")) {
            resourceFlag = 0;
        } else {
            resourceFlag = 1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long preDay = 0;
        long curDay = 0;
        try {
            String str = inputContent[flavorNum + 6];
            preDay = simpleDateFormat.parse(str).getTime();
            str = inputContent[flavorNum + 7];
            curDay = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        predictDays = (int) (curDay - preDay) / (1000 * 60 * 60 * 24);

        //分离traData文件数据
        split = ecsContent[0].split("\\t");
        String previousTime = split[2];
        String currentTime;

        try {
            preDay = simpleDateFormat.parse(previousTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int k = 0;//第一天为0，每增加一天加一
        for (String anEcsContent : ecsContent) {
            split = anEcsContent.split("\\t");
            currentTime = split[2];
            try {
                curDay = simpleDateFormat.parse(currentTime).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int days = (int) (curDay - preDay) / (1000 * 60 * 60 * 24);
            preDay = curDay;
            if (days < 1) {
                for (int j = 0; j < flavorNum; j++) {
                    if (flavor[j].getName().equals(split[1])) {
                        int data = flavor[j].getTraData(k);
                        flavor[j].setTraData(k, data + 1);
                        break;
                    }
                }
            } else {
                while (days > 0) {
                    k++;
                    for (int j = 0; j < flavorNum; j++) {
                        flavor[j].addTraData(0);
                    }
                    days--;
                }
            }
        }

        //预测
        history.add("1");
        int totalNum = 0;
        TripleExpMovingAverage[] linRegs = new TripleExpMovingAverage[flavorNum];
        for (int i = 0; i < flavorNum; i++) {
            linRegs[i] = new TripleExpMovingAverage(flavor[i],0.01);
            for (int j = 0; j < 7; j++) {
                linRegs[i].FindAlpha(0.01);
            }
            linRegs[i].Prediction(predictDays);
            history.add(linRegs[i].resultToString());
            int tempNum = linRegs[i].getEscTotalNumber();
            totalNum += tempNum;
            flavor[i].setPreData(tempNum);
        }
//        history.add(String.valueOf(flavorNum));
//        LinearRegression[] linRegs = new LinearRegression[flavorNum];
//        for (int i = 0; i < flavorNum; i++) {
//            linRegs[i] = new LinearRegression(flavor[i],0.2);
//            linRegs[i].GradientDescent(100,0.00001);
//            linRegs[i].Prediction(predictDays);
//            history.add(linRegs[i].resultToString());
//            totalNum += flavor[i].getPreData();
//        }
        history.set(0,String.valueOf(totalNum));

        //排序

        //放置
        history.add("");//results[flavorNum] = "";

        int cpuNum = cpuNumber;
        int memSize = memorySize;
        int[] oneServer = new int[flavorNum];
        for (int i = 0; i < flavorNum; i++) {
            oneServer[i] = 0;
        }
        history.add("1");
        int ecsNum = 1;
        while (totalNum >0){
            for (int i= flavorNum-1; i >0; i--) {
                if((flavor[i].getPreData()>0) &&  (cpuNum>flavor[i].getCpuNumber())	&& (memSize>flavor[i].getMemorySize())){
                    oneServer[i] += 1;
                    totalNum--;
                    cpuNum -= flavor[i].getCpuNumber();
                    memSize -= flavor[i].getMemorySize();
                    int temp = flavor[i].getPreData();
                    flavor[i].setPreData(temp-1);
                    i = i+1;
                }
            }
            StringBuilder stringBuffer = new StringBuilder();
            stringBuffer.append(ecsNum);
            for (int j = 0; j < flavorNum; j++) {
                if(oneServer[j] != 0){
                    stringBuffer.append(" ");
                    stringBuffer.append(flavor[j].getName());
                    stringBuffer.append(" ");
                    stringBuffer.append(oneServer[j]);
                }
            }
            history.add(stringBuffer.toString());
            ecsNum++;
        }
        history.set(flavorNum+2,String.valueOf(ecsNum-1));

        //返回结果
        String[] results = new String[history.size()];
        for (int i = 0; i < history.size(); i++) {
            results[i] = history.get(i);
        }
        return results;
    }


}

