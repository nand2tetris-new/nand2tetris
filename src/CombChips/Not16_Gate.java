package CombChips;

import Misc.Convert;

class Not16_Gate extends Not_Gate {

    protected static int[] Not16(int[] in) {
        int[] arr_in = Convert.Arrayto16(in);

        int[] out = new int[16];
        for (int i = 0; i < arr_in.length; ++i) {
            out[i] = Not(arr_in[i]);
        }

        return out;
    }
}