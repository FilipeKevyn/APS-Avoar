package Swing;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaLogin extends JFrame {

    private UserController userController;

    // Componentes da interface
    private JLabel labelTitulo, labelEmail, labelSenha;
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private JButton botaoVoltar, botaoEntrar;

    public TelaLogin(JFrame telaAnterior, UserController userController) { // Recebe a tela inicial como parâmetro
        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Login");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fecha apenas esta janela
        setLocationRelativeTo(null);
        setLayout(null);

        // --- TÍTULO ---
        labelTitulo = new JLabel("Login");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setBounds(150, 20, 100, 40);
        add(labelTitulo);

        // --- FORMULÁRIO ---
        labelEmail = new JLabel("Email:");
        labelEmail.setBounds(50, 90, 80, 25);
        add(labelEmail);

        campoEmail = new JTextField();
        campoEmail.setBounds(120, 90, 200, 25);
        add(campoEmail);

        labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(50, 130, 80, 25);
        add(labelSenha);

        campoSenha = new JPasswordField();
        campoSenha.setBounds(120, 130, 200, 25);
        add(campoSenha);

        // --- BOTÕES ---
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(50, 250, 100, 30);
        add(botaoVoltar);

        botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBounds(220, 250, 100, 30);
        add(botaoEntrar);

        // --- AÇÕES DOS BOTÕES ---

        // Ação para o botão Voltar

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (userController.login(campoEmail.getText(), campoSenha.getText())){
                    TelaMenuUsuario telaMenuUsuario = new TelaMenuUsuario(telaAnterior, userController); // Passa a instância da tela atual
                    telaMenuUsuario.setVisible(true);
                    setVisible(false); // Esconde a tela inicial
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaAnterior.setVisible(true); // Mostra a tela inicial novamente
                dispose(); // Fecha a tela de login
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