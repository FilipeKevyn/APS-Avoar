package Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

public class TelaPagamento extends JFrame {

    public TelaPagamento(JFrame telaAnterior, double valorTotal) {
        setTitle("Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel labelTitulo = new JLabel("Pagamento");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        labelTitulo.setBounds(110, 20, 200, 40);
        add(labelTitulo);

        DecimalFormat df = new DecimalFormat("R$ #,##0.00");
        JLabel labelTotal = new JLabel("Total = " + df.format(valorTotal));
        labelTotal.setFont(new Font("Arial", Font.PLAIN, 18));
        labelTotal.setBounds(80, 90, 250, 30);
        add(labelTotal);

        JTextField campoPagamento = new JTextField();
        campoPagamento.setBounds(80, 130, 240, 30);
        add(campoPagamento);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(50, 200, 100, 30);
        add(botaoVoltar);

        JButton botaoPagar = new JButton("Pagar");
        botaoPagar.setBounds(230, 200, 100, 30);
        add(botaoPagar);

        botaoVoltar.addActionListener(e -> {
            telaAnterior.setVisible(true);
            dispose();
        });

        botaoPagar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pagamento realizado com sucesso!");
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                telaAnterior.setVisible(true);
            }
        });
    }
}