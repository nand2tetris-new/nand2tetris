---
description: >-
  Abstraction and Implementation of 16-bit Subtractor Chip in Hardware Design
  Language and Java™.
---

# Subtract16 Chip

### Subtract16 (16-bit Subtractor) Chip

16-bit Subtractor chip is used to subtract 3-bits.

```nand2tetris-hdl
Chip name: Subtract16
Inputs: a[16], b[16]
Outputs: out[16]
Function: out = a - b
```

### Implementation of 16-bit Subtractor Chip in HDL

The function in the above abstraction can help in the implementation of 16-bit Subtractor Chip.

The implementation of 16-bit Subtractor is analogous to 16-bit Adder.

```nand2tetris-hdl
CHIP Subtract16 {
    IN a[16], b[16];
    OUT out[16];

    PARTS:
   // Put you code here:
   HalfSubtractor(a=a[0], b=b[0], diff=out[0], borrow=c1);
   FullSubtractor(a=a[1], b=b[1], c=c1, diff=out[1], borrow=c2);
   FullSubtractor(a=a[2], b=b[2], c=c2, diff=out[2], borrow=c3);
   FullSubtractor(a=a[3], b=b[3], c=c3, diff=out[3], borrow=c4);
   FullSubtractor(a=a[4], b=b[4], c=c4, diff=out[4], borrow=c5);
   FullSubtractor(a=a[5], b=b[5], c=c5, diff=out[5], borrow=c6);
   FullSubtractor(a=a[6], b=b[6], c=c6, diff=out[6], borrow=c7);
   FullSubtractor(a=a[7], b=b[7], c=c7, diff=out[7], borrow=c8);
   FullSubtractor(a=a[8], b=b[8], c=c8, diff=out[8], borrow=c9);
   FullSubtractor(a=a[9], b=b[9], c=c9, diff=out[9], borrow=c10);
   FullSubtractor(a=a[10], b=b[10], c=c10, diff=out[10], borrow=c11);
   FullSubtractor(a=a[11], b=b[11], c=c11, diff=out[11], borrow=c12);
   FullSubtractor(a=a[12], b=b[12], c=c12, diff=out[12], borrow=c13);
   FullSubtractor(a=a[13], b=b[13], c=c13, diff=out[13], borrow=c14);
   FullSubtractor(a=a[14], b=b[14], c=c14, diff=out[14], borrow=c15);
   FullSubtractor(a=a[15], b=b[15], c=c15, diff=out[15], borrow=c16);
}
```

### Implementation of 16-bit Subtractor Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Subtract16_Gate extends FullSubtractor_Gate {

    protected static int[] Subtract16(int[] a, int[] b) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] out = new int[16];
        int[] temp1 = HalfSubtractor(arr_a[arr_a.length-1], arr_b[arr_b.length-1]);
        out[out.length-1] = temp1[0];

        for (int i = a.length-2; i >= 0; --i) {
            int[] temp2 = FullSubtractor(arr_a[i], arr_b[i], temp1[1]);
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
