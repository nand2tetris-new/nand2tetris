---
description: >-
  Abstraction and Implementation of Full Subtractor Chip in Hardware Design
  Language and Java™.
---

# Full Subtractor Chip

### Full Subtractor Chip

Full Subtractor chip is used to subtract 3-bits.

```nand2tetris-hdl
Chip name: FullSubtractor
Inputs: a, b, c
Outputs: diff, borrow
Function: diff = LSB of a - b - c
          borrow = MSB of a - b - c
```

![Abstraction of Full Subtractor Chip - Representation, Implementation and Truth Table](http://1.bp.blogspot.com/-SUJYo2O1jnw/U41tbmBrd1I/AAAAAAAAAUI/htiQFMZFrrA/s1600/fs.JPG)

### Implementation of Full Subtractor Chip in HDL

The function in the above abstraction can help in the implementation of Full Subtractor Chip.

{% hint style="info" %}
diff = a XOR b XOR c

borrow = (a' AND b) OR (b AND c) OR (a' AND c)
{% endhint %}

```nand2tetris-hdl
CHIP FullSubtractor {
    IN a, b, c;  // 1-bit inputs
    OUT diff,     // Right bit of a + b + c
        borrow;   // Left bit of a + b + c

    PARTS:
    // Put you code here:
    HalfSubtractor(a=a, b=b, diff=diffab, borrow=borrowab);
    HalfSubtractor(a=diffab, b=c, diff=diff, borrow=temp);
    Or(a=temp, b=borrowab, out=borrow);
}
```

### Implementation of Full Subtractor Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class FullSubtractor_Gate extends HalfSubtractor_Gate {

    protected static int[] FullSubtractor(int a, int b, int c) {
        int[] out = new int[2];

        int[] ab = HalfSubtractor(a, b);
        int[] temp = HalfSubtractor(ab[0], c);
        int borrow = Or_Gate.Or(temp[1], ab[1]);

        out[0] = temp[0];
        out[1] = borrow;

        return out;
    }
}
```
