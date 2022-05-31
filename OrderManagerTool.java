

import logger.LoggerAdministration;
import article.ArticleAdministration;
//import order.OrderAdministraion;


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


class OrderManagerTool extends Frame implements ActionListener {

	MenuBar mBar = new MenuBar();
	Menu menu = new Menu("Application");	
	MenuItem loggerItem = new MenuItem("logger administration");
	MenuItem articleItem = new MenuItem("article administration");
	MenuItem orderItem = new MenuItem("order administration");
	MenuItem exitItem = new MenuItem("exit");
		
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
				
    public void actionPerformed(ActionEvent e){
		
			
	}						
			
	public void setup() {

		try {
						
			ImageComponent image = new ImageComponent("postfactory.png");
			
			image.setBounds(10,10,100,20);
			image.setBounds(10,0,800,180);
		
			loggerItem.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){								
					LoggerAdministration logger = new LoggerAdministration();
					logger.setup();
				}
				
			});

			articleItem.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e){						
					ArticleAdministration article = new ArticleAdministration();
					article.setup();					
				}				
			});


			orderItem.addActionListener(new ActionListener(){				
				
				public void actionPerformed(ActionEvent e) {
					//OrderAdministration order = new OrderAdministration();					
				}								
			});
			
			exitItem.addActionListener(new ActionListener(){
				
				public void actionPerformed(ActionEvent e){
					System.exit(0);
				}
			});
			

			add(image);	
			
			menu.add(loggerItem);
			menu.add(articleItem);
			menu.add(orderItem);
			menu.add(exitItem);				
			
			mBar.add(menu);			
			setMenuBar(mBar);
			
		}catch(Exception e) {
			System.out.println("error occurred while initialzing setup");
		}
	
		setSize(1000,700);	
		setLayout(null);
		setVisible(true);
	}		
	
	public static void main(String args[]){
		OrderManagerTool tool = new OrderManagerTool();
		tool.setup();
	}	
}