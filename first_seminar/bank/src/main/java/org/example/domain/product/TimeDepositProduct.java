package org.example.domain.product;

import java.util.List;
import java.util.NoSuchElementException;

public class TimeDepositProduct extends Product {

    protected TimeDepositProduct(int id, String name, float interestRate, int period) {
        super(id, name, interestRate, period);
    }

    public static final TimeDepositProduct happyTimeDepositProduct =
        new TimeDepositProduct(0, "행복 예금", 3.2f, 12);

    public static final List<Product> products = List.of(happyTimeDepositProduct);

    public static TimeDepositProduct getInstance(int id) {
        if (id == 0) {
            return happyTimeDepositProduct;
        }
        throw new NoSuchElementException("존재하지 않는 예금 상품입니다.");
    }
}
