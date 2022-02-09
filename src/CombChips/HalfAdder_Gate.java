package CombChips;

class HalfAdder_Gate extends Xor_Gate {

    protected static int[] HalfAdder(int a, int b) {
        int[] out = new int[2];

        // sum
        out[0] = Xor(a, b);

        // carry
        out[1] = And_Gate.And(a, b);

        return out;
    }
}