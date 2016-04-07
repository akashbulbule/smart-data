package dbapp;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

//import org.jsoup.select.Evaluator.IsEmpty;

public class MainPage extends JFrame{
	
	JRadioButton nouns;
	JRadioButton collocations;
	JRadioButton paragraphSummary;
	JTextField paragraphPercentage;
	JCheckBox c1;
	JButton selFile;
	JButton execute;
	final JLabel statusbar;
	final ButtonGroup btnGroup;
	static JPanel outputPanel;
	JPanel inputPanel;
	JSplitPane splitPane;
	ShowData show = new ShowData();
	JFrame frame;
	
	public MainPage()
	{
		super("BigData System");
		//setSize(350, 200);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);

	    Container c = getContentPane();
	    c.setLayout(new FlowLayout());
	    
	    nouns=new JRadioButton("Nouns");
		collocations=new JRadioButton("Collocations");
		paragraphSummary=new JRadioButton("Paragraph Summary");
		//c1=new JCheckBox("Graph based output");
		paragraphPercentage=new JTextField();
		paragraphPercentage.setPreferredSize(new Dimension(10,10));
		paragraphPercentage.setText("Enter percentage of paragraph text");
		
		selFile=new JButton("Select File");
		execute=new JButton("Execute");
		statusbar = new JLabel("Selected File: ");
		btnGroup = new ButtonGroup();
		btnGroup.add(nouns);
		btnGroup.add(collocations);
		btnGroup.add(paragraphSummary);
		
		String[] inputData = new String[6];
	      inputData[0]= "2";inputData[1]= "Data1";
	      inputData[2]= "10";inputData[3]= "Data2";
	      inputData[4]= "6";inputData[5]= "Data";
	      
		try {
			outputPanel=show.showOutput(inputData,"Plain Text Output Shows Here","Smart Data Shows Here","Data Point");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void startUI()
	{
		frame=new JFrame("BigData System ");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		inputPanel=new JPanel();
		inputPanel.setLayout(new GridLayout(5,1));
		
		execute.setEnabled(false);
		
		inputPanel.add(nouns);		
		inputPanel.add(collocations);
		inputPanel.add(paragraphSummary);
		inputPanel.add(paragraphPercentage);
		//panel.add(c1);
		
		
		inputPanel.add(selFile);
		inputPanel.add(statusbar);
		execute.setActionCommand("execute");
		execute.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ButtonModel selectedModel = btnGroup.getSelection();
				if (selectedModel != null)
				{
					selectedModel.getActionCommand();
				
					if(nouns.isSelected())
					{
						execute("/home/adarshavadhani/workspace/BigData/NounCount.py","Noun");
					}
					else if(collocations.isSelected())
					{
						execute("/home/adarshavadhani/workspace/BigData/collCount.py","Collocation");
					}
					else if(paragraphSummary.isSelected())
					{
						execute("/home/adarshavadhani/workspace/BigData/paraSumm.py","ParagraphSummary");
					}
					
				}
				
				System.out.println("no login");
			}

			private void execute(String choice, String filePrefix) {
				/*Plug in algorithm logic to work on the input file with selected algorithm*/
				Process p;
				
				try
				{
					//p = Runtime.getRuntime().exec(choice+" "+statusbar.getText()+" "+percentage.getText());
					//p = Runtime.getRuntime().exec("python "+choice+" "+statusbar.getText()+" "+"out.txt");
					//p = Runtime.getRuntime().exec("python /home/adarshavadhani/workspace/BigData/test.py 1 2");
					
					FileReader f = new FileReader("output"+filePrefix+".txt");
					BufferedReader in = new BufferedReader(f);
					StringBuilder sb = new StringBuilder();
					String line;
					String[] send = new String[6];
					int i = 0;
					while(((line = in.readLine()) !=null) && i<6){
						String[] tokens = line.split(" ");
						send[i] = tokens[0];
						send[i+1] = tokens[1];
						i = i+2;
						sb.append(line+"\n");
						
					}
					in.close();
					
					
					
					FileReader f1 = new FileReader("smartOutput.txt");
					BufferedReader in1 = new BufferedReader(f1);
					StringBuilder sb1 = new StringBuilder();
					String line1;
					String[] send1 = new String[6];
					int i1 = 0;
					while(((line1 = in1.readLine()) !=null) && i1<6){
						String[] tokens1 = line1.split(" ");
						send1[i1] = tokens1[0];
						send1[i1+1] = tokens1[1];
						i1 = i1+2;
						sb1.append(line1+"\n");
						
					}
					in1.close();
					

					outputPanel=show.showOutput(send, sb.toString(),sb1.toString(),filePrefix);
					splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
					frame.getContentPane().setLayout(new FlowLayout());
					frame.getContentPane().removeAll();
					frame.getContentPane().add(splitPane);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.pack();
					frame.setVisible(true);
					//splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
					
				}
				
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//Change 0.1 to user input
				
			}
		});
		
		selFile.setActionCommand("select");
		selFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(MainPage.this);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    if(selectedFile!=null && !selectedFile.equals(""))
				    {
				    	statusbar.setText(selectedFile.getAbsolutePath());
				    	execute.setEnabled(true);
				    }
				    else
				    {
				    	execute.setEnabled(true);
				    	statusbar.setText("Selected File:");
				    }
				    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
				
			}

		});
		
		inputPanel.add(execute);
		
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, inputPanel, outputPanel);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(splitPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
	
	public static void main(String[] args)
	{
		MainPage ui=new MainPage();
		ui.startUI();
		
	}

}
