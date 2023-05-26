package Cardgame.Server;

import javax.swing.*;

public class ServerView {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextArea textArea3;
    private JTextArea textArea4;
    private JTextArea textArea5;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel;
    private JTextField textField2;
    private JTextArea textArea6;

    public JPanel getPanel() {
        return panel;
    }

    public String getTextField() {
        return textField1.getText();
    }

    public JButton getButton1() {
        return button1;
    }

    public void setTextField(String c) {
        textField2.setText(c);
    }

    public void setTextArea(String c) {
        textArea6.setText(c);
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
