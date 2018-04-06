package com.company;

import java.util.ArrayList;

public class TernaryTree {
    private TernaryNode mRoot = null;
    public TernaryTree(){}

    public void setRoot(TernaryNode node){
        // Sets root node, mRoot
        mRoot = node;
    }

    public TernaryNode findNextNodeWithSpace(){
        // Traverses the tree and returns the next node that has space for at least one child node
        ArrayList<TernaryNode> queue = new ArrayList<>();
        queue.add(mRoot);
        int iterator = 0;
        TernaryNode node = queue.get(iterator);
        boolean state = true;
        while (state){
            node = queue.get(iterator);
            if (node.getNodeCount() == 0){
                state = false;
            } else if (node.getNodeCount() == 1){
                state = false;
            } else if (node.getNodeCount() == 2){
                state = false;
            } else {
                queue.add(node.getChild("left"));
                queue.add(node.getChild("mid"));
                queue.add(node.getChild("right"));
            }
            iterator += 1;
        }
        return node;
    }

    public void put(TernaryNode node){
        // Adds new node to tree
        TernaryNode parent = findNextNodeWithSpace();
        parent.put(node);
    }

    public TernaryNode getRoot(){
        // Returns TernaryNode root, mRoot
        return mRoot;
    }

    public TernaryNode ternarySearch(int value){
        // Traverses TernaryTree until node with specific value is found
        ArrayList<TernaryNode> queue = new ArrayList<>();
        queue.add(mRoot);
        int iterator = 0;
        TernaryNode node = queue.get(iterator);
        boolean state = true;
        while (state){
            node = queue.get(iterator);
            if (node.getValue() == value){
                state = false;
            } else if (node.getNodeCount() == 1){
                queue.add(node.getChild("left"));
            } else if (node.getNodeCount() == 2){
                queue.add(node.getChild("left"));
                queue.add(node.getChild("mid"));
            } else if (node.getNodeCount() == 3){
                queue.add(node.getChild("left"));
                queue.add(node.getChild("mid"));
                queue.add(node.getChild("right"));
            } else { }
            iterator += 1;
        }
        return node;
    }
}
