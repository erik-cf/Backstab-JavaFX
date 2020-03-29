package com.mpec.entities;

public class GameCharacter {

	private String name;
	private double attack;
	private double defense;
	private double hp;
	private double movement_speed;
	private double attack_speed;
	private double range;
	
	public GameCharacter(String name, double attack, double defense, double hp, double movement_speed, double attack_speed,
			double range) {
		super();
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.hp = hp;
		this.movement_speed = movement_speed;
		this.attack_speed = attack_speed;
		this.range = range;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public double getDefense() {
		return defense;
	}

	public void setDefense(double defense) {
		this.defense = defense;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getMovement_speed() {
		return movement_speed;
	}

	public void setMovement_speed(double movement_speed) {
		this.movement_speed = movement_speed;
	}

	public double getAttack_speed() {
		return attack_speed;
	}

	public void setAttack_speed(double attack_speed) {
		this.attack_speed = attack_speed;
	}

	public double getRange() {
		return range;
	}

	public void setRange(double range) {
		this.range = range;
	}	
}
