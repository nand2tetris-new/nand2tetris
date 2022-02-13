---
description: >-
  Abstraction and Implementation of Half Subtractor Chip in Hardware Design
  Language and Java™.
---

# Half Subtractor Chip

### Subtractor Chip

The chip used to sutract two n-bit numbers is known as Subtractor, also known as n-bit Subtractor.

### Half Subtractor Chip

Half Subtractor chip is used to subtract 2-bits.

```nand2tetris-hdl
Chip name: HalfSubtractor
Inputs: a, b
Outputs: diff, borrow
Function: diff = LSB of a - b
                borrow = MSB of a - b
```

![Abstraction of Half Subtractor Chip - Representation, Implementation and Truth Table](https://api-reader.tinkercad.com/api/images/bIqJR61LA2l/t725.jpg)

### Implementation of Half Subtractor Chip in HDL

The function in the above abstraction can help in the implementation of Half Subtractor Chip.

{% hint style="info" %}
diff = a XOR b

borrow = (NOT a) AND b
{% endhint %}

```nand2tetris-hdl
CHIP HalfSubtractor {
    IN a, b;    // 1-bit inputs
    OUT diff,    // Right bit of a + b 
        borrow;  // Left bit of a + b

    PARTS:
    Xor(a=a, b=b, out=diff);
    Not(in=a, out=nota);
    And(a=nota, b=b, out=borrow);
}
```

### Implementation of Half Subtractor Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class HalfSubtractor_Gate extends Xor_Gate {

    protected static int[] HalfSubtractor(int a, int b) {
        int[] out = new int[2];

        // sum
        out[0] = Xor(a, b);

        // borrow
        out[1] = And_Gate.And(Not(a), b);

        return out;
    }
}
```
