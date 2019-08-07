import java.util.*;


public class Paquet {
	
	
	private ArrayList<Carte> cartes = new ArrayList<Carte>();

	public Paquet(ArrayList<Carte> ca) {
		for(int i=0;i<10;i++)
			cartes.add(ca.get(i));
	}
	public Paquet() {
		
		for(int i=1;i<8;i++) {
			cartes.add(new Carte("Oros",i));
			cartes.add(new Carte("Bastos",i));
			cartes.add(new Carte("Shbadas",i));
			cartes.add(new Carte("Copas",i));
		}
		for(int i=10;i<13;i++) {
			cartes.add(new Carte("Oros",i));
			cartes.add(new Carte("Bastos",i));
			cartes.add(new Carte("Shbadas",i));
			cartes.add(new Carte("Copas",i));
		}
		
	}
	
	public static void main(String[] args) {
		Paquet p=new Paquet();
		System.out.println(p.cartes.size());
		for(int i=0;i<40;i++)
			System.out.println(p.cartes.get(i));
		
	}
	
	public ArrayList<Carte> getCartes(){
		return cartes;
	}


}

