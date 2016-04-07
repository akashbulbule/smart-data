package dbapp;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.Document;

import org.jfree.ui.RefineryUtilities;

public class ShowData {
	
	public JPanel showOutput(String[] barChartData, String textData, String smartText, String choice) throws IOException 
	{
		JPanel panel=new JPanel();
		JPanel textPanel=new JPanel();
		textPanel.setLayout(new GridLayout(2,1));
		//panel.setLayout(new GridLayout(1, 2));
		BarChart_AWT chart =  new BarChart_AWT("Noun Count Statistics", "Top 3 "+choice+"s",barChartData, choice);
		TextDemo text = new TextDemo(textData);
		JTextArea smartData=new JTextArea();
		smartData.setSize(new Dimension(500,250));
		smartData.setText(smartText);
		textPanel.add(text);
		textPanel.add(smartData);
		
		JSplitPane outputPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chart.chartPanel, textPanel);
		panel.add(outputPane);
		return panel;
		
	}
	
	
	public static void main(String[] args){

		try {
			FileReader f = new FileReader("/home/adarshavadhani/del/output.txt");
		
			BufferedReader in = new BufferedReader(f);
			
			ShowData test = new ShowData();
			//test.show("NC",in);
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
