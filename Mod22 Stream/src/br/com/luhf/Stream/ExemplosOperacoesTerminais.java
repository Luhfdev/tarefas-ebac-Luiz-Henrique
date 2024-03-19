package br.com.luhf.Stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemplosOperacoesTerminais {
    public static void main(String[] args) {

        List<Pessoa> lista2 = new Pessoa().populaPessoas();
        //Exemplo Count -> Conta o numero de elementos da lista
        System.out.println("Exemplo Count");
        long streamCount = lista2.stream()
                .filter(pessoa -> pessoa.getNome().startsWith("M"))
                .count();
        System.out.println(streamCount);

        System.out.println();

        //Exemplo forEach
        System.out.println("Exemplo forEach");
        Stream<Integer> stream2 = lista2.stream()
                .map(Pessoa::getIdade);
        stream2.forEach(System.out::println);

        System.out.println();

        //Exemplo allMatch -> Verifica alguma condição
        System.out.println("Exemplo allMatch");
        boolean streamAllMatch = lista2.stream()
                .allMatch(pessoa -> pessoa.getNacionalidade().equals("MEXICO"));
        System.out.println(streamAllMatch); //Verificou se todas as nacionalidades possuem mexico no nome

        System.out.println();

//      Exemplo Collect -> O metodo collect() possibilita coletar os elementos de uma stream na forma
//      de coleções, convertendo uma stream para os tipos List, Set ou Map.
        System.out.println("Exemplo Collect");
        lista2.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"))
                .toList()
                .forEach(System.out::println);

        System.out.println();

        //Exemplo Optional -> Um código que só é executado se a condição dele existir.
        System.out.println("Exemplo Optional");
        Optional<Pessoa> optionalMax = lista2.stream()
                .max(Comparator.comparing(Pessoa::getIdade));
        optionalMax.ifPresent(System.out::println);

        System.out.println();

        Optional<Pessoa> optionalMin = lista2.stream()
                .min(Comparator.comparing(Pessoa::getIdade));
        optionalMin.ifPresent(System.out::println);


    }
}
