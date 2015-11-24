package com.addhen.rule.engine;

import java.util.Map;
import java.util.Stack;

public class Equals extends Operation {

    public Equals() {
        super("==");
    }

    @Override
    public Operation copy() {
        return new Equals();
    }

    @Override
    public int parse(String[] tokens, int pos, Stack<Expression> stack) {
        if (pos - 1 >= 0 && tokens.length >= pos + 1) {
            String variable = tokens[pos - 1];
            this.leftOperand = new Var(variable);
            this.rightOperand = BaseType.getBaseType(tokens[pos + 1]);
            stack.push(this);
            return pos + 1;
        }
        return -1;
    }

    @Override
    public boolean interpret(Map<String, ?> data) {
        Var v = (Var) this.leftOperand;
        Object obj = data.get(v.getName());
        if (obj == null) {
            return false;
        }

        BaseType<?> type = (BaseType<?>) this.rightOperand;
        if (type.getType().equals(obj.getClass())) {
            if (type.getValue().equals(obj)) {
                return true;
            }
        }
        return false;
    }
}
