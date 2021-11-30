public class Esportivo extends VeiculoMotorizado{

    private static String[] esportivo = {"        __         \n","      ~( @\\ \\   \n","   _____]_[_/_>__   \n",
            "  / __ \\<> |  __ \\      \n","=\\_/__\\_\\__|_/__\\_D     Ferrari\n","   (__)      (__)    \n"};
    private boolean IPVA;
    public Esportivo(int ident, int qtdeRodas){
      super(ident,qtdeRodas);
    }


    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>2.3){
            if(IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    for(int i = 0; i< esportivo.length; i++)
                    {
                        esportivo[i] = espacoB +esportivo[i];
                    }
                    desenharVeiculo();
                    setdistanciaPercorrida(1);
                    setCombustivel(2.3);
                }
            }
            else System.out.println("O veiculo "+getIdentificacao()+" não possui IPVA pago");
        }
        else System.out.println("O veiculo "+getIdentificacao()+" não possui combustivel suficiente");
    }

    public void desenharVeiculo() {
        for(int i=0;i<esportivo.length;i++)
        {
            System.out.print(esportivo[i]);
        }
//        System.out.print(esportivo[0]);
//        System.out.print(esportivo[1]);
//        System.out.print(esportivo[2]);
//        System.out.print(esportivo[3]);
//        System.out.print(esportivo[4]);
    }

}
