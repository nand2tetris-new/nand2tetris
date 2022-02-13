package CombChips;

class HalfSubtractor_Gate extends Xor_Gate {

    protected static int[] HalfSubtractor(int a, int b) {
        int[] out = new int[2];

        // sum
        out[0] = Xor(a, b);

        // borrow
        out[1] = And_Gate.And(Not(a), b);

        return out;
    }
}