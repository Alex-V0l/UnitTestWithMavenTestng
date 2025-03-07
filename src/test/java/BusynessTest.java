import Vln.Busyness;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static Vln.Busyness.VERY_HIGH;

public class BusynessTest {
    @DataProvider
    public static Object[][] dataForBusynessTest() {
        return new Object[][]{{VERY_HIGH}, {Busyness.HIGH}, {Busyness.INCREASED}, {Busyness.NORMAL}};
    }

    @Test(description = "тест соответствия значений коэффициента загруженности службы доставки",
            groups = {"smoke", "busynessTest"},
            dataProvider = "dataForBusynessTest")
    void getCostForBusynessTest(Busyness busyness) {

        double actualMultiplierForBusyness = busyness.getMultiplierForBusyness();
        double expectedMultiplierForBusyness;

        switch (busyness) {
            case VERY_HIGH:
                expectedMultiplierForBusyness = 1.6;
                break;
            case HIGH:
                expectedMultiplierForBusyness = 1.4;
                break;
            case INCREASED:
                expectedMultiplierForBusyness = 1.2;
                break;
            default:
                expectedMultiplierForBusyness = 1.0;
        }

        assertEquals(actualMultiplierForBusyness, expectedMultiplierForBusyness, "Значения должны совпадать");
    }
}

