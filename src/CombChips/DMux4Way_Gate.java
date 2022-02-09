package CombChips;

class DMux4Way_Gate extends DMux_Gate {
    
    protected static int[] DMux4Way(int in, int[] sel) {
        int[] arr_sel = new int[2];

        int[] temp = DMux(in, arr_sel[0]);
        int[] temp1 = DMux(temp[0], arr_sel[1]);
        int[] temp2 = DMux(temp[1], arr_sel[1]);

        int[] out = new int[4];
        System.arraycopy(temp1, 0, out, 0, temp1.length);
        System.arraycopy(temp2, 0, out, temp1.length, temp2.length);

        return out;
    }
}