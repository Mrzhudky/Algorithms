package com.elasticcloudservice.predict;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;


public class Predict {

	private static int cpuNumber;
	private static int  memorySize;
	private static int flavorNum;
	private static int resourceFlag; //0--CPU 1--Memory
	private static int predictDays;



	public static String[] predictVm(String[] ecsContent, String[] inputContent) {

//		String[] results = new String[ecsContent.length];

		Flavor[] flavors =  GetInputInfo(ecsContent,inputContent);

		int totalNum = 0;
		String[] results = new String[cpuNumber + flavorNum +3];
		results[0] = Integer.toString(flavorNum);
		LinearRegression[] linRegs = new LinearRegression[flavorNum];
		for (int i = 0; i < flavorNum; i++) {
			linRegs[i] = new LinearRegression(flavors[i],0.3);
			linRegs[i].MovingAverage(1000,0.05);
			linRegs[i].Prediction(predictDays);
			results[i+1] = linRegs[i].resultToString();
			flavors[i].setPreData(linRegs[i].getEscTotalNumber());
			totalNum += linRegs[i].getEscTotalNumber();
		}

		//根据 CPU/MEM 对flavor经行排序
		//先不写了

		//放置
		int cpuNum = cpuNumber;
		int memSize = memorySize;
		int[] oneServer = new int[flavorNum];
		for (int i = 0; i < flavorNum; i++) {
			oneServer[i] = 0;
		}
		results[flavorNum] = "";
		int resultLine = flavorNum+2;
		while (totalNum >0){
			for (int i= flavorNum-1; i >0; i--) {
				if(flavors[i].getPreData()>0 &&  cpuNum>flavors[i].getCpuNumber()	&& memSize>flavors[i].getMemorySize()){
					oneServer[i] += 1;
					totalNum--;
					cpuNum -= flavors[i].getCpuNumber();
					memSize -= flavors[i].getMemorySize();
					int temp = flavors[i].getPreData();
					flavors[i].setPreData(temp-1);
					i = i+1;
				}
			}
			StringBuilder stringBuffer = new StringBuilder();
			stringBuffer.append(resultLine - flavorNum -1);
			for (int j = 0; j < flavorNum; j++) {
				if(oneServer[j] != 0){
					stringBuffer.append(" ");
					stringBuffer.append(flavors[j].getName());
					stringBuffer.append(" ");
					stringBuffer.append(oneServer[j]);
				}
			}
			results[resultLine] = stringBuffer.toString();
			resultLine++;

		}

		results[flavorNum+1] = Integer.toString(resultLine-flavorNum -1);

//		List<String> history = new ArrayList<String>();
//
//		for (int i = 0; i < history.size(); i++) {
//			results[i] = history.get(i);
//
//		}

		return results;
	}

	/**
	*  提取input.txt 与 TrainData.txt文件信息
	* */
	private static Flavor[] GetInputInfo(String[] ecsContent, String[] inputContent) {

		String[] split = ecsContent[0].split(" ");
		cpuNumber = Integer.parseInt(split[0]);
		memorySize = Integer.parseInt(split[1]);
		memorySize *= 1024;
		flavorNum = Integer.parseInt(ecsContent[2]);
		Flavor[] flavor = new Flavor[flavorNum];

		for (int i = 0; i < flavorNum; i++) {
//			if (ecsContent[i + 3].split("\\s").length == 3) {
				split = ecsContent[i + 3].split("\\s");
				flavor[i] = new Flavor(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
//			}
		}
		if (ecsContent[flavorNum + 4].equals("CPU")) {
			resourceFlag = 0;
		} else {
			resourceFlag = 1;
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long preDay = 0;
		long curDay = 0;
		try {
			String str = ecsContent[flavorNum + 6];
			preDay = simpleDateFormat.parse(str).getTime();
			str = ecsContent[flavorNum + 7];
			curDay = simpleDateFormat.parse(str).getTime();


		} catch (ParseException e) {
			e.printStackTrace();
		}
		predictDays = (int) (curDay - preDay) / (1000 * 60 * 60 * 24);

		split = inputContent[0].split("\\t");
		String previousTime = split[2];
		String currentTime;


		try {
			preDay = simpleDateFormat.parse(previousTime).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int k = 0;//第一天为0，每增加一天加一
		for (String anInputContent : inputContent) {
			split = anInputContent.split("\\t");
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
						int data = flavor[j].traDataList.get(k);
						flavor[j].traDataList.set(k, data + 1);
						break;
					}
				}
			} else {
				while (days > 0) {
					k++;
					for (int j = 0; j < flavorNum; j++) {
						flavor[j].traDataList.add(0);
					}
					days--;
				}
			}

		}
		return flavor;
	}
}

class Flavor {
	private String name;
	private int cpuNumber;
	private int memorySize;
	private int preData;

	ArrayList<Integer> traDataList = new ArrayList<>();
//	private ArrayList<Double> theta = new ArrayList<>();

	Flavor(String n, int cpuN, int memN){
		name = n;
		cpuNumber = cpuN;
		memorySize = memN;
		traDataList.add(0,0);
//		theta.add(1.0);
	}

	public int getPreData(){
		return preData;
	}
	void setPreData(int preD){
		preData = preD;
	}
//	public void SetFlavorInfo(String n,int cpuN,int memN){
//		name = n;
//		cpuNumber = cpuN;
//		memorySize = memN;
//		traDataList.add(0,0);
////		theta.add(0,1.0);
//	}

	String getName(){
		return name;
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
}

class LinearRegression {
	private Flavor flavor; //存放训练数据信息的对象
	private double learningRate; //学习率
	private double alpha; //平滑系数
	private int dataNum = 0; //系数的个数
	public ArrayList<Integer> preData = new ArrayList<>();
//    private int preData;
	private int S1;
	private int S2;
//	public ArrayList<Integer> singleExpData = new ArrayList<Integer>();
//	public ArrayList<Integer> doubleExpData = new ArrayList<Integer>();
	private ArrayList<Integer> tripleExpData = new ArrayList<>();

	LinearRegression(Flavor flavor, double learningRate){
		this.flavor = flavor;
		this.learningRate = learningRate;
		alpha = 0;

		dataNum = flavor.getDataLength();
		for (int i = 0; i < dataNum; i++) {
			tripleExpData.add(0);
		}
	}

	/**
	 *  <p>批量梯度下降法，迭代 iterativeNum 次</br>
	 *      计算f(x) = theta_0 * x_0 + theta_1 * x_1 + ... + theta_n * x_n 的系数</br>
	 *      theta_0、theta_1、...、theta_n </p>
	 * @param iterativeNum： 迭代次数
	 */

	void MovingAverage(int iterativeNum, double accruacy){
		UpdataThreeExpData();
//		double minCost;
//		double lastCost;
//		double minAlpha = alpha;
//		lastCost = CostFunction();
//		minCost = lastCost;
//		for (int i = 0; i < iterativeNum && minCost>accruacy; i++) {
//			UpDataAlpha();
//			UpdataThreeExpData();
//			lastCost = CostFunction();
//			if(lastCost < minCost){
//				minCost = lastCost;
//				minAlpha = alpha;
//			}
//		}
//		alpha = minAlpha;
//		UpdataThreeExpData();
	}

	/**
	 * 更新一次、二次、三次预估值St1、St2、St3
	 * */
	private void UpdataThreeExpData(){
		int S0 = flavor.traDataList.get(0);
		double lastSingleExp = S0;
		double lastDoubleExp = S0;
		tripleExpData.set(0,S0);

		double tempDouble;
		int tempInteger;
		for (int i = 1; i < dataNum; i++) {
			tempDouble = alpha * flavor.traDataList.get(i) + (1.0-alpha)*lastSingleExp;
			lastSingleExp =tempDouble;
			tempDouble = alpha*lastSingleExp + (1.0-alpha)*lastDoubleExp;
			lastDoubleExp = tempDouble;
			tempDouble = alpha*lastDoubleExp+(1.0-alpha)*tripleExpData.get(i-1);
			tempInteger = (int)Math.round(tempDouble);
			tripleExpData.set(i,tempInteger);
		}
		S1 = (int) Math.round(lastSingleExp);
		S2 = (int) Math.round(lastDoubleExp);
	}

	/**
    *  代价函数, 求均方误差  JAlpha
    * @return double:代价函数的值，即建模误差
    * */
	private double CostFunction(){
		double JAlpha;
		double sum = 0;
		int temp;
		for (int i = 0; i < dataNum; i++) {
			temp = tripleExpData.get(i) - flavor.traDataList.get(i);
			sum += temp*temp;
		}
		JAlpha = sum / dataNum;
		return JAlpha;
	}

	private void UpDataAlpha(){
		alpha = alpha + learningRate;
		if(alpha>1){
			alpha = alpha -1;
		}
	}

	/**
    * 描述: 在算出系数 alpha 后，预测接下来一天的数量，
    *       若需预测多天，每次将新预测的数据加在原数据末尾作为已知数据。
    * @param day:需要预测的天数
    * */
	void Prediction(int day){
		if(day<1){
			System.out.println("input day number is wrong!");
		}
		int preD = 0;
		for (int i = 0; i < day; i++) {
			int S3 = flavor.traDataList.get(dataNum-1);
			double At,Bt,Ct;

			At = 3*S1 - 3*S2 + S3;
			Bt = (alpha/(2*(1-alpha)*(1-alpha))) * ( (6-5*alpha)*S1 - 2*(5-4*alpha)*S2 + (4-3*alpha)*S3);
			Ct = (alpha*alpha/(2*(1-alpha)*(1-alpha)))*(S1-2*S2 + S3);
			double preX = At + Bt*day + Ct*day*day;
			preD = (int) Math.round(preX);
			System.out.print(preD);
			dataNum += 1;
			flavor.traDataList.add(preD);
			tripleExpData.add(preD);
			preData.add(preD);
			UpdataThreeExpData();
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

