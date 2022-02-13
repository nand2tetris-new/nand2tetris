---
description: >-
  Abstraction and Implementation of Xor Gate in Hardware Design Language and
  Java™.
---

# Xor Gate

### Xor Gate

The Xor function, also known as Exclusive-OR, returns 1 (true) when either of the inputs are same (both are 0 or both are 1 simultaneously).

![Abstraction of Xor Gate - Representation and Truth Table](https://sub.allaboutcircuits.com/images/04116.png)

### Implementation of Xor Gate in HDL

Xor Gate can be implemented in four ways: (in fact, they are simplifications by DeMorgan's laws.)

* Xor Gate can be implemented using Not, And and Or gates implemented previously as follows:

![Implementation of Xor Gate using two Not gates, two And gates and an Or gate.](https://www.electronicshub.org/wp-content/uploads/2015/07/exor-equivalent-circuit.jpg)

* Another way to implement is to substitute all gates with basic Nand gates, eventually ending up with four Nand gates.

![Implementation of Xor Gate using four Nand Ga](https://www.electronicshub.org/wp-content/uploads/2015/07/XOR-USING-NAND.jpg)

* We can simply the expression of first implementation of Xor gate as follows:

{% hint style="info" %}
Output = A'B + B'A

&#x20;            \= A'A + A'B + B'A + B'B (since A'A = B'B = 1)

&#x20;            \= (A + B)(A' + B')
{% endhint %}

![Another Implementation of Xor Gate using two Not gates, two Or gates and an And gate.](<../.gitbook/assets/image (1).png>)

* In the expression of third implementation of Xor gate, A' + B' can be rewritten as (AB)' \[ Nand gate ] using DeMorgan's laws.

![Implementation of Xor using Or, Nand and And gates.](https://www.electronicshub.org/wp-content/uploads/2015/07/USING-AND-OR-NAND-GATES.jpg)

{% hint style="info" %}
(A + B)(A' + B') = (A + B)(AB)'
{% endhint %}

```nand2tetris-hdl
CHIP Xor {
    IN a, b;
    OUT out;

    PARTS:
    Not(in=a, out=nota);
    Not(in=b, out=notb);
    Or(a=a, b=notb, out=aOrnotb);
    Or(a=nota, b=b, out=notaOrb);
    And(a=aOrnotb, b=notaOrb, out=out);
}
```

### Implementation of Xor Gate in Java™

_Similar to the implementations in HDL. While we're not going to implement every implementation, you can try other implementations to see if it works._

```java
package CombChips;

class Xor_Gate extends Or_Gate {

    protected static int Xor(int a, int b) {
        int OrofNots = Or(Not(a), Not(b));
        int Or = Or(a, b);
        return And_Gate.And(Or, OrofNots);
    }
}
```
