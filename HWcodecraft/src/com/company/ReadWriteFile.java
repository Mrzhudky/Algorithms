package com.company;

import java.io.*;
import java.util.regex.*;

public class ReadWriteFile {
    private int cpuNumber;
    private int memorySize;
    private int hardDiskSize;
    private int resourceFlag; //0--CPU 1--Memory

    public TimeAsXAxis forecastStartTime = new TimeAsXAxis();
    public TimeAsXAxis forecastEndTime = new TimeAsXAxis();

    public void ReadInputFile(String fileName) throws IOException{
//        File file = new File(fileName);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String str;
        str = reader.readLine();

        String[] split = str.split("\\s");
        cpuNumber = Integer.parseInt(split[0]);
        memorySize = Integer.parseInt(split[1]);
        hardDiskSize = Integer.parseInt(split[2]);
        reader.readLine();
        str = reader.readLine();
        int n = Integer.parseInt(str);
        Flavor[] flavors = new  Flavor[n];
        for (int i = 0; i < n; i++) {
            str = reader.readLine();
            split = str.split("\\s");
            flavors[i] = new Flavor(split[0],Integer.parseInt(split[2]),Integer.parseInt(split[1]));
        }
        reader.readLine();
        str = reader.readLine();
        if(str.equals("CPU")){
            resourceFlag = 0;
        }
        else{
            resourceFlag = 1;
        }
        reader.readLine();
        str = reader.readLine();
        split = str.split("\\D");
        forecastStartTime.Set(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));
        str = reader.readLine();
        split = str.split("\\D");
        forecastEndTime.Set(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]));

    }

    public static void main(String[] args) throws IOException{
        ReadWriteFile file = new ReadWriteFile();
        file.ReadInputFile("files/input_5flavors_cpu_7days.txt");
        TimeAsXAxis time = new TimeAsXAxis();
        time.Set(2015,1,1);
        System.out.println(file.forecastStartTime.TranseToXAxis(time));
        System.out.println(file.forecastEndTime.TranseToXAxis(time));
    }
}
