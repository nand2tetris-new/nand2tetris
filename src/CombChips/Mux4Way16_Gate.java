package CombChips;

import Misc.Convert;

class Mux4Way16_Gate extends Mux16_Gate {

    protected static int[] Mux4Way16(int[] a, int[] b, int[] c, int[] d, int[] sel) {
                
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        int[] arr_c = Convert.Arrayto16(c);
        int[] arr_d = Convert.Arrayto16(d);
        
        int[] arr_sel = new int[2];
        System.arraycopy(sel, 0, arr_sel, 0, arr_sel.length);

        int[] temp1 = Mux16(arr_a, arr_b, arr_sel[1]);
        int[] temp2 = Mux16(arr_c, arr_d, arr_sel[1]);
        int[] out = Mux16(temp1, temp2, arr_sel[0]);

        return out;
    }
}