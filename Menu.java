import java.util.Scanner;

public class Menu {
    public static void exibirMenu() {
        System.out.println("1- Cadastrar Cliente");
        System.out.println("2- Consultar Clientes");
        System.out.println("3- Cadastrar Sapato");
        System.out.println("4- Consultar Sapatos");
        System.out.println("5- Sair");
    }

    public static int obterOpcao() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Escolha uma opção: ");
            return scanner.nextInt();
        }
    }
}
