---
description: >-
  Abstraction and Implementation of Demultiplexor Chip in Hardware Design
  Language and Java™.
---

# Demultiplexor Chip

### Demultiplexor (DMux)

A Demultiplexor performs the opposite function of a Multiplexor.

It takes a single input and channels it to one of two possible outputs according to a selector bit that specifies which output to chose.

![Abstraction of Demultiplexor Chip - Representation and Truth Table](https://www.researchgate.net/publication/341612055/figure/fig13/AS:962179159318558@1606412796949/Truth-table-and-symbol-of-12-demultiplexer.png)

### Implementation of Demultiplexor Chip in HDL

You can create Demultiplexor Chip in the similar way as Multiplexor Chip.

Unlike Multiplexor Chip, Demultiplexor Chip has two outputs and one input.

![Implementation of Demultiplexor using a Not gate and two And gates.](https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjwqbuzBDB1edpFclAFOjkFG1mBo2mpNDKsQ\&usqp=CAU)

```nand2tetris-hdl
CHIP DMux {
    IN in, sel;
    OUT a, b;

    PARTS:
    Not(in=sel, out=notsel);
    And(a=in, b=notsel, out=a);
    And(a=sel, b=in, out=b);
}
```

### Implementation of Demultiplexor Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class DMux_Gate extends And_Gate {

    protected static int[] DMux(int in, int sel) {
        int[] out = new int[16];
        out[0] = And(in, Not(sel));
        out[1] = And(in, sel);
        return out; 
    }
}
```
