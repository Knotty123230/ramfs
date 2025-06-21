package com.ramfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RamFileSystem {
    private final ShellContext shellContext = new ShellContext();
    private final CommandExecutor commandExecutor = new CommandExecutor();

    public static void main(String[] args) {
        RamFileSystem ramFileSystem = new RamFileSystem();
        ramFileSystem.run();
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(currentPath() + " $ ");
            String input = scanner.nextLine();
            Command command = commandExecutor.parseCommand(input);
            if (command == null) {
                System.out.println("Unknown command");
            }else {
                command.processCommand(shellContext);
            }
        }
    }

    private String currentPath() {
        // Побудова шляху від root до current
        List<String> path = new ArrayList<>();
        DirectoryNode temp = shellContext.getCurrentDirectory();
        while (temp != null) {
            path.addFirst(temp.getName());
            temp = temp.getParent();
        }
        return String.join("/", path);
    }
}
