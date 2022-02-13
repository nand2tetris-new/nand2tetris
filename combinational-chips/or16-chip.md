---
description: >-
  Abstraction and Implementation of 16-bit Or Chip in Hardware Design Language
  and Java™.
---

# Or16 Chip

### Or16 (16-bit Or) Chip

An 16-bit Or Chip applies the boolean operation Or to every one of the bits in its 16-bit input bus.

```nand2tetris-hdl
Chip name: Or16
Inputs: a[16], b[16]
Outputs: out[16]
Function: For i=0..15 out[i]=Or(a[i],b[i]).
```

### Implementation of Or16 Chip in HDL

The function in the above abstraction can help in the implementation of Or16 Chip.

```nand2tetris-hdl
CHIP Or16 {
    IN a[16], b[16];
    OUT out[16];

    PARTS:
    Or(a=a[0], b=b[0], out=out[0]);
    Or(a=a[1], b=b[1], out=out[1]);
    Or(a=a[2], b=b[2], out=out[2]);
    Or(a=a[3], b=b[3], out=out[3]);
    Or(a=a[4], b=b[4], out=out[4]);
    Or(a=a[5], b=b[5], out=out[5]);
    Or(a=a[6], b=b[6], out=out[6]);
    Or(a=a[7], b=b[7], out=out[7]);
    Or(a=a[8], b=b[8], out=out[8]);
    Or(a=a[9], b=b[9], out=out[9]);
    Or(a=a[10], b=b[10], out=out[10]);
    Or(a=a[11], b=b[11], out=out[11]);
    Or(a=a[12], b=b[12], out=out[12]);
    Or(a=a[13], b=b[13], out=out[13]);
    Or(a=a[14], b=b[14], out=out[14]);
    Or(a=a[15], b=b[15], out=out[15]);
}
```

### Implementation of Or16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Or16_Gate extends Or_Gate {

    protected static int[] Or16(int[] a, int[] b) {
        int[] out = new int[16];
        
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        
        for (int i = 0; i < arr_a.length; ++i) {
            out[i] = Or(arr_a[i], arr_b[i]);
        }

        return out;
    }
}
```
