package com.addhen.rule.engine;

import java.util.Map;
import java.util.Stack;

public class LessThanOrEqualTo extends Operation {

    public LessThanOrEqualTo() {
        super("<=");
    }

    @Override
    public Operation copy() {
        return new LessThanOrEqualTo();
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
        Var leftVar = (Var) this.leftOperand;
        Object obj = data.get(leftVar.getName());
        if ((obj == null) || !(obj instanceof Integer) || (obj instanceof Float)) {
            return false;
        }

        Var rightVar = (Var) this.rightOperand;
        Object rightObj = data.get(rightVar.getName());
        if ((rightObj == null) || !(rightObj instanceof Integer) || (rightObj instanceof Float)) {
            return false;
        }
        if ((rightObj instanceof Integer) && (obj instanceof Integer)) {
            Integer right = (Integer) rightObj;
            Integer left = (Integer) obj;
            if (left <= right) {
                return true;
            }
        }

        if ((rightObj instanceof Float) && (obj instanceof Float)) {
            Float right = (Float) rightObj;
            Float left = (Float) obj;
            if (left <= right) {
                return true;
            }
        }
        return false;
    }
}
