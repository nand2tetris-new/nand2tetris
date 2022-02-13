---
description: >-
  Abstraction and Implementation of 4-way 16-bit Multiplexor Chip in Hardware
  Design Language and Java™.
---

# Mux4Way16 Chip

### Mux4Way16 (4-way 16-bit Multiplexor) Chip

An 4-way 16-bit Multiplexor chip outputs one of the given four 16-bit inputs, which is specified by selector bit.

{% hint style="info" %}
An m-way n-bit multiplexor selects one of m n-bit input buses and outputs it to a single n-bit output bus. The selection is specified by a set of k control bits, where k = (log m to the base 2).
{% endhint %}

Unlike n-bit input logic gates, n-way logic gates use the same output iteratively over the boolean operation, which means, it uses the previous output as input for the next similar boolean operation.

```nand2tetris-hdl
Chip name: Mux4Way16
Inputs: a[16], b[16], c[16], d[16], sel[2]
Outputs: out[16]
Function: If sel=00 then out=a 
                else if sel=01 then out=b
                else if sel=10 then out=c
                else if sel=11 then out=d
Comment: The assignment operations mentioned above are all
16-bit. For example, "out=a" means "for i=0..15
out[i]=a[i]".
```

![Abstraction of 4-way 16-bit Multiplexor Chip - Representation and Truth Table](<../.gitbook/assets/img (4).png>)

### Implementation of Mux4Way16 Chip in HDL

The function in the above abstraction can help in the implementation of Mux4Way16 Chip.

{% hint style="info" %}
You can use the Mux16 chip that you've built earlier.
{% endhint %}

```nand2tetris-hdl
CHIP Mux4Way16 {
    IN a[16], b[16], c[16], d[16], sel[2];
    OUT out[16];

    PARTS:
    Mux16(a=a, b=b, sel=sel[0], out=ab);
    Mux16(a=c, b=d, sel=sel[0], out=cd);
    Mux16(a=ab, b=cd, sel=sel[1], out=out);
}
```

### Implementation of Mux4Way16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Mux4Way16_Gate extends Mux16_Gate {

    protected static int[] Mux4Way16(int[] a, int[] b, int[] c, int[] d, int[] sel) {
                
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        int[] arr_c = Convert.Arrayto16(c);
        int[] arr_d = Convert.Arrayto16(d);
        
        int[] arr_sel = new int[2];
        System.arraycopy(sel, 0, arr_sel, 0, arr_sel.length);

        int[] temp1 = Mux16(arr_a, arr_b, arr_sel[1]);
        int[] temp2 = Mux16(arr_c, arr_d, arr_sel[1]);
        int[] out = Mux16(temp1, temp2, arr_sel[0]);

        return out;
    }
}
```
