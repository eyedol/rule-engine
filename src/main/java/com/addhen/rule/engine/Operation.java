package com.addhen.rule.engine;

import java.util.Stack;

/**
 * Operations are NOT, AND, OR, etc operands
 */
public abstract class Operation implements Expression {

    protected String symbol;

    protected Expression leftOperand = null;

    protected Expression rightOperand = null;

    public Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract Operation copy();

    public String getSymbol() {
        return this.symbol;
    }

    public abstract int parse(final String[] tokens, final int pos, final Stack<Expression> stack);

    protected Integer findNextExpression(String[] tokens, int pos, Stack<Expression> stack) {
        Operations operations = Operations.INSTANCE;

        for (int i = pos; i < tokens.length; i++) {
            Operation op = operations.getOperation(tokens[i]);
            if (op != null) {
                op = op.copy();
                // We found an operation
                i = op.parse(tokens, i, stack);
                return i;
            }
        }
        return null;
    }
}
