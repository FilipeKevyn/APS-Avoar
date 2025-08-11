package Swing;

import controller.FlightController;
import models.Flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class TelaVoo extends JFrame {
    private Map<String, Double> precos = new HashMap<>();
    private Map<String, JTextField> camposQuantidade = new HashMap<>();

    public TelaVoo(JFrame telaAnterior, Flight flight) {
        precos.put("Primeira Classe", flight.getPriceFirstClass());
        precos.put("Classe Executiva", flight.getPriceExecutive());
        precos.put("Classe Econômica", flight.getPriceEconomic());

        setTitle("Voo " + flight.getCode());
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Voo " + flight.getCode());
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setBounds(180, 20, 200, 40);
        add(labelTitulo);

        // Adiciona seletor de quantidade para cada classe
        criarSeletorDeClasse("Primeira Classe", 80);
        criarSeletorDeClasse("Classe Executiva", 130);
        criarSeletorDeClasse("Classe Econômica", 180);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(80, 350, 100, 30);
        add(botaoVoltar);

        JButton botaoPagar = new JButton("Pagar");
        botaoPagar.setBounds(300, 350, 100, 30);
        add(botaoPagar);

        botaoVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });

        botaoPagar.addActionListener(e -> {
            double total = 0;
            for (String classe : camposQuantidade.keySet()) {
                int quantidade = Integer.parseInt(camposQuantidade.get(classe).getText());
                total += quantidade * precos.get(classe);
            }

            if (total > 0) {
                TelaPagamento telaPagamento = new TelaPagamento(this, total);
                telaPagamento.setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione ao menos um ticket para continuar.");
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                telaAnterior.setVisible(true);
            }
        });
    }

    private void criarSeletorDeClasse(String nomeClasse, int yPos) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        JLabel labelClasse = new JLabel(nomeClasse + " - (R$ " + df.format(precos.get(nomeClasse)) + ")");
        labelClasse.setBounds(20, yPos, 220, 25);
        add(labelClasse);

        JButton botaoMenos = new JButton("-");
        botaoMenos.setBounds(250, yPos, 45, 25);
        add(botaoMenos);

        JTextField campoQtd = new JTextField("0");
        campoQtd.setHorizontalAlignment(JTextField.CENTER);
        campoQtd.setEditable(false);
        campoQtd.setBounds(300, yPos, 50, 25);
        add(campoQtd);
        camposQuantidade.put(nomeClasse, campoQtd);

        JButton botaoMais = new JButton("+");
        botaoMais.setBounds(355, yPos, 45, 25);
        add(botaoMais);

        // Ações dos botões + e -
        botaoMenos.addActionListener(e -> {
            int qtd = Integer.parseInt(campoQtd.getText());
            if (qtd > 0) {
                campoQtd.setText(String.valueOf(qtd - 1));
            }
        });

        botaoMais.addActionListener(e -> {
            int qtd = Integer.parseInt(campoQtd.getText());
            campoQtd.setText(String.valueOf(qtd + 1));
        });
    }
}