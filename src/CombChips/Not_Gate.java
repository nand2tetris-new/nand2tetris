package CombChips;

class Not_Gate extends Nand_Gate {

    protected static int Not(int a) {
        return Nand(a, a);
    }
}