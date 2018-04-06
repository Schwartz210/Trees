package com.company;

public class BinarySearchTree {
    private Node mRoot;
    public BinarySearchTree(){ }

    public void setRoot(Node root){
        // Sets root node, mRoot
        mRoot = root;
    }

    public void put(Node node){
        // Adds new node to BinarySearchTree
        boolean state = true;
        Node temp = mRoot;
        String message;
        while (state){
            if (node.getValue() < temp.getValue()){
                if (temp.getLeftChild() == null){
                    temp.putLeft(node);
                    state = false;
                    message = node.getValue() + " is the left child of " + temp.getValue();
                    System.out.println(message);
                } else {
                    temp = temp.getLeftChild();
                }
            } else {
                if (temp.getRightChild() == null){
                    temp.putRight(node);
                    state = false;
                    message = node.getValue() + " is the right child of " + temp.getValue();
                    System.out.println(message);
                } else {
                    temp = temp.getRightChild();
                }
            }
        }
    }

    public String binarySearch(int value){
        // Conducts binary search, and returns String that represents search path
        boolean state = true;
        Node temp = mRoot;
        String message = "";
        int level = 2;
        while (state){
            if (temp.getValue() == value){
                state = false;
            } else if (value < temp.getValue()){
                message += "Level " +
                        level +
                        ": " +
                        temp.getLeftChild().getValue() +
                        " is the left child of " +
                        temp.getValue() + ". ";
                temp = temp.getLeftChild();
            } else {
                message += "Level " +
                        level +
                        ": " +
                        temp.getRightChild().getValue() +
                        " is the right child of " +
                        temp.getValue() + ". ";
                temp = temp.getRightChild();
            }
            level += 1;
        }
        return message;
    }
}
