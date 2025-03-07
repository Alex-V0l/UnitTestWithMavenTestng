import Vln.Dimension;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Vln.Dimension.BIG;
import static Vln.Dimension.SMALL;

public class DimensionsTest {
    @DataProvider
    public static Object[][] dataForDimensionsTest() {
        return new Object[][]{{Dimension.BIG}, {Dimension.SMALL}};
    }

    @Test(description = "тест соответствия значений габаритов",
            groups = {"smoke", "dimensionsTest"},
            dataProvider = "dataForDimensionsTest")
    void getCostForDimensionTest(Dimension dimension) {

        double actualCostForDimensions = dimension.getCostForDimension();
        double expectedCostForDimensions;

        if (dimension == BIG) {
            expectedCostForDimensions = 200;
        } else if (dimension == SMALL) {
            expectedCostForDimensions = 100;
        } else {
            throw new IllegalArgumentException("Нужно указать корректные габариты");
        }

        Assert.assertEquals(actualCostForDimensions, expectedCostForDimensions, "Значения должны совпадать");
    }
}

