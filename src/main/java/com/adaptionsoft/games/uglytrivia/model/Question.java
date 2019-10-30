package com.adaptionsoft.games.uglytrivia.model;

public class Question {

    private QuestionCategory questionCategory;
    private String question;
    // Will there ever truly be an answer
    private String answer;

    public Question(QuestionCategory questionCategory, String question, String answer) {
        this.questionCategory = questionCategory;
        this.question = question;
        this.answer = answer;
    }

    public Question(QuestionCategory questionCategory, String question) {
        this.questionCategory = questionCategory;
        this.question = question;
    }

    public QuestionCategory getQuestionCategory() {
        return questionCategory;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
