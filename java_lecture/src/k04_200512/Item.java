package k04_200512;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 123456789L;

	private String name;
	private int price;
	private int weight;

	public Item(String name, int price, int weight) {
		super();
		this.name = name;
		this.price = price;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", weight=" + weight + "]";
	}

}
