---
description: >-
  Abstraction and Implementation of ALU (Arithmetic Logic Unit) in Hardware
  Design Language and Java™.
---

# ALU

### Arithmetic Logic Unit (ALU)

The Hack ALU computes a fixed set of functions on given two 16-bit inputs, out of which the function can be one of the possible eighteen functions.

We instruct the ALU which function to compute using six input bits, called **control bits** to the selected binary values.

{% hint style="info" %}
Since the overall operation is driven by six control bits, the total number of possible functions that ALU can potientially compute is 2^6 = 64 possible functions.
{% endhint %}

![Abstraction of ALU - Representation](<../.gitbook/assets/img (3).png>)

```nand2tetris-hdl
Chip name: ALU
Inputs: x[16], y[16], // Two 16-bit data inputs
        zx, // Zero the x input
        nx, // Negate the x input
        zy, // Zero the y input
        ny, // Negate the y input
        f, // Function code: 1 for Add, 0 for And
        no // Negate the out output

Outputs: out[16], // 16-bit output
                zr, // True iff out=0
                ng // True iff out<0

Function: if zx then x = 0 // 16-bit zero constant
                if nx then x = !x // Bit-wise negation
                if zy then y = 0 // 16-bit zero constant
                if ny then y = !y // Bit-wise negation
                if f then out = x + y // Integer 2's complement addition
                                else out = x & y // Bit-wise And
                if no then out = !out // Bit-wise negation
                if out=0 then zr = 1 else zr = 0 // 16-bit eq. comparison
                if out<0 then ng = 1 else ng = 0 // 16-bit neg. comparison

Comment: Overflow is neither detected nor handled.
```

![Abstraction of ALU - Truth Table with control bits](<../.gitbook/assets/img (2).png>)

{% hint style="info" %}
Control bits:

zx -- essentially named as zerox -- states whether x is 0 or not -- if zx = true, then x = 0.

nx -- essentially named as negationx -- states whether x will undergo negation or not -- if nx = true, then x will undergo negation.

zy -- essentially named as zeroy -- states whether y is 0 or not -- if zy = true, then y = 0.

ny -- essentially named as negationy -- states whether y will undergo negation or not -- if ny = true, then y will undergo negation.

f -- essentially named as function -- states whether addition or and function is selected -- if f = true, then execute function x + y ; else x & y

no -- essentially named as negationout -- states whether output will undergo negaton or not -- if no = true, then out will undergo negation.
{% endhint %}

{% hint style="info" %}
Output bits:

While output bits other than **out** is not shown in the truth table, there are two output bits -- zr & ng -- other than out.

zr -- essentially named as **z**e**r**o -- states whether the final output is zero or not. -- if out = 0; zr = true

ng -- essentially named as **n**e**g**ative -- states whether the final output is negative or not. -- if out = negative; ng = true
{% endhint %}

{% hint style="info" %}
Remember:

The nx and ny bits cause negation of x and negation of y respectively when true.

Negation (also known as Bitwise negation) of zero (000...00) is essentially (111...11), the 2's complement code of -1.
{% endhint %}

### Implementation of ALU in HDL

The ALU can be implemented using some of the gates we've learnt earlier.

```nand2tetris-hdl
CHIP ALU {
    IN  
        x[16], y[16],  // 16-bit inputs        
        zx, // zero the x input?
        nx, // negate the x input?
        zy, // zero the y input?
        ny, // negate the y input?
        f,  // compute out = x + y (if 1) or x & y (if 0)
        no; // negate the out output?

    OUT 
        out[16], // 16-bit output
        zr, // 1 if (out == 0), 0 otherwise
        ng; // 1 if (out < 0),  0 otherwise

    PARTS:

   // zx, nx
   Mux16(a=x, b=false, sel=zx, out=zerox);
   Not16(in=zerox, out=notx);
   Mux16(a=zerox, b=notx, sel=nx, out=inpx);

   // zy, ny
   Mux16(a=y, b=false, sel=zy, out=zeroy);
   Not16(in=zeroy, out=noty);
   Mux16(a=zeroy, b=noty, sel=ny, out=inpy);

   // f
   Add16(a=inpx, b=inpy, out=addxy);
   And16(a=inpx, b=inpy, out=andxy);
   Mux16(a=andxy, b=addxy, sel=f, out=fxy);

   // no, ng -- ng from Sign Magnitude Representation
   Not16(in=fxy, out=notfxy);
   Mux16(a=fxy, b=notfxy, sel=no, out=out, out[0..7] = pzr1, out[8..15] = pzr2, out[15] = ng);

   // zr
   Or8Way(in=pzr1, out=zr1);
   Or8Way(in=pzr2, out=zr2);
   Or(a=zr1, b=zr2, out=notzr);
   Not(in=notzr, out=zr);
}
```

### Implementation of ALU in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import java.util.Arrays;

import Misc.Convert;

class ALU_Design extends Mux16_Gate {
    // since Mux16 is the most used gate in ALU

    protected static int[][] ALU(int[] x, int[] y, int zx, int nx, int zy, int ny, int f, int no) {
        int[] arr_x = Convert.Arrayto16(x);
        int[] arr_y = Convert.Arrayto16(y);
        
        // zx, nx
        int[] zerox = Mux16(arr_x, new int[16], zx);
        int[] notx = Not16_Gate.Not16(zerox);
        int[] inpx = Mux16(zerox, notx, nx);

        // zy, ny
        int[] zeroy = Mux16(arr_y, new int[16], zy);
        int[] noty = Not16_Gate.Not16(zeroy);
        int[] inpy = Mux16(zeroy, noty, ny);

        // f
        int[] addxy = Add16_Gate.Add16(inpx, inpy);
        int[] andxy = And16_Gate.And16(inpx, inpy);
        int[] fxy = Mux16(andxy, addxy, f);

        // no, ng -- ng from Sign magnitude representation
        int[] notfxy = Not16_Gate.Not16(fxy);
        int[] out = Mux16(fxy, notfxy, no);

        int[] pzr1 = Arrays.copyOfRange(out, 0, 7);

        int[] pzr2 = Arrays.copyOfRange(out, 8, 15);

        // zr
        int zr1 = Or8Way_Gate.Or8Way(pzr1);
        int zr2 = Or8Way_Gate.Or8Way(pzr2);
        int notzr = Or_Gate.Or(zr1, zr2);
        int[] zr = new int[1];
        zr[0] = Not(notzr);

        // ng
        int[] ng = new int[1];
        ng[0] = out[out.length-1];

        // final array
        int[][] output = {out, zr, ng};
        return output;

    }
}
```

{% hint style="info" %}
The Most Significant Bit is dropped.
{% endhint %}
