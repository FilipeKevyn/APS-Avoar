package Swing;

import controller.UserController;
import models.Ticket;
import models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class TelaVerificarTickets extends JFrame {

    private JFrame telaAnterior;
    private User user;
    private UserController userController;

    private JPanel painelTickets;
    private JScrollPane scrollPane;
    private JButton botaoVoltar, botaoCancelarTodos;
    private JLabel labelTitulo;

    public TelaVerificarTickets(JFrame telaAnterior, UserController userController) {
        this.telaAnterior = telaAnterior;
        this.user = userController.getCurrentUser();
        this.userController = userController;

        // --- CONFIGURAÇÕES DA JANELA ---
        setTitle("Volare - Meus Tickets");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE para não fechar a aplicação
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- TÍTULO ---
        labelTitulo = new JLabel("Meus Tickets", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(labelTitulo, BorderLayout.NORTH);

        // --- PAINEL DE TICKETS COM SCROLL ---
        painelTickets = new JPanel();
        painelTickets.setLayout(new BoxLayout(painelTickets, BoxLayout.Y_AXIS));
        painelTickets.setBackground(Color.WHITE);
        painelTickets.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(painelTickets);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);

        // --- PAINEL INFERIOR COM BOTÕES ---
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        botaoVoltar = new JButton("Voltar");
        botaoCancelarTodos = new JButton("Cancelar Todos");

        painelBotoes.add(botaoVoltar);
        painelBotoes.add(botaoCancelarTodos);
        add(painelBotoes, BorderLayout.SOUTH);

        // Carrega a lista de tickets
        atualizarListaDeTickets();

        // --- AÇÕES DOS BOTÕES ---

        botaoVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });

        botaoCancelarTodos.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja cancelar TODOS os seus tickets?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                userController.cancelAllTicket(user);
                atualizarListaDeTickets();
            }
        });

        // Ação para quando a janela é fechada pelo "X"
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                telaAnterior.setVisible(true);
            }
        });
    }

    private void atualizarListaDeTickets() {
        painelTickets.removeAll(); // Limpa a lista atual

        List<Ticket> tickets = user.getTickets();

        if (tickets == null || tickets.isEmpty()) {
            JLabel labelVazio = new JLabel("Você ainda não possui tickets.");
            labelVazio.setFont(new Font("Arial", Font.ITALIC, 16));
            labelVazio.setHorizontalAlignment(SwingConstants.CENTER);
            painelTickets.add(labelVazio);
        } else {
            for (Ticket ticket : tickets) {
                painelTickets.add(criarPainelDeTicket(ticket));
                painelTickets.add(Box.createRigidArea(new Dimension(0, 5))); // Espaçamento
            }
        }

        // Revalida e repinta o painel para mostrar as atualizações
        painelTickets.revalidate();
        painelTickets.repaint();
    }

    private JPanel criarPainelDeTicket(Ticket ticket) {
        JPanel painel = new JPanel(new BorderLayout(10, 0));
        painel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        painel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Limita a altura

        JLabel labelInfo = new JLabel("  " + ticket.toString());
        labelInfo.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        botaoCancelar.addActionListener(e -> {
            int resposta = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja realmente cancelar este ticket?\n" + ticket,
                    "Confirmação de Cancelamento",
                    JOptionPane.YES_NO_OPTION
            );

            if (resposta == JOptionPane.YES_OPTION) {
                userController.cancelTicket(user, ticket);
                atualizarListaDeTickets(); // Atualiza a UI
            }
        });

        painel.add(labelInfo, BorderLayout.CENTER);
        painel.add(botaoCancelar, BorderLayout.EAST);

        return painel;
    }
}