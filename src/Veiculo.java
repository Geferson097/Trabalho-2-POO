import java.util.Random;

public abstract class Veiculo{
    private final int identificacao; //um numero aleatório de 0 a 19
    private Roda[] rodas;
    private final int qtdRodas;
    private int distanciaPercorrida;

    public Veiculo(int ident, int quantidadeRodas, int distanciaPercorrida){
        this.identificacao = ident;
        this.distanciaPercorrida=distanciaPercorrida;
        this.qtdRodas=quantidadeRodas;
        this.rodas = new Roda[qtdRodas];
        for(int i=0;i<rodas.length;i++)
        {
            rodas[i]=new Roda();
        }
    }
    public abstract void moverVeiculo();
    public abstract void desenharVeiculo();
    public abstract void imprimirDados();
    public int getQtdRodas() { return qtdRodas;}
    public int getIdentificacao(){return this.identificacao;}
    public int getDistanciaPercorrida() { return distanciaPercorrida;}
    public void setdistanciaPercorrida(int dist){this.distanciaPercorrida += dist;}
    public void calibrar(int numRoda,boolean caliEsva){ rodas[numRoda].setCalibragem(caliEsva); }
    public void calibrar(int numRoda){ rodas[numRoda].setCalibragem(true); }
    public void esvaziar(int numRoda){ rodas[numRoda].setCalibragem(false); }
    public boolean verificaRodasCalibradas()
    {
        for(int i = 0; i<rodas.length; i++){
            if(!rodas[i].getCalibragem()){
                System.out.println("A roda "+i+" do veiculo "+getIdentificacao()+" não está calibrada");
                return false;
            }
        }
        return true;
    }










}
