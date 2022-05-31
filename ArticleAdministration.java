package article;

import entity.Article;
import entity.Mandat;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.io.IOException;
import java.nio.file.*;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


import javax.imageio.ImageIO;

public class ArticleAdministration extends Frame implements ActionListener {

	Choice selectMandante;
	ArrayList<Mandat> mandatList = new ArrayList<Mandat>();

	public ArticleAdministration() {

		//TODO: load from DB
		Mandat m1 = new Mandat();
		m1.setId(24);
		m1.setName("Inter E-Shop");
		m1.setPath("InterEShop");

		Mandat m2 = new Mandat();
		m2.setId(22);
		m2.setName("Mr.Fuss");
		m2.setPath("MrFuss");

		mandatList.add(m1);
		mandatList.add(m2);
	}

	public void renderView() {
		
		selectMandante = new Choice();
		selectMandante.setBounds(100,200,100,100);
		
		for(int i=0; i<mandatList.size(); i++){
			selectMandante.add(mandatList.get(i).getName());
		}
		
		add(selectMandante);		
		
		setSize(1000,700);	
		setLayout(null);
		setVisible(true);	

		Button load = new Button("load");
		load.setBounds(200,200,50,20);
		
		load.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				int index = selectMandante.getSelectedIndex();
				String name = selectMandante.getSelectedItem();
				loadCSVFile(index);						
			}
		});	
		
		add(load);						
	}

	//TODO: apply own CSV Handler 
	protected void loadCSVFile(int index){
	
		//get data from SFTP Server
		Mandat mandat = mandatList.get(index);

		//first read article csv
		Path dir = Paths.get("Y:\\" + mandat.getPath() + "\\Artikel");

		//check whether "Y:\\" is accessible and if there are any files
		Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
		for (Path name: dirs){
			System.out.println(name);
		}

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){

			for(Path file:stream) {
				System.out.println(file.getFileName());
			}

		} catch (IOException | DirectoryIteratorException e){
			System.err.println(e);
		}
	}
	
	public void addArticle(Article article) {

		//
	}

	public Article getArticle(int id){

		Article article = new Article();

		//TODO:

		return article;
	}

	public void updateArticle(Article article) {

		//TODO:
	}

	public void deleteArticle(int id) {

		//TODO:
	}

	/*
	 howto?
	public Article[] getArticleList(Array) {
		//TODO:
	}*/

	public void actionPerformed(ActionEvent e){

	}	
	
	public void setup() {

		renderView();
	}	
}