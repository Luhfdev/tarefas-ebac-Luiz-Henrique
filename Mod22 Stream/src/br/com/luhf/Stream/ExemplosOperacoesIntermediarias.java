package br.com.luhf.Stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ExemplosOperacoesIntermediarias {
    public static void main(String[] args) {

        List<Pessoa> lista = new Pessoa().populaPessoas();

        System.out.println();

        //Exemplo Filter
        System.out.println("Exemplo Filter");
        Stream<Pessoa> stream = lista.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasil"));
        stream.forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println();

        //Exemplo Map
        System.out.println("Exemplo Map");
        Stream<Integer> stream2 = lista.stream()
                .map(Pessoa::getIdade);
        stream2.forEach(System.out::println);

        System.out.println();

        //Exemplo Sorted -> organiza a lista
        System.out.println("Exemplo Sorted");
        Stream<Pessoa> streamOrdAlfab = lista.stream()
                .sorted(Comparator.comparing(Pessoa::getNome));
        streamOrdAlfab.forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println();

        System.out.println("Exemplo Sorted");
        Stream<Pessoa> streamIdadeCres = lista.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade));
        streamIdadeCres.forEach(pessoa -> System.out.println(pessoa.getNome()+" - "+pessoa.getIdade()));

        System.out.println();

        //Exemplo Distinct -> Não deixa repetir valores e pode ser usado com o hascode (linha 71 em diante da classe Pessoa)
        System.out.println("Exemplo Distinct");
        Stream<Pessoa> streamDinstinct = lista.stream()
                .distinct();
        streamDinstinct.forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println();

        //Exemplo Limit -> Limita a quantidade sem alterar a lista.
        System.out.println("Exemplo Limit");
        Stream<Pessoa> streamLimit = lista.stream().limit(2);
        streamLimit.forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println();


    }
}
