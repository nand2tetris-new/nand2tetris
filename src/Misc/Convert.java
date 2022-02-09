package Misc;

public class Convert {

    public static int Bool2Int(boolean bool) {
        int value;
        if (bool) {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }

    public static boolean Int2Bool(int value) {
        boolean bool;
        if (value == 1) {
            bool = true;
        } else {
            bool = false;
        }
        return bool;
    }

    public static int[] Arrayto16(int[] in) {
        int[] inp16 = new int[16];

        System.arraycopy(in, 0, inp16, 0, in.length);
        // arraycopy is used so that leading zeros is present
        
        return inp16;
    }
}