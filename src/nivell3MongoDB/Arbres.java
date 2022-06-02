package nivell3MongoDB;

import java.util.Scanner;

public class Arbres{

	String nom_arbre;
	Double alcada_arbre;
	Double preu_arbre;
	int quantitat_arbres;
	
	
	
	public Arbres(String nom_arbre, Double alcada_arbre, Double preu_arbre) {
		super();
		this.nom_arbre = nom_arbre;
		this.alcada_arbre = alcada_arbre;
		this.preu_arbre = preu_arbre;
		this.quantitat_arbres = 1;
	}
	
	public static Floristeria afegir(Floristeria floristeria) {
		
		Scanner nom_arbre = new Scanner(System.in);
		System.out.println("Introdueix el nom de l'arbre a afegir:");        		
		String arbre = nom_arbre.nextLine();     
				
		Scanner alcada_arbre = new Scanner(System.in);
		System.out.println("Introdueix l'alcada de l'arbre a afegir:");        		
		Double alcada = alcada_arbre.nextDouble();
		
		Scanner preu_arbre = new Scanner(System.in);
		System.out.println("Introdueix el preul arbre a afegir:");        		
		Double preu = preu_arbre.nextDouble();
		
		if (floristeria.arbres.size() == 0) {
			floristeria.arbres.add(new Arbres(arbre, alcada, preu));
			System.out.println("Arbre creat");
			
		} else {
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.arbres.get(index).nom_arbre.equals(arbre) &&  floristeria.arbres.get(index).alcada_arbre.equals(alcada)) {
					coincideix=true;
					floristeria.arbres.get(index).quantitat_arbres =  (floristeria.arbres.get(index).quantitat_arbres)+1;
					System.out.println("Arbre sumat");
				};
				if ((index == (floristeria.arbres.size()-1) && coincideix == false)  ) {
					floristeria.arbres.add(new Arbres(arbre, alcada, preu));
					System.out.println("Arbre creat");
					coincideix=true;
				}
				index++;
			
			} while (coincideix==false);
		};
			
		//nom_flor.close();
		//color_flor.close();
		//preu_flor.close();
		
		return floristeria;
		
	}
	
	public static Floristeria retirar(Floristeria floristeria, int ticket) {
				
		if (floristeria.arbres.size() == 0) {			
			System.out.println("No hi ha arbres introduïts");
			
		} else {
			
			Scanner nom_arbre = new Scanner(System.in);
			System.out.println("Introdueix el nom de l'arbre a retirar:");        		
			String arbre = nom_arbre.nextLine();     			
			
			Scanner alcada_arbre = new Scanner(System.in);
			System.out.println("Introdueix la alcada de l'arbre a retirar:");        		
			Double alcada = alcada_arbre.nextDouble();
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.arbres.get(index).nom_arbre.equals(arbre) &&  floristeria.arbres.get(index).alcada_arbre.equals(alcada)) {
				
					coincideix=true;
				
					if (floristeria.arbres.get(index).quantitat_arbres-1 == 0) {
						
						floristeria.tickets.get(ticket).arbres.add(floristeria.arbres.get(index));
						floristeria.arbres.remove(index);
						
					
						System.out.println("Arbre esborrat, no quedaven més unitats");
					
						index = index-1;
					
					} else {
						floristeria.tickets.get(ticket).arbres.add(floristeria.arbres.get(index));
						floristeria.arbres.get(index).quantitat_arbres =  floristeria.arbres.get(index).quantitat_arbres-1;					
						System.out.println("Restaun arbre, queden "+ floristeria.arbres.get(index).quantitat_arbres + " disponibles");}		
				};
				if ((index == (floristeria.arbres.size()-1) && coincideix == false)  ) {
					System.out.println("No existeix aquest arbre en estoc");
					coincideix=true;
				}
				
				index++;
			
			} while (coincideix==false);
		
		}
		
		return floristeria;
		
	}


	
	
	
}
