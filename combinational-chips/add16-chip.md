---
description: >-
  Abstraction and Implementation of 16-bit Adder Chip in Hardware Design
  Language and Java™.
---

# Add16 Chip

### Add16 (16-bit Adder) Chip

16-bit Adder chip is used to add two 16-bit numbers.

```nand2tetris-hdl
Chip name: Add16
Inputs: a[16], b[16]
Outputs: out[16]
Function: out = a + b
Comment: Integer 2's complement addition.
Overflow is neither detected nor handled
```

![Abstraction of 16-bit Adder Chip - Representation and Truth Table](<../.gitbook/assets/img (3) (1).png>)

### Implementation of 16-bit Adder Chip in HDL

The function in the above abstraction can help in the implementation of 16-bit Adder Chip.

{% hint style="info" %}
You can use the Half Adder and Full Adder Chips you've built earlier.
{% endhint %}

```nand2tetris-hdl
CHIP Add16 {
    IN a[16], b[16];
    OUT out[16];

    PARTS:
   HalfAdder(a=a[0], b=b[0], sum=out[0], carry=c1);
   FullAdder(a=a[1], b=b[1], c=c1, sum=out[1], carry=c2);
   FullAdder(a=a[2], b=b[2], c=c2, sum=out[2], carry=c3);
   FullAdder(a=a[3], b=b[3], c=c3, sum=out[3], carry=c4);
   FullAdder(a=a[4], b=b[4], c=c4, sum=out[4], carry=c5);
   FullAdder(a=a[5], b=b[5], c=c5, sum=out[5], carry=c6);
   FullAdder(a=a[6], b=b[6], c=c6, sum=out[6], carry=c7);
   FullAdder(a=a[7], b=b[7], c=c7, sum=out[7], carry=c8);
   FullAdder(a=a[8], b=b[8], c=c8, sum=out[8], carry=c9);
   FullAdder(a=a[9], b=b[9], c=c9, sum=out[9], carry=c10);
   FullAdder(a=a[10], b=b[10], c=c10, sum=out[10], carry=c11);
   FullAdder(a=a[11], b=b[11], c=c11, sum=out[11], carry=c12);
   FullAdder(a=a[12], b=b[12], c=c12, sum=out[12], carry=c13);
   FullAdder(a=a[13], b=b[13], c=c13, sum=out[13], carry=c14);
   FullAdder(a=a[14], b=b[14], c=c14, sum=out[14], carry=c15);
   FullAdder(a=a[15], b=b[15], c=c15, sum=out[15], carry=c16);
}
```

### Implementation of 16-bit Adder Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Add16_Gate extends FullAdder_Gate {

    protected static int[] Add16(int[] a, int[] b) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] out = new int[16];
        int[] temp1 = HalfAdder(arr_a[arr_a.length-1], arr_b[arr_b.length-1]);
        out[out.length-1] = temp1[0];

        for (int i = a.length-2; i >= 0; --i) {
            int[] temp2 = FullAdder(arr_a[i], arr_b[i], temp1[1]);
            temp1 = temp2;
            out[i] = temp1[0];
            // Most significant bit is dropped
        }

        return out;
    }
}
```

{% hint style="info" %}
The Most Significant Bit is dropped.
{% endhint %}
