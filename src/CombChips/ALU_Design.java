package CombChips;

import java.util.Arrays;

import Misc.Convert;

class ALU_Design extends Mux16_Gate {
    // since Mux16 is the most used gate in ALU

    protected static int[][] ALU(int[] x, int[] y, int zx, int nx, int zy, int ny, int f, int no) {
        int[] arr_x = Convert.Arrayto16(x);
        int[] arr_y = Convert.Arrayto16(y);
        
        // zx, nx
        int[] zerox = Mux16(arr_x, new int[16], zx);
        int[] notx = Not16_Gate.Not16(zerox);
        int[] inpx = Mux16(zerox, notx, nx);

        // zy, ny
        int[] zeroy = Mux16(arr_y, new int[16], zy);
        int[] noty = Not16_Gate.Not16(zeroy);
        int[] inpy = Mux16(zeroy, noty, ny);

        // f
        int[] addxy = Add16_Gate.Add16(inpx, inpy);
        int[] andxy = And16_Gate.And16(inpx, inpy);
        int[] fxy = Mux16(andxy, addxy, f);

        // no, ng -- ng from Sign magnitude representation
        int[] notfxy = Not16_Gate.Not16(fxy);
        int[] out = Mux16(fxy, notfxy, no);

        int[] pzr1 = Arrays.copyOfRange(out, 0, 7);

        int[] pzr2 = Arrays.copyOfRange(out, 8, 15);

        // zr
        int zr1 = Or8Way_Gate.Or8Way(pzr1);
        int zr2 = Or8Way_Gate.Or8Way(pzr2);
        int notzr = Or_Gate.Or(zr1, zr2);
        int[] zr = new int[1];
        zr[0] = Not(notzr);

        // ng
        int[] ng = new int[1];
        ng[0] = out[out.length-1];

        // final array
        int[][] output = {out, zr, ng};
        return output;

    }
}