package CombChips;

import Misc.Convert;

class And16_Gate extends And_Gate {

    protected static int[] And16(int[] a, int[] b) {
        int[] out = new int[16];
        
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        
        for (int i = 0; i < arr_a.length; ++i) {
            out[i] = And(arr_a[i], arr_b[i]);
        }

        return out;
    }
}
