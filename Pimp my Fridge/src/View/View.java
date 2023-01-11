package View;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class View extends JFrame implements ActionListener {
	

JFrame j = new JFrame("PIMP MY FRIDGE");

private boolean statut;
private float temperatureint ;
private float temperatureext;
private float temperatureconsigne ;
private float humidite;


 
 JButton b1 = new JButton("Valider");
 JButton b2 = new JButton("Accèder à l'historique");
 JButton b3 = new JButton("Commander des produits");
 
 JTextField jtxt = new JTextField(""+ temperatureconsigne);
 
 JPanel p = new JPanel();
 JPanel p1 = new JPanel();
 JPanel p2 = new JPanel();
 JPanel p3 = new JPanel();
 JPanel p4 = new JPanel();
 JPanel p5 = new JPanel();
 JPanel p6 = new JPanel();
 
 JLabel l1 = new JLabel("             FRIDGE MANAGER");
 JLabel l2 = new JLabel("Tempèrature intèrieur");
 JLabel l3 = new JLabel("Tempèrature extèrieur");
 JLabel l4 = new JLabel("Taux d'humidité");
 JLabel l5 = new JLabel("Detection d'erreur");
 JLabel l7 = new JLabel(""+ this.temperatureint );
 JLabel l8 = new JLabel(""+ this.temperatureext);
 JLabel l9 = new JLabel(""+ this.humidite);
 
  
 Font f = new Font("Arial",Font.BOLD,30);
 
 GridLayout gl = new GridLayout (0,2);
 

public View(boolean statut,float temperatureint,float temperatureext,float temperatureconsigne,float humidite){
	 	
		
	 	this.statut = statut;
	 	this.temperatureint = temperatureint;
	 	this.temperatureconsigne = temperatureconsigne;
	 	this.humidite = humidite;
	 	this.temperatureext = temperatureext;
	 	
	 	j.setSize(1600, 900);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtxt.addActionListener(this);
		jtxt.setActionCommand("Passer une Commande");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		b1.setActionCommand("Valider");
		b2.setActionCommand("Accèder à l'historique");
		b3.setActionCommand("Commander des produits");
		
		 
		l1.setFont(f);
		
		p.setLayout(gl);
		p1.setLayout(gl);
		p2.setLayout(gl);
		p3.setLayout(gl);
		p4.setLayout(gl);
		p5.setLayout(gl);
		
		
		p1.add(l2);
		p1.add(l7);
		
		p2.add(l3);
		p2.add(l8);
		
		p3.add(l4);
		p3.add(l9);
		
		p4.add(jtxt);
		p4.add(b1);
		
		p5.add(l5);
		p5.add(p6);	
		
		p.add(l1);
		p.add(p4);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p5);
		
		
		p.add(b2);
		p.add(b3);
		
		
		j.add(p);
		
		j.setVisible(true);
 }
@Override
public void actionPerformed(ActionEvent e) {
	 if (e.getActionCommand().equals("Valider")){
		 this.temperatureconsigne = Float.parseFloat(jtxt.getText());
		 System.out.println(this.temperatureconsigne);
		 
	 }
	 else if (e.getActionCommand().equals("Accèder à l'historique")){
		 System.out.println("le fichier text n'est pas encore dispo");
	 }
	 else if (e.getActionCommand().equals("Commander des produits")){
		 try {
			Desktop.getDesktop().browse(new URI("https://www.bing.com/ck/a?!&&p=433b4dce78aedeaaJmltdHM9MTY3MzMwODgwMCZpZ3VpZD0zNTJhMmY3OC05ZGNlLTYxZTMtMzlkNi0zZmMwOTljZTZmNzQmaW5zaWQ9NTE2OQ&ptn=3&hsh=3&fclid=352a2f78-9dce-61e3-39d6-3fc099ce6f74&psq=carrefour+market+cameroun&u=a1aHR0cHM6Ly93d3cuY2FycmVmb3VyLmNtLw&ntb=1"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
	 }
	 else if (e.getActionCommand().equals("Passer une Commande")){
		 int firstime = 0;
		 if (firstime == 0){
		 jtxt.setText("");
		 firstime = 1;
		 }
	 }
	 }
public void setTemperatureint(float temperatureint) {
	this.temperatureint = temperatureint;
}
public void setTemperatureext(float temperatureext) {
	this.temperatureext = temperatureext;
}
public void setHumidite(float humidite) {
	this.humidite = humidite;
}
public void setStatut(boolean statut) {
	this.statut = statut;
	
}
public boolean getStatut(){
	return this.statut;
}
public void update(){
	  l7.setText(""+ ""+ this.temperatureint);
	  l8.setText(""+ this.temperatureext);
	  l9.setText(""+ this.humidite);
	  
	  if (statut == true){
		  p6.setBackground(Color.RED);
	  }	
	  if (statut == false){
		  p6.setBackground(Color.GREEN);
	  }
}
public JFrame getFrame() {
	return j;
}
public float getTemperatureconsigne() {
	return this.temperatureconsigne;
	
 }
}


