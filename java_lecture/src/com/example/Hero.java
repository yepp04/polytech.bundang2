package com.example;

import java.io.Serializable;

public class Hero implements Serializable {
	private static final long serialVersionUID = 213253211616L;

	private String name;
	private int hp;
	private int mp;
	private Sword sword;

	public Hero(String name, int hp, int mp) {
		super();
		this.name = name;
		this.hp = hp;
		this.mp = mp;
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

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	@Override
	public String toString() {
		return "Hero [name=" + name + ", hp=" + hp + ", mp=" + mp + "]";
	}

}
