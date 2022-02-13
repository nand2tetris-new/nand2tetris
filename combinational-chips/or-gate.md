---
description: >-
  Abstraction and Implementation of Or Gate in Hardware Design Language and
  Java™.
---

# Or Gate

### Or Gate

The Or function returns 1 (true) when either of the inputs are 1 (true).

![Abstraction of Or Gate - Representation and Truth Table](https://www.allaboutcircuits.com/uploads/articles/two-input-or-gate-truth-table.jpg)

### Implementation of Or Gate in HDL

Or Gate can be implemented in two ways:

* Or Gate can be implemented by connecting negation of first input and negation of second input to the either inputs of Nand Gate.
* It can also be implemented by connecting first input to both inputs of first Nand Gate and second input to both inputs of second Nand Gate, and outputs of both to the either inputs of third Nand Gate.

![Implementation of Or Gate from Nand Gates](https://www.learningaboutelectronics.com/images/OR-gate-from-NAND-gates.png)

```nand2tetris-hdl
CHIP Or {
    IN a, b;
    OUT out;

    PARTS:
    Not(in=a, out=nota);
    Not(in=b, out=notb);
    Nand(a=nota, b=notb, out=out);
}
```

### Implementation of Or Gate in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class Or_Gate extends Not_Gate {

    protected static int Or(int a, int b) {
        return Nand(Not(a), Not(b));
    }
}
```
