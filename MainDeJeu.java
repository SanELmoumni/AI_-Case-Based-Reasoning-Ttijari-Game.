import java.util.*;

public class MainDeJeu {
	
	private ArrayList<Carte> main = new ArrayList<Carte>();
	private String trunfo;
	
	private ArrayList<Carte> cartesSansValeur = new ArrayList<Carte>();
	private ArrayList<Carte> cartesValeur = new ArrayList<Carte>();
	
	
	public MainDeJeu(Paquet p){
		Random r=new Random();
		int aleat;
		for(int i=0;i<10;i++) {
			aleat = r.nextInt(p.getCartes().size());
			main.add(p.getCartes().get(aleat));
			p.getCartes().remove(aleat);
		}
		trunfo = coulTrunfo(main);
		trouveCartesSansVal();
		trouveCartesVal();
	}
	
	

	public MainDeJeu() {
		Scanner sc = new Scanner(System.in);
		Scanner sn = new Scanner (System.in);
		String coul = new String();
		int num = -5;
		
		for(int i=0;i<10;i++) {
				System.out.println("Saisissez la couleur de la carte souhait�e ( Oros - Bastos - Shbadas - Copas) ..." );
				coul = sc.nextLine();
				System.out.println("Saisissez le num�ro de la carte souhait�e ( Oros - Bastos - Shbadas - Copas) ..." );
				num = sn.nextInt();
				main.add(new Carte(coul,num));
		}
		trunfo = coulTrunfo(main);
			
	}
	public MainDeJeu(MainDeJeu m) {
		for(int i=0;i<10;i++) 
			main.add(new Carte(m.main.get(i).getCouleur(),m.main.get(i).getNumero()));
		trunfo = coulTrunfo(main);
		
	}
	
	public void trouveCartesSansVal() {
		for(Carte c : main) {
			if(c.getPoint()==0) {
				cartesSansValeur.add(c);
			}
		}
	}
	public void trouveCartesVal() {
		for(Carte c : main) {
			if(c.getPoint()!=0) {
				cartesValeur.add(c);
			}
		}
	}
	
	public ArrayList<Carte> getMain(){
		return main;
	}
	
	public String getTrunfo() {
		return coulTrunfo(main);
	}
	public static  String coulTrunfo(ArrayList<Carte> m) {
		int max=0;
		String maxS="";
		int bastos=0,copas=0,oros=0,shbadas=0;
		for(int i=0;i<m.size();i++) {
			if(m.get(i).getCouleur().equals("Bastos"))
				bastos+=m.get(i).getPoint();
			if(m.get(i).getCouleur().equals("Copas"))
				copas+=m.get(i).getPoint();
			if(m.get(i).getCouleur().equals("Oros"))
				oros+=m.get(i).getPoint();
			if(m.get(i).getCouleur().equals("Shbadas"))
				shbadas+=m.get(i).getPoint();
		}
		if(bastos<copas) {
			max = copas;
			maxS="Copas";
		}
		else {
			max = bastos;
			maxS = "Bastos";
		}
		if(max < oros) {
			max = oros;
			maxS = "Oros";
			}
		if(max < shbadas) {
			max = shbadas;
			maxS = "Shbadas";
		}
		return maxS;
			
	}
	
	public static void trierCouleur(ArrayList<Carte> m) {
		Carte temp = new Carte();
        for (int i = 0; i < m.size(); i++) 
        {
            for (int j = i + 1; j < m.size(); j++) 
            {
                if (m.get(i).getCouleur().compareTo(m.get(j).getCouleur())>0) 
                	{
                    Collections.swap(m,i,j);
                }
            }
        }
	}
	public static void trierPoints(ArrayList<Carte> m) {
		Carte temp = new Carte();
		for(int i=0; i<m.size(); i++) {
			for(int j=i+1; j<m.size(); j++) {
				if(m.get(i).getCouleur().equals(m.get(j).getCouleur())) {
					if(m.get(i).getPoint() < m.get(j).getPoint() ) {
						Collections.swap(m,i,j);
					}
					if(m.get(i).getPoint() == m.get(j).getPoint()) {
						if(m.get(i).getNumero() < m.get(j).getNumero() ) {
							Collections.swap(m,i,j);
						}
					}
				}
			}
		}
	}
	public static void trier(ArrayList<Carte> m) {
		trierCouleur(m);
		trierPoints(m);
	}
	
	
	//Les points en communs que peuvent apporter les deux mains � la fois en fonction du m�me num�ro.
	public static int similaritePoints(ArrayList<Carte> m1, ArrayList<Carte> m2) {
		ArrayList<Carte> temp = new ArrayList(m2);
		int i,j=0;
		int taillem2=m2.size();
		int similarite = 0;
		for(i=0; i<m1.size(); i++) {

			j=0;
			while (j<m2.size() && m1.get(i).getNumero() != m2.get(j).getNumero())
				j++;
			if(j<m2.size()) { 
				similarite += m1.get(i).getPoint();	
				m2.remove(j);
			}
			
		}
		m2.clear();
		for(i=0;i<temp.size();i++) {
			m2.add(temp.get(i));
		}
		

		return similarite;
	}
	
	
	public static int similariteChant(ArrayList<Carte> m1, ArrayList<Carte> m2,String coulTrunfo) {
		trier(m1);
		trier(m2);
		String couleur;
		int pointchant1 = 0;
		int pointchant2 = 0;
		int i=0,j=0;
		boolean chant1=false,chant2=false;
		int nm1=m1.size();
		int nm2=m2.size();	
		for (i=0; i<nm1; i++){
			couleur = m1.get(i).getCouleur();
			
			if(m1.get(i).getNumero()==12) {	
				
				j=i+1;
				while(j<nm1 && m1.get(j).getCouleur().equals(couleur)){
					if(m1.get(j).getNumero()==11) {
						chant1=true;
						pointchant1+=20;
						if(couleur.equals(coulTrunfo)) pointchant1+=20;
						break;
					}
					j++;
				}
			}	
		}
		j=0;
		for (i=0; i<nm2; i++){
			couleur = m2.get(i).getCouleur();
			
			if(m2.get(i).getNumero()==12) {	
				
				j=i+1;
				while(j<nm2 && m2.get(j).getCouleur().equals(couleur)){
					if(m2.get(j).getNumero()==11) {
						chant2=true;
						pointchant2+=20;
						if(couleur.equals(coulTrunfo)) pointchant2+=20;
						break;
					}
					j++;
				}
			}	
		}
		//System.out.println("Chant main 1 : "+pointchant1+ " Chant main 2 : "+pointchant2);		
		
		if(chant1 && chant2) {
			return pointchant1;
		}	
		return 0;
	}
	
