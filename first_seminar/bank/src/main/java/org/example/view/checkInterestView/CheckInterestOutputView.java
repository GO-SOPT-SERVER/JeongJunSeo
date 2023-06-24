package org.example.view.checkInterestView;

import java.util.List;
import org.example.view.common.CommonOutputView;

public class CheckInterestOutputView extends CommonOutputView {
    public void show(List<String> accountNumbers) {
        System.out.println("======================");
        System.out.println("이자 조회할 계좌를 고르세요.");
        int i = 0;
        for (String a : accountNumbers) {
            System.out.printf("(%d) %s \n", i, a);
            i++;
        }
        System.out.println("======================");
    }
}
