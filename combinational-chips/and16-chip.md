---
description: >-
  Abstraction and Implementation of 16-bit And Chip in Hardware Design Language
  and Java™.
---

# And16 Chip

### And16 (16-bit And) Chip

An 16-bit And Chip applies the boolean operation And to every one of the bits in its 16-bit input bus.

```nand2tetris-hdl
Chip name: And16
Inputs: a[16], b[16]
Outputs: out[16]
Function: For i=0..15 out[i]=And(a[i],b[i]).
```

### Implementation of And16 Chip in HDL

The function in the above abstraction can help in the implementation of And16 Chip.

```nand2tetris-hdl
CHIP And16 {
    IN a[16], b[16];
    OUT out[16];

    PARTS:
    And(a=a[0], b=b[0], out=out[0]);
    And(a=a[1], b=b[1], out=out[1]);
    And(a=a[2], b=b[2], out=out[2]);
    And(a=a[3], b=b[3], out=out[3]);
    And(a=a[4], b=b[4], out=out[4]);
    And(a=a[5], b=b[5], out=out[5]);
    And(a=a[6], b=b[6], out=out[6]);
    And(a=a[7], b=b[7], out=out[7]);
    And(a=a[8], b=b[8], out=out[8]);
    And(a=a[9], b=b[9], out=out[9]);
    And(a=a[10], b=b[10], out=out[10]);
    And(a=a[11], b=b[11], out=out[11]);
    And(a=a[12], b=b[12], out=out[12]);
    And(a=a[13], b=b[13], out=out[13]);
    And(a=a[14], b=b[14], out=out[14]);
    And(a=a[15], b=b[15], out=out[15]);
}
```

### Implementation of And16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class And16_Gate extends And_Gate {

    protected static int[] And16(int[] a, int[] b) {
        int[] out = new int[16];
        
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        
        for (int i = 0; i < arr_a.length; ++i) {
            out[i] = And(arr_a[i], arr_b[i]);
        }

        return out;
    }
}
```
