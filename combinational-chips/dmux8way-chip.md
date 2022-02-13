---
description: >-
  Abstraction and Implementation of 8-way Demultiplexor Chip in Hardware Design
  Language and Java™.
---

# DMux8Way Chip

### DMux8Way (8-way Demultiplexor) Chip

An 8-way Demultiplexor chip outputs the given input to certain output pin, which is specified by selector bit.

{% hint style="info" %}
Width of selector bit = (log 8) to the base 2 = 3
{% endhint %}

```nand2tetris-hdl
Chip name: DMux8Way
Inputs: in, sel[3]
Outputs: a, b, c, d, e, f, g, h
Function: If sel=000 then {a=in, b=c=d=e=f=g=h=0}
                else if sel=001 then {b=in, a=c=d=e=f=g=h=0}
                else if sel=010 ...
                ...
                else if sel=111 then {h=in, a=b=c=d=e=f=g=0}.
```

![Abstraction of 8-way Demultiplexor Chip - Representation](https://www.electronicshub.org/wp-content/uploads/2015/07/1-to-8-Demux.jpg)

### Implementation of DMux8Way Chip in HDL

The function in the above abstraction can help in the implementation of DMux8Way Chip.

{% hint style="info" %}
You can use the DMux4Way Chip that you've built earlier.
{% endhint %}

```nand2tetris-hdl
CHIP DMux8Way {
    IN in, sel[3];
    OUT a, b, c, d, e, f, g, h;

    PARTS:
    DMux(in=in, sel=sel[2], a=abcd, b=efgh);
    DMux4Way(in=abcd, sel=sel[0..1], a=a, b=b, c=c, d=d);
    DMux4Way(in=efgh, sel=sel[0..1], a=e, b=f, c=g, d=h);
}
```

### Implementation of DMux8Way Chip in Java™

_Similar to the Implementation in HDL_

```java
package CombChips;

class DMux8Way_Gate extends DMux4Way_Gate {
    
    protected static int[] DMux8Way(int in, int sel) {
        int[] arr_sel = new int[3];

        int[] subarr_sel = new int[2];
        System.arraycopy(arr_sel, 1, subarr_sel, 0, subarr_sel.length);

        int[] temp = DMux(in, arr_sel[0]);
        int[] temp1 = DMux4Way(temp[0], subarr_sel);
        int[] temp2 = DMux4Way(temp[1], subarr_sel);

        int[] out = new int[4];
        System.arraycopy(temp1, 0, out, 0, temp1.length);
        System.arraycopy(temp2, 0, out, temp1.length, temp2.length);

        return out;
    }
}
```
