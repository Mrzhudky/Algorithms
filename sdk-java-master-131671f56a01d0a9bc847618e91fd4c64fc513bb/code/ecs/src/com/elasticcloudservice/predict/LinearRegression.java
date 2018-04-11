package com.elasticcloudservice.predict;

import java.util.ArrayList;

public
class LinearRegression {
    private Flavor flavor; //存放训练数据信息的对象
    private double learningRate; //学习率
    private int thetaNum = 0; //系数的个数
    private ArrayList<Double> theta = new ArrayList<Double>();

    public LinearRegression(Flavor flavor,double learnRate){
        this.learningRate = learnRate;
        this.flavor = flavor;
        this.thetaNum = flavor.getDataLength() -7;

        for (int i = 0; i < thetaNum; i++) {
            theta.add(0.1);
        }
    }

    /**
     *  描述:
     * < p >批量梯度下降法，迭代 iterativeNum 次<br>
     *      计算f(x) = theta_0 * x_0 + theta_1 * x_1 + ... + theta_n * x_n 的系数 theta_0、theta_1、...、theta_n
     * @param iterativeNum 迭代次数
     * */

    public void GradientDescent(int iterativeNum,double deviation){

        double lastJ = 0;
        double nextJ = 0;
        for (int i = 0; i < iterativeNum; i++) {
            lastJ = CostFunction();
            UpDataTheta();
            nextJ = CostFunction();
            if(lastJ < nextJ){
                learningRate *= -0.5;
            }
            if(nextJ<deviation){
                break;
            }
        }
    }

    /**
     *描述:
     *                          1    _     i     i  2
     *  求 代价函数  J_theta = --- * > (h(x  )- y  )
     *                         2*m   -
     * @return 代价函数的值，即建模误差
     */
    public double CostFunction(){
        double hx;
        double JTheta = 0;
        int m = flavor.getDataLength() - thetaNum;
        for (int j = 0; j < m; j++) {
            hx = 0;
            for (int i = 0; i < thetaNum; i++) {
                hx += theta.get(i) * flavor.getTraData(i+j);
            }
            double temp = hx - flavor.getTraData(j+thetaNum);
            JTheta += temp * temp;
        }

        JTheta = JTheta / (2*m);
        return JTheta;
    }

    /**
     * 描述：批量更新系数 theta_0 、theta_1 、...、theta_n
     *                           1    _
     * theta_j  = theta_j - a * --- * > ( h(x_i) - y_i)*x_ij
     *                           m    -
     */
    public void UpDataTheta(){
        double temp;
        double hx = 0;
        double sum = 0;
        double m = flavor.getDataLength() - thetaNum;
        ArrayList<Double> newTheta = new ArrayList<Double>();
        for (int i = 0; i < thetaNum; i++) {
            sum = 0;
            for (int k = 0; k < m; k++) {
                hx = 0;
                for (int j = 0; j < thetaNum; j++) {
                    hx += theta.get(j) * flavor.getTraData(k+j);
                }
                hx = hx - flavor.getTraData(k+thetaNum);
                sum += hx * flavor.getTraData(i+k);
            }
            temp = theta.get(i) + learningRate/m*sum;
            newTheta.add(temp);
        }
        theta.clear();
        theta = newTheta;
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
        int preNum = 0;
        double hx;
        int m;
        for(int j=0;j<day;j++) {
            hx=0;
            m = flavor.getDataLength() - thetaNum;
            for (int i = 0; i < thetaNum; i++) {
                hx += theta.get(i) * flavor.getTraData(m+i);
            }
            int preDay = (int)Math.round(hx);
            if(preDay<0){
                preDay = 0;
            }
            if(preDay>10){
                preDay = 10;
            }
            flavor.addTraData(preDay);
            preNum += preDay;
            System.out.print(preDay + " ");
        }
        flavor.setPreData(preNum);
    }



    String resultToString() {
        return flavor.getName() + " " + flavor.getPreData();
    }
}