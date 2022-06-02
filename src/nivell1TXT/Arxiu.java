package nivell1TXT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;


public class Arxiu {
	
	
	public static boolean CrearArxiu(String nomArxiu) {
		
		File arxiu = new File("C:\\Users\\kart_\\Desktop\\Prova" + File.separator + nomArxiu + ".txt");
		boolean existeix=false;
		
		if (!arxiu.exists()) {
			try {
			
				arxiu.createNewFile();
				System.out.println("Arxiu creat");
			
			} catch (IOException e) {

				e.printStackTrace();
			};
		} else existeix=true;
		
		return existeix;
	}
	
	public static void EscriureArxiu(String nomArxiu, Floristeria floristeria) {
		
		BufferedWriter bufferedWriter = null;
		FileWriter escriptura=null;
		Gson gson = new Gson();
		String enviarJSON = gson.toJson(floristeria);
		
		try {
			
			escriptura = new FileWriter("C:\\Users\\kart_\\Desktop\\Prova" + File.separator + nomArxiu + ".txt"); 
			bufferedWriter = new BufferedWriter(escriptura);	
			bufferedWriter.write(enviarJSON);
			bufferedWriter.close();
			escriptura.close();
			System.out.println("Arxiu guardat amb les dades");
			
		} catch (IOException e) {
			
			System.out.println("Arxiu no disponible");
			e.printStackTrace();
		}
				
	}
	
	public static Floristeria LlegirArxiu(String nomArxiu) {
		
		String contingutJSON = null;
		StringBuilder sb = null;

		File file = new File("C:\\Users\\kart_\\Desktop\\Prova" + File.separator + nomArxiu + ".txt");

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			sb = new StringBuilder();
			String linea = bufferedReader.readLine();
			while (linea != null) {
				sb.append(linea);
				linea = bufferedReader.readLine();
			}

		} catch (IOException ex) {
			System.err.println(ex.getMessage());

		} finally {

			if (bufferedReader != null) {
				try {

					bufferedReader.close();
				} catch (IOException ex) {

					System.err.println(ex.getMessage());
				}
			}

			if (fileReader != null) {
				try {

					fileReader.close();
				} catch (IOException ex) {

					System.err.println(ex.getMessage());
				}
			}
		}

		if (sb != null) {
			contingutJSON = sb.toString();
		}
				
		Floristeria floristeria = null;
		Gson gson = new Gson();
		floristeria = gson.fromJson(contingutJSON, Floristeria.class);
		
		return floristeria;
				
	}

}
