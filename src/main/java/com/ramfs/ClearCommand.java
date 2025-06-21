package com.ramfs;

public class ClearCommand implements Command {
    @Override
    public boolean processCommand(ShellContext shellContext) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        return true;
    }
}
