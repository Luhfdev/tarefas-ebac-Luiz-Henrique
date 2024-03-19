package br.com.luhf.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercicios {

    public static void main(String[] args) {

        //Lista e filtrar numeros pares
        List<Integer> numeros = Arrays.asList(1, 2, 4, 6, 9, 11, 48);
        Stream<Integer> stream = numeros.stream()
                .filter(n -> n % 2 == 0);
        stream.forEach(System.out::println);






    }
}
