import java.util.Random;

public class Esportivo extends VeiculoMotorizado implements IPVA{

    private static String[] esportivo = {"        __         \n","      ~( @\\ \\   \n","   _____]_[_/_>__   \n",
            "  / __ \\<> |  __ \\      \n","=\\_/__\\_\\__|_/__\\_D     Ferrari\n","   (__)      (__)    \n"};
    private boolean IPVA;
    public Esportivo(int ident, int qtdeRodas, int distIni){

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

    public double calcularValorIPVA() {return (valorBase * cte_Esportivo);}
    public void moverVeiculo() {
        String espacoB = "      ";
        if(getCombustivel()>2.3){
            if(this.IPVA == true)
            {
                if(verificaRodasCalibradas())
                {
                    System.out.println("O veiculo "+getIdentificacao()+" se movimentou");
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
    }
    public void imprimirDados() {
        if(this.IPVA){
            System.out.println("O veiculo Esportivo id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                    +getDistanciaPercorrida() +" espaços e seu IPVA está pago");
        }
        else System.out.println("O veiculo Esportivo id "+getIdentificacao()+" possui "+getQtdRodas()+" rodas, percorreu: "
                +getDistanciaPercorrida() +" espaços e seu IPVA não está pago");

    }

}
