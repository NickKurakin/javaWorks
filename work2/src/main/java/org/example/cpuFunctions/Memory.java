package org.example.cpuFunctions;

import org.example.IsHandler;

import java.util.Map;

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
}
