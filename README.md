### RuleEngine
A tiny simple rule engine. You define a bunch of supported expressions, then build a bunch of 
rules that needs to be satisfied. When a particular rule is satisfied a corresponding action is 
triggered otherwise it returns false. See the examples folder to see how to use it

The project is built with Gradle.

This is based on [Interpreter Pattern][1]

```
$ cd experiment-finder
$ ./gradlew runEngineExample

[1]: https://en.wikipedia.org/wiki/Interpreter_pattern