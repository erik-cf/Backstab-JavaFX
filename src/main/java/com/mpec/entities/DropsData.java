package com.mpec.entities;

public class DropsData {

	private String name;
	private int value;
	private int duration;
	private int min_range;
	private int max_range;

	public DropsData(String name, int value, int duration, int min_range, int max_range) {
		super();
		this.name = name;
		this.value = value;
		this.duration = duration;
		this.min_range = min_range;
		this.max_range = max_range;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getMin_range() {
		return min_range;
	}

	public void setMin_range(int min_range) {
		this.min_range = min_range;
	}

	public int getMax_range() {
		return max_range;
	}

	public void setMax_range(int max_range) {
		this.max_range = max_range;
	}

}
