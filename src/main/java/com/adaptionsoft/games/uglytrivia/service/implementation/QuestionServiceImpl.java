package com.adaptionsoft.games.uglytrivia.service.implementation;

import com.adaptionsoft.games.uglytrivia.model.Question;
import com.adaptionsoft.games.uglytrivia.model.QuestionCategory;
import com.adaptionsoft.games.uglytrivia.service.interfaces.QuestionService;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Simple service that generates questions.. Normally we would probaly get these from a DB or smth
 */
public class QuestionServiceImpl implements QuestionService {

    @Override
    public LinkedList<Question> getPopQuestions(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Question(QuestionCategory.POP, "Pop Question " + i))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public LinkedList<Question> getScienceQuestions(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Question(QuestionCategory.SCIENCE, "Science Question " + i))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public LinkedList<Question> getSportsQuestions(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Question(QuestionCategory.SPORTS, "Sports Question " + i))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public LinkedList<Question> getRockQuestions(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(i -> new Question(QuestionCategory.ROCK, "Rock Question " + i))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
