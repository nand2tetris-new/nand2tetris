package CombChips;

class Or_Gate extends Not_Gate {

    protected static int Or(int a, int b) {
        return Nand(Not(a), Not(b));
    }
}