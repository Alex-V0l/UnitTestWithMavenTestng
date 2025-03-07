package Vln;

public enum Fragility {
    FRAGILE(300),
    NOT_FRAGILE(0);

    private final int costForFragility;

    Fragility(int costForFragility){
        this.costForFragility = costForFragility;
    }

    public int getCostForFragility() {
        return costForFragility;
    }
}
