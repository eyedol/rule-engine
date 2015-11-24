package com.addhen.rule.engine;

import java.util.Map;

public class Var implements Expression {

    private String name;

    public Var(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean interpret(Map<String, ?> data) {
        return true;
    }
}
