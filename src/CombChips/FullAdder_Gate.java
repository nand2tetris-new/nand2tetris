package CombChips;

class FullAdder_Gate extends HalfAdder_Gate {

    protected static int[] FullAdder(int a, int b, int c) {
        int[] out = new int[2];

        int[] ab = HalfAdder(a, b);
        int[] temp = HalfAdder(ab[0], c);
        int carry = Or_Gate.Or(temp[1], ab[1]);

        out[0] = temp[0];
        out[1] = carry;

        return out;
    }
}