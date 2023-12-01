import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Loja.criarTabelas();

        while (true) {
            Menu.exibirMenu();
            int opcao = Menu.obterOpcao();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    consultarClientes();
                    break;
                case 3:
                    cadastrarSapato();
                    break;
                case 4:
                    consultarSapatos();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome do cliente: ");
            String nome = scanner.nextLine();  // Use nextLine to consume the entire line
            System.out.print("Digite o CPF do cliente: ");
            String cpf = scanner.nextLine();
    
            Cliente cliente = new Cliente(nome, cpf);
            Loja.adicionarCliente(cliente);
        }
    }
    

    private static void consultarClientes() {
        List<Cliente> clientes = Loja.consultarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }
    }

    private static void cadastrarSapato() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite a marca do sapato: ");
            String marca = scanner.nextLine();
            System.out.print("Digite o tamanho do sapato: ");
            int tamanho = scanner.nextInt();
            System.out.print("Digite o preço do sapato: ");
            double preco = scanner.nextDouble();

            Sapato sapato = new Sapato(marca, tamanho, preco);
            Loja.adicionarSapato(sapato);
        }
    }

    private static void consultarSapatos() {
        List<Sapato> sapatos = Loja.consultarSapatos();
        for (Sapato sapato : sapatos) {
            System.out.println("Marca: " + sapato.getMarca() + ", Tamanho: " + sapato.getTamanho() + ", Preço: " + sapato.getPreco());
        }
    }
}
