package CombChips;

import Misc.Convert;

class Add16_Gate extends FullAdder_Gate {

    protected static int[] Add16(int[] a, int[] b) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] out = HalfAdder(arr_a[0], arr_b[0]);

        for (int i = 1; i < arr_a.length; ++i) {
            int[] temp2 = FullAdder(a[i], b[i], out[1]);
            out = temp2;
        }

        return out;
    }
}