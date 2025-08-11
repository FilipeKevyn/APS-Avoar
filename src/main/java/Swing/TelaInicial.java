package Swing;

import controller.UserController;
import repositories.UserRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    UserRepository userRepository = new UserRepository();
    // Componentes da interface
    UserController userController = new UserController(userRepository);
    private JLabel labelTitulo;
    private JButton botaoLogin;
    private JButton botaoRegistro;

    public TelaInicial() {
        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Volare - Bem-vindo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Layout manual

        // --- TÍTULO ---
        labelTitulo = new JLabel("Volare");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        labelTitulo.setBounds(135, 30, 150, 50); // Posição (x, y, largura, altura)
        add(labelTitulo);

        // --- BOTÃO LOGIN ---
        botaoLogin = new JButton("Login");
        botaoLogin.setBounds(100, 120, 200, 30);
        add(botaoLogin);

        // --- BOTÃO REGISTRO ---
        botaoRegistro = new JButton("Registro"); // Nome do botão corrigido
        botaoRegistro.setBounds(100, 160, 200, 30);
        add(botaoRegistro);

        // --- AÇÕES DOS BOTÕES ---

        // Ação para o botão de Login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de login
                TelaLogin telaLogin = new TelaLogin(TelaInicial.this, userController); // Passa a instância da tela atual
                telaLogin.setVisible(true);
                setVisible(false); // Esconde a tela inicial
            }
        });

        // Ação para o botão de Registro
        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abre a tela de registro
                TelaRegistro telaRegistro = new TelaRegistro(TelaInicial.this, userController); // Passa a instância da tela atual
                telaRegistro.setVisible(true);
                setVisible(false); // Esconde a tela inicial
            }
        });
    }

    // --- MÉTODO PRINCIPAL PARA EXECUTAR A APLICAÇÃO ---
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }
}
