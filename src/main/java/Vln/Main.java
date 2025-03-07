package Vln;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        CostCount costCount = new CostCount(10.0, Dimension.BIG, Fragility.NOT_FRAGILE, Busyness.HIGH);

        double totalPrice = costCount.countTotalPrice();
        System.out.println("Общая стоимость доставки составляет " + totalPrice);
    }
}