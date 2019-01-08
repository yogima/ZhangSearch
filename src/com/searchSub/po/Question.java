package com.searchSub.po;

public class Question implements IQuestion{
	private int questionId;
	private String question;
	private String answer;
	private int error;
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

}
