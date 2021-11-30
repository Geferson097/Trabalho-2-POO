public class Esportivo extends VeiculoMotorizado{

    private boolean IPVA;
    private String[] ferrari = {"        __         \n","      ~( @\\ \\   \n","   _____]_[_/_>__   \n",
            "  / __ \\<> |  __ \\      \n","=\\_/__\\_\\__|_/__\\_D     Ferrari\n","   (__)      (__)    \n"};

    public Esportivo(int ident, int qtdeRodas){
      super(ident,qtdeRodas);
    }


    public void moverVeiculo() {

    }

//    public void imprimirDados(){
//      super.imprimirDados();
//      System.out.println("Valor venda: "+this.valorVendaEsportivo);
//      System.out.println(" ");
//    }
}
