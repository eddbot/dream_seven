package com.murismo;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import javax.swing.text.Document;

public class NameInputField extends JTextField {
    public NameInputField(int columns) {
        super(columns);
    }

    protected Document createDefaultModel() {
        return new NameInputDocument();
    }

    static class NameInputDocument extends PlainDocument {
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

            if (str == null) {
                return;
            }

            if(offs < 10 && str.length() <= 10) {
                super.insertString(offs, str, a );
            }
        }
    }
}
