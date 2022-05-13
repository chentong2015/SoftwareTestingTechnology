package model;

public enum CoffeeType {

    ESPRESSO(7, 0),
    LATTE(7, 227),
    FILTER(10, 0);

    private final int requireBeans;
    private final int requireMilk;

    CoffeeType(int requireBeans, int requireMilk) {
        this.requireBeans = requireBeans;
        this.requireMilk = requireMilk;
    }

    public int getRequireBeans() {
        return requireBeans;
    }

    public int getRequireMilk() {
        return requireMilk;
    }
}
