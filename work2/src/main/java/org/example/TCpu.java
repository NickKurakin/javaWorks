package org.example;

import java.util.Map;
import java.util.HashMap;

public class TCpu implements ICpu{
    private int[] memory;
    private Map<String, Integer> registers = new HashMap<>();
    private IsHandler nextProcess;
    /*(
            Map.of("a", null,
                    "b", null,
                    "c", null,
                    "d", null)
    );*/
    public TCpu()
    {
        memory = new int[1024];
        registers.put("a", null);
        registers.put("b", null);
        registers.put("c", null);
        registers.put("d", null);
    }
    public IsHandler addHandler()
    {
        if (nextProcess == null)
        {

        }
    }

    @Override
    public void doCommand(String[] command) {
        switch (command[0])
        {
            case "ld": registers.replace(command[1], memory[Integer.parseInt(command[2])]); break;
            case "st": memory[Integer.parseInt(command[2])] = registers.get(command[1]); break;
            case "mv": registers.replace(command[1], registers.get(command[2])); break;
            case "init": memory[Integer.parseInt(command[1])] = Integer.parseInt(command[2]); break;
            case "print": for (String key : registers.keySet())
            {
                if(registers.get(key) == null) System.out.print("* ");
                else System.out.printf("%d ",registers.get(key));
            }
                System.out.println(); break;
            case "add": registers.replace("d", registers.get("a") + registers.get("b")); break;
            case "sub": registers.replace("d", registers.get("a") - registers.get("b")); break;
            case "mult": registers.replace("d", registers.get("a") * registers.get("b")); break;
            case "div": registers.replace("d", registers.get("a") / registers.get("b")); break;
        }
    }
}
