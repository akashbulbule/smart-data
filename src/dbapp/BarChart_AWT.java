package dbapp;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset; 
import org.jfree.data.category.DefaultCategoryDataset; 
import org.jfree.ui.ApplicationFrame; 
import org.jfree.ui.RefineryUtilities; 

	public class BarChart_AWT //extends ApplicationFrame
	{
		 ChartPanel chartPanel;
	   public BarChart_AWT( String applicationTitle , String chartTitle, String[] inputData, String choice)
	   {
	      //super( applicationTitle );        
	      JFreeChart barChart = ChartFactory.createBarChart(
	         chartTitle,           
	         choice+"s",            
	         choice+" Count",            
	         createDataset(inputData),          
	         PlotOrientation.VERTICAL,           
	         true, true, false);
	         
	      chartPanel = new ChartPanel( barChart );        
	      //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );  //560 , 367      
	      //setContentPane( chartPanel ); 
	   }
	   private CategoryDataset createDataset(String[] inputData)
	   {

	      final DefaultCategoryDataset dataset = 
	      new DefaultCategoryDataset( ); 
	      
	      dataset.addValue( Integer.parseInt(inputData[0]), inputData[1] , "" );
	      dataset.addValue( Integer.parseInt(inputData[2]), inputData[3] , "" );
	      dataset.addValue( Integer.parseInt(inputData[4]), inputData[5] , "" );

	      return dataset; 
	   }
	   public static void main( String[] args )
	   {
	      String[] inputData = new String[6];
	      inputData[0]= "2";inputData[1]= "adarsh";
	      inputData[2]= "10";inputData[3]= "bangalore";
	      inputData[4]= "6";inputData[5]= "mumbai";
		   
		  BarChart_AWT chart = new BarChart_AWT("Noun Count Statistics", "Top 3 nouns",inputData,"Noun");
		  //JPanel pan=new JPanel();
		  //pan.add(chart);
		  JFrame fr=new JFrame();
		  fr.setContentPane(chart.chartPanel);
		  fr.setVisible(true);
		  fr.pack();
	      //chart.pack( );        
	      //RefineryUtilities.centerFrameOnScreen( chart );        
	      //chart.setVisible(true);
	   }
}
