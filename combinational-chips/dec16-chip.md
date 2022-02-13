---
description: >-
  Abstraction and Implementation of 16-bit Decrementer Chip in Hardware Design
  Language and Java™.
---

# Dec16 Chip

### Dec16 (16-bit Decrementer) Chip

16-bit Decrementer chip is a special kind of Subtractor, used to decrement a 16-bit input by 1.

```nand2tetris-hdl
Chip name: Dec16
Inputs: in[16]
Outputs: out[16]
Function: out=in-1
```

### Implementation of 16-bit Decrementer Chip in HDL

The function in the above abstraction can help in the implementation of 16-bit Decrementer Chip.

The implementation of 16-bit Decrementer is analogous to 16-bit Incrementer.

{% hint style="info" %}
You can use the Subtract16 Chip you've built earlier.

Remember that 1 in 4-bit binary (say) is 0001.
{% endhint %}

```nand2tetris-hdl
CHIP Dec16 {
    IN in[16];
    OUT out[16];

    PARTS:
   Subtract16(a=in, b[0]=true, out=out);
}
```

### Implementation of 16-bit Decrementer Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class Dec16_Gate extends Subtract16_Gate {
    
    protected static int[] Dec16(int[] in) {
        int[] b = new int[16];
        b[in.length-1] = 1;

        return Subtract16(in, b);
    }
}
```

{% hint style="info" %}
The Most Significant Bit is dropped.
{% endhint %}
