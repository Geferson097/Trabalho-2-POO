import java.util.Random;

public abstract class VeiculoMotorizado extends Veiculo{
    private boolean ipva = true; //1 para ipva pago 0 para ipv nao pago
    private double combIni;
    private double valorIpva;

    public VeiculoMotorizado(int ident, int qtdeRodas,int distIni){
      super(ident,qtdeRodas,distIni);
      Random aleatorio = new Random();
      int sorteio;
      sorteio = aleatorio.nextInt(100);
      if(sorteio % 2 == 0)
      {
        this.ipva = true;
      }
      else
      {
        this.ipva = false;
      }
      this.combIni = 3.5;
    }
    public void setCombustivel(float comb){this.combIni += comb;}
    public void setCombustivel(double comb){this.combIni -= comb;}
    public double getCombustivel(){ return combIni;}
    public boolean getIpva(){ return ipva;}
}
