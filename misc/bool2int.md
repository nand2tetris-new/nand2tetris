---
description: >-
  Misc is a package in Java™ Implementation of nand2tetris. It contains basic
  utilites and reusable codes for creation and modification of chips and its
  outputs.
---

# Bool2Int

### Bool2Int Method in class Convert

**Input:** Boolean

**Output:** Integer

```java
    public static int Bool2Int(boolean bool) {
        int value;
        if (bool) {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }
```

Unlike most programming languages, Java treats boolean and integer data types unusually. However, some of the implemented gates needs to convert back to binary values after conversion to boolean. Therefore, a method Bool2Int is created to convert boolean values (true and false) to binary integral values (0 and 1) for faster computations.
