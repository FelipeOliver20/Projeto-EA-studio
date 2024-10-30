import java.util.ArrayList;
import java.util.Scanner;

// Classe Cliente na qual ira ficar as informações para proceder o resto do codigo 
class Cliente {
    private String nome;
    private String email;
    private String telefone;

    // Construtor
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Email: " + email + ", Telefone: " + telefone;
    }
}

// Classe CadastroDeClientes
class CadastroDeClientes {
    private ArrayList<Cliente> clientes;

    // Construtor
    public CadastroDeClientes() {
        this.clientes = new ArrayList<>();
    }

    // Adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso!");
    }

    // Listar clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n--- Lista de Clientes ---");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    // Remover cliente
    public void removerCliente(String nome) {
        Cliente clienteParaRemover = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                clienteParaRemover = cliente;
                break;
            }
        }
        
        if (clienteParaRemover != null) {
            clientes.remove(clienteParaRemover);
            System.out.println("Cliente " + nome + " removido com sucesso!");
        } else {
            System.out.println("Cliente " + nome + " não encontrado.");
        }
    }
}

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CadastroDeClientes cadastro = new CadastroDeClientes();
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email do cliente: ");
                    String email = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();
                    Cliente novoCliente = new Cliente(nome, email, telefone);
                    cadastro.adicionarCliente(novoCliente);
                    break;

                case 2:
                    cadastro.listarClientes();
                    break;

                case 3:
                    System.out.print("Digite o nome do cliente a remover: ");
                    String nomeRemover = scanner.nextLine();
                    cadastro.removerCliente(nomeRemover);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}
 