package com.addhen.rule.engine;

import java.util.Map;
import java.util.Stack;

public class And extends Operation {

    public And() {
        super("AND");
    }

    @Override
    public And copy() {
        return new And();
    }

    @Override
    public int parse(String[] tokens, int pos, Stack<Expression> stack) {
        Expression left = stack.pop();
        int i = findNextExpression(tokens, pos + 1, stack);
        Expression right = stack.pop();
        this.leftOperand = left;
        this.rightOperand = right;
        stack.push(this);
        return i;
    }

    @Override
    public boolean interpret(Map<String, ?> data) {
        return leftOperand.interpret(data) && rightOperand.interpret(data);
    }
}
