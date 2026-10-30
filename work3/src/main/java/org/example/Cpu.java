package org.example;

import java.util.Map;
import java.util.HashMap;

public class Cpu implements ICpu{
    private int[] memory;
    private Map<String, Integer> registers = new HashMap<>();
    private IsHandler nextProcess;
    /*(
            Map.of("a", null,
                    "b", null,
                    "c", null,
                    "d", null)
    );*/
    public Cpu()
    {
        memory = new int[1024];
        registers.put("a", null);
        registers.put("b", null);
        registers.put("c", null);
        registers.put("d", null);
    }
    @Override
    public IsHandler addNext(IsHandler handler)
    {
        if (nextProcess == null) nextProcess = handler;
        else nextProcess.addNext(handler);
        return nextProcess;
    }

    @Override
    public void doCommand(String[] command) {
        if (nextProcess != null) nextProcess.work(command,memory,registers);
    }
}
