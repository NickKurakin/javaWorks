package org.example;

import org.example.cpuFunctions.Math;
import org.example.cpuFunctions.Memory;
import org.example.cpuFunctions.inputOutput;

public class BCpu {
    static ICpu build()
    {
        ICpu newCPU = new Cpu();
        newCPU.addNext(new Memory());
        newCPU.addNext(new Math());
        newCPU.addNext(new inputOutput());
        return newCPU;
    }
}
