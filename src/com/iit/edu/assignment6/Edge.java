package com.iit.edu.assignment6;

public class Edge {
	int from;
	int to;
	int wight;
	
	
	public Edge(int from, int to, int wight) {
		super();
		this.from = from;
		this.to = to;
		this.wight = wight;
	}
	public int getFrom() {
		return from;
	}
	public void setFrom(int from) {
		this.from = from;
	}
	public int getTo() {
		return to;
	}
	public void setTo(int to) {
		this.to = to;
	}
	public int getWight() {
		return wight;
	}
	public void setWight(int wight) {
		this.wight = wight;
	}
	
	
}
