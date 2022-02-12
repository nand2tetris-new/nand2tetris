package CombChips;

import Misc.Convert;

class Subtract16_Gate extends FullSubtractor_Gate {

    protected static int[] Subtract16(int[] a, int[] b) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] out = new int[16];
        int[] temp1 = HalfSubtractor(arr_a[arr_a.length-1], arr_b[arr_b.length-1]);
        out[out.length-1] = temp1[0];

        for (int i = a.length-2; i >= 0; --i) {
            int[] temp2 = FullSubtractor(arr_a[i], arr_b[i], temp1[1]);
            temp1 = temp2;
            out[i] = temp1[0];
            // Most significant bit is dropped
        }

        return out;
    }
}