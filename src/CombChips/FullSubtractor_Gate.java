package CombChips;

class FullSubtractor_Gate extends HalfSubtractor_Gate {

    protected static int[] FullSubtractor(int a, int b, int c) {
        int[] out = new int[2];

        int[] ab = HalfSubtractor(a, b);
        int[] temp = HalfSubtractor(ab[0], c);
        int borrow = Or_Gate.Or(temp[1], ab[1]);

        out[0] = temp[0];
        out[1] = borrow;

        return out;
    }
}