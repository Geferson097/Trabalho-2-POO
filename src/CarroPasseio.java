import java.util.Random;

public class CarroPasseio extends VeiculoMotorizado implements IPVA{
    private String[] carroPopular = {"    ____\n"," __/  |_ \\_\n",
            "|  _     _``-.       Carro popular\n","'-(_)---(_)--'\n\n\n"};
    private boolean IPVA;
    public CarroPasseio(int ident, int qtdeRodas,int distIni){

        super(ident,qtdeRodas,distIni);
        Random x = new Random();
        int i =  x.nextInt(100);
        if(i % 2 == 0) {
            this.IPVA = true;
        }
        else{
            this.IPVA = false;
        }
    }
    public double calcularValorIPVA() {return (valorBase * cte_Carro);}
    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>.75){
            if(IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
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
    public void imprimirDados() {
        if(getIpva()){
            System.out.println("O veiculo de Passeio com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                    +getDistanciaPercorrida() +" espaços e seu IPVA está pago");
        }
        else System.out.println("o veiculo de Passeio com id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                +getDistanciaPercorrida() +" espaços e seu IPVA não está pago");

    }
}
