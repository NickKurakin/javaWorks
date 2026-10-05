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
    public void printCommand(Command[] commands)
    {
        for (Command command : commands)
        {
            for (String str : command.getCommand())
            {
                System.out.printf("\"%s\" ",str);
            }
            System.out.println();
        }
    }
}
