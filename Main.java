import java.util.*;
//Rei = 12
//Cabal = 11		les deux nous donnent un chant !
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 				MAIN_Programme VERSION 1 : 
		 * 
		
		
		Paquet p = new Paquet();
		
		MainDeJeu joueur1 = new MainDeJeu(p);
		MainDeJeu joueur2 = new MainDeJeup);
		MainDeJeu joueur3 = new MainDeJeu(p);
		MainDeJeu joueur4 = new MainDeJeu(p);
		
		System.out.println("---- JOUEUR 1 ----");
		for(int i=0; i<joueur1.getMain().size(); i++) {
			System.out.println(joueur1.getMain().get(i));
		}
		
		System.out.println("---- JOUEUR 2 ----");
		for(int i=0; i<joueur2.getMain().size(); i++) {
			System.out.println(joueur2.getMain().get(i));
		}
		
		System.out.println("---- JOUEUR 3 ----");
		for(int i=0; i<joueur3.getMain().size(); i++) {
			System.out.println(joueur3.getMain().get(i));
		}
		
		System.out.println("---- JOUEUR 4 ----");
		for(int i=0; i<joueur4.getMain().size(); i++) {
			System.out.println(joueur4.getMain().get(i));
		}
		*/
		
		//MainDeJeu m = new MainDeJeu();
	
		
		
		
		
		
		
		
		
		
		Paquet p = new Paquet();
		
		MainDeJeu joueur1 = new MainDeJeu(p);
		MainDeJeu joueur2 = new MainDeJeu(p);
		MainDeJeu joueur3 = new MainDeJeu(p);
		MainDeJeu joueur4 = new MainDeJeu(p);
		ArrayList<MainDeJeu> base = new ArrayList();
		
		base.add(joueur1);
		base.add(joueur2);
		base.add(joueur3);
		base.add(joueur4);
		
		
		
		ArrayList<Carte> l1 = new ArrayList();
		Carte c = new Carte("Bastos",10);
		Carte c2 = new Carte("Bastos",7);
		Carte c3 = new Carte("Bastos",12);
		Carte c4= new Carte("Copas",5);
		Carte c5 = new Carte("Copas",4);
		Carte c6 = new Carte("Oros",3);
		Carte c7 = new Carte("Oros",11);
		Carte c8 = new Carte("Oros",12);
		Carte c9 = new Carte("Oros",5);
		Carte c10 = new Carte("Shbadas",10);
		l1.add(c);
		l1.add(c2);
		l1.add(c3);
		l1.add(c4);
		l1.add(c5);
		l1.add(c6);
		l1.add(c7);
		l1.add(c8);
		l1.add(c9);
		l1.add(c10);
		Paquet p1 = new Paquet(l1);
		MainDeJeu m1 = new MainDeJeu(p1);
		MainDeJeu.trier(m1.getMain());
		
		ArrayList<Carte> l2 = new ArrayList();
		Carte c0 = new Carte("Bastos",11);
		Carte c30 = new Carte("Copas",12);
		Carte c20 = new Carte("Bastos",4);

		Carte c40= new Carte("Copas",7);
		Carte c50 = new Carte("Copas",10);
		Carte c60 = new Carte("Oros",12);
		Carte c70 = new Carte("Oros",5);
		Carte c80 = new Carte("Shbadas",12);
		Carte c90 = new Carte("Shbadas",6);
		Carte c100 = new Carte("Shbadas",7);
		l2.add(c0);
		l2.add(c20);
		l2.add(c30);
		l2.add(c40);
		l2.add(c50);
		l2.add(c60);
		l2.add(c70);
		l2.add(c80);
		l2.add(c90);
		l2.add(c100);
		Paquet p2 = new Paquet(l2);
		MainDeJeu m2 = new MainDeJeu(p2);
		MainDeJeu.trier(m2.getMain());
		
		
		base.add(m2);
		System.out.println(m1);
		System.out.println(m2);
		MainDeJeu.similariteMain(base, m1);
		//System.out.println("Trunfo main 1 : "+m1.getTrunfo());
		//System.out.println("Trunfo main 2 : "+m2.getTrunfo());		
		
		//System.out.println("Similarite Point : "+MainDeJeu.similaritePoints(m1.getMain(), m2.getMain()));
		//System.out.println("Similarite Chant : "+MainDeJeu.similariteChant(m1.getMain(), m2.getMain(), m1.getTrunfo()));
		/*System.out.println("Similarite Nombre cartes par couleur : "+MainDeJeu.similariteNombreCartes(m1, m2));
		System.out.println("Similarite Cartes valeurs : "+MainDeJeu.similariteCartesValeurs(m1,m2));
		
		System.out.println("Similarite Priorite : "+MainDeJeu.similaritePriorite(m1,m2));
		System.out.println("Similarité Cartes sans valeur : "+MainDeJeu.similariteCartesSansValeurs(m1,m2));*/
		
		//System.out.println(MainDeJeu.similariteCouleur(m1, m2));
	/*	joueur1.trier();
		System.out.println(joueur1);*/
		
		
		
		
	}

}
