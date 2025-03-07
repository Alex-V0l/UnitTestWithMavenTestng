import Vln.Busyness;
import Vln.CostCount;
import Vln.Dimension;
import Vln.Fragility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DistancePositiveTest {

    @DataProvider(name = "PositiveDistanceData")
    public static Object[][] PositiveDistanceData() {
        return new Object[][]{{2.0}, {3.0}, {10.0}, {15.5}, {30.0}, {31.0}, {45.0}};
    }

    @Test(description = "тест цены за расстояние по классам и границам",
            groups = {"smoke", "distanceTest"},
            dataProvider = "PositiveDistanceData",
            dataProviderClass = DistancePositiveTest.class)
    void addPriceForDistanceTest(double distance) {
        CostCount costCount = new CostCount(distance, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.NORMAL);
        double expectedPriceForDistance;
        double actualPriceForDistance = costCount.addPriceForDistance(distance);

        if (distance <= 2) {
            expectedPriceForDistance = 50;
        } else if (distance <= 10) {
            expectedPriceForDistance = 100;
        } else if (distance <= 30) {
            expectedPriceForDistance = 200;
        } else {
            expectedPriceForDistance = 300;
        }

        Assert.assertEquals(actualPriceForDistance, expectedPriceForDistance, "Значения должны совпадать");
    }
}
