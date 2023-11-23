
public class MetodoMedia {

    private double n1;
    private double n2;
    private double n3;
    private double n4;

    private double mediaT;

    public double getN1() {
        return n1;
    }

    public void setN1(double n1) {
        this.n1 = n1;
    }

    public double getN2() {
        return n2;
    }

    public void setN2(double n2) {
        this.n2 = n2;
    }

    public double getN3() {
        return n3;
    }

    public void setN3(double n3) {
        this.n3 = n3;
    }

    public double getN4() {
        return n4;
    }

    public void setN4(double n4) {
        this.n4 = n4;
    }

    public void Calcmedia(double num1, double num2, double num3, double num4){
        double media = (num1 + num2 + num3 + num4) / 4;
        System.out.printf("%.2f %n", media);
        mediaT = media;
    }

    public void Medi() {
        if(mediaT > 7) {
            System.out.println("Aprovado!!!");
        }
        else if(mediaT == 7){
            System.out.println("Passou raspando!");
        }
        else if(mediaT < 7) {
            System.out.println("Reprovado!");
        }
    }
}
