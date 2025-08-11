package Swing;

import controller.FlightController;
import models.Flight;
import repositories.FlightRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class TelaConsultarVoos extends JFrame {

    private FlightController flightController = new FlightController(new FlightRepository());
    private List<Flight> flights = flightController.getFlights();

    private JLabel labelTitulo;
    private JButton botaoVoltar;
    private JPanel painelVoos; // Painel para adicionar os botões dos voos

    public TelaConsultarVoos(JFrame telaAnterior) {
        setTitle("Consultar Voos");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        labelTitulo = new JLabel("Consultar Voos");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setBounds(100, 20, 250, 40);
        add(labelTitulo);

        painelVoos = new JPanel();
        painelVoos.setLayout(new BoxLayout(painelVoos, BoxLayout.Y_AXIS)); // Layout vertical

        JScrollPane scrollPane = new JScrollPane(painelVoos);
        scrollPane.setBounds(50, 80, 350, 200);
        add(scrollPane);

        for (Flight flight : flights) {
            JButton botaoVoo = new JButton(flight.toString());
            botaoVoo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40)); // Ajusta a largura do botão
            botaoVoo.addActionListener(e -> {
                TelaVoo telaVoo = new TelaVoo(this, flight);
                telaVoo.setVisible(true);
                setVisible(false);
            });
            painelVoos.add(botaoVoo);
            painelVoos.add(Box.createRigidArea(new Dimension(0, 5))); // Espaçamento
        }

        // --- BOTÃO VOLTAR ---
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(175, 300, 100, 30);
        add(botaoVoltar);

        // --- AÇÃO DO BOTÃO VOLTAR ---
        botaoVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
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