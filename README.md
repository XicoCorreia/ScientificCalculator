# Scientific Calculator

Simple scientific calculator, capable of performing several operations

The grammar used to write the evaluate_func is the following:
```
Grammar:
expression = term | expression `+` term | expression `-` term
term = factor | term `*` factor | term `/` factor
factor = `+` factor | `-` factor | `(` expression `)`| number | functionName factor | factor `^` factor
````
