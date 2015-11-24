package com.addhen.rule.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Rule {

    private List<Expression> expressions;

    private ActionTrigger actionTrigger;

    public static class Builder {

        private List<Expression> expressions = new ArrayList<>();

        private ActionTrigger actionTrigger;

        public Builder withExpression(Expression expr) {
            expressions.add(expr);
            return this;
        }

        public Builder withTrigger(ActionTrigger actionTrigger) {
            this.actionTrigger = actionTrigger;
            return this;
        }

        public Rule build() {
            return new Rule(expressions, actionTrigger);
        }
    }

    private Rule(List<Expression> expressions, ActionTrigger actionTrigger) {
        this.expressions = expressions;
        this.actionTrigger = actionTrigger;
    }

    public boolean execute(Map<String, ?> data) {
        boolean trigger = false;
        for (Expression expression : expressions) {
            trigger = expression.interpret(data);
            if (trigger) {
                actionTrigger.trigger();
            }
        }
        return trigger;
    }
}
