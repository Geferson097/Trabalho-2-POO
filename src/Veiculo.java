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


//    public int getQtdRodas(){ return this.qtdRodas;}
//    public Roda getRodas(int i){ return rodas[i];}
    public int getIdentificacao(){return this.identificacao;}
    public void setdistanciaPercorrida(int dist){this.distanciaPercorrida += dist;}

    public String imprimirDados(){
        return "Veiculo "+identificacao+" possui "+qtdRodas+" rodas e percorreu: "+distanciaPercorrida +" espaços";
    }

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
    private void calibrarOuEsvaziarRodas(boolean caliEsva, int roda, char tipo)
    {
      if (caliEsva)
      {
        rodas[roda].setCalibragem(caliEsva);
      }
      else
      {
        rodas[roda].setCalibragem(caliEsva);
      }
    }

    public void calibrarOuEsvaziarRodas(int caliEsva, int roda, char tipo)
    {
      if(caliEsva == 1){
        calibrarOuEsvaziarRodas(true,roda,tipo);
      }
      else
      {
        calibrarOuEsvaziarRodas(false,roda,tipo);
      }
    }

    public void calibrarOuEsvaziarRodas(boolean flag, char tipo)
    {
      if(flag)
      {
        if((tipo == 'B') || (tipo == 'M'))
        {
          for(int i=0; i<2; i++){
            calibrarOuEsvaziarRodas(flag,i,tipo);
          }
        }
        else
        {
          for(int i=0; i<4; i++){
            calibrarOuEsvaziarRodas(flag,i,tipo);
          }
        }
      }
      else
      {
        if((tipo == 'B') || (tipo == 'M'))
        {
          for(int i=0; i<2; i++){
            calibrarOuEsvaziarRodas(flag,i,tipo);
          }
        }
        else
        {
          for(int i=0; i<4; i++){
            calibrarOuEsvaziarRodas(flag,i,tipo);
          }
        }
      }
    }

}
