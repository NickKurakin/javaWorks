package org.example;

public class Executer {
    ICpu cpu;
    public Executer(ICpu c)
    {
        cpu = c;
    }
    public void run(Command[] commands)
    {
        for (Command command : commands)
        {
            cpu.doCommand(command.getCommand());
        }
    }
    public void run(Program prog)
    {
        for (Command command : prog)
        {
            cpu.doCommand(command.getCommand());
        }
    }

    public void printCommand(Command[] commands)
    {
        for (Command command : commands)
        {
            System.out.println(command);
        }
    }
    public void printCommand(Program prog)
    {
        for (Command command : prog)
        {
            System.out.println(command);
        }
    }
}
