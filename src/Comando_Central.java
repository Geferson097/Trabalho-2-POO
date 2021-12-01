import java.util.Scanner;
import java.util.Random;
// OPÇÃO 1,2,3,4,7,8,12,13 TESTADAS E OK!

// ALGUNS BUGS AINDA PRESENTES//
// NA OPÇÃO MOVER TODOS VEICULOS ELE MOVE VEICULO COM RODA DESCALIBRADA, VERIFICAR
//NA OPÇÂO DE CALIBRAR TODOS OS PNEUS ELE NÂO CALIBRA TODOS, VERIFICAR
public class Comando_Central {
    private static final int max = 20;
    private static final float combIni = 3.5F;
    private static final int distanciaIni =0;
    static Veiculo[] listaCorrida = new Veiculo[max];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String opcao;
        int aux = 0;
        int id;

        //menu iterativo para acessar as funções
        do{
            System.out.println("===> SIMULADOR <===");
            System.out.println(" ");
            System.out.println("1 - Incluir um veiculo");
            System.out.println("2 - Remover um veiculo");
            System.out.println("3 - Abastecer um veiculo");
            System.out.println("4 - Movimentar um veículo específico");
            System.out.println("5 - Movimentar veiculos por tipo");
            System.out.println("6 - Movimentar todos os veiculos");
            System.out.println("7 - Imprimir todos os dados de todos os veiculos");
            System.out.println("8 - Imprimir dados de veiculos por tipo");//solicitar qualveículo e qual pneu
            System.out.println("9 - Esvaziar/calibrar um pneu especıfico");
            System.out.println("10 - Calibrar todos os pneus de veıculos por tipo");
            System.out.println("11 - Esvaziar todos os pneus de veıculos por tipo");
            System.out.println("12 - Imprimir pista de Corrida");
            System.out.println("13 - Sair da aplicação");
            System.out.println("Digite sua opçao: ");
            opcao = sc.next();
            System.out.println(" ");
            switch (opcao) {
                case "1":

                    System.out.println("Incluindo um veiculo...");
                    System.out.println("-----------------------------------------");
                    Random aleatorio = new Random(System.nanoTime());
                    int ident = aleatorio.nextInt(100);
                    System.out.println("Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    System.out.println("Informe o tipo do veiculo a ser adicionado: ");
                    char tipo;
                    tipo = sc.next().charAt(0);
                    if(tipo == 'B' || tipo == 'M' || tipo == 'C' || tipo =='E'){
                        if(!verificaExisteIdent(ident)) {
                            adicionarVeiculo(ident,tipo);
                            aux++;
                        }
                        else System.out.println("Veiculo não adicionado,o id "+ident+" ja foi adicionado");
                    }
                    else System.out.println("Tipo de veiculo incorreto!");

                    if(aux>=20) System.out.println("Cheio, remova um veiculo caso queira adicionar mais");
                    System.out.print("\n\n");
                    break;

                case "2":
                    System.out.println("Removendo um veiculo...");
                    System.out.println("-----------------------------");
                    System.out.println("Informe o numero do veiculo a ser removido: ");
                    id = sc.nextInt();
                    if(verificaExisteIdent(id)){
                        removerVeiculo(id);
                        aux--;
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    System.out.print("\n\n");
                    break;

                case "3":

                    System.out.println("Abastecendo um veiculo...");
                    System.out.println("---------------------------------");
                    System.out.println("Informe o id do veiculo que sera abastecido: ");
                    id = sc.nextInt();
                    float comb;
                    System.out.println("Informe a quantidade de combustivel que sera abastecido: ");
                    comb = sc.nextFloat();
                    if(verificaExisteIdent(id)){
                        abastecerVeiculo(id,comb);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    break;

                case "4":

                    System.out.println("Movimentando um veiculo especifico...");
                    System.out.println("--------------------------------------");
                    System.out.println("Informe o id do veiculo que vai se movimentar: ");
                    id = sc.nextInt();
                    if(verificaExisteIdent(id)){
                        movimentarVeiculo(id);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    break;

                case "5":
                    System.out.println("Movimentando veiculos por tipo...");
                    System.out.println("------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    movimentarVeiculoPorTipo(tipo);
                    break;

                case "6":
                    System.out.println("Movimentando todos os veiculos...");
                    System.out.println("-------------------------------------");
                    movimentarVeiculo();
                    break;

                case "7":
                    System.out.println("Imprimindo todos os dados de todos os veiculos...");
                    System.out.println("--------------------------------------------------");
                    imprimirTodosDados();
                    System.out.print("\n\n");
                    break;

                case "8":
                    System.out.println("Imprimimindo dados de veiculos por tipo...");
                    System.out.println("---------------------------------------------");
                    System.out.println("Informe o tipo do veiculo: Bicicleta (B) | Motocicleta (M) | Carro Passeio (C) | Esportivo(E)");
                    tipo = sc.next().charAt(0);
                    imprimirDadosPorTipo(tipo);
                    System.out.print("\n\n");
                    break;

                case "9":
                    System.out.println("Evaziando/calibrando um pneu especifico...");
                    System.out.println("----------------------------------------------");
                    System.out.println("Informe o id do veiculo: ");
                    id = sc.nextInt();
                    int roda;
                    System.out.println("Informe a roda que sera calibrada/esvaziada: ");
                    roda = sc.nextInt();
                    int caliEsva;
                    System.out.println("Digite 1 para calibrar e 0 para esvaziar: ");
                    caliEsva = sc.nextInt();
                    if (verificaExisteIdent(id)){
                        calibrarEspecifico(id,roda,caliEsva);
                    }
                    else System.out.println("O veiculo "+id+" não esta na corrida");
                    break;

                case "10":
                    System.out.println("Calibrando todos os pneus de veiculos por tipo...");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Informe o modelo dos veiculos que serao calibrada os pneus: ");
                    tipo = sc.next().charAt(0);
                    calibrarOuEsvaziarPorTipo(true,tipo);
                    break;

                case "11":
                    System.out.println("Esvaziando todos os pneus de veiculos por tipo...");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Informe o modelo dos veiculos que serao calibrada os pneus: ");
                    tipo = sc.next().charAt(0);
                    calibrarOuEsvaziarPorTipo(false,tipo);
                    break;

                case "12":  //só falta implementar isoo
                    System.out.println("Imprimindo pista de corrida...");
                    System.out.println("----------------------------------------------------");
                    imprimirPistaCorrida();
                    break;
                case "13":
                    System.out.println("Saindo da Operação...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }while(!opcao.equalsIgnoreCase("13"));
    }


    private static void adicionarVeiculo(int ident, char tipo) {
        for (int i = 0; i < listaCorrida.length; i++)
        {
            if (listaCorrida[i] == null)
            {
                if(tipo == 'B'){
                    listaCorrida[i] = new Bicicleta(ident,2,distanciaIni);
                    System.out.println("A Bicicleta com id "+ident+" foi adicionado na posicao "+i);
                }
                else if (tipo == 'M'){
                    listaCorrida[i] = new Motocicleta(ident,2,distanciaIni);
                    System.out.println("A Motocicleta com id "+ident+" foi adicionado na posicao "+i);
                }
                else if (tipo == 'C'){
                    listaCorrida[i] = new CarroPasseio(ident,4,distanciaIni);
                    System.out.println("O Carro de Passeio com id "+ident+" foi adicionado na posicao "+i);
                }
                else if(tipo == 'E'){
                    listaCorrida[i] = new Esportivo(ident,4,distanciaIni);
                    System.out.println("O Esportivo com id "+ident+" foi adicionado na posicao "+i);
                }
            }
        }
    }

    private static void removerVeiculo(int id) {
        for(int i = 0; i < listaCorrida.length; i++)
        {
            if(listaCorrida[i] != null)
            {
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    listaCorrida[i] = null;
                    System.out.println("O veiculo "+id+" foi removido.");
                }
            }
        }
    }

    private static void abastecerVeiculo(int id, float comb) {
        for(int i=0; i<listaCorrida.length; i++){
            if(listaCorrida[i]  != null )
            {
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    if(listaCorrida[i] instanceof  VeiculoMotorizado){
                        ((VeiculoMotorizado) listaCorrida[i]).setCombustivel(comb);
                        System.out.println("O veiculo "+ id + " foi abastecido e agora possui "+((VeiculoMotorizado)listaCorrida[i]).getCombustivel() + " litros");
                    }
                    else System.out.println("Não dá pra abstecer uma Bicicleta!");
                }
            }
        }
    }

    static void movimentarVeiculo(int id) {  //mover um veiculo especifico pelo seu ID
        for(int i=0 ;i<listaCorrida.length;i++)
        {
            if(listaCorrida[i]!=null){
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    listaCorrida[i].moverVeiculo();
                }
            }
        }
    }
    static void movimentarVeiculo() { //mover todos os veiculos
        for(int i=0 ;i<listaCorrida.length;i++)
        {
            if (listaCorrida[i] != null) {
                listaCorrida[i].moverVeiculo();
            }
        }
    }

    static void movimentarVeiculoPorTipo(char tipoV){  //movimentar um veiculo pelo seu tipo
        boolean verificarPneus = true;
        int distancia = 0;
        for(int i=0;i<listaCorrida.length;i++)
        {
            if (listaCorrida[i] != null) {
                if (tipoV == 'B') {
                    if(listaCorrida[i] instanceof  Bicicleta)
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else  if(tipoV == 'M'){
                    if(listaCorrida[i] instanceof  Motocicleta)
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else if(tipoV =='C'){
                    if(listaCorrida[i] instanceof  CarroPasseio)
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else if(tipoV =='E'){
                    if(listaCorrida[i] instanceof  Esportivo)
                    {
                        listaCorrida[i].moverVeiculo();
                    }
                }
                else System.out.println("Tipo do veiculo Inválido");
            }


        }
    }
    private static void imprimirTodosDados() {
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                if (listaCorrida[i] instanceof Bicicleta) {
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof Motocicleta) {
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof CarroPasseio) {
                    listaCorrida[i] .imprimirDados();
                }
                else if (listaCorrida[i] instanceof Esportivo) {
                    listaCorrida[i] .imprimirDados();
                }
            }
        }
    }

    private static void imprimirDadosPorTipo(char tipoV) {
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {

                if (tipoV == 'B') {
                    if(listaCorrida[i] instanceof  Bicicleta)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else  if(tipoV == 'M'){
                    if(listaCorrida[i] instanceof  Motocicleta)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else if(tipoV =='C'){
                    if(listaCorrida[i] instanceof  CarroPasseio)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else if(tipoV =='E'){
                    if(listaCorrida[i] instanceof  Esportivo)
                    {
                        listaCorrida[i] .imprimirDados();
                    }
                }
                else System.out.println("Tipo do veiculo Inválido");
            }
        }
    }

    private static void calibrarEspecifico(int id,int numRoda, int caliEsva) {
        for(int i = 0; i < listaCorrida.length;i++){
            if (listaCorrida[i] != null) {
                if(listaCorrida[i].getIdentificacao()==id)
                {
                    if(caliEsva ==1) {
                        listaCorrida[i].calibrar(numRoda);
                    }
                    else listaCorrida[i].esvaziar(numRoda);
                }

            }
        }
    }
    private  static void calibrarOuEsvaziarPorTipo(boolean caliEsva, char tipo){
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                if (tipo == 'B') {
                    if (listaCorrida[i] instanceof Bicicleta) {
                        for(int j=0;i<4;i++)
                        {
                            listaCorrida[j].calibrar(j,caliEsva);
                        }
                    }
                }
                else if (tipo == 'M') {
                    if (listaCorrida[i] instanceof Motocicleta) {
                        for(int j=0;i<4;i++)
                        {
                            listaCorrida[j].calibrar(j,caliEsva);
                        }
                    }
                }
                else if(tipo == 'C') {
                    if (listaCorrida[i] instanceof CarroPasseio) {
                        for(int j=0;i<4;i++)
                        {
                            listaCorrida[j].calibrar(j,caliEsva);
                        }
                    }
                }
                else if(tipo =='E') {
                    if (listaCorrida[i] instanceof Esportivo) {
                        for(int j=0;i<4;i++)
                        {
                            listaCorrida[j].calibrar(j,caliEsva);
                        }
                    }
                }
                else System.out.println("Tipo do veiculo Inválido");
            }
        }
    }

    public static void imprimirPistaCorrida(){
        for (int i = 0; i < listaCorrida.length; i++) {
            if (listaCorrida[i] != null) {
                listaCorrida[i].desenharVeiculo();
            }
        }
    }
    private static boolean verificaExisteIdent(int ident) {
        for(int i = 0; i < listaCorrida.length;i++){
            if((listaCorrida[i] != null) && (listaCorrida[i].getIdentificacao() == ident)) return true;
        }
        return false;
    }
}
