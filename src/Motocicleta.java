public class Motocicleta extends VeiculoMotorizado implements IPVA{
    private boolean IPVA;

    public Motocicleta(int ident,int qtdeRodas){ super(ident,qtdeRodas);}


    public void moverVeiculo() {

    }


    public double calcularValorIPVA() {return (valorBase * gastoMotocicleta);}
}
