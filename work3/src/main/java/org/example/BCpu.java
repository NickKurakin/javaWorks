package org.example;

import org.example.cpuFunctions.Math;
import org.example.cpuFunctions.Memory;
import org.example.cpuFunctions.inputOutput;

public class BCpu {
    public static ICpu build()
    {
        ICpu newCPU = new Cpu();
        newCPU.addNext(new Memory());
        newCPU.addNext(new Math());
        newCPU.addNext(new inputOutput());
        return newCPU;
    }

    public static boolean findRegister(Command c, String a)
    {
        return Memory.findRegister(c, a) ||
                Math.findRegister(c, a) ||
                inputOutput.findRegister(c, a);
    }
}
