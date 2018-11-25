package vue;

import controle.Global;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Menu {
	public Menu() {
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
    	
    	JFrame frame = new JFrame();
				
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 380);//Taille de la fenetre
		frame.setBounds(100,100,Global.LARGEUR,Global.HAUTEUR); //Coordonne de la position de la fenetre dans l'ecran
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		
		/************
		 * Bouton Quitter
		 */
		JButton btnQuitter = new JButton("Quitter");//Creation du bouton Quitter
		btnQuitter.setBackground(Color.WHITE);
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {//Lors du clic ferme le menu
				System.exit(0);
			}
		});
		frame.getContentPane().setLayout(null);
		btnQuitter.setBounds(460, 450, 204, 68);//Position du Bouton Quitter dans la frame
		frame.getContentPane().add(btnQuitter);//Ajout a la Frame du bouton Quitter
				
		/*******
		 * Bouton Jouer
		 */
		JButton btnJouer = new JButton("Jouer");//Creation du bouton Jouer
		btnJouer.setBackground(Color.WHITE);
		btnJouer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				vue.Plateau.main(null);;
				frame.setVisible(false);
			}
		});
		btnJouer.setBounds(110, 450, 204, 68);//Position du Bouton Jouer dans la frame
		frame.getContentPane().add(btnJouer);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(269, 105, 240, 186);
		frame.getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon("/Users/Chris/Documents/workspace/Hex/media/HegaLogo.png"));
		
		JLabel lblLeJeuDe = new JLabel("    LE JEU DE HEX");
		lblLeJeuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeJeuDe.setBounds(314, 336, 127, 48);
		frame.getContentPane().add(lblLeJeuDe);
		
		frame.setVisible(true);
			
	}
}