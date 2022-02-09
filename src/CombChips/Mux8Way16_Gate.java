package CombChips;

import Misc.Convert;

class Mux8Way16_Gate extends Mux4Way16_Gate {

    protected static int[] Mux8Way16(int[] a, int[] b, int[] c, int[] d, int[] e, int[] f, int[] g, int[] h, int[] sel) {
                
        int[] arr_a = Convert.Arrayto16(a);
        int[] arr_b = Convert.Arrayto16(b);
        int[] arr_c = Convert.Arrayto16(c);
        int[] arr_d = Convert.Arrayto16(d);
        int[] arr_e = Convert.Arrayto16(a);
        int[] arr_f = Convert.Arrayto16(b);
        int[] arr_g = Convert.Arrayto16(c);
        int[] arr_h = Convert.Arrayto16(d);

        int[] arr_sel = new int[3];
        System.arraycopy(sel, 0, arr_sel, 0, arr_sel.length);

        int[] subarr_sel = new int[2];
        System.arraycopy(sel, 1, subarr_sel, 0, subarr_sel.length);

        int[] temp1 = Mux4Way16(arr_a, arr_b, arr_c, arr_d, subarr_sel);
        int[] temp2 = Mux4Way16(arr_e, arr_f, arr_g, arr_h, subarr_sel);
        int[] out = Mux16(temp1, temp2, arr_sel[0]);

        return out;
    }
}