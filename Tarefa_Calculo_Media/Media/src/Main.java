public class Main {
    public static void main(String[] args) {
        MetodoMedia met = new MetodoMedia();

        met.setN1(7);
        met.setN2(7);
        met.setN3(7);
        met.setN4(7);

        met.Calcmedia(met.getN1(), met.getN2(), met.getN3(), met.getN4());
        met.Medi();
    }
}