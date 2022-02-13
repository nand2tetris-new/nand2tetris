---
description: >-
  Abstraction and Implementation of Not Gate in Hardware Design Language and
  Java™.
---

# Not Gate

### Not Gate

The single-input Not Gate, also referred as Inverter, inverts the value of input.

![Abstraction of Not Gate - Representation and Truth Table](https://electronics-club.com/wp-content/uploads/2019/04/NOT-Gate.png)

### Implementation of Not Gate in HDL

Not Gate can be implemented by giving the same input to either input pins of Nand Gate.

![Implementation of Not Gate from Nand Gate](https://www.electronicshub.org/wp-content/uploads/2015/06/111.jpg)

```nand2tetris-hdl
CHIP Not {
    IN in;
    OUT out;

    PARTS:
    Nand(a=in, b=in, out=out);
}
```

### Implementation of Not Gate in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class Not_Gate extends Nand_Gate {

    protected static int Not(int a) {
        return Nand(a, a);
    }
}
```
