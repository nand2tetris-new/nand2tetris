package CombChips;

class Dec16_Gate extends Subtract16_Gate {
    
    protected static int[] Dec16(int[] in) {
        int[] b = new int[16];
        b[in.length-1] = 1;

        return Subtract16(in, b);
    }
}