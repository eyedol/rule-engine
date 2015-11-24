package com.addhen.rule.engine;

import java.util.Map;
import java.util.Stack;

public class Not extends Operation {

    public Not() {
        super("NOT");
    }

    @Override
    public Not copy() {
        return new Not();
    }

    @Override
    public int parse(String[] tokens, int pos, Stack<Expression> stack) {
        int i = findNextExpression(tokens, pos + 1, stack);
        Expression right = stack.pop();
        this.rightOperand = right;
        stack.push(this);
        return i;
    }

    @Override
    public boolean interpret(Map<String, ?> data) {
        return !rightOperand.interpret(data);
    }
}
