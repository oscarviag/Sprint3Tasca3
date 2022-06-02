package nivell3MongoDB;

import java.util.ArrayList;


public class Floristeria {

	String nom_floristeria;
    ArrayList<Flors> flors;
	ArrayList<Decoracio> decoracio;
	ArrayList<Arbres> arbres;
	ArrayList<Tickets> tickets;
	
	public Floristeria(String nom_floristeria) {
		super();
		this.nom_floristeria = nom_floristeria;
		this.flors = new ArrayList<Flors>();
		this.decoracio = new ArrayList<Decoracio>();
		this.arbres = new ArrayList<Arbres>();
		this.tickets = new ArrayList<Tickets>();
	}	


	public static void crear(String nom_triat) {
		Floristeria floristeria = new Floristeria(nom_triat);		
	}
	
	
	public void llistarEstoc() {
		if (flors.size()== 0 ) {System.out.println("No hi ha flors en estoc");};
		for(Flors element:flors){
            System.out.println( "Flor: " + element.nom_flor + " Color: " + element.color + " Quantitat: " + element.quantitat_flor);
        } 
		if (decoracio.size()==0 ) {System.out.println("No hi ha decoració en estoc");};
		for(Decoracio element:decoracio){
            System.out.println( "Decoració: " + element.nom_decoracio + " Material: " + element.material_decoracio + " Quantitat: " + element.quantitat_decoracio);
        }
		if (arbres.size()==0 ) {System.out.println("No hi ha arbres en estoc");};
		for(Arbres element:arbres){
            System.out.println( "Arbre: " + element.nom_arbre + " Alçada: " + element.alcada_arbre + " Quantitat: " + element.quantitat_arbres);
        }
	}
	
	
	public void llistarValorTotal() {
		Double valorTotal=0.00;
		if (flors.size()==0 ) {System.out.println("No hi ha flors en estoc");};
		for(Flors element:flors){
            valorTotal = valorTotal + element.quantitat_flor*element.preu_flor;
        }
		if (arbres.size()==0 ) {System.out.println("No hi ha arbres en estoc");};
		for(Arbres element:arbres){
            valorTotal = valorTotal + element.quantitat_arbres*element.preu_arbre;
        }
		if (decoracio.size()==0 ) {System.out.println("No hi ha decoració en estoc");};
		for(Decoracio element:decoracio){
            valorTotal = valorTotal + element.quantitat_decoracio*element.preu_decoracio;
        }
		System.out.println("El valor total dels productes a la floristeria " + nom_floristeria + " es " + valorTotal);
	}
	
	
	public void llistarQuantitats() {
            System.out.println( "Flors: " + flors.size());
            System.out.println( "Arbres: " + arbres.size());
            System.out.println( "Decoracio: " + decoracio.size());		
	}
	
	
	public void llistarTickets() {
		if (tickets.size()==0 ) {System.out.println("No hi ha tickets");};
		for(Tickets element:tickets){
			System.out.println("Ticket: "+ element.id_ticket);
            element.llistarEstoc();
        }   		
	}
	
	public void llistarValorTickets() {
		Double total=0.00;
		if (tickets.size()==0 ) {System.out.println("No hi ha tickets");};
		for(Tickets element:tickets){
			System.out.println("Ticket: "+ element.id_ticket + " Total: " + element.llistarValorTicket());
			total= total + element.llistarValorTicket();
        }   		
	}
	
}
