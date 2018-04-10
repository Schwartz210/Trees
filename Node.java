package com.company;

public class Node {
    // Basic node used for BinarySearchTree and BinaryTree
    private int mValue;
    private Node mLeftChild;
    private Node mRightChild;
    private int mNodeCount = 0;
    public Node(int value){
        mValue = value;
    }

    public int getValue(){
        // returns mValue
        return mValue;
    }

    public Node getLeftChild(){
        // Returns left child
        return mLeftChild;
    }

    public Node getRightChild(){
        // Returns right child
        return mRightChild;
    }

    public void put(Node node){
        // Adds children nodes
        if (mNodeCount == 0){
            mLeftChild = node;
            mNodeCount += 1;
        } else if (mNodeCount == 1){
            mRightChild = node;
            mNodeCount += 1;
        } else {

        }
    }

    public int getNodeCount(){
        // Returns count of nodes. Used to indicate if this node can accommodate children
        return mNodeCount;
    }

    public void putLeft(Node node){
        // Sets left child node
        mLeftChild = node;
    }

    public void putRight(Node node){
        // Sets right child node
        mRightChild = node;
    }
}
