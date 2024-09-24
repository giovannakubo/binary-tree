import java.util.Scanner;
public class Executora {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(70);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(40);
        arvoreBinaria.inserir(60);
        arvoreBinaria.inserir(80);
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(45);
        arvoreBinaria.inserir(55);
        arvoreBinaria.inserir(78);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(43);
        arvoreBinaria.inserir(57);
        arvoreBinaria.inserir(79);
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(16);





        int escolha = 0;
        int escolha2 = 0;
        int opcao = 100;
        while (opcao != 6) {
            System.out.println(" 1-Remover\n 2-PréOrdem\n 3-EmOrdem\n 4-PosOrdem\n 5-Inserir\n 6-Encerrar");
            opcao = teclado.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Insira qual nó quer remover: ");
                    escolha = teclado.nextInt();
                    arvoreBinaria.remover(escolha);
                    break;
                case 2:
                    System.out.println("Imprimindo árvore PréOrdem...");
                    arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
                    break;
                case 3:
                    System.out.println("Imprimindo árvore EmOrdem...");
                    arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
                    break;
                case 4:
                    System.out.println("Imprimindo árvore PósOrdem...");
                    arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
                    break;
                case 5:
                    System.out.println("Qual nó quer inserir?");
                    escolha2 = teclado.nextInt();
                    arvoreBinaria.inserir(escolha2);
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
            }
        }
    }
}