package lesson4;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    private JTextArea chatArea;
    private JTextField messageArea;


    public MyWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 100, 500, 500);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);

        JScrollPane scrollChatArea = new JScrollPane(chatArea);
        add(scrollChatArea, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        messageArea = new JTextField();
        bottomPanel.add(messageArea, BorderLayout.CENTER);

        JButton sendMessage = new JButton("Send");
        bottomPanel.add(sendMessage, BorderLayout.EAST);
        sendMessage.addActionListener(e -> {
            if(!messageArea.getText().isEmpty() && !messageArea.getText().startsWith(" ")) {
                chatArea.append(messageArea.getText());
                chatArea.append("\n");
            }
            messageArea.setText("");
        });

        bottomPanel.getRootPane().setDefaultButton(sendMessage);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}

