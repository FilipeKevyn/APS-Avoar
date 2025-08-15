package views;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaRegistro extends JFrame {
    private UserController userController;

    private JLabel labelTitulo, labelNome, labelEmail, labelSenha;
    private JTextField campoNome, campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoVoltar, botaoRegistrar;

    public TelaRegistro(JFrame telaAnterior, UserController userController) { // Recebe a tela inicial como parâmetro
        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Registrar-se");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null);
        setLayout(null);

        // --- TÍTULO ---
        labelTitulo = new JLabel("Registrar-se");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setBounds(110, 20, 200, 40);
        add(labelTitulo);

        // --- FORMULÁRIO ---
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(50, 90, 80, 25);
        add(labelNome);

        campoNome = new JTextField();
        campoNome.setBounds(120, 90, 200, 25);
        add(campoNome);

        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 130, 80, 25);
        add(labelEmail);

        campoEmail = new JTextField();
        campoEmail.setBounds(120, 130, 200, 25);
        add(campoEmail);

        labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 170, 80, 25);
        add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 170, 200, 25);
        add(campoSenha);

        // --- BOTÕES ---
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(50, 280, 100, 30);
        add(botaoVoltar);

        botaoRegistrar = new JButton("Entrar");
        botaoRegistrar.setBounds(220, 280, 100, 30);
        add(botaoRegistrar);

        // --- AÇÕES DOS BOTÕES ---

        botaoRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userController.register(campoNome.getText(), campoEmail.getText(), campoSenha.getText())){
                    System.out.println("Registrado");
                }
            }
        });

        // Ação para o botão Voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAnterior.setVisible(true); // Mostra a tela inicial novamente
                dispose(); // Fecha a tela de registro
            }
        });

        // Garante que a tela anterior reapareça se o usuário fechar no "X"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                telaAnterior.setVisible(true);
            }
        });
    }
}