import Vln.Fragility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static Vln.Fragility.FRAGILE;
import static Vln.Fragility.NOT_FRAGILE;

public class FragilityTest {
    @DataProvider
    public static Object[][] dataForFragilityTest() {
        return new Object[][]{{FRAGILE}, {NOT_FRAGILE} };
    }

    @Test(description = "тест соответствия значений хрупкости",
            groups = {"smoke", "fragilityTest"},
            dataProvider = "dataForFragilityTest")
    void getCostForFragilityTest(Fragility fragility) {

        double actualCostForFragility = fragility.getCostForFragility();
        double expectedCostForFragility;

        if (fragility == FRAGILE) {
            expectedCostForFragility = 300;
        } else if (fragility == NOT_FRAGILE) {
            expectedCostForFragility = 0;
        } else {
            throw new IllegalArgumentException("Нужно указать корректную хрупкость");
        }

        Assert.assertEquals(actualCostForFragility, expectedCostForFragility, "Значения должны совпадать");
    }
}



