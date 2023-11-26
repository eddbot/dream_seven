package com.murismo;

import com.sun.jna.Pointer;

import javax.swing.*;
import java.awt.*;
import java.util.Formatter;
import java.util.List;
import java.util.stream.IntStream;

public class Gui {

    private final Application app;

    public Gui(Application app) {
        this.app = app;
    }

    public void start(){

        JFrame frame = new JFrame("Dream Seven");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(2,1));

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

            // cloud.setLevel(level);
            // this should be 'updateStat(characterClass.getLevel)'
            app.updateCloudLevel(level);
            app.updateCloudName(name);


            JOptionPane.showMessageDialog(frame, "Stats updated");
        });

        connectButton.addActionListener(e -> {

            if(app.isConnected()) {
                connectButton.setText("Connect to FF7");
                indicatorLabel.setBackground(Color.RED);
                cloudPanel.setVisible(false);
                app.disconnect();
                return;
            }

            if(app.connectToGame()) {
                indicatorLabel.setBackground(Color.GREEN);
                connectButton.setText("Disconnect from FF7");
                cloudLevel.setSelectedItem(app.readStatInformation(new Pointer(Application.CLOUD_CHARACTER)));
                cloudName.setText(app.readNameInformation(new Pointer(Application.CLOUD_CHARACTER+15)));
                cloudPanel.setVisible(true);
                // ok
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
        frame.add(cloudPanel);
        frame.setSize(1200, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
