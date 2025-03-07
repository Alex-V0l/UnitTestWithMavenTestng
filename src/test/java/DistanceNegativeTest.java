import Vln.Busyness;
import Vln.CostCount;
import Vln.Dimension;
import Vln.Fragility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DistanceNegativeTest {

    @DataProvider(name = "NegativeDistanceData")
    public static Object[][] NegativeDistanceData() {
        return new Object[][]{{0.0}, {-1.0}, {-5.5}};
    }

    @Test(description = "тест исключения на отрицательные значения и 0",
            groups = {"smoke", "distanceTest", "exception", "negative"},
            dataProvider = "NegativeDistanceData",
            dataProviderClass = DistanceNegativeTest.class)
    void addPriceForDistanceExceptionTest(double distance) {
        try {
            CostCount costCount = new CostCount(distance, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.NORMAL);
            costCount.addPriceForDistance(distance);

        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Расстояние должно быть больше 0. В противном случае доставка невозможна.");
        }
    }
}
