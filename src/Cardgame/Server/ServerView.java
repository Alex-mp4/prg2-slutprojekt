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

    public JPanel getPanel() {
        return panel;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public void setTextArea2(JTextArea textArea2) {
        this.textArea2 = textArea2;
    }

    public void setTextArea3(JTextArea textArea3) {
        this.textArea3 = textArea3;
    }

    public void setTextArea4(JTextArea textArea4) {
        this.textArea4 = textArea4;
    }

    public void setTextArea5(JTextArea textArea5) {
        this.textArea5 = textArea5;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JButton getButton1() {
        return button1;
    }
}
