package com.adaptionsoft.games.uglytrivia.service.interfaces;

import com.adaptionsoft.games.uglytrivia.model.Question;

import java.util.LinkedList;

public interface QuestionService {

    LinkedList<Question> getPopQuestions(int amount);

    LinkedList<Question> getScienceQuestions(int amount);

    LinkedList<Question> getSportsQuestions(int amount);

    LinkedList<Question> getRockQuestions(int amount);

}
