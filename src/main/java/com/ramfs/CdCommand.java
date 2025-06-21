package com.ramfs;

public class CdCommand implements Command {
    private final String[] args;

    public CdCommand(String[] args) {
        this.args = args;
    }

    @Override
    public boolean processCommand(ShellContext shellContext) {
        if (args.length == 0) {
            System.out.println("No command specified");
            return false;
        }

        String path = ArgsPathExtractor.extractPath(args);
        if (path.isEmpty()) {
            System.out.println("No command specified");
            return false;
        }

        FileSystemNode pathNode = shellContext.getCurrentDirectory().getPathNode(path);
        shellContext.setCurrentDirectory((DirectoryNode) pathNode);
        return true;
    }


}
