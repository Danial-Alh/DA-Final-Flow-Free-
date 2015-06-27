package ui;

import utilities.FileParser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Hosein on 6/27/2015.
 */
public class FilePanel extends JPanel
{
    JLabel label;
    JTextField textField;
    JButton button;

    JFileChooser fileChooser;

    JButton solveButton;

    public FilePanel()
    {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        fileChooser = new JFileChooser();
        label = new JLabel("Pick your file: ");
        textField = new JTextField(30);
        button = new JButton("Browse...");
        solveButton = new JButton("Solve");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                solveButtonActionPerformed(evt);
            }
        });

        add(label);
        add(textField);
        add(button);
        add(solveButton);

    }
    private void buttonActionPerformed(ActionEvent evt)
    {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }
    private void solveButtonActionPerformed(ActionEvent evt)
    {
        String fileLocation = textField.getText();
        if(fileLocation != null)
        {
            FileParser myFileParser;
            myFileParser = new FileParser(fileLocation);
        }
    }
}