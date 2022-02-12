---
description: >-
  Misc is a package in Java™ Implementation of nand2tetris. It contains basic
  utilites and reusable codes for creation and modification of chips and its
  outputs.
---

# Int2Bool

### Int2Bool Method in class Convert

**Input:** Integer

**Output:** Boolean&#x20;

```java
    public static boolean Int2Bool(int value) {
        boolean bool;
        if (value == 1) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }
```

Unlike most programming languages, Java treats boolean and integer data types unusually. However, some of the implemented gates needs values in the form of binary values (0 or 1). Therefore, a method Int2Bool is created to convert integer values (0 and 1) to boolean (true and false) for comparisons.
