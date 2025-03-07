package Vln;

public enum Dimension {
    BIG(200),
    SMALL(100);

    private final int costForDimension;

    Dimension(int costForDimension){
        this.costForDimension = costForDimension;}

    public int getCostForDimension(){
        return costForDimension;
    }
}
