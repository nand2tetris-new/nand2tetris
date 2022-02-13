package CombChips;

import Misc.Convert;

class Arithmetic_Gate extends Mux16_Gate {
    
    protected static int[] Arithmetic(int[] a, int[] b, int sel) {
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);

        int[] addab = Add16_Gate.Add16(arr_a, arr_b);
        int[] subtractab = Subtract16_Gate.Subtract16(arr_a, arr_b);
        int[] out = Mux16(subtractab, addab, sel);

        return out;
    }
}