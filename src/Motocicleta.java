import java.util.Random;

public class Motocicleta extends VeiculoMotorizado implements IPVA{
    private String[] moto = {"   ,_oo\n",".-/c-//::          Motocicleta\n","(_)'==(_)\n\n"};
    private boolean IPVA;

    public Motocicleta(int ident,int qtdeRodas, int distanciaIni){
        super(ident,qtdeRodas,distanciaIni);
        Random x = new Random();
        int i =  x.nextInt(100);
        if(i % 2 == 0) {
            this.IPVA = true;
        }
        else{
            this.IPVA = false;
        }
    }

    public double calcularValorIPVA() {return (valorBase * cte_Motocicleta);}
    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>.25){
            if(this.IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
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
        for(int i=0;i<moto.length;i++)
        {
            System.out.print(moto[i]);
        }
    }

    public void imprimirDados() {
        if(this.IPVA){
            System.out.println("A motocicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                    +getDistanciaPercorrida() +" espaços e seu IPVA está pago");
        }
        else System.out.println("A motocicleta com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                +getDistanciaPercorrida() +" espaços e seu IPVA não está pago");

    }
}
