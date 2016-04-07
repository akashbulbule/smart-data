package dbapp;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Paths;

import javax.swing.*;
 
public class TextDemo extends JPanel implements ActionListener {
    //protected JTextField textField;
    //protected JTextArea textArea;
    //private final static String newline = "\n";
 
    public TextDemo(String inputText) {
    	//setLayout(new BorderLayout());
    	
    	//Create and set up the window.
        //JFrame frame = new JFrame("TextDemo");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	//Create a text area.
        JTextArea textArea = new JTextArea();
        
        textArea.setFont(new Font("Serif", Font.ITALIC, 16));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setText(inputText);
        JScrollPane areaScrollPane = new JScrollPane(textArea);
        areaScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(500, 250));
        areaScrollPane.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Plain Text"),
                                BorderFactory.createEmptyBorder(5,5,5,5)),
                areaScrollPane.getBorder()));
        //JPanel panel = new JPanel(new BorderLayout());
        add(areaScrollPane, BorderLayout.PAGE_START);
        //Add contents to the window.
        //frame.add(areaScrollPane, BorderLayout.PAGE_START);
 
        //Display the window.
        //frame.pack();
        //frame.setVisible(true);
    }
 
    public void actionPerformed(ActionEvent evt) {
       /* String text = textField.getText();
        textArea.append(text + newline);
        textField.selectAll();
 
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
        textArea.setCaretPosition(textArea.getDocument().getLength());*/
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI(String inputText) {
        //Create and set up the window.
        JFrame frame = new JFrame("TextDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add contents to the window.
        frame.add(new TextDemo(inputText));
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) throws IOException {
    	
    	//byte[] encoded = Files.readAllBytes(Paths.get("/home/adarshavadhani/del/output.txt"));
    	//final String input = new String(encoded, Charset.defaultCharset());
    	
    	//FileReader f = new FileReader("/home/adarshavadhani/del/output.txt");
    	//BufferedReader in = new BufferedReader(f);
    	
    	//final String input = in.toString();		
    	/*System.out.println(input);
    	//Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI(input);
            }
        });*/
    }
}