package com.ramfs;

public class FileNode extends FileSystemNode {
    private final StringBuilder content = new StringBuilder();

    public FileNode(String name, DirectoryNode parent) {
        super(name, parent);
    }

    public void write(String text) {
        content.append(text);
    }

    public String read() {
        return content.toString();
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

}
