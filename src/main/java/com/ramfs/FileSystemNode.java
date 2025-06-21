package com.ramfs;

public abstract class FileSystemNode {
    protected String name;
    protected DirectoryNode parent;

    public FileSystemNode(String name, DirectoryNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public abstract boolean isDirectory();

    public String getName() {
        return name;
    }

    public DirectoryNode getParent() {
        return parent;
    }

    public FileSystemNode findFilesForPath(String path, ShellContext shellContext) {
        DirectoryNode root = shellContext.getRoot();
        String[] paths = path.split("/");
        FileSystemNode fileSystemNode = root;
        for (String directoryPath : paths) {
            if (fileSystemNode.isDirectory()) {
                DirectoryNode directoryNode = (DirectoryNode) fileSystemNode;
                fileSystemNode = directoryNode.getChild(directoryPath);
                if (fileSystemNode == null) {
                    System.out.println("unknown path");
                    break;
                }
            } else {
                return fileSystemNode;
            }

        }
        return fileSystemNode;
    }

    public FileSystemNode getPathNode(String path){
        String[] paths = path.split("/");
        FileSystemNode fileSystemNode = this;
        for (String directoryPath : paths) {
            if (directoryPath.startsWith("..") && !fileSystemNode.isRoot()){
                fileSystemNode = fileSystemNode.getParent();
                continue;
            }
            if (directoryPath.startsWith(".")){
                continue;
            }
            if (fileSystemNode.isDirectory()) {
                DirectoryNode directoryNode = (DirectoryNode) fileSystemNode;
                fileSystemNode = directoryNode.getChild(directoryPath);
                if (fileSystemNode == null || !fileSystemNode.isDirectory()){
                    return this;
                }
            }else{
                return this;
            }
        }
        return fileSystemNode;
    }

    private boolean isRoot() {
        return parent == null;
    }
}

