public class Bicicleta extends Veiculo{
    private static String[] bike = {"   __o\n"," _`\\<,_       Bike\n","(*)/ (*)\n\n"};
    public Bicicleta(int ident,int qtdeROdas,int distIni){
      super(ident,qtdeROdas,distIni);
    }
    public void moverVeiculo() {
        String espacoB = "    ";
        if (verificaRodasCalibradas())
        {
            System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
            for(int i = 0; i<bike.length; i++)
            {
                bike[i] = espacoB + bike[i];
            }
            desenharVeiculo();
            setdistanciaPercorrida(1);
        }
    }
    public void desenharVeiculo(){
        for(int i=0;i<bike.length;i++)
        {
            System.out.print(bike[i]);
        }
    }
    public void imprimirDados(){
        System.out.println("A bicicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas e percorreu: "+getDistanciaPercorrida() +" espaços");
    }
}


