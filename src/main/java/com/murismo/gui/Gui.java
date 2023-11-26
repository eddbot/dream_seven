package com.murismo.gui;

import com.murismo.character.FF7Character;
import com.murismo.core.Processor;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Gui {

    private final Processor processor;

    public Gui(Processor processor) {
        this.processor = processor;
    }

    private List<CharacterPanel> createCharacterPanels(JFrame frame){
        return this.processor.characterList().stream().map(character -> {
            CharacterPanel characterPanel = new CharacterPanel(character, frame);
            characterPanel.setVisible(false);
            return characterPanel;
        }).toList();

    }

    public void start(){

        JFrame frame = new JFrame("Dream Seven");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(16,1));

        JPanel connectionPanel = new JPanel();
        JLabel statusLabel = new JLabel("Status: ");
        JLabel indicatorLabel = new JLabel();


        indicatorLabel.setOpaque(true);
        indicatorLabel.setPreferredSize(new Dimension(20, 20));
        indicatorLabel.setBackground(Color.RED);

        JButton connectButton = new JButton("connect to FF7");
        connectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        List<CharacterPanel> charPanels = createCharacterPanels(frame);

        connectButton.addActionListener(e -> {

            if(processor.isConnected()) {
                connectButton.setText("Connect to FF7");
                indicatorLabel.setBackground(Color.RED);
                charPanels.forEach(CharacterPanel::hidePanel);
                processor.disconnect();
                return;
            }

            if(processor.connect()) {
                indicatorLabel.setBackground(Color.GREEN);
                connectButton.setText("Disconnect from FF7");
                charPanels.forEach(CharacterPanel::showPanel);
            } else {
                charPanels.forEach(CharacterPanel::hidePanel);
                connectButton.setText("Connect to FF7");
                indicatorLabel.setBackground(Color.RED);
                JOptionPane.showMessageDialog(frame, "FF7 is not running");
            }

            charPanels.forEach(frame::add);
            frame.revalidate();
            frame.repaint();
        });


        connectionPanel.add(statusLabel);
        connectionPanel.add(indicatorLabel);
        connectionPanel.add(connectButton);
        frame.add(connectionPanel);

        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
