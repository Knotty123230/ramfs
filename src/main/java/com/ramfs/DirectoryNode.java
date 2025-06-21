package com.ramfs;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DirectoryNode extends FileSystemNode {
    private final Map<String, FileSystemNode> children = new HashMap<>();

    public DirectoryNode(String name, DirectoryNode parent) {
        super(name, parent);
    }

    public void addChild(FileSystemNode node) {
        children.put(node.getName(), node);
    }

    public FileSystemNode getChild(String name) {
        return children.get(name);
    }

    public Collection<FileSystemNode> listChildren() {
        return children.values();
    }


    @Override
    public boolean isDirectory() {
        return true;
    }
}
