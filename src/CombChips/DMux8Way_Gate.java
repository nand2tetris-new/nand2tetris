package CombChips;

class DMux8Way_Gate extends DMux4Way_Gate {
    
    protected static int[] DMux8Way(int in, int sel) {
        int[] arr_sel = new int[3];

        int[] subarr_sel = new int[2];
        System.arraycopy(arr_sel, 1, subarr_sel, 0, subarr_sel.length);

        int[] temp = DMux(in, arr_sel[0]);
        int[] temp1 = DMux4Way(temp[0], subarr_sel);
        int[] temp2 = DMux4Way(temp[1], subarr_sel);

        int[] out = new int[4];
        System.arraycopy(temp1, 0, out, 0, temp1.length);
        System.arraycopy(temp2, 0, out, temp1.length, temp2.length);

        return out;
    }
}