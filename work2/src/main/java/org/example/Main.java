package org.example;

public class Main {
    static void main() {

        Command[] prog = {
                new Command("init 10 20"),
                new Command("init" ,"11", "25"),
                new Command("ld", "a" ,"10"),
                new Command("ld", "b" ,"11"),
                new Command("add"),
                new Command("print")}; //вывод 20 25 * 45
        ICpu cpu = new ICpu();
        Executer exec = new Executer(cpu);
        exec.run(prog);
        //exec.printCommand(prog);
    }
}
