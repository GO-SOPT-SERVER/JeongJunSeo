package org.example.domain.product;

import java.util.List;
import java.util.NoSuchElementException;

public class InstallmentSavingProduct extends Product{

    private InstallmentSavingProduct(int id, String name, float interestRate, int period) {
        super(id, name, interestRate, period);
    }

    public static final InstallmentSavingProduct militaryInstallmentSaving =
        new InstallmentSavingProduct(0, "군 적금", 4.5f, 18);

    public static final List<Product> products = List.of(militaryInstallmentSaving);

    public static InstallmentSavingProduct getInstance(int id) {
        if (id == 0) {
            return militaryInstallmentSaving;
        }
        throw new NoSuchElementException("존재하지 않는 적금 상품입니다.");
    }
}
