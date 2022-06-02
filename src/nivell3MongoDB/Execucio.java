package nivell3MongoDB;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.*;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;


public class Execucio {
	
	static Floristeria floristeria;

	public static void main(String[] args) {
		
		//Desactivem els missatges de MongoDB
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.OFF);
		
		// Creating a Mongo client 
	    MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
	     			
		Scanner nm_floristeria = new Scanner(System.in);
		System.out.println("El nom de la floristeria:");        		
		String nom_floristeria = nm_floristeria.nextLine();
		
		// Creating Credentials 
	    MongoCredential credential; 
	    credential = MongoCredential.createCredential("sampleUser", nom_floristeria,"password".toCharArray()); 
	    System.out.println("Conectat a la base de dades correctament");  
	      
	    // Accedim a la Base de Dades
	    MongoDatabase database = mongo.getDatabase(nom_floristeria);
	    
	    boolean collectionExisteix = database.listCollectionNames()
	    	    .into(new ArrayList<String>()).contains("stockCollection");
	    	    
	    if (collectionExisteix) {
	    	System.out.println("Base de dades amb dades antigues per consultar");
	    }
	    
	    else {
	        	database.createCollection("stockCollection");
	    	    database.createCollection("ticketsCollection");
	    	    System.out.println("Nova base de dades creada");
	    };	    
	  
		
		floristeria = new Floristeria(nom_floristeria);

		
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
