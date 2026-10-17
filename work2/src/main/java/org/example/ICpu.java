package org.example;

public interface ICpu {
    public void doCommand(String[] command);
    public IsHandler addNext(IsHandler handler);
}
