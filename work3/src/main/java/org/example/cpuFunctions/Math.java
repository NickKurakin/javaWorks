package org.example.cpuFunctions;

import org.example.Command;
import org.example.IsHandler;

import java.util.Map;
import java.util.Objects;

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

    public static boolean findRegister(Command c, String a)
    {
        String[] command = c.getCommand();
        switch (command[0])
        {
            case "add": return !Objects.equals(a, "c");
            case "sub": return !Objects.equals(a, "c");
            case "mult": return !Objects.equals(a, "c");
            case "div": return !Objects.equals(a, "c");
            default: return false;
        }
    }
}
