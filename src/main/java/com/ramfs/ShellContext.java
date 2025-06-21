package com.ramfs;

public class ShellContext {
    private DirectoryNode currentDirectory;

    private final DirectoryNode root = new DirectoryNode("root", null);

    public ShellContext() {
        DirectoryNode etc = new DirectoryNode("etc", root);
        FileNode java = new FileNode("java.java", etc);
        DirectoryNode hello = new DirectoryNode("hello", etc);
        FileNode readme = new FileNode("readme.txt", root);

        root.addChild(etc);
        etc.addChild(hello);
        root.addChild(readme);
        etc.addChild(java);
        this.currentDirectory = root;
    }

    public DirectoryNode getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(DirectoryNode dir) {
        this.currentDirectory = dir;
    }

    public DirectoryNode getRoot() {
        return root;
    }
}
