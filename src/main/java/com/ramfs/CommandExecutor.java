package com.ramfs;

import java.util.Arrays;

public class CommandExecutor {


    public Command parseCommand(String input) {
        if (input == null || input.isBlank()) return null;

        String[] tokens = input.trim().split("\\s+");
        String cmd = tokens[0];
        String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);

        return switch (cmd) {
            case "ls" -> new LsCommand(args);
            case "cd" -> new CdCommand(args);
            case "mkdir" -> new MkdirCommand(args);
            case "clear" -> new ClearCommand();
            case "exit" -> new ExitCommand();
            default -> null;
        };
    }
}
