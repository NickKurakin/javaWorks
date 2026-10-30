package org.example;

import org.example.cpuFunctions.Math;

import java.util.List;
import java.util.Map;

public class Main {
    static void main() {

        Program prog = new Program();
        prog.add(new Command("init 10 20"));
        prog.add(new Command("init", "11", "25"));
        prog.add(new Command("ld", "a", "10"));
        prog.add(new Command("ld", "b", "11"));
        prog.add(new Command("add"));
        prog.add(new Command("print"));

        for(Command c: prog) System.out.println(c); // программа итерируема

        System.out.println();
        System.out.println(prog.mostPopularInstruction()); // ld

        System.out.println();
        System.out.println(prog.getMemoryAddressRange()); // [10, 11]

        System.out.println();
        for(String c: prog.getCommandsList()) System.out.println(c);

        Map<String, List<Command>> map = prog.getCommandsMap();
        System.out.println();
        for(String s : map.keySet())
        {
            System.out.println(s);
            for (Command cmd : map.get(s))
            {
                System.out.println("\t" + cmd);
            }
        }

        System.out.println();
        for(Command c: prog.getCommandsUsedRegister("a")) System.out.println(c);

        System.out.println();
        System.out.println();

        ICpu cpu = BCpu.build();
        Executer exec = new Executer(cpu);
        exec.run(prog);
        //exec.printCommand(prog);
    }
}
