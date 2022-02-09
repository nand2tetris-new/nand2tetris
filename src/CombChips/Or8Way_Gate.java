package CombChips;

import Misc.Convert;

class Or8Way_Gate extends Or_Gate {

    protected static int Or8Way(int[] in) {
        
        int[] arr_in = Convert.Arrayto16(in);

        int out = Or(arr_in[0], arr_in[1]);
        for (int i = 2; i < arr_in.length; ++i) {
            int temp= Or(out, arr_in[i]);
            out = temp;
        }
        
        return out;
    }
}