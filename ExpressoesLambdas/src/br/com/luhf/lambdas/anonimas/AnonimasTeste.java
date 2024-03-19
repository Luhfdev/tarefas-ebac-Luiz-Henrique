package br.com.luhf.lambdas.anonimas;

public class AnonimasTeste {
    public static void main(String[] args) {
        MyEventConsumer anonima = new MyEventConsumer() {
            @Override
            public void consume(Object value) {
                System.out.println(value);
            }
        };
        anonima.consume("Teste Anonima");
    }
}
