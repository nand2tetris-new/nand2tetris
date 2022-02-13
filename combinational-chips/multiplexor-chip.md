---
description: >-
  Abstraction and Implementation of Multiplexor Chip in Hardware Design Language
  and Java™.
---

# Multiplexor Chip

### Multiplexor (Mux)

A Multiplexor, also known as Selector, is a three-input bit gate that uses one of the input called "selection bit" to select one of the given two inputs for outputting them.

The name multiplexor was adopted from communications systems, where similar devices are used to serialize (multiplex) several input signals over a single output wire.

![Abstraction of Multiplexor Chip - Representation and Truth Table](https://vlsi-iitg.vlabs.ac.in/images/5.1.png)

### Implementation of Multiplexor Chip in HDL

The expression in the above abstraction can help in the implementation of Multiplexor chip.

![Implementation of Multiplexor using Not, And and Or gates.](https://i.stack.imgur.com/VmzKJ.png)

```nand2tetris-hdl
CHIP Mux {
    IN a, b, sel;
    OUT out;

    PARTS:
    Not(in=a, out=notsel);
    And(a=a, b=notsel, out=aAndnotsel);
    And(a=sel, b=b, out=bAndsel);
    Or(a=aAndnotsel, b=bAndsel, out=out);
}
```

### Implementation of Multiplexor Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class Mux_Gate extends And_Gate {

    protected static int Mux(int a, int b, int sel) {
        int first = And(a, Not(sel));
        int second = And(b, sel);
        return Or_Gate.Or(first, second);
    }
}
```
