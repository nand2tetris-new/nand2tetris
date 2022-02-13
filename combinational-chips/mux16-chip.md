---
description: >-
  Abstraction and Implementation of 16-bit Multiplexor Chip in Hardware Design
  Language and Java™.
---

# Mux16 Chip

### Mux16 (16-bit Multiplexor) Chip

An 16-bit multiplexor is almost similar to the Multiplexor Chip described previously, except that both inputs are each 16-bit wide, while the selector is a single bit.

```nand2tetris-hdl
Chip name: Mux16
Inputs: a[16], b[16], sel
Outputs: out[16]
Function: If sel=0 then for i=0..15 out[i]=a[i]
else for i=0..15 out[i]=b[i].
```

### Implementation of Mux16 Chip in HDL

The function in the above abstraction can help in the implementation of Mux16 Chip.

{% hint style="info" %}
The Mux16, can considered splitting into 16 Multiplexor chips, each taking a bit from each input. Each Multiplexor chip uses the same single-bit register.
{% endhint %}

```nand2tetris-hdl
CHIP Mux16 {
    IN a[16], b[16], sel;
    OUT out[16];

    PARTS:
    Mux(a=a[0], b=b[0], sel=sel, out=out[0]);
    Mux(a=a[1], b=b[1], sel=sel, out=out[1]);
    Mux(a=a[2], b=b[2], sel=sel, out=out[2]);
    Mux(a=a[3], b=b[3], sel=sel, out=out[3]);
    Mux(a=a[4], b=b[4], sel=sel, out=out[4]);
    Mux(a=a[5], b=b[5], sel=sel, out=out[5]);
    Mux(a=a[6], b=b[6], sel=sel, out=out[6]);
    Mux(a=a[7], b=b[7], sel=sel, out=out[7]);
    Mux(a=a[8], b=b[8], sel=sel, out=out[8]);
    Mux(a=a[9], b=b[9], sel=sel, out=out[9]);
    Mux(a=a[10], b=b[10], sel=sel, out=out[10]);
    Mux(a=a[11], b=b[11], sel=sel, out=out[11]);
    Mux(a=a[12], b=b[12], sel=sel, out=out[12]);
    Mux(a=a[13], b=b[13], sel=sel, out=out[13]);
    Mux(a=a[14], b=b[14], sel=sel, out=out[14]);
    Mux(a=a[15], b=b[15], sel=sel, out=out[15]);
}
```

### Implementation of Mux16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Mux16_Gate extends Mux_Gate {

    protected static int[] Mux16(int[] a, int[] b, int sel) {
        int[] out = new int[16];
        
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        
        for (int i = 0; i < arr_a.length; ++i) {
            out[i] = Mux(arr_a[i], arr_b[i], sel);
        }

        return out;
    }
}
```
