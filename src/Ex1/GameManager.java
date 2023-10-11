package Ex1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GameManager {
	public List<Person> persons = new ArrayList<Person>();
	public Set<Integer> values = new HashSet<Integer>(); // per tenere traccia dei valori estratti dal banco

	public void Play() {
		// inizializzo i giocatori e le carte
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Hi Player 1, please insert the number of players for the game: ");
			int n = scanner.nextInt();
			scanner.nextLine();
		    for (int i = 0; i < n; i++) {
		    	// per tenere traccia dei valori già usciti per ogni giocatore
		    	Set<Integer> cardValues = new HashSet<Integer>();
		        System.out.print("Insert name: ");
		        String name = scanner.nextLine();
		        System.out.print("Insert number of cards for the player: ");
		        int num = scanner.nextInt();
		        scanner.nextLine(); 

		        persons.add(new Person(name, num, cardValues));
		    }
		} catch (Exception e) {
		    e.printStackTrace(); 
		}
		
		// ordino le schede
		for(int i = 0; i < persons.size(); i ++) {
			for(int j = 0; j < persons.get(i).num; j ++) {
				persons.get(i).cards.get(j).sortCard();
				persons.get(i).cards.get(j).printCard(i + 1,j + 1);
				System.out.println();
			}
			
		}
		
		//estraggo i numeri
		
		boolean gameWon = false;

		while (!gameWon) {
		    int number;
		    do {
		        number = (int) (Math.random() * 90) + 1;
		    } while (!values.add(number));
		    
		    System.out.println("Numero estratto: " + number);
		   
		    for (int i = 0; i < persons.size(); i++) {
		        for (int j = 0; j < persons.get(i).num; j++) {
		            boolean ris = persons.get(i).cards.get(j).checkCard(values);
		            if (ris) {
		                System.out.println(persons.get(i).getName() + " won!");
		                gameWon = true; // Imposta la variabile gameWon a true per terminare il ciclo
		                break;
		            }
		        }
		        if (gameWon) {
		            break; // Se un giocatore ha vinto, esci dal ciclo esterno anche
		        }
		    }
		}
		





		
	}

}
