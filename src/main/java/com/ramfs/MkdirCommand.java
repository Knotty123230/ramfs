package com.ramfs;

public class MkdirCommand implements Command {
    private final String[] args;

    public MkdirCommand(String[] args) {
        this.args = args;
    }

    @Override
    public boolean processCommand(ShellContext shellContext) {
        return false;
    }
}
