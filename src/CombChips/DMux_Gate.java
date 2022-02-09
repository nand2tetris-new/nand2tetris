package CombChips;

class DMux_Gate extends And_Gate {

    protected static int[] DMux(int in, int sel) {
        int[] out = new int[16];
        out[0] = And(in, Not(sel));
        out[1] = And(in, sel);
        return out; 
    }
}