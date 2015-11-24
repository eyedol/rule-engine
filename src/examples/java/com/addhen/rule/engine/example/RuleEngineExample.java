package com.addhen.rule.engine.example;

import com.addhen.rule.engine.ActionTrigger;
import com.addhen.rule.engine.And;
import com.addhen.rule.engine.Equals;
import com.addhen.rule.engine.ExperimentTrigger;
import com.addhen.rule.engine.Expression;
import com.addhen.rule.engine.ExpressionParser;
import com.addhen.rule.engine.GreaterThan;
import com.addhen.rule.engine.GreaterThanOrEqualTo;
import com.addhen.rule.engine.LessThan;
import com.addhen.rule.engine.LessThanOrEqualTo;
import com.addhen.rule.engine.Not;
import com.addhen.rule.engine.Operations;
import com.addhen.rule.engine.Rule;

import java.util.HashMap;
import java.util.Map;

public class RuleEngineExample {

    public static void main(String args[]) throws Exception {

        ActionTrigger actionTrigger = new ExperimentTrigger();
        Operations operations = Operations.INSTANCE;
        operations.registerOperation(new And());
        operations.registerOperation(new Equals());
        operations.registerOperation(new Not());
        operations.registerOperation(new GreaterThan());
        operations.registerOperation(new GreaterThanOrEqualTo());
        operations.registerOperation(new LessThan());
        operations.registerOperation(new LessThanOrEqualTo());
        Expression expression = ExpressionParser
                .parse("os_version == '6.1.1' AND NOT country == 'china'");
        Rule rule = new Rule.Builder()
                .withExpression(expression)
                .withTrigger(actionTrigger)
                .build();
        Map<String, String> data = new HashMap<>();
        data.put("os_version", "'6.1.1'");
        data.put("country", "'usa'");
        boolean action = rule.execute(data);
        if (!action) {
            System.out.println("false");
        }
    }
}
