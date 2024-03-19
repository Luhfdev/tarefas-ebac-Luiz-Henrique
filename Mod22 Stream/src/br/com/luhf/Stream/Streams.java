package br.com.luhf.Stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;


public class Streams {
    public static void main(String[] args) {
        List<String> stream = List.of("Luiz", "Joyce", "Pietra", "João");

        Set<String> set = Set.of("Luiz", "Joyce", "Pietra", "João");

        Map<String, String> map = Map.of("Luiz", "Joyce");
        java.util.stream.Stream<String> chaves = map.keySet().stream();
        java.util.stream.Stream<String> valores = map.values().stream();

        Stream<String> streamSTS = Stream.of("String", "sadsada");



    }
}
