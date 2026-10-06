package org.example;

public class BCpu {
    static ICpu build()
    {
        ICpu newCPU = new TCpu();
        return newCPU;
    }
}
