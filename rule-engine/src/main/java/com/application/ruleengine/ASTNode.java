package com.application.ruleengine;

class ASTNode {
    String type; 
    ASTNode left; 
    ASTNode right; 
    String value; 

    public ASTNode(String type, ASTNode left, ASTNode right, String value) {
        this.type = type;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public String toString() {
        if ("operand".equals(type)) {
            return value;
        } else {
            return "(" + left + " " + value + " " + right + ")";
        }
    }

    public void modifyOperandValue(String newValue) {
        if ("operand".equals(type)) {
            this.value = newValue;
        } else {
            throw new UnsupportedOperationException("not modify");
        }
    }


    public void modifyOperator(String newOperator) {
        if ("operator".equals(type)) {
            this.value = newOperator;
        } else {
            throw new UnsupportedOperationException("not modify");
        }
    }
}
