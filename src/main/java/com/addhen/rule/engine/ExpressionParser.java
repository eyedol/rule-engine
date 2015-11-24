package com.addhen.rule.engine;

import java.util.Stack;

public class ExpressionParser {

    private static final Operations operations = Operations.INSTANCE;

    public static Expression parse(String expr) {
        Stack<Expression> stack = new Stack<>();
        String[] tokens = expr.split("\\s");
        for (int i = 0; i < tokens.length - 1; i++) {
            Operation op = operations.getOperation(tokens[i]);
            if (op != null) {
                // Create a new instance
                op = op.copy();
                i = op.parse(tokens, i, stack);
            }
        }
        return stack.pop();
    }
}
