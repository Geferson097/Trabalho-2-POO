public class Bicicleta extends Veiculo{
    private static String[] bike = {"   __o\n"," _`\\<,_       Bike\n","(*)/ (*)\n\n"};
    public Bicicleta(int ident,int dist){
      super(ident,2,dist);
    }
    public void moverVeiculo() {
        String espacoB = "    ";
        if (verificaRodasCalibradas())
        {
            for(int i = 0; i<bike.length; i++)
            {
                bike[i] = espacoB + bike[i];
            }
            desenharVeiculo();
            setdistanciaPercorrida(1);
        }
    }
    public void desenharVeiculo(){
        for(int i=0;i<bike.length;i++)
        {
            System.out.print(bike[i]);
        }
    }
}


