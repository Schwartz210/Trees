package com.company;

public class TernaryNode {
    // Node used for TernaryTree
    private int mValue;
    private int mNodeCount = 0;
    private TernaryNode mLeftChild = null;
    private TernaryNode mMidChild = null;
    private TernaryNode mRightChild = null;
    public TernaryNode(int value){
        mValue = value;
    }

    public TernaryNode getChild(String child){
        // Returns specific child node
        if (child.equals("left")){
            return mLeftChild;
        } else if (child.equals("right")){
            return mRightChild;
        } else if (child.equals("mid")){
            return mMidChild;
        } else {
            throw new IllegalArgumentException("The only acceptable options are 'left', 'right', and 'mid'.");
        }
    }

    public void put(TernaryNode node){
        // Add new node to child slots
        switch (mNodeCount){
            case 0:
                mLeftChild = node;
            case 1:
                mMidChild = node;
            case 2:
                mRightChild = node;
        }
        mNodeCount += 1;
    }

    public int getNodeCount(){
        // Returns node count
        return mNodeCount;
    }

    public int getValue(){
        // returns value of node
        return mValue;
    }
}
