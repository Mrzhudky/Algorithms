package com.elasticcloudservice.predict;

/**
 * @Description：三次指数平滑
 * @Author: zhudky
 * @Date: 2018/4/11 21:55
 * @Version: 1.0.
 */

import java.util.ArrayList;


public class TripleExpMovingAverage {
    private Flavor flavor; //存放训练数据信息的对象
    private double learningRate; //学习率
    private int thetaNum = 0; //系数的个数
    //    private ArrayList<Double> theta = new ArrayList<Double>();
    private double alphaStart; //起始平滑系数
    //    private int dataNum = 0; //系数的个数
    public ArrayList<Integer> preData = new ArrayList<>();
    //    private int preData;
    private ArrayList<Integer> tripleExpData = new ArrayList<>();
    private int[] S0 = new int[7];
    private int[] S1 = new int[7];
    private int[] S2 = new int[7];
    private int[] S3 = new int[7];
    private double[] alphas = new double[7];//平滑系数

    public TripleExpMovingAverage(Flavor flavor,double learnRate){
        this.learningRate = learnRate;
        this.flavor = flavor;
        this.thetaNum = flavor.getDataLength() -7;
        alphaStart = 0.01;

        for (int i = 0; i < thetaNum; i++) {
            tripleExpData.add(0);
        }

        int len =0;
        if(flavor.getDataLength() > 140){
            len = 140;
        }else{
            len = flavor.getDataLength();
        }
        for (int i = 0; i < 7; i++) {
            alphas[i] = alphaStart;
            int sum = 0;
            int tempDayNum = 0;
            for (int j = i; j < len; j+=7) {
                sum += flavor.getTraData(j);
                tempDayNum++;
            }
            S0[i] = sum/tempDayNum;
        }
    }

    /**
     * 更新一次、二次、三次预估值St1、St2、St3
     * */
    private void UpdateThreeExpData(int index){

        double lastSingleExp = S0[index];
        double lastDoubleExp = S0[index];
        double lastTripleExp = S0[index];
        double tempDouble;
        int tempInteger = 0;

        for (int j = index; j < thetaNum; j = j+7) {
            tempDouble = alphas[index] * flavor.getTraData(j) + (1.0 - alphas[index]) * lastSingleExp;
            lastSingleExp = tempDouble;
            tempDouble = alphas[index] * lastSingleExp + (1.0 - alphas[index]) * lastDoubleExp;
            lastDoubleExp = tempDouble;
            tempDouble = alphas[index] * lastDoubleExp + (1.0 - alphas[index]) * lastTripleExp;
            lastTripleExp = tempDouble;
            tempInteger = (int) Math.round(tempDouble);
            tripleExpData.set(j, tempInteger);
        }
        S1[index] = (int) Math.round(lastSingleExp);
        S2[index] = (int) Math.round(lastDoubleExp);
        S3[index] = tempInteger;
    }

    /**
     *  代价函数, 求均方误差  JAlpha
     * @return double:代价函数的值，即建模误差
     * */
    private double CostFunction(int index){
        double JAlpha;
        double sum = 0;
        int temp;
        int tempDayNum = 0;
        for (int i = index; i < thetaNum; i+=7) {
            temp = tripleExpData.get(i) - flavor.getTraData(i+7);
            sum += temp*temp;
            tempDayNum ++;
        }
        JAlpha = sum / tempDayNum;
        return JAlpha;
    }

    private void UpDataAlpha(int index){
        double minJ = 10;
        double minAlphas = 0;
        int minS1 = 0;
        int minS2 = 0;
        double nextJ = 0;
        for (double i = alphaStart; i < 1.0; i+=learningRate) {
            alphas[index] = i;
            UpdateThreeExpData(index);
            nextJ = CostFunction(index);
            if(minJ > nextJ){
                minJ = nextJ;
                minAlphas = i;
                minS1 = S1[index];
                minS2 = S2[index];
            }
        }
        alphas[index] = minAlphas;
        S1[index] = minS1;
        S2[index] = minS2;
    }

    public void FindAlpha(double alpha)
    {
        alphaStart = alpha;
        for (int i = 0; i < 7 ; i++) {
            UpDataAlpha(i);
        }
    }

    /**
     * 描述: 在算出系数 theta 后，预测接下来一天的数量，
     *       若需预测多天，每次将新预测的数据加在原数据末尾作为已知数据。
     * @param day:需要预测的天数
     * */
    public void Prediction(int day){
        if(day<1){
            System.out.println("input day number is wrong!");
        }
        int preD = 0;
        for (int i = 0; i < day; i++) {
            double At,Bt,Ct;
            int index = i%7;

            At = 3*S1[index] - 3*S2[index] + S3[index];
            Bt = (alphas[index]/(2*(1-alphas[index])*(1-alphas[index]))) * ( (6-5*alphas[index])*S1[index] - 2*(5-4*alphas[index])*S2[index] + (4-3*alphas[index])*S3[index]);
            Ct = (alphas[index]*alphas[index]/(2*(1-alphas[index])*(1-alphas[index])))*(S1[index]-2*S2[index] + S3[index]);
            double preX = At + Bt + Ct;
            preD = (int) Math.round(preX);
            System.out.print(preD);
            preData.add(preD);

            double tempDouble;
            tempDouble = alphas[index] * preD + (1.0 - alphas[index]) * S1[index];
            S1[index] = (int) Math.round(tempDouble);
            tempDouble = alphas[index] * tempDouble + (1.0 - alphas[index]) * S2[index];
            S2[index] = (int)Math.round(tempDouble);
            tempDouble = alphas[index] * tempDouble + (1.0 - alphas[index]) * S3[index];
            S3[index] = (int)Math.round(tempDouble);
        }

    }

    int getEscTotalNumber(){
//		return preData;
        int totalNum = 0;
        for (int i = 0; i < preData.size(); i++) {
            totalNum += preData.get(i);
        }
        return totalNum;
    }

    String resultToString() {
        return flavor.getName() + ": " + getEscTotalNumber();
    }
}

