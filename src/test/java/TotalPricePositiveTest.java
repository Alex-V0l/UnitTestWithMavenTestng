import Vln.Busyness;
import Vln.CostCount;
import Vln.Dimension;
import Vln.Fragility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TotalPricePositiveTest {
    @DataProvider(name = "PositiveTotalPriceData")
    public static Object[][] PositiveTotalPriceData() {
        return new Object[][]{
                {1.0, Dimension.BIG, Fragility.FRAGILE, Busyness.VERY_HIGH, 880.0},
                {1.0, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.HIGH, 400.0},
                {1.0, Dimension.BIG, Fragility.FRAGILE, Busyness.INCREASED, 660.0},
                {1.0, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.NORMAL, 400.0},
                {5.0, Dimension.SMALL, Fragility.FRAGILE, Busyness.NORMAL, 500.0},
                {5.0, Dimension.BIG, Fragility.NOT_FRAGILE, Busyness.VERY_HIGH, 480.0},
                {5.0, Dimension.SMALL, Fragility.FRAGILE, Busyness.HIGH, 700.0},
                {5.0, Dimension.BIG, Fragility.NOT_FRAGILE, Busyness.INCREASED, 400.0},
                {20.0, Dimension.BIG, Fragility.FRAGILE, Busyness.INCREASED, 840.0},
                {20.0, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.NORMAL, 400.0},
                {20.0, Dimension.BIG, Fragility.FRAGILE, Busyness.VERY_HIGH, 1120.0},
                {20.0, Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.HIGH, 420.0},
                {40.0, Dimension.BIG, Fragility.NOT_FRAGILE, Busyness.INCREASED, 600.0},
                {40.0, Dimension.BIG, Fragility.NOT_FRAGILE, Busyness.VERY_HIGH, 800.0},
        };
    }

    @Test(description = "позитивная проверка попарного тестирования при полном расчете стоимости доставки",
            groups = {"smoke", "TotalPriceTest"},
            dataProvider = "PositiveTotalPriceData",
            dataProviderClass = TotalPricePositiveTest.class)
    void PairWiseTotalPriceTest(double distance, Dimension dimensions, Fragility fragility, Busyness busyness, double expectedTotalPrice){
        try {
            CostCount costCount = new CostCount(distance, dimensions, fragility, busyness);
            double actualTotalPrice = costCount.countTotalPrice();

            Assert.assertEquals(expectedTotalPrice, actualTotalPrice, "Значения должны совпадать");
        } catch (Exception e){
            Assert.fail("Расчет был произведен неверно, или была некорректно задана переменна");
        }
    }
}