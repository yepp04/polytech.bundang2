package testProject;

public class Item {
	private int no;
	private String name;
	private int weight;
	private int screen;
	private int capacity;
	private String etc;
	private int price;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Item(int no, String name, int weight, int screen, int capacity, String etc, int price) {
		super();
		this.no = no;
		this.name = name;
		this.weight = weight;
		this.screen = screen;
		this.capacity = capacity;
		this.etc = etc;
		this.price = price;
	}

	public Item(String name, int weight, int screen, int capacity, String etc, int price) {
		super();
		this.name = name;
		this.weight = weight;
		this.screen = screen;
		this.capacity = capacity;
		this.etc = etc;
		this.price = price;
	}

	public Item(int no) {
		super();
		this.no = no;
	}

	@Override
	public String toString() {
		return no + "   " + name + "     " + weight + "      " + screen + "           " + capacity + "               "
				+ etc + "     " + price;
	}

}
