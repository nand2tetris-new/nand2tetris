---
description: >-
  Abstraction and Implementation of 8-way 16-bit Multiplexor Chip in Hardware
  Design Language and Java™.
---

# Mux8Way16 Chip

### Mux8Way16 (8-way 16-bit Multiplexor) Chip

An 8-way 16-bit Multiplexor chip outputs one of the given eight 16-bit inputs, which is specified by selector bit.

{% hint style="info" %}
Width of selector bit = (log 8) to the base 2 = 3
{% endhint %}

```nand2tetris-hdl
Chip name: Mux8Way16
Inputs: a[16],b[16],c[16],d[16],e[16],f[16],g[16],h[16],
sel[3]
Outputs: out[16]
Function: If sel=000 then out=a 
                else if sel=001 then out=b
                else if sel=010 then out=c
                ... 
                else if sel=111 then out=h
Comment: The assignment operations mentioned above are all
16-bit. For example, "out=a" means "for i=0..15
out[i]=a[i]".
```

![Abstraction of 8-way 16-bit Multiplexor Chip - Representation and Truth Table](https://www.tutorialspoint.com/digital\_circuits/images/8\_1\_multiplexer.jpg)

### Implementation of Mux8Way16 Chip in HDL

The function in the above abstraction can help in the implementation of Mux8Way16 Chip.

{% hint style="info" %}
You can use the Mux4Way16 chip that you've built earlier.
{% endhint %}

```nand2tetris-hdl
CHIP Mux8Way16 {
    IN a[16], b[16], c[16], d[16],
       e[16], f[16], g[16], h[16],
       sel[3];
    OUT out[16];

    PARTS:
    Mux16(a=a, b=b, c=c, d=d, sel=sel[0..1], out=abcd);
    Mux16(a=e, b=f, c=g, d=h, sel=sel[0..1], out=efgh);
    Mux16(a=abcd, b=efgh, sel=sel[2], out=out);
}
```

### Implementation of Mux8Way16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Mux8Way16_Gate extends Mux4Way16_Gate {

    protected static int[] Mux8Way16(int[] a, int[] b, int[] c, int[] d, int[] e, int[] f, int[] g, int[] h, int[] sel) {
                
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        int[] arr_c = Convert.Arrayto16(c);
        int[] arr_d = Convert.Arrayto16(d);
        int[] arr_e = Convert.Arrayto16(a);
        int[] arr_f = Convert.Arrayto16(b);
        int[] arr_g = Convert.Arrayto16(c);
        int[] arr_h = Convert.Arrayto16(d);

        int[] arr_sel = new int[3];
        System.arraycopy(sel, 0, arr_sel, 0, arr_sel.length);

        int[] subarr_sel = new int[2];
        System.arraycopy(sel, 1, subarr_sel, 0, subarr_sel.length);

        int[] temp1 = Mux4Way16(arr_a, arr_b, arr_c, arr_d, subarr_sel);
        int[] temp2 = Mux4Way16(arr_e, arr_f, arr_g, arr_h, subarr_sel);
        int[] out = Mux16(temp1, temp2, arr_sel[0]);

        return out;
    }
}
```
