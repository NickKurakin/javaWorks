package org.example.cpuFunctions;

import org.example.Command;
import org.example.IsHandler;

import java.util.Map;
import java.util.Objects;

public class Memory implements IsHandler {
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
            case "ld": registers.replace(command[1], memory[Integer.parseInt(command[2])]); break;
            case "st": memory[Integer.parseInt(command[2])] = registers.get(command[1]); break;
            case "mv": registers.replace(command[1], registers.get(command[2])); break;
            case "init": memory[Integer.parseInt(command[1])] = Integer.parseInt(command[2]); break;
            default: if (next != null) next.work(command,memory,registers); break;
        }
    }

    public static int usedMemory(Command c)
    {
        String[] command = c.getCommand();
        int res;
        switch (command[0])
        {
            case "ld": res = Integer.parseInt(command[2]); break;
            case "st": res = Integer.parseInt(command[2]); break;
            case "mv": res = -1; break;
            case "init": res = Integer.parseInt(command[1]); break;
            default: res = -1; break;
        }
        return res;
    }

    public static boolean findRegister(Command c, String a)
    {
        String[] command = c.getCommand();
        switch (command[0])
        {
            case "ld": return Objects.equals(a, command[1]);
            case "st": return Objects.equals(a, command[1]);
            case "mv": return Objects.equals(a, command[1]) || Objects.equals(a, command[2]);
            case "init": return false;
            default: return false;
        }
    }
}
