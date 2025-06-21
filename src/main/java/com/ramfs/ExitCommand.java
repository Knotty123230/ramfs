package com.ramfs;

public class ExitCommand implements Command {
    @Override
    public boolean processCommand(ShellContext shellContext) {
        System.exit(0);
        return true;
    }
}
