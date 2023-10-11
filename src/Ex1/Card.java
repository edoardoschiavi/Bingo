package Ex1;

import java.util.Set;


public class Card {
	private final static int  ROW = 3;
	private final static int  COL = 5;
	
	public int[][] card = new int[ROW][COL];
	
	public Card() {
		
	}
	
	public void createCard(Set<Integer> set) {
		for(int i = 0; i < ROW; i ++) {
			for(int j = 0; j < COL; j ++) {
				int num;
				do {
					num = (int) (Math.random()*90) + 1;
				}while(!set.add(num));
				card[i][j] = num;
			}
		}
	}
	
	public void printCard(int x, int y) {
		System.out.println("Cartella numero " + y + " del giocatore  " + x + ":");
		for(int i = 0; i < ROW; i ++) {
			for(int j = 0; j < COL; j ++) {
				System.out.print(card[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	
	public void sortCard() {
		for(int i = 0; i < ROW; i ++) {
			for(int j = 0; j < COL; j ++) {
				boolean flag = false;
				for(int z = 0; z < COL - 1; z ++) {
					if(card[i][z] > card[i][z + 1]) {
						int temp = card[i][z];
						card[i][z] = card[i][z + 1];
						card[i][z + 1] = temp;
						flag = true;
					}
				}
				if(!flag)
					break;
			}
		}
	}
	
	public boolean checkCard(Set<Integer> valuesExtracted) {
		boolean ris = false;
		for(int i = 0; i < ROW; i ++) {
			for(int j = 0; j < COL; j ++) {
				if(!valuesExtracted.contains(card[i][j]))
					break;
				else {
					if(j == COL - 1)
						ris = true;
				}
			}
			if(ris)
				return true;
		}

		return false;
		
	}
}
