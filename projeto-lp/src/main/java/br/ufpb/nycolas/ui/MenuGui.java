package br.ufpb.nycolas.ui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.*;

public class MenuGui extends JFrame implements Menu {
    // Panels
    private JPanel painelButtons;

    // Buttons
    private JButton buttonConsulta;
    private JButton buttonCadastra;
    private JButton buttonLista;

    public MenuGui() {
        this.init();
    }

    @Override
    public void init() {

        // Configurando JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setResizable(false);
        setTitle("Assistencia Tecnica");
        setVisible(true);

        // Botão consulta
        buttonConsulta = new JButton();
        buttonConsulta.setFont(new Font("Consolas", 1, 12));
        buttonConsulta.setText("Consultar..");
       

        // Botão cadastra
        buttonCadastra = new JButton();
        buttonCadastra.setFont(new Font("Consolas", 1, 12));
        buttonCadastra.setText("Cadastrar..");
        

        // Contêiner Lateral de botões
        painelButtons = new JPanel();
        painelButtons.setBackground(new Color(200, 200, 200));
        painelButtons.setSize(200, 1200);
        painelButtons.setRequestFocusEnabled(false);
        painelButtons.setLayout(new java.awt.GridLayout(4, 0, 10, 10));
        painelButtons.add(buttonConsulta, 0); // Adiciona o botão de consultar ao conteiner
        painelButtons.add(buttonCadastra, 1); // Adiciona o botão de cadastrar ao conteiner

        // Contêiner principal
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
                layout.createSequentialGroup().addComponent(painelButtons, GroupLayout.PREFERRED_SIZE, 150,
                        GroupLayout.PREFERRED_SIZE).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)));

        pack();
    }
}
