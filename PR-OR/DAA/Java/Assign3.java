import java.util.Arrays;
import java.util.Comparator;

class Item {
    int weight;
    int value;
    double ratio;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.ratio = (double) value / weight;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(Item[] items, int capacity) {
        Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.ratio).reversed());

        double maxValue = 0;
        int currentWeight = 0;

        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                maxValue += item.value;
            } else {
                int remainingCapacity = capacity - currentWeight;
                maxValue += item.ratio * remainingCapacity;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int capacity = 50;
        Item[] items = {
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        };

        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
