public class CarroPasseio extends VeiculoMotorizado{
    private String[] carroPopular = {"    ____\n"," __/  |_ \\_\n",
            "|  _     _``-.       Carro popular\n","'-(_)---(_)--'\n\n\n"};
    private boolean IPVA;

    public CarroPasseio(int ident, int qtdeRodas){
      super(ident,qtdeRodas);
    }

    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>.75){
            if(IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    for(int i = 0; i< carroPopular.length; i++)
                    {
                        carroPopular[i] = espacoB +carroPopular[i];
                    }
                    desenharVeiculo();
                    setdistanciaPercorrida(1);
                    setCombustivel(.75);
                }
            }
            else System.out.println("O veiculo "+getIdentificacao()+" não possui IPVA pago");
        }
        else System.out.println("O veiculo "+getIdentificacao()+" não possui combustivel suficiente");

    }

    public void desenharVeiculo() {
        for(int i=0;i<carroPopular.length;i++)
        {
            System.out.print(carroPopular[i]);
        }

    }
}
