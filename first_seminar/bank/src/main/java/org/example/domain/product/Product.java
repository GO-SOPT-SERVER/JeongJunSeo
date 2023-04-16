package org.example.domain.product;


public abstract class Product {

    private final int id;
    private final String name;
    private final float interestRate;
    private final int period; // 상품 기간

    protected Product(int id, String name, float interestRate, int period) {
        this.id = id;
        this.name = name;
        this.interestRate = interestRate;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public int getPeriod() {
        return period;
    }

}
