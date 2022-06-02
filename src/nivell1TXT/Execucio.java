package nivell1TXT;


import java.util.Scanner;

public class Execucio {
	
	static Floristeria floristeria;

	public static void main(String[] args) {
		
		Scanner nm_floristeria = new Scanner(System.in);
		System.out.println("El nom de la floristeria:");        		
		String nom_floristeria = nm_floristeria.nextLine();
		if (Arxiu.CrearArxiu(nom_floristeria) == true) {
			
			System.out.println("L'arxiu ja existeix, s'importen les dades");
			floristeria = Arxiu.LlegirArxiu(nom_floristeria);
		} else {
		
		floristeria = new Floristeria(nom_floristeria);
		Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
		};
		
		boolean sortir=false;
		
		do {
			System.out.println("Tria una opció:");
			System.out.println("1: Afegir Flors");
			System.out.println("2: Afegir Decoració");
			System.out.println("3: Afegir Arbres");
			System.out.println("4: Consultar Estoc");
			System.out.println("5: Valor Total de la Floristeria");
			System.out.println("6: Crear Ticket de Compra");
			System.out.println("7: Llistat de tots els Tickets de Venda");
			System.out.println("8: Valor total de les vendes");
			System.out.println("9: Sortir");
			Scanner opcio = new Scanner(System.in);       		
			int opcio_triada = opcio.nextInt(); 
			
			switch (opcio_triada) {
				case 1:  {
					floristeria = Flors.afegir(floristeria);
					Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);				
					break;}
				case 2: { 
					floristeria = Decoracio.afegir(floristeria);
					Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
					break;}
				case 3: { 
					floristeria = Arbres.afegir(floristeria);
					Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
					break;}
				case 4:  floristeria.llistarEstoc();
					break;
				case 5:  floristeria.llistarValorTotal();
					break;
				case 6:{
						boolean retornar=false;
						floristeria = Tickets.crear(floristeria, floristeria.tickets.size());
						Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
						int id_ticket = floristeria.tickets.size();
						do {						
							System.out.println("1: Retirar Flors");
							System.out.println("2: Retirar Decoració");
							System.out.println("3: Retirar Arbres");
							System.out.println("4: Sortir");
							Scanner opcio_tickets = new Scanner(System.in);
							System.out.println("Opcio triada:");        		
							int opcio_ticket = opcio_tickets.nextInt();
							switch (opcio_ticket) {
								case 1: { 
									floristeria = Flors.retirar(floristeria, id_ticket-1);
									Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
									break;}
								case 2:  {
									floristeria = Decoracio.retirar(floristeria, id_ticket-1);
									Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
									break;}
								case 3: { 
									floristeria = Arbres.retirar(floristeria, id_ticket-1);
									Arxiu.EscriureArxiu(floristeria.nom_floristeria, floristeria);
									break;}
								case 4:  retornar=true;
									break;
								default:  System.out.println("Opció triada no correcta");
									break;
							}
						}while(retornar==false);
						
						break;}
				case 7:  floristeria.llistarTickets();
					break;
				case 8:  floristeria.llistarValorTickets();
					break;
				case 9:  sortir=true;
					break;
				default: System.out.println("Opció triada no correcta");
					break;		
			}
		} while (sortir!=true);
			
		nm_floristeria.close();


	};

}
