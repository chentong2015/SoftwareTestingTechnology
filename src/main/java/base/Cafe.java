package base;

public class Cafe {

    private int beansInStock = 0;
    private int milkInStock = 0;

    public Coffee brew(CoffeeType type) {
        return brew(type, 1);
    }

    public Coffee brew(CoffeeType type, int quality) {
        requirePositive(quality);
        int requireBeans = type.getRequireBeans() * quality;
        int requireMilk = type.getRequireMilk() * quality;
        if (requireBeans > beansInStock || requireMilk > milkInStock) {
            throw new IllegalStateException("Insufficient beans of milk");
        }
        beansInStock -= requireBeans;
        milkInStock -= requireMilk;
        return new Coffee(type, requireBeans, requireMilk);
    }

    public void restockBeans(int weightInGrams) {
        requirePositive(weightInGrams);
        beansInStock += weightInGrams;
    }

    public void restockMilk(int weightInGrams) {
        requirePositive(weightInGrams);
        milkInStock += weightInGrams;
    }

    public void requirePositive(int value) {
        if (value < 1) {
            throw new IllegalArgumentException();
        }
    }

    public int getBeansInStock() {
        return beansInStock;
    }

    public int getMilkInStock() {
        return milkInStock;
    }
}


