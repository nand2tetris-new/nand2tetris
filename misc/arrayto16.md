---
description: >-
  Misc is a package in Java™ Implementation of nand2tetris. It contains basic
  utilites and reusable codes for creation and modification of chips and its
  outputs.
---

# Arrayto16

### Arrayto16 Method in class Convert

**Input:** Integer Array

**Output:** Integer Array

```java
    public static int[] Arrayto16(int[] in) {
        int[] inp16 = new int[16];

        System.arraycopy(in, 0, inp16, 0, in.length);
        // arraycopy is used so that leading zeros is present
        
        return inp16;
    }
```

Generally, you may encounter situations where you want to give an input of less than 16 bits or the value in the integer parameter has leading zeros, this may lead to **ArrayIndexOutOfBoundsException.** To avoid such issues, the method Arrayto16 is created, so that the size of the array is always 16. The arraycopy method from system is used to implement leading zeros.

{% hint style="warning" %}
Unlike nand2tetris, where <mark style="color:purple;">**HDL considers arrays from right to left**</mark>**, **<mark style="color:orange;">**Java considers arrays from left to right**</mark><mark style="color:orange;">.</mark>&#x20;
{% endhint %}
