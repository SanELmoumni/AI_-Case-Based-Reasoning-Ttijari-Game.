import java.util.*;

public class Carte {

	private String couleur;
	private int numero,point;
	
	public Carte() {	}
	
	public Carte(String c, int n) {
		couleur = c;
		numero = n;
		switch(n) {
			case 1 : 
				point = 11;	break;
			case 2: 
				case 4: 
					case 5: 
						case 6: 
							case 7:
								point = 0;	break;
			case 3:
				point = 10 ; break;
			case 10:
				point = 2; break;
			case 11: 
				point =3 ;	break;
			case 12: 
				point =4 ;	break;
		}
		
	}
					//Getters & Setters.
	public String getCouleur() {
		return couleur;
	}
	public int getNumero() {
		return numero;
	}
	public int getPoint() {
		return point;
	}
	
	public void setNumero(int n) {
		numero = n;
	}
	public void setCouleur(String c) {
		couleur = c;
	}
	
	public String toString() {
		return " " + couleur + " " +numero;
	}
	
	
}
