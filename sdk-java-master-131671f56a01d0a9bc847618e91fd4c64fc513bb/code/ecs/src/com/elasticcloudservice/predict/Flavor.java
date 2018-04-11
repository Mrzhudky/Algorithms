package com.elasticcloudservice.predict;

import java.util.ArrayList;

public class Flavor {
    private String name;
    private int cpuNumber;
    private int memorySize;
    private int preData;

    ArrayList<Integer> traDataList = new ArrayList<>();

    void setPreData(int preD){
        preData = preD;
    }
    public void SetFlavorInfo(String n,int cpuN,int memN){
        name = n;
        cpuNumber = cpuN;
        memorySize = memN;
        traDataList.add(0);
    }

    String getName(){
        return name;
    }
    int getPreData(){
        return preData;
    }
    int getCpuNumber(){
        return cpuNumber;
    }
    int getMemorySize(){
        return memorySize;
    }
    int getDataLength(){
        return traDataList.size();
    }

    int getTraData(int index){
        return traDataList.get(index);
    }
    void setTraData(int index,int data){
        traDataList.set(index,data);
    }
    void addTraData(int data){
        traDataList.add(data);
    }

    String preDataToString(){
        return name + " " + preData;
    }
}
