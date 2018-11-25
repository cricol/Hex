package controle;

import controle.Global;

import modele.Jeu;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Mouse extends MouseAdapter{

	Jeu jeu;

	@Override
	public void mouseClicked(MouseEvent e) {

		int xclic = e.getX();
		int yclic = e.getY();
		int a = (int) (0.5*Global.RAYON);
		int b = (int) (Math.sin(61)*Global.RAYON); 
		int col = 0;
		int ligne = 0;
		
		double mindistance = 800;
		int colmin = 0;
		int lignemin = 0;
		
		int k=0;
		//Regarde quel hexagone est le plus près du clic du joueur
		for (int i = 5 - k ; i <= 15 ; i++){
		k++;
		col = 0;
			for(int j = 7; j <= 15; j++){
				int xcentreHex =  (( ( Global.MAILLE * j) )+ (b*k) );
				int ycentreHex = ( ( Global.MIMAILLE * i) + (a *k) );
				
				Point Hexagone = new Point (xcentreHex,ycentreHex);
				Point Clic = new Point(xclic,yclic);
				
				double x= (Clic.x - Hexagone.x);
				double y = (Clic.y - Hexagone.y );
				
				double distance = Math.sqrt( ((x)*(x)) + ((y)*(y)) );
				if(distance < mindistance){
					colmin = col;
					lignemin = ligne;
					mindistance = distance;
				}col ++;
			
			}ligne++;
		}
		
		//Jeu.Plateauconsole();
		jeu.triggeraction(lignemin+1, colmin+1);//Envoi les coordonnes du clic du bonne hexagone 

		System.out.println(jeu.gagnant() );
		if(jeu.gagnant() == 2) {
			System.out.println("Rouge Gagne");
			JOptionPane.showMessageDialog(null,"Les Rouge Gagne La Partie");
		}
		else if(jeu.gagnant() == 1) {
			System.out.println("Bleu Gagne");
			JOptionPane.showMessageDialog(null,"Les Bleu Gagne La Partie");
		}
	}

	public void setJeu(Jeu jeu){
		this.jeu = jeu;
	}


}

