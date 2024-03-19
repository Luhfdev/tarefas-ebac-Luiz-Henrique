package br.com.luhf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        List<Pessoa> mulheres = new Pessoa().pessoas();

        List<Pessoa> listaMulheres = mulheres.stream()
                .filter(pessoa -> pessoa.getGenero().equals("Mulher"))
                .toList();
        System.out.println(listaMulheres);








    }
}
