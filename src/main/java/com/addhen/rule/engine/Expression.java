package com.addhen.rule.engine;

import java.util.Map;

/**
 * Using the Interpreter pattern to evaluate expressions
 *
 * Credits: https://en.wikipedia.org/wiki/Interpreter_pattern
 */
public interface Expression {

    boolean interpret(final Map<String, ?> data);
}
