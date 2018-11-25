package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import controle.Global;
import controle.Mouse;
import modele.Jeu;

public class Plateau extends JComponent {

	private static final long serialVersionUID = 1L;
	Mouse mouse;
	Jeu jeu;
	FinJeu FinduJeu;

	public static void main(String[] args) {
		 Jeu jeu = new Jeu();
		 Plateau plateau = new Plateau();
		 JFrame frame = new JFrame();
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(Global.LARGEUR, Global.HAUTEUR);
		 frame.setBackground(Color.WHITE);
		 
		 plateau.setJeu(jeu);
		 Jeu.initPlat();
		 jeu.setPlateau(plateau);
		 JOptionPane.showMessageDialog(null,"Les Bleu Commence La Partie");
		 
		 frame.getContentPane().add(plateau);
		 //Jeu.Plateauconsole();

		 frame.setVisible(true);
		
	}

	//Parametre de l'Hexagone position ...
		int a = (int) (0.5*Global.RAYON);
		int b = (int) (Math.sin(61)*Global.RAYON); 
		
		/**
		 * Create the panel.
		 */
	public void Hexagone()  {
		setPreferredSize(new Dimension(Global.LARGEUR,Global.HAUTEUR));
		}
		
	//Comment l'Hexagone doit être dessiné
	public void paintHexa(Graphics g, int x, int y, int state) {
    	
    	int xpoints[] = {x,(x+b),(x+b),x,(x-b),(x-b)};
	    int ypoints[] = {(y-Global.RAYON),(y-a),(y+a),(y+Global.RAYON),(y+a),(y-a)};
	    
	    if(state == 0) {//Quel type d'hexagone doit être colorié
	    	g.setColor(Color.WHITE);
	    	g.fillPolygon(xpoints,ypoints,6);
	    	g.setColor(Color.BLACK);
	    	g.drawPolygon(xpoints,ypoints,6);
	    } else if ( state == 1){
	    	g.setColor(Color.BLUE);
	    	g.fillPolygon(xpoints,ypoints,6);
	    	g.setColor(Color.BLACK);
	    	g.drawPolygon(xpoints, ypoints, 6);
	    }
	    else if ( state == 2 ){
	    	g.setColor(Color.RED);
	    	g.fillPolygon(xpoints,ypoints,6);
	    	g.setColor(Color.BLACK);
	    	g.drawPolygon(xpoints, ypoints, 6);
	    }
    }
	
	
	
	//Dessine le plateau d'hexagone
	public void paintPlateauHexa(Graphics g){
		int i;
		int j;
		int k =0;
		double p = 0;
		
		int ligne = 0;
		int colonne = 0;

		for (i = 5 - k ; i <= 15 ; i++){k++;
			colonne = 0;
			for(j = 7; j <= 15; j++){
				int xcolonne =  (( ( Global.MAILLE *j) )+ (b*k) );
				int ycolonne = ( ( Global.MIMAILLE * i) + (a *k) );
				
				paintHexa(g,  xcolonne,  ycolonne, jeu.getCase(ligne+1, colonne+1)); //Creer le plateau 											
				
				colonne++; 
			}p=p+0.5;
			ligne++;
		}
	}
		
	//Dessine l'Hexagone
	protected void paintComponent(Graphics g) {
		this.paintBordure(g);
		this.paintPlateauHexa(g);		
	}
	
	
	public Plateau() {
		mouse = new Mouse();
		this.addMouseListener(mouse);
	}
	
	public void setJeu(Jeu jeu){
		this.jeu = jeu;
		mouse.setJeu(jeu);
	}
	
	
	
	//Dessine les bords des joueurs
		public void paintBordure(Graphics g){
			int xPoints1[] = {290,770,525,30};
			int yPoints1[] = {105,110,510,510};
			g.drawPolygon(xPoints1, yPoints1, 4);
			g.setColor(Color.BLUE);
			g.fillPolygon(xPoints1, yPoints1, 4);
			
			int xPoints3[] = {330,750,465,35};
			int yPoints3[] = {90,90,530,530};
			g.drawPolygon(xPoints3, yPoints3, 4);
			g.setColor(Color.RED);
			g.fillPolygon(xPoints3, yPoints3, 4);


		}
		
}


