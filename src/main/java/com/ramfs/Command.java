package com.ramfs;

public interface Command {
    boolean processCommand(ShellContext shellContext);
}
