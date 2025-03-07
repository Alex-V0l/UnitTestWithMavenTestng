import Vln.Busyness;
import Vln.CostCount;
import Vln.Dimension;
import Vln.Fragility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TotalPriceNegativeTest {

    @DataProvider(name = "NegativeTotalPriceData")
    public static Object[][] NegativeTotalPriceData() {
        return new Object[][]{
                {40.0, Dimension.SMALL, Fragility.FRAGILE, Busyness.HIGH},
                {40.0, Dimension.SMALL, Fragility.FRAGILE, Busyness.NORMAL}
        };
    }

    @Test(description = "проверка исключения при расчете полной стоимости доставки",
            groups = {"smoke", "TotalPriceTest", "exception", "negative"},
            dataProvider = "NegativeTotalPriceData",
            dataProviderClass = TotalPriceNegativeTest.class)
    void PairWiseTotalPriceExceptionTest(double distance, Dimension dimensions, Fragility fragility, Busyness busyness){

        try{
            CostCount costCount = new  CostCount(distance, dimensions, fragility, busyness);
            costCount.countTotalPrice();

        } catch (IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Хрупкий груз не может быть перевезен на расстояние более 30 км");
        } catch (Exception e) {
            Assert.fail("Исключение не было выведено");
        }
    }

    @Test(description = "проверка выброса минимальной стоимости при полном расчете стоимости доставки",
            groups = {"smoke", "TotalPriceTest"})
    void minimumTotalPriceTest(){
        try {
            CostCount costCount = new CostCount(1.0,Dimension.SMALL, Fragility.NOT_FRAGILE, Busyness.NORMAL);
            double actualTotalPrice = costCount.countTotalPrice();
            double expectedTotalPrice = 400;

            Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Значения должны совпадатаь");

        } catch (Exception e) {
            Assert.fail("Некорректный расчет минимальной стоимости");
        }
    }
}