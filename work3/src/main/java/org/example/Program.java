package org.example;

import org.example.cpuFunctions.Memory;
import org.w3c.dom.css.Counter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program implements Iterable<Command>
{
    private ArrayList<Command> commands = new ArrayList<>();;

    public void add(Command c)
    {
        commands.add(c);
    }

    @Override
    public Iterator<Command> iterator()
    {
        return commands.iterator();
    }

    public String mostPopularInstruction()
    {
        Map<String,Long> mapCommands = commands.stream()
                .collect(Collectors.groupingBy(comand -> comand.getCommand()[0], Collectors.counting()));
        String comand = mapCommands.entrySet().stream()
                .max(Map.Entry.comparingByValue()).orElse(null)
                .getKey();
        return comand;
    }
    public List<Integer> getMemoryAddressRange() {
        Set<Integer> usedMem = commands.stream()
                .map(Memory::usedMemory)
                .filter((x) -> x != -1)
                .collect(Collectors.toSet());

        ArrayList<Integer> range = new ArrayList<Integer>();
        range.add(usedMem.stream().min((x,y) -> {if (x > y) return 1; else return -1;}).get());
        range.add(usedMem.stream().max((x,y) -> {if (x > y) return 1; else return -1;}).get());
        return range;
    }
    public List<String> getCommandsList()
    {
        Map<String,Long> mapCommands = commands.stream()
                .collect(Collectors.groupingBy(comand -> comand.getCommand()[0], Collectors.counting()));
        /*mapCommands.entrySet().stream()
                .forEach((x) -> System.out.println(x.getKey() + " " + x.getValue()));*/
        ArrayList<String> instructions = mapCommands.entrySet().stream()
                .sorted((x,y) -> {if (x.getValue() < y.getValue()) return 1; else return -1;})
                .collect(
                        () -> new ArrayList<String>(),
                        (list, item) -> list.add(item.getKey()),
                        (list1,list2) -> list1.addAll(list2)
                );
        return instructions;
    }
    public Map<String, List<Command>> getCommandsMap()
    {
        Map<String, List<Command>> CommandList =
                commands.stream()
                        .collect(
                                () -> new HashMap<String, List<Command>>(),
                                (map, item) -> map.put(item.getCommand()[0], new ArrayList<Command>()),
                                (map1,map2) -> map1.putAll(map2)
                        );
        commands.stream().forEach(
                (x) -> CommandList.get(x.getCommand()[0]).add(x)
        );
        return CommandList;
    }
    public List<Command> getCommandsUsedRegister(String a)
    {
        List<Command> c = commands.stream()
                .filter((x) -> BCpu.findRegister(x,a))
                .toList();
        return c;
    }
}
