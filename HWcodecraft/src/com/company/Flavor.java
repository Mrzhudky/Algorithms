package com.company;

import java.util.ArrayList;

public class Flavor {
    private String name;
    private int cpuNumber;
    private int memorySize;
    public ArrayList<Integer> dataYAxis = new ArrayList<Integer>();
    public ArrayList<Integer> timeXAxis = new ArrayList<Integer>();
    public int dataLength;

    public Flavor(String n,int cpuN,int memN){
        name = n;
        cpuNumber = cpuN;
        memorySize = memN;
    }

    public void SetFlavorInfo(String n,int cpuN,int memN){
        name = n;
        cpuNumber = cpuN;
        memorySize = memN;
    }
}
