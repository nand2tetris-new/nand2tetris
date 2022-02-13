---
description: >-
  Abstraction and Implementation of (16-bit) Arithmetic Chip in Hardware Design
  Language and Java™.
---

# Arithmetic Chip

### Arithmetic Chip

Arithmetic Chip is an 16-bit user-defined chip, is a mixed implementation of 16-bit Adder and 16-bit Subtractor (also known as Parallel Adder and Parallel Subtractor respectively).

![Abstraction and Implementation of Arithmetic Chip](<../.gitbook/assets/img (4).png>)

```nand2tetris-hdl
Chip name: Arithmetic
Inputs: a[16], b[16]
Outputs: out[16]
Function: if (select == 1) then out = a + b
          else out = a - b
```

### Implementation of Arithmetic Chip in HDL

{% hint style="info" %}
You can use 16-bit Multiplexor that you've created earlier.
{% endhint %}

```nand2tetris-hdl
CHIP Arithmetic {
    IN a[16], b[16], sel;
    OUT out[16];

    PARTS:
   Add16(a=a, b=b, out=addab);
   Subtract16(a=a, b=b, out=diffab);
   Mux16(a=diffab, b=addab, sel=sel, out=out);
}
```

### Implementation of Arithmetic Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Arithmetic_Gate extends Mux16_Gate {
    
    protected static int[] Arithmetic(int[] a, int[] b, int sel) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] addab = Add16_Gate.Add16(arr_a, arr_b);
        int[] subtractab = Subtract16_Gate.Subtract16(arr_a, arr_b);
        int[] out = Mux16(subtractab, addab, sel);

        return out;
    }
}
```
