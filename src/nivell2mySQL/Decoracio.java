package nivell2mySQL;

import java.util.Scanner;

public class Decoracio{

	String nom_decoracio;
	String material_decoracio;
	Double preu_decoracio;
	int quantitat_decoracio;
	
	
	
	public Decoracio(String nom_decoracio, String material_decoracio, Double preu_decoracio) {
		super();
		this.nom_decoracio = nom_decoracio;
		this.material_decoracio = material_decoracio;
		this.preu_decoracio = preu_decoracio;
		this.quantitat_decoracio = 1;
	}

	public static Floristeria afegir(Floristeria floristeria) {
		
		Scanner nom_decoracio = new Scanner(System.in);
		System.out.println("Introdueix el nom de la decoraci� a afegir:");        		
		String decoracio = nom_decoracio.nextLine();     
				
		Scanner material_decoracio = new Scanner(System.in);
		System.out.println("Introdueix el material de la decoraci� a afegir:");        		
		String material = material_decoracio.nextLine();
		
		Scanner preu_decoracio = new Scanner(System.in);
		System.out.println("Introdueix el preu de l'article afegir:");        		
		Double preu = preu_decoracio.nextDouble();
		
		if (floristeria.decoracio.size() == 0) {
			floristeria.decoracio.add(new Decoracio(decoracio, material, preu));
			System.out.println("Decoracio creada");
			
		} else {
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.decoracio.get(index).nom_decoracio.equals(decoracio) &&  floristeria.decoracio.get(index).material_decoracio.equals(material)) {
					coincideix=true;
					floristeria.decoracio.get(index).quantitat_decoracio =  (floristeria.decoracio.get(index).quantitat_decoracio)+1;
					System.out.println("Decoraci� sumada");
				};
				if ((index == (floristeria.decoracio.size()-1) && coincideix == false)  ) {
					floristeria.decoracio.add(new Decoracio(decoracio, material, preu));
					System.out.println("Decoraci� creada");
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
				
		if (floristeria.decoracio.size() == 0) {			
			System.out.println("No hi ha decoracions introdu�des");
			
		} else {
			
			Scanner nom_decoracio = new Scanner(System.in);
			System.out.println("Introdueix la decoraci� a retirar:");        		
			String decoracio = nom_decoracio.nextLine();     			
			
			Scanner material_decoracio = new Scanner(System.in);
			System.out.println("Introdueix el material de la decoraci� a retirar:");        		
			String material = material_decoracio.nextLine();
		
			boolean coincideix = false;
			int index=0;
		
			do {
				if (floristeria.decoracio.get(index).nom_decoracio.equals(decoracio) &&  floristeria.decoracio.get(index).material_decoracio.equals(material)) {
				
					coincideix=true;
				
					if (floristeria.decoracio.get(index).quantitat_decoracio-1 == 0) {
						
						floristeria.tickets.get(ticket).decoracio.add(floristeria.decoracio.get(index));
						floristeria.decoracio.remove(index);
						
					
						System.out.println("Decoraci� esborrada, no quedaven m�s unitats");
					
						index = index-1;
					
					} else {
						floristeria.tickets.get(ticket).decoracio.add(floristeria.decoracio.get(index));
						floristeria.decoracio.get(index).quantitat_decoracio =  floristeria.decoracio.get(index).quantitat_decoracio-1;					
						System.out.println("Resta una decoraci�, queden "+ floristeria.decoracio.get(index).quantitat_decoracio + " disponibles");}		
				};
				if ((index == (floristeria.decoracio.size()-1) && coincideix == false)  ) {
					System.out.println("No existeix aquesta decoraci� en estoc");
					coincideix=true;
				}
				
				index++;
			
			} while (coincideix==false);
		
		}
		
		return floristeria;
		
	}

}
