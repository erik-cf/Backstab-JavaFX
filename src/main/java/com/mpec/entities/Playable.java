package com.mpec.entities;

public class Playable extends GameCharacter {

	public Playable(String name, double attack, double defense, double hp, double movement_speed,
			double attack_speed, double range) {
		super(name, attack, defense, hp, movement_speed, attack_speed, range, GameCharacter.PLAYABLE);
		
	}
	
	
	
}
