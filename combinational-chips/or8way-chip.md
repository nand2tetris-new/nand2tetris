---
description: >-
  Abstraction and Implementation of Or8Way Chip in Hardware Design Language and
  Java™.
---

# Or8Way Chip

### Or8Way (8-way Or) Chip

An 8-way Or gate outputs 1 when at least one bit of its 16-bit input is 1.

Unlike n-bit input logic gates, n-way logic gates use the same output iteratively over the boolean operation, which means, it uses the previous output as input for the next similar boolean operation.

```nand2tetris-hdl
Chip name: Or8Way
Inputs: in[8]
Outputs: out
Function: out=Or(in[0],in[1],...,in[7]).
```

### Implementation of Or8Way Chip in HDL

The function in the above abstraction can help in the implementation of Or8Way Chip.

```nand2tetris-hdl
CHIP Or8Way {
    IN in[8];
    OUT out;

    PARTS:
    Or(a=in[0], b=in[1], out=o1);
    Or(a=o1, b=in[2], out=o2);
    Or(a=o2, b=in[3], out=o3);
    Or(a=o3, b=in[4], out=o4);
    Or(a=o4, b=in[5], out=o5);
    Or(a=o5, b=in[6], out=o6);
    Or(a=o6, b=in[7], out=out);
}
```

### Implementation of Or8Way Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

import Misc.Convert;

class Or8Way_Gate extends Or_Gate {

    protected static int Or8Way(int[] in) {
        
        int[] arr_in = Convert.Arrayto16(in);

        int out = Or(arr_in[0], arr_in[1]);
        for (int i = 2; i < arr_in.length; ++i) {
            int temp= Or(out, arr_in[i]);
            out = temp;
        }
        
        return out;
    }
}
```
