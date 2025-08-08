package view;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner = new Scanner(System.in);

    public String askUsername() {
        System.out.print("Digite o nome de usuário: ");
        return scanner.nextLine();
    }

    public String askPassword() {
        System.out.print("Digite a senha: ");
        return scanner.nextLine();
    }

    public int showMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Login");
        System.out.println("2. Registrar");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}