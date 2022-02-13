---
description: >-
  Abstraction and Implementation of Half Adder Chip in Hardware Design Language
  and Java™.
---

# Half Adder Chip

### Adder Chip

The chip used to add two n-bit numbers is known as Adder, also known as n-bit Adder.

### Half Adder Chip

Half Adder chip is used to add 2-bits.

```nand2tetris-hdl
Chip name: HalfAdder
Inputs: a, b
Outputs: sum, carry
Function: sum = LSB of a + b
          carry = MSB of a + b
```

![Abstraction of Half Adder Chip - Representation and Truth Table](<../.gitbook/assets/img (1) (1).png>)

### Implementation of Half Adder Chip in HDL

The function in the above abstraction can help in the implementation of Half Adder Chip.

{% hint style="info" %}
sum = a XOR b

carry = a AND b
{% endhint %}

```nand2tetris-hdl
CHIP HalfAdder {
    IN a, b;    // 1-bit inputs
    OUT sum,    // Right bit of a + b 
        carry;  // Left bit of a + b

    PARTS:
    Xor(a=a, b=b, out=sum);
    And(a=a, b=b, out=carry);
}
```

### Implementation of Half Adder Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class HalfAdder_Gate extends Xor_Gate {

    protected static int[] HalfAdder(int a, int b) {
        int[] out = new int[2];

        // sum
        out[0] = Xor(a, b);

        // carry
        out[1] = And_Gate.And(a, b);

        return out;
    }
}
```
