package CombChips;

class And_Gate extends Not_Gate {

    protected static int And(int a, int b) {
        return Not(Nand(a, b));
    }
}