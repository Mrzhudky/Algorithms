package com.company;

import java.util.ArrayList;

public class LinearRegression {
    private Flavor flavor; //存放训练数据信息的对象
    private double learningRate; //学习率
    private int thetaNum = 0; //系数的个数
    private ArrayList<Double> theta = new ArrayList<Double>();

    public LinearRegression(Flavor flavor){
        this.flavor = flavor;
        this.thetaNum = (flavor.dataLength/7-2)*7;

    }

    /*
    * @see 描述:
    * < p >批量梯度下降法，迭代 iterativeNum 次<br>
    *      计算f(x) = theta_0 * x_0 + theta_1 * x_1 + ... + theta_n * x_n 的系数 theta_0、theta_1、...、theta_n
    * @param 参数：
    * iterativeNum 迭代次数
    * */

    public void GradientDescent(int iterativeNum){
        double lastJ = 0;
        double nextJ = 0;
        for (int i = 0; i < iterativeNum; i++) {
            lastJ = CostFunction();
            UpDataTheta();
            nextJ = CostFunction();
            if(lastJ < nextJ){
                learningRate *= -1;
            }
        }
    }

    /*
    *@see 描述:
    *                          1    _     i     i  2
    *  求 代价函数  J_theta = --- * > (h(x  )- y  )
    *                         2*m   -
    * @return 代价函数的值，即建模误差
    * */
    public double CostFunction(){
        double hx = 0;
        double JTheta = 0;
        for (int j = thetaNum; j < flavor.dataLength; j++) {
            for (int i = j-thetaNum; i < j; i++) {
                hx += theta.get(i) * flavor.dataYAxis.get(i);
            }
            double temp = hx - flavor.dataYAxis.get(j);
            JTheta += temp * temp;
        }

        JTheta = JTheta / (2*flavor.dataLength);
        return JTheta;
    }

    /*
    * 描述：批量更新系数 theta_0 、theta_1 、...、theta_n
    *                           1    _
    * theta_j  = theta_j - a * --- * > ( h(x_i) - y_i)*x_ij
    *                           m    -
    * */
    public void UpDataTheta(){
        double temp;
        double hx = 0;
        double sum = 0;
        double m = flavor.dataLength - thetaNum;
        ArrayList<Double> newTheta = new ArrayList<Double>();
        for (int i = 0; i < thetaNum; i++) {
            sum = 0;
            for (int j = thetaNum; j < flavor.dataLength; j++) {
                hx = 0;
                for (int k = j-thetaNum; k < j; k++) {
                    hx += theta.get(k)*flavor.dataYAxis.get(k);
                }
                sum += hx - flavor.dataYAxis.get(j);
            }
            temp = theta.get(i) - learningRate/m*sum;
            newTheta.add(i,temp);
        }
        theta.clear();
        theta = newTheta;
    }

    /*
    * 描述: 在算出系数 theta 后，预测接下来一天的数量，
    *       若需预测多天，每次将新预测的数据加在原数据末尾作为已知数据。
    * @param day:需要预测的天数
    * */
    public void Prediction(int day){
        if(day<1){
            System.out.println("input day number is wrong!");
        }
        double preNum = 0;
        double hx = 0;
        int m = 0;
        for(int j=0;j<day;j++) {
            m = flavor.dataLength - thetaNum;
            for (int i = 0; i < thetaNum; i++) {
                hx += theta.get(i) * flavor.dataYAxis.get(m + i);
            }
            int preDay = (int)Math.round(hx);
            flavor.dataYAxis.add(preDay);
            flavor.dataLength = flavor.dataYAxis.size();
            System.out.println(preDay);
        }
    }
}
