---
description: >-
  Abstraction and Implementation of 16-bit Not Chip in Hardware Design Language
  and Java™.
---

# Not16 Chip

### Not16 (16-bit Not) Chip

Unlike Not gate, Not16 takes 16-bit input, inverts each bit and produces output.

In other words, An 16-bit Not Chip applies the boolean operation Not to every one of the bits in its 16-bit input bus.

```nand2tetris-hdl
Chip name: Not16
Inputs: in[16] // a 16-bit pin
Outputs: out[16]
Function: For i=0..15 out[i]=Not(in[i]).
```

### Implementation of Not16 Chip in HDL

The function in the above abstraction can help in the implementation of Not16 Chip.

```nand2tetris-hdl
CHIP Not16 {
    IN in[16];
    OUT out[16];

    PARTS:
    Not(in=in[0], out=out[0]);
    Not(in=in[1], out=out[1]);
    Not(in=in[2], out=out[2]);
    Not(in=in[3], out=out[3]);
    Not(in=in[4], out=out[4]);
    Not(in=in[5], out=out[5]);
    Not(in=in[6], out=out[6]);
    Not(in=in[7], out=out[7]);
    Not(in=in[8], out=out[8]);
    Not(in=in[9], out=out[9]);
    Not(in=in[10], out=out[10]);
    Not(in=in[11], out=out[11]);
    Not(in=in[12], out=out[12]);
    Not(in=in[13], out=out[13]);
    Not(in=in[14], out=out[14]);
    Not(in=in[15], out=out[15]);
}
```

### Implementation of Not16 Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Not16_Gate extends Not_Gate {

    protected static int[] Not16(int[] in) {
        int[] arr_in = Convert.Arrayto16(in);

        int[] out = new int[16];
        for (int i = 0; i < arr_in.length; ++i) {
            out[i] = Not(arr_in[i]);
        }

        return out;
    }
}
```
