package com.company;

import java.util.ArrayList;

public class BinaryTree {
    private Node mRoot;
    public BinaryTree(){ }

    public void setRoot(Node root){
        // Sets root node, mRoot
        mRoot = root;
    }

    public void put(Node node){
        // Adds new node to BinaryTree
        Node lastNode = findNextNodeWithSpace();
        String message = node.getValue() + " is the child of " + lastNode.getValue();
        System.out.println(message);
        lastNode.put(node);
    }

    public Node findNextNodeWithSpace(){
        // Traverses the tree and returns the next node that has space for at least one child node
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(mRoot);
        int iterator = 0;
        Node node = queue.get(iterator);
        boolean state = true;
        while (state){
            node = queue.get(iterator);
            if (node.getNodeCount() == 0){
                state = false;
            } else if (node.getNodeCount() == 1){
                state = false;
            } else {
                queue.add(node.getLeftChild());
                queue.add(node.getRightChild());
            }
            iterator += 1;
        }
        return node;
    }

    public Node bruteForceSearch(int value){
        // Traverses tree until matching value is found
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(mRoot);
        int iterator = 0;
        Node node = queue.get(iterator);
        boolean state = true;
        while (state){
            node = queue.get(iterator);
            if (node.getValue() == value){
                state = false;
            } else if (node.getNodeCount() == 1){
                queue.add(node.getLeftChild());
            } else if (node.getNodeCount() == 2){
                queue.add(node.getLeftChild());
                queue.add(node.getRightChild());
            } else {}
            iterator += 1;
        }
        return node;
    }
}
