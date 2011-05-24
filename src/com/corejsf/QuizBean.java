package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
//@ManagedBean
//@SessionScoped

@Named
@ConversationScoped
public class QuizBean implements Serializable {

	@Inject
	Conversation conversation;

	private static final long serialVersionUID = 1L;
	private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;

	public QuizBean() {
		problems.add(new ProblemBean(new int[] { 3, 1, 4, 1, 5 }, 9)); // pi
		problems.add(new ProblemBean(new int[] { 1, 1, 2, 3, 5 }, 8)); // fibonacci
		problems.add(new ProblemBean(new int[] { 1, 4, 9, 16, 25 }, 36)); // squares
		problems.add(new ProblemBean(new int[] { 2, 3, 5, 7, 11 }, 13)); // primes
		problems.add(new ProblemBean(new int[] { 1, 2, 4, 8, 16 }, 32)); // powers
																			// of
																			// 2
	}

	public void setProblems(ArrayList<ProblemBean> newValue) {
		problems = newValue;
		currentIndex = 0;
		score = 0;
	}

	public int getScore() {
		return score;
	}

	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}

	public String getAnswer() {
		return "";
	}

	public void setAnswer(String newValue) {
		try {
			if (currentIndex == 0)
				conversation.begin();
			int answer = Integer.parseInt(newValue.trim());
			if (getCurrent().getSolution() == answer)
				score++;
			currentIndex = (currentIndex + 1) % problems.size();
			if (currentIndex == 0)
				conversation.end();
		} catch (NumberFormatException ex) {
		}
	}

}
