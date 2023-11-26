package com.murismo.gui;

import com.murismo.character.FF7Character;
import com.murismo.core.Processor;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class Gui {

    private final Processor processor;

    public Gui(Processor processor) {
        this.processor = processor;
    }

    public void start(){

        JFrame frame = new JFrame("Dream Seven");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(16,1));

        JPanel connectionPanel = new JPanel();
        JLabel statusLabel = new JLabel("Status: ");
        JLabel indicatorLabel = new JLabel();



        JPanel cloudPanel = new JPanel();
        JLabel cloudLabel = new JLabel("Cloud Level: ");
        Integer[] levels = IntStream.range(1,100).boxed().toArray(Integer[]::new);
        JComboBox<Integer> cloudLevel = new JComboBox<>(levels);
        JButton updateCloud = new JButton("Update");
        JLabel cloudNameLabel = new JLabel("Cloud Name: ");
        NameInputField cloudName = new NameInputField(12);




        cloudPanel.add(cloudLabel);
        cloudPanel.add(cloudLevel);
        cloudPanel.add(cloudNameLabel);
        cloudPanel.add(cloudName);
        cloudPanel.add(updateCloud);
        cloudPanel.setVisible(false);



        indicatorLabel.setOpaque(true);
        indicatorLabel.setPreferredSize(new Dimension(20, 20));
        indicatorLabel.setBackground(Color.RED);



        JButton connectButton = new JButton("connect to FF7");
        connectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        updateCloud.addActionListener(e -> {
            Integer level = (Integer) cloudLevel.getSelectedItem();
            if(level == null){
                JOptionPane.showMessageDialog(frame, "Unable to update level");
                return;
            }

            String name = cloudName.getText();

            if(name == null || name.isBlank()){
                JOptionPane.showMessageDialog(frame, "Unable to update name");
                return;
            }

            FF7Character cloud = processor.characterList().get("cloud");

            cloud.setLevel(level);
            cloud.setName(name);


            JOptionPane.showMessageDialog(frame, "Stats updated");
        });

        connectButton.addActionListener(e -> {

            FF7Character cloud = processor.characterList().get("cloud");

            if(processor.isConnected()) {
                connectButton.setText("Connect to FF7");
                indicatorLabel.setBackground(Color.RED);
                cloudPanel.setVisible(false);
                processor.disconnect();
                return;
            }

            if(processor.connect()) {
                indicatorLabel.setBackground(Color.GREEN);
                connectButton.setText("Disconnect from FF7");

                cloudLevel.setSelectedItem(cloud.getLevel());
                cloudName.setText(cloud.getName());
                cloudPanel.setVisible(true);
            } else {
                connectButton.setText("Connect to FF7");
                indicatorLabel.setBackground(Color.RED);
                cloudPanel.setVisible(false);
                JOptionPane.showMessageDialog(frame, "FF7 is not running");
            }

            frame.revalidate();
            frame.repaint();
        });


        connectionPanel.add(statusLabel);
        connectionPanel.add(indicatorLabel);
        connectionPanel.add(connectButton);
        frame.add(connectionPanel);



        frame.add(cloudPanel); // one for each char




        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
