---
description: >-
  Abstraction and Implementation of 16-bit Incrementer Chip in Hardware Design
  Language and Java™.
---

# Inc16 Chip

### Inc16 (16-bit Incrementer) Chip

16-bit Incrementer chip is a special kind of Adder, used to increment a 16-bit input by 1.

```nand2tetris-hdl
Chip name: Inc16
Inputs: in[16]
Outputs: out[16]
Function: out=in+1
Comment: Integer 2’s complement addition.
Overflow is neither detected nor handled.
```

![Abstraction of 16-bit Adder Chip - Representation and Truth Table](<../.gitbook/assets/img (3).png>)

### Implementation of 16-bit Incrementer Chip in HDL

The function in the above abstraction can help in the implementation of 16-bit Incrementer  Chip.

{% hint style="info" %}
You can use the Add16 Chip you've built earlier.

Remember that 1 in 4-bit binary (say) is 0001.
{% endhint %}

```nand2tetris-hdl
CHIP Inc16 {
    IN in[16];
    OUT out[16];

    PARTS:
   Add16(a=in, b[0]=true, out=out);
}
```

### Implementation of 16-bit Incrementer Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class Inc16_Gate extends Add16_Gate {
    
    protected static int[] Inc16(int[] in) {
        int[] b = new int[16];
        b[b.length-1] = 1;

        return Add16(in, b);
    }
}
```
