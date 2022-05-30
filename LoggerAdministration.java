package logger;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;

public class LoggerAdministration extends Frame implements ActionListener {
	
	
	SimpleDateFormat month = new SimpleDateFormat("MM");
	SimpleDateFormat day   = new SimpleDateFormat("d");
	SimpleDateFormat year  = new SimpleDateFormat("yyyy");

	TextField tf;
	TextArea t;
	Calendar c;
	Date date = new Date();
	JComboBox box_months, box_years;	
	
	public LoggerAdministration(){
		System.out.println("logger Administration called!");
	}	
	
	protected void addCalender() {
		
		c = Calendar.getInstance();
		c.setTime(date);		
	}		
					
    public void actionPerformed(ActionEvent e){
					
		String str = day.format(date) + month.format(date) + year.format(date);		
		
		String year = (String)box_years.getSelectedItem();
		String month = (String)box_months.getSelectedItem();
		int index = box_months.getSelectedIndex()+1;
		
		tf.setText(month + " " + year);					
		
		try {
			String log = this.readLogFile(year, index);		
			t.setText(log);	
		} catch (Exception ex) {
			System.out.println("error occured while performing action");
		}		
	}					
	
	
	protected void addComboBox() {
		
		String[] months = {"Januar","Februar","Maerz","April","Mai", "Juni","Juli","August","September","Oktober","November","Dezember"};		
		String[] years = {"2020","2021","2022"};
		
		box_months = new JComboBox<String>(months);
		box_years = new JComboBox<String>(years);				
	}	
	
	protected String readLogFile(String year, int month) throws IOException
	{		
		Boolean writeData = false;	
		String line;
		String str;	
		String sMonth = Integer.toString(month);
				
		if (month < 10) {
			sMonth = "0" + sMonth;
		}
		
		String file = "W:\\logs\\Bestellungen-GAPTEQ_Abgleich " + year + "-" + sMonth + ".log";			
		
		Path filePath = Paths.get(file);
		if (Files.exists(filePath) == false){
			return new String("selected file: " + file + " does not exist!");
		}
				
		StringBuilder builder = new StringBuilder();		
		FileReader fileReader = new FileReader(file);			
		BufferedReader reader = new BufferedReader(fileReader);				
		
		while ( (line = reader.readLine()) != null) {
				
			if (line.contains("Error:")) {													
				writeData = true;
				builder.append("\n ERROR OCCURED WHILE IMPORTING DATA \n");
				continue;
			}
			
			if (line.contains("--- ERROR --- BLOCK ---")){
				writeData = false;
			}
			
			if (writeData) {						
				builder.append(line);
				builder.append("\n");				
			}					
		}	
		
		return builder.toString();
	}				
	
		public void setup() {

		try {
			
			this.addCalender();			
			this.addComboBox();			
			
			
			ImageComponent image = new ImageComponent("postfactory.png");			
			image.setBounds(10,10,100,20);
			image.setBounds(10,0,800,180);
		
			
			
			Button b = new Button("load file");
			b.setBounds(30,300,80,30);
			b.addActionListener(this);
		
			tf = new TextField(); tf.setBounds(30,250, 80,30);				
			t = new TextArea();  t.setBounds(150,190,800,500);				
			
			box_months.setBounds(30,190, 80,30);
			box_years.setBounds(30,220, 80,30);
					
			add(image);
			add(b);
			add(t);
			add(tf);
			
			add(box_months);
			add(box_years);							
			
		}catch(Exception e) {
			System.out.println("error occurred while initialzing setup");
		}
	
		setSize(1000,700);	
		setLayout(null);
		setVisible(true);
	}		


	class ImageComponent extends Component {
		
		BufferedImage img;

		public ImageComponent(String path){
			
				try {
					img = ImageIO.read(new File(path));
				} catch(IOException e){
					e.printStackTrace();
				}
		}

		public void paint(Graphics graphics){		
			graphics.drawImage(img, 0,0,null);		
		}		
		
		public Dimension getPreferredSize(){
			
			if (img == null) {
				return new Dimension(100,100);
			} else {
				return new Dimension(img.getWidth(), img.getHeight());
			}			
		}		
	}

}