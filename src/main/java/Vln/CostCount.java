package Vln;

public class CostCount {
    public static int BASECOST = 400;
    private final double distance;
    private final Dimension dimensions;
    private final Fragility fragility;
    private final Busyness busyness;

    public CostCount(double distance, Dimension dimensions, Fragility fragility, Busyness busyness) {
        this.distance = distance;
        this.dimensions = dimensions;
        this.fragility = fragility;
        this.busyness = busyness;
    }

    public String toString (){
        return "CostCount{"+"distance='"+distance+'\''+
                ", dimensions='"+ dimensions + '\''+
                ", fragility='"+ fragility + '\''+
                ", busyness='"+busyness+
                '}';
    }

    public double addPriceForDistance(Double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Расстояние должно быть больше 0. В противном случае доставка невозможна.");
        }
        if (distance <= 2.0) {
            return 50.0;
        } else if (distance <= 10.0) {
            return 100.0;
        } else if (distance <= 30.0) {
            return 200.0;
        } else {
            return 300.0;
        }
    }

    public double countTotalPrice() throws Exception {
        if (fragility == Fragility.FRAGILE && distance > 30.0) {
            throw new IllegalArgumentException("Хрупкий груз не может быть перевезен на расстояние более 30 км");
        }
        double totalPrice = ((addPriceForDistance(distance)
                + this.dimensions.getCostForDimension()
                + this.fragility.getCostForFragility())
                * this.busyness.getMultiplierForBusyness());

        return Math.max(totalPrice, BASECOST);
    }
}
