package org.example.domain.product;

import java.util.NoSuchElementException;

public class SavingProduct extends Product {

    private static final int INFINITY = -1;

    private SavingProduct(int id, String name, float ineterestRate) {
        super(id, name, ineterestRate, INFINITY);
    }

    private static final SavingProduct studentSavingProduct =
        new SavingProduct(0, "학생 입출금", 0.2f);

    public static SavingProduct getInstance(int id) {
        if (id == 0) {
            return studentSavingProduct;
        }
        throw new NoSuchElementException("존재하지 않는 입출금 상품입니다.");
    }

}
