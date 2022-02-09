package CombChips;

class Mux_Gate extends And_Gate {

    protected static int Mux(int a, int b, int sel) {
        int first = And(a, Not(sel));
        int second = And(b, sel);
        return Or_Gate.Or(first, second);
    }
}