package modele;

import java.awt.Point;
import controle.Global;
import vue.Plateau;

public class Jeu {

	public static int G[][] = new int[Global.NBCASE][Global.NBCASE];
	Plateau plateau;
	public static int tour = 0;

	public Jeu() {
	}

	public int gettour() {
		return tour;
	}

	// Si une case est vide ou deja utiliser
	public boolean triggeraction(int ligne, int col) {

		if (ligne < 0 || ligne > 12 || col < 0 || col > 10) {
			System.out.println("ERROR " + ligne + "," + col + " Mauvaises coords");
			return false;
		}

		if (G[ligne][col] == 0 && tour % 2 == 0) {
			G[ligne][col] = 1;
			plateau.repaint();
			tour++;
			return true;
		} else if (G[ligne][col] == 0 && tour % 2 != 0) {
			G[ligne][col] = 2;
			plateau.repaint();
			tour++;
			return true;

		}
		return false;
	}

	public Point retournePoint(int x, int y) {
		Point point = new Point(x, y);
		return point;
	}

	// Representation du Plateau en console et initialisation de ce plateau 1 =
	// JouRouge // 2 = JouBleu // 0 = case non utiliser
	public static void Plateauconsole() {
		int i;
		int j;

		for (i = 0; i <= 12; i++) {
			System.out.println("");
			for (j = 0; j <= 10; j++) {
				System.out.print(G[i][j]);
			}
		}

	}

	public static void initPlat() {
		int i;
		int j;

		for (i = 0; i <= 12; i++) {
			for (j = 0; j <= 10; j++) {
				if (i == 0)
					G[i][j] = 2;
				else if ((i > j && j == 0))
					G[i][j] = 1;
				else if (j == 10 && i < 12)
					G[i][j] = 1;
				else if (i == 12)
					G[i][j] = 2;
				else
					G[i][j] = 0;
				G[12][0] = 2;
			}
		}
		System.out.println("tour = " + tour);
	}

	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}

	public int getCase(int ligne, int colonne) {
		if (ligne < 0 || ligne >= 20 || colonne < 0 || colonne >= 20) {
			return 0;
		}
		return G[ligne][colonne];
	}

	public int gagnant() {
		int i, j;
		int B[][] = new int[30][30];

		for (i = 0; i <= 12; i++) {
			for (j = 0; j <= 10; j++) {
				B[i][j] = G[i][j];
			}
		}
		/* Remplace les 2 en -2 des case du bord du haut */
		for (j = 0; j <= 12; j++) {
			if (B[0][j] == 2) {
				B[0][j] = -2;
			}
		}

		/* Remplace les 1 en -1 des cases du bord gauche */
		for (i = 0; i <= 12; i++) {
			if (B[i][0] == 1) {
				B[i][0] = -1;
			}
		}

		/*
		 * Pour une case i j du tableau verifie qu'il y a un pions rouge ou bleu autour
		 */
		for(int t = 1; t <= 10; t++) {
		for (i = 1; i <= 12; i++) {
			for (j = 1; j <= 10; j++) {

				if (B[i][j] == 2) {
					if ((B[i - 1][j - 1] == -2) || (B[i - 1][j] == -2) || (B[i][j + 1] == -2) || (B[i + 1][j + 1] == -2)
							|| (B[i + 1][j] == -2) || (B[i][j - 1] == -2)) {
						B[i][j] = -2;/* Si il y a un pion rouge autour il le change en -2 dans le tableau B */
					}
				}

				if (B[i][j] == 1) {
					if ((B[i - 1][j - 1] == -1) || (B[i - 1][j] == -1) || (B[i][j + 1] == -1) || (B[i + 1][j + 1] == -1)
							|| (B[i + 1][j] == -1) || (B[i][j - 1] == -1)) {
						B[i][j] = -1;/* Si il y a un pion bleu autour il le change en -1 dans le tableau B */
					}

				}
			}
		}
		}

		

		// Permet d'afficher le tableau B Dans le compilateur
		/*for (i = 0; i <= 12; i++) {
			System.out.println("");
			for (j = 0; j <= 10; j++) {
				System.out.print("   " + B[i][j]);
			}
		}
		*/

		/* Si le bord du bas contient un -2 alors le joueur rouge gagne */
		for (j = 0; j <= 12; j++) {
			if (B[12][j] == -2) {

				return 2;
			}

		}

		/* Si le bord du bas contient un -1 alors le joueur bleu gagne */
		for (i = 1; i <= 11; i++) {
			if (B[i][10] == -1) {
				return 1;
			}

		}

		return 0;
	}

}
