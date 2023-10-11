package Ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Person {
	private String name;
	public int num;
	protected List<Card> cards = new ArrayList<Card>();
	
	public Person(String name, int num, Set<Integer> set) {
		this.name = name;
		this.num = num;
		createCards(num, cards, set);
	}
	
	public void createCards(int n, List<Card> c, Set<Integer> set ) {
		for(int i = 0; i < n; i ++) {
			c.add(new Card());
			c.get(i).createCard(set);
		}
	}
	
	public String getName() {
		return name;
	}
	
	
}
