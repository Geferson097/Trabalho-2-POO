import java.util.Random;
public class Roda{
    //Atributos da classe
    private boolean calibragem = true; //1 para calibrado e 0 para não calibrado

    //Métodos
    public Roda() {
        Random x = new Random();
        int i = x.nextInt(100);
        if (i % 2 == 0) {
            this.calibragem = true;
        } else {
            this.calibragem = false;
        }
    }
    public boolean getCalibragem(){ return calibragem;} //obter informação se a ruda esta calibrada ou não
    public void setCalibragem(boolean calibragem){this.calibragem = calibragem;}  //Definir o valor da calibragem da roda (True ou false)
}
