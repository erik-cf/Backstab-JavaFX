package com.mpec.entities;
/**
 * Esta es la clase que define los parametros del juego.
 * @author erikc
 *
 */
public class Map {
	
	private int phase_time;
	private int min_drop_time;
	private int max_drop_time;
	private int base_monsters_count;
	private int collision_probability;

	public Map(int phase_time, int min_drop_time, int max_drop_time, int base_monsters_count,
			int collision_probability) {
		super();
		this.phase_time = phase_time;
		this.min_drop_time = min_drop_time;
		this.max_drop_time = max_drop_time;
		this.base_monsters_count = base_monsters_count;
		this.collision_probability = collision_probability;
	}

	public int getPhase_time() {
		return phase_time;
	}

	public void setPhase_time(int phase_time) {
		this.phase_time = phase_time;
	}

	public int getMin_drop_time() {
		return min_drop_time;
	}

	public void setMin_drop_time(int min_drop_time) {
		this.min_drop_time = min_drop_time;
	}

	public int getMax_drop_time() {
		return max_drop_time;
	}

	public void setMax_drop_time(int max_drop_time) {
		this.max_drop_time = max_drop_time;
	}

	public int getBase_monsters_count() {
		return base_monsters_count;
	}

	public void setBase_monsters_count(int base_monsters_count) {
		this.base_monsters_count = base_monsters_count;
	}

	public int getCollision_probability() {
		return collision_probability;
	}

	public void setCollision_probability(int collision_probability) {
		this.collision_probability = collision_probability;
	}

}
