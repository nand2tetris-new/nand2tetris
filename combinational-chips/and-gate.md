---
description: >-
  Abstraction and Implementation of And Gate in Hardware Design Language and
  Java™.
---

# And Gate

### And Gate

The And function returns 1 (true) only when both of the inputs are 1 (true).

![Abstraction of And Gate - Representation and Truth Table](https://www.allaboutcircuits.com/uploads/articles/two-input-and-gate-truth-table.jpg)

### Implementation of And Gate in HDL

And Gate can be implemented in two ways:

* And Gate can be implemented using two Nand Gates - one Nand Gate for both inputs to produce some output, which is connected to either inputs of Another Nand Gate.
* You can observe that the second Nand Gate can be replaced with a Not Gate of single input which is the output of First Nand Gate.

![Implementation of And Gate from Nand Gates](https://www.learningaboutelectronics.com/images/AND-gate-from-NAND-gates.png)

```nand2tetris-hdl
CHIP And {
    IN a, b;
    OUT out;

    PARTS:
    // Put your code here:
    Nand(a=a, b=b, c=notout);
    Not(in=notout, out=out);
}
```

### Implementation of And Gate in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class And_Gate extends Not_Gate {

    protected static int And(int a, int b) {
        return Not(Nand(a, b));
    }
}
```
