package Swing;

import controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaMenuUsuario extends JFrame {

    // Componentes da interface
    private JLabel labelTitulo, labelUsuario;
    private JButton botaoConsultarVoos, botaoVerificarTickets, botaoSair;

    // Construtor que recebe o nome do usuário
    public TelaMenuUsuario(JFrame telaInicial, UserController user) {
        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Volare - Menu Principal");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // --- TÍTULO ---
        labelTitulo = new JLabel("Volare");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 40));
        labelTitulo.setBounds(135, 20, 150, 50);
        add(labelTitulo);

        // --- BOTÕES ---
        botaoConsultarVoos = new JButton("Consultar Voos");
        botaoConsultarVoos.setBounds(100, 100, 200, 30);
        add(botaoConsultarVoos);

        botaoVerificarTickets = new JButton("Verificar Tickets");
        botaoVerificarTickets.setBounds(100, 140, 200, 30);
        add(botaoVerificarTickets);

        botaoSair = new JButton("Sair");
        botaoSair.setBounds(100, 180, 200, 30);
        add(botaoSair);

        // --- LABEL DO USUÁRIO ---
        labelUsuario = new JLabel("Usuário: " + user.getCurrentUser().getName());
        labelUsuario.setBounds(10, 280, 200, 25);
        add(labelUsuario);

        // --- AÇÕES DOS BOTÕES ---

        // Ação para o botão Consultar Voos
        botaoConsultarVoos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaConsultarVoos telaVoos = new TelaConsultarVoos(TelaMenuUsuario.this, user.getCurrentUser());
                telaVoos.setVisible(true);
                setVisible(false); // Esconde o menu
            }
        });

        botaoVerificarTickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria a nova tela passando a instância atual (this), o usuário e o controller
                TelaVerificarTickets telaTickets = new TelaVerificarTickets(TelaMenuUsuario.this, user);
                telaTickets.setVisible(true);
                setVisible(false); // Esconde o menu
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.logout();
                telaInicial.setVisible(true); // Mostra a tela inicial novamente
                dispose(); // Fecha a tela de login
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                telaInicial.setVisible(true);
            }
        });
    }
}