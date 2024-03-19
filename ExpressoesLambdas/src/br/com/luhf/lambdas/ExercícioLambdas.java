package br.com.luhf.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExercícioLambdas {
    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2 ,3 ,4, 5, 6, 12, 15, 28);
        numeros.forEach(n -> {if (n % 2 == 0) {
            System.out.println(n);
            }
        });
    }
}