	public static int similariteNbrCouleur(ArrayList<Carte> m1, ArrayList<Carte> m2,String couleur) {
		int nm1 = m1.size();
		int nm2  = m2.size();
		int cpt1 =0,cpt2=0;
		int debug=0;
		for(int i=0; i<nm1;i++) {
			if(m1.get(i).getCouleur().equals(couleur))
				cpt1++;
		}
		for(int i=0; i<nm2;i++) {
			if(m2.get(i).getCouleur().equals(couleur))
				cpt2++;
		}
		if(cpt1==cpt2)
			return 25;
		if(cpt2==0) 
			return Math.abs(cpt1-cpt2/cpt1)*25;
		
		
		return Math.abs(cpt1-cpt2/cpt2)*25;
	}
	
	public static int similariteNombreCartes(ArrayList<Carte> m1, ArrayList<Carte> m2) {
		int coeff=0;
		coeff += similariteNbrCouleur(m1, m2, "Bastos");
		coeff += similariteNbrCouleur(m1, m2, "Copas");
		coeff += similariteNbrCouleur(m1, m2, "Oros");		
		coeff += similariteNbrCouleur(m1, m2, "Shbadas");		
		return coeff;
	}
	
	
	public static double similariteCartesValeurs(ArrayList<Carte> m1, ArrayList<Carte> m2){
		return (0.6*similaritePoints(m1,m2))+(0.3*similariteChant(m1,m2,coulTrunfo(m1)))+ 
		(0.1*similariteNombreCartes(m1,m2));
	}
	
	public static double similaritePriorite(MainDeJeu m1,MainDeJeu m2) {
		trier(m1.main);
		trier(m2.main);
		int i,n;
		double prioriteExisteC1_C2 = 0;		
		for (Carte carte : m1.main) {
			for (i = 0,n=m2.main.size(); i < n && carte.getNumero() != m2.main.get(i).getNumero(); i++) ;
			if(i<n && carte.getNumero() == m2.main.get(i).getNumero()) {
				switch(carte.getNumero()) {
				case 7:prioriteExisteC1_C2+=1.5;
				break;
				case 6:prioriteExisteC1_C2+=1;
				break;
				case 5:prioriteExisteC1_C2+=0.75;
				break;
				case 4:prioriteExisteC1_C2+=0.5;
				break;
				case 2:prioriteExisteC1_C2+=0.25;
				break;
				}
			   }
			}
			return prioriteExisteC1_C2;
	}
	
	public static double similariteCartesSansValeurs(MainDeJeu m1,MainDeJeu m2) {
		return (0.55*similaritePriorite(m1,m2))+0.45*similariteNombreCartes(m1.main,m2.main);
	}
	

	public static double similariteCouleur(MainDeJeu m1,MainDeJeu m2) {
		double similarite=0;
		String[] allcolors=new String[4];
		allcolors[0]="Bastos";allcolors[1]="Copas";allcolors[2]="Oros";allcolors[3]="Shbadas";
		int simChant=0;
		for(String i :allcolors) {
			simChant += similariteChant(m1.main,m2.main,i);
			similarite = 0.6*similariteCartesValeurs(m1.cartesValeur,m2.cartesValeur)+
					0.4*similariteCartesSansValeurs(m1,m2);
		}

		return similarite;
	}
	
	
	public static int similariteMain(ArrayList<MainDeJeu> baseDeCas,MainDeJeu m) {
		trier(m.getMain());
		
		
		double similarite = 0;
		double max=0;
		int position=0;
		int i;
		for(i=0; i<baseDeCas.size();i++) {
			trier(baseDeCas.get(i).getMain());
			similarite = similariteCouleur(baseDeCas.get(i),m);
			if(similarite > max) {
				max = similarite;
				position = i;
			}
			System.out.println("Similarite avec la main "+i+" = "+similarite+"%");
		}
		System.out.println("La main la plus similaire est celle qui occupe la position : "+position+".");
		System.out.println("Le taux de similarit� est de : "+max+"%.");
		return position;
	}

	
	public String toString() {
		String ret = new String();
		for(int i=0; i<10; i++) {
			ret += " Couleur : ";
			ret += main.get(i).getCouleur();
			ret += " Num�ro : ";
			ret += main.get(i).getNumero();
			ret += " Point : ";
			ret += main.get(i).getPoint();
			ret +="\n";
		}
		return ret;
	}

}
