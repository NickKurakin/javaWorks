package org.example.cpuFunctions;

import org.example.IsHandler;

import java.util.Map;

public class Math implements IsHandler {
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
            case "add": registers.replace("d", registers.get("a") + registers.get("b")); break;
            case "sub": registers.replace("d", registers.get("a") - registers.get("b")); break;
            case "mult": registers.replace("d", registers.get("a") * registers.get("b")); break;
            case "div": registers.replace("d", registers.get("a") / registers.get("b")); break;
            default: if (next != null) next.work(command,memory,registers); break;
        }
    }
}
