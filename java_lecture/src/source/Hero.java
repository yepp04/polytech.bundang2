package source;

import java.io.Serializable;

public class Hero implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int hp;

	public Hero(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + "]";
	}

}
