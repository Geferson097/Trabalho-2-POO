public class Motocicleta extends VeiculoMotorizado implements IPVA{
    private boolean IPVA;

    public Motocicleta(int ident,int qtdeRodas){ super(ident,qtdeRodas);}


    public void moverVeiculo() {
        String espacoB = "      ";
        String[] moto = {"   ,_oo\n",".-/c-//::          Motocicleta\n","(_)'==(_)\n\n"};


        if(getCombustivel()>.25){
            if(IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    for(int i = 0; i< moto.length; i++)
                    {
                        moto[i] = espacoB +moto[i];
                    }
                    desenharVeiculo();
                    setdistanciaPercorrida(1);
                    setCombustivel(.25);
                }
            }
            else System.out.println("O veiculo "+getIdentificacao()+" não possui IPVA pago");
        }
        else System.out.println("O veiculo "+getIdentificacao()+" não possui combustivel suficiente");

    }

    public void desenharVeiculo() {
        String[] moto = {"   ,_oo\n",".-/c-//::          Motocicleta\n","(_)'==(_)\n\n"};
        for(int i=0;i<moto.length;i++)
        {
            System.out.print(moto[i]);
        }
    }
    public double calcularValorIPVA() {return (valorBase * gastoMotocicleta);}
}
