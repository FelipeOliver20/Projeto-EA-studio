import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {

    // Simulando o banco de dados de usuários com um HashMap
    private Map<String, String> usersDb;

    // Construtor que inicializa o banco de dados com alguns usuários de exemplo
    public LoginSystem() {
        usersDb = new HashMap<>();
        usersDb.put("admin", "admin123");
        usersDb.put("user1", "password1");
        usersDb.put("user2", "password2");
    } 

    // Método para verificar se um usuário já existe no "banco de dados"
    public boolean userExists(String username) {
        return usersDb.containsKey(username);
    }

    // Método para validar o login do usuário
    public boolean isValidUser(String username, String password) {
        return usersDb.containsKey(username) && usersDb.get(username).equals(password);
    }

    // Método para adicionar um novo usuário ao "banco de dados"
    public boolean addUser(String username, String password) {
        if (!userExists(username)) {
            usersDb.put(username, password);
            return true;
        }
        return false;
    }

    // Método para realizar o login
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu username: ");
        String username = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String password = scanner.nextLine();

        if (isValidUser(username, password)) {
            System.out.println("Login bem-sucedido!");
        } else {
            System.out.println("Falha no login! Usuário ou senha incorretos.");
        }
    }

    // Método para realizar o registro de um novo usuário
    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um username para registro: ");
        String username = scanner.nextLine();
        System.out.print("Digite uma senha: ");
        String password = scanner.nextLine();

        if (addUser(username, password)) {
            System.out.println("Usuário registrado com sucesso!");
        } else {
            System.out.println("Falha no registro! O usuário já existe.");
        }
    }

    // Método principal com o loop do menu
    public static void main(String[] args) {
        LoginSystem system = new LoginSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Menu de opções
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Login");
            System.out.println("2 - Registro");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1:
                    system.login();  // Processo de login
                    break;
                case 2:
                    system.register();  // Processo de registro
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;  // Encerra o programa
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}
