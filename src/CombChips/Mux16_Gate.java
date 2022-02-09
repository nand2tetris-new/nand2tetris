package CombChips;

import Misc.Convert;

class Mux16_Gate extends Mux_Gate {

    protected static int[] Mux16(int[] a, int[] b, int sel) {
        int[] out = new int[16];
        
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        
        for (int i = 0; i < arr_a.length; ++i) {
            out[i] = Mux(arr_a[i], arr_b[i], sel);
        }

        return out;
    }
}