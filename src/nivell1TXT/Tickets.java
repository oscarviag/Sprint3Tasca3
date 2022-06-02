package nivell1TXT;

import java.util.ArrayList;
import java.util.Scanner;

public class Tickets {
	
	//private static int count = 0;
	int id_ticket;
	ArrayList<Flors> flors;
	ArrayList<Decoracio> decoracio;
	ArrayList<Arbres> arbres;
	
	public Tickets(int index) {
		super();
		this.id_ticket = index;
		this.flors = new ArrayList<Flors>();
		this.decoracio = new ArrayList<Decoracio>();
		this.arbres = new ArrayList<Arbres>();
	}

	public static Floristeria crear(Floristeria floristeria, int index) {
		Tickets tickets = new Tickets(index);
		System.out.println("Numero de ticket: " + tickets.id_ticket);        		
		floristeria.tickets.add(tickets);
		
		return floristeria;
	}
	
	public void llistarEstoc() {
		if (flors.size()==0 ) {System.out.println("No hi ha flors en estoc");};
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
	
	public Double llistarValorTicket() {
		Double valorTotal=0.00;
		
		for(Flors element:flors){
            valorTotal = valorTotal + element.quantitat_flor*element.preu_flor;
        }
		for(Decoracio element:decoracio){
            valorTotal = valorTotal + element.quantitat_decoracio*element.preu_decoracio;
        }
		for(Arbres element:arbres){
            valorTotal = valorTotal + element.quantitat_arbres*element.preu_arbre;
        }
		return valorTotal;
	}
	
	
}
