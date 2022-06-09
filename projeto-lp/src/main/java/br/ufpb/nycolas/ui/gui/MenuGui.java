package br.ufpb.nycolas.ui.gui;

import javax.swing.*;

import br.ufpb.nycolas.ui.Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui extends JFrame implements ActionListener, Menu {
    // Buttons
    private JButton buttonConsulta;
    private JButton buttonCadastra;
    private JButton buttonLista;

    public MenuGui() {
        this.init();
    }

    @Override
    public void init() {

        // Botão consulta
        buttonConsulta = new JButton();
        buttonConsulta.setFont(new Font("Consolas", 1, 12));
        buttonConsulta.setSize(160, 200);
        buttonConsulta.setText("Consultar..");

        // Botão cadastra
        buttonCadastra = new JButton();
        buttonCadastra.setFont(new Font("Consolas", 1, 12));
        buttonCadastra.setText("Cadastrar..");

        buttonLista = new JButton();
        buttonLista.setFont(new Font("Consolas", 1, 12));
        buttonLista.setText("Listar..");

        // Configurando JFrame
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 200);
        setResizable(false);
        setTitle("Assistencia Tecnica");
        setVisible(true);

        // add(buttonConsulta);
        // add(buttonCadastra);
        // add(buttonLista);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
}
