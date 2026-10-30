package org.example.cpuFunctions;

import org.example.Command;
import org.example.IsHandler;

import java.util.Map;

public class inputOutput implements IsHandler {
    private IsHandler next = null;

    @Override
    public IsHandler addNext(IsHandler handler) {
        if (next == null) next = handler;
        else next.addNext(handler);
        return next;
    }

    @Override
    public void work(String[] command, int[] memory, Map<String, Integer> registers) {
        switch (command[0])
        {
            case "print": for (String key : registers.keySet())
            {
                if(registers.get(key) == null) System.out.print("* ");
                else System.out.printf("%d ",registers.get(key));
            }
                System.out.println(); break;
            default: if (next != null) next.work(command,memory,registers); break;
        }
    }

    public static boolean findRegister(Command c, String a)
    {
        String[] command = c.getCommand();
        switch (command[0])
        {
            case "print": return true;
            default: return false;
        }
    }

}
