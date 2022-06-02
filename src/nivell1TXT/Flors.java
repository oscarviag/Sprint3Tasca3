package nivell1TXT;

import java.util.Scanner;

public class Flors{
	
	String nom_flor;
	String color;
	Double preu_flor;
	int quantitat_flor;
	
	
	public Flors(String nom_flor, String color, Double preu_flor) {
		super();
		this.nom_flor = nom_flor;
		this.color = color;
		this.preu_flor = preu_flor;
		this.quantitat_flor = 1;
	}
	
	
	public static Floristeria afegir(Floristeria floristeria) {
		
		Scanner nom_flor = new Scanner(System.in);
		System.out.println("Introdueix la flor a afegir:");        		
		String flor = nom_flor.nextLine();     
				
		Scanner color_flor = new Scanner(System.in);
		System.out.println("Introdueix el color de la flor a afegir:");        		
		String color = color_flor.nextLine();
		
		Scanner preu_flor = new Scanner(System.in);
		System.out.println("Introdueix el preu de la flor a afegir:");        		
		Double preu = preu_flor.nextDouble();
		
		if (floristeria.flors.size() == 0) {
			floristeria.flors.add(new Flors(flor, color, preu));
			System.out.println("Flor creada");
			
		} else {
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.flors.get(index).nom_flor.equals(flor) &&  floristeria.flors.get(index).color.equals(color)) {
					coincideix=true;
					floristeria.flors.get(index).quantitat_flor =  (floristeria.flors.get(index).quantitat_flor)+1;
					System.out.println("Flor sumada");
				};
				if ((index == (floristeria.flors.size()-1) && coincideix == false)  ) {
					floristeria.flors.add(new Flors(flor, color, preu));
					System.out.println("Flor creada");
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
				
		if (floristeria.flors.size() == 0) {			
			System.out.println("No hi ha flors introduïdes");
			
		} else {
			
			Scanner nom_flor = new Scanner(System.in);
			System.out.println("Introdueix la flor a retirar:");        		
			String flor = nom_flor.nextLine();     			
			
			Scanner color_flor = new Scanner(System.in);
			System.out.println("Introdueix el color de la flor a retirar:");        		
			String color = color_flor.nextLine();
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.flors.get(index).nom_flor.equals(flor) &&  floristeria.flors.get(index).color.equals(color)) {
				
					coincideix=true;
				
					if (floristeria.flors.get(index).quantitat_flor-1 == 0) {
						
						floristeria.tickets.get(ticket).flors.add(floristeria.flors.get(index));
						floristeria.flors.remove(index);
						
					
						System.out.println("Flor esborrada, no quedaven més unitats");
					
						index = index-1;
					
					} else {
						floristeria.tickets.get(ticket).flors.add(floristeria.flors.get(index));
						floristeria.flors.get(index).quantitat_flor =  floristeria.flors.get(index).quantitat_flor-1;					
						System.out.println("Restada una flor, queden "+ floristeria.flors.get(index).quantitat_flor + " disponibles");}		
				};
				if ((index == (floristeria.flors.size()-1) && coincideix == false)  ) {
					System.out.println("No existeix aquesta flor en estoc");
					coincideix=true;
				}
				
				index++;
			
			} while (coincideix==false);
		
		}
		
		//nom_flor.close();
		//color_flor.close();
		//preu_flor.close();
		
		return floristeria;
		
	}



}
