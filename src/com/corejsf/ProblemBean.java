package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;

public class ProblemBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> sequence;
	private int solution;

	public ProblemBean() {
	}

	public ProblemBean(int[] values, int solution) {
		sequence = new ArrayList<Integer>();
		for (int i = 0; i < values.length; i++) {
			sequence.add(values[i]);
			this.solution = solution;
		}
	}

	public ArrayList<Integer> getSequence() {
		return sequence;
	}

	public void setSequence(ArrayList<Integer> sequence) {
		this.sequence = sequence;
	}

	public int getSolution() {
		return solution;
	}

	public void setSolution(int solution) {
		this.solution = solution;
	}

}
