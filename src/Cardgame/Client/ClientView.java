package Cardgame.Client;

import javax.swing.*;

public class ClientView {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel;

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setRogue(String c) {
        textArea1.setText(c);
    }

    public void setBarbarian(String c) {
        textArea2.setText(c);
    }

    public void setShaman(String c) {
        textArea3.setText(c);
    }

    public void setArcher(String c) {
        textArea4.setText(c);
    }

    public void setAmalgam(String c) {
        textArea5.setText(c);
    }
}
