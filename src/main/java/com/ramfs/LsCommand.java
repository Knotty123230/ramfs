package com.ramfs;

import java.util.stream.Collectors;

public class LsCommand implements Command {
    private final String[] args;

    public LsCommand(String[] args) {
        this.args = args;
    }

    private static String getOutput(FileSystemNode fileNode) {
        if (fileNode.isDirectory()) {
            DirectoryNode directoryNode = (DirectoryNode) fileNode;
            return directoryNode.listChildren().stream()
                    .map(it -> {
                        if (it.isDirectory()) {
                            return it.name + "/";
                        } else {
                            return it.name;
                        }
                    })
                    .collect(Collectors.joining("\n"));
        } else {
            return fileNode.getName();
        }

    }

    @Override
    public boolean processCommand(ShellContext shellContext) {
        if (args != null && args.length > 0) {
            String path = ArgsPathExtractor.extractPath(args);
            if (!path.isEmpty()) {
                FileSystemNode filesForPath = shellContext.getCurrentDirectory().findFilesForPath(path, shellContext);
                if (filesForPath == null) return true;
                System.out.println(getOutput(filesForPath));
                return true;
            }
        }
        DirectoryNode directoryNode = shellContext.getCurrentDirectory();
        String output = getOutput(directoryNode);
        System.out.println(output);
        return true;
    }


}
