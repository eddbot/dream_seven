package com.murismo.gui;

import com.murismo.character.FF7Character;

import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class CharacterPanel extends JPanel {

    private final FF7Character character;
    private final String label;

    private final JFrame frame;

    private final JComboBox<Integer> levelBox;

    private final NameInputField characterNameInput;

    public void showPanel(){
        levelBox.setSelectedItem(character.getLevel());
        characterNameInput.setText(character.getName());
        this.setVisible(true);
    }

    public void hidePanel(){
        this.setVisible(false);
    }

    public CharacterPanel(FF7Character character, JFrame frame) {
        this.character = character;
        this.label = character.getDefaultName();
        this.frame = frame;
        this.levelBox = new JComboBox<>(IntStream.range(1,100).boxed().toArray(Integer[]::new));
        this.characterNameInput = new NameInputField(12);

        JLabel charLabel = new JLabel("%s Level: ".formatted(label));
        JButton updateCharacter = new JButton("Update");
        updateCharacter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JLabel characterNameLabel = new JLabel("%s Name: ".formatted(label));

        updateCharacter.addActionListener(e -> {
            Integer level = (Integer) levelBox.getSelectedItem();
            if(level == null){
                JOptionPane.showMessageDialog(frame, "Unable to update level");
                return;
            }

            String name = characterNameInput.getText();

            if(name == null || name.isBlank()){
                JOptionPane.showMessageDialog(frame, "Unable to update name");
                return;
            }

            character.setLevel(level);
            character.setName(name);

            JOptionPane.showMessageDialog(frame, "Stats updated");
        });

        this.add(charLabel);
        this.add(levelBox);
        this.add(characterNameLabel);
        this.add(characterNameInput);
        this.add(updateCharacter);
    }
}
