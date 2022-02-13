---
description: >-
  Abstraction and Implementation of 4-way Demultiplexor Chip in Hardware Design
  Language and Java™.
---

# DMux4Way Chip

### DMux4Way (4-way Demultiplexor) Chip

An 4-way Demultiplexor chip outputs the given input to certain output pin, which is specified by selector bit.

{% hint style="info" %}
An m-way n-bit demultiplexor channels a single n-bit input into one of m possible n-bit outputs. The selection is specified by a set of k control bits, where k = (log m) to the base 2.
{% endhint %}

```nand2tetris-hdl
Chip name: DMux4Way
Inputs: in, sel[2]
Outputs: a, b, c, d
Function: If sel=00 then {a=in, b=c=d=0}
                else if sel=01 then {b=in, a=c=d=0}
                else if sel=10 then {c=in, a=b=d=0}
                else if sel=11 then {d=in, a=b=c=0}.
```

![Abstraction of 4-way Demultiplexor Chip - Representation and Truth Table](<../.gitbook/assets/img (1).png>)

### Implementation of DMux4Way Chip in HDL

The function in the above abstraction can help in the implementation of DMux4Way Chip.

```nand2tetris-hdl
CHIP DMux4Way {
    IN in, sel[2];
    OUT a, b, c, d;

    PARTS:
    DMux(in=in, sel=sel[1], a=ab, b=cd);
    DMux(in=ab, sel=sel[0], a=a, b=b);
    DMux(in=cd, sel=sel[0], a=c, b=d);
}
```

### Implementation of DMux4Way Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class DMux4Way_Gate extends DMux_Gate {
    
    protected static int[] DMux4Way(int in, int[] sel) {
        int[] arr_sel = new int[2];

        int[] temp = DMux(in, arr_sel[0]);
        int[] temp1 = DMux(temp[0], arr_sel[1]);
        int[] temp2 = DMux(temp[1], arr_sel[1]);

        int[] out = new int[4];
        System.arraycopy(temp1, 0, out, 0, temp1.length);
        System.arraycopy(temp2, 0, out, temp1.length, temp2.length);

        return out;
    }
}
```
