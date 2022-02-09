package CombChips;

class Inc16_Gate extends Add16_Gate {
    
    protected static int[] Inc16(int[] in) {
        int[] b = new int[16];
        b[b.length-1] = 1;

        return Add16(in, b);
    }
}