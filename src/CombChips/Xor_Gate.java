package CombChips;

class Xor_Gate extends Or_Gate {

    protected static int Xor(int a, int b) {
        int OrofNots = Or(Not(a), Not(b));
        int Or = Or(a, b);
        return And_Gate.And(Or, OrofNots);
    }
}
