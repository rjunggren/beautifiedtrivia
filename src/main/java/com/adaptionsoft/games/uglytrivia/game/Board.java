package com.adaptionsoft.games.uglytrivia.game;

import com.adaptionsoft.games.uglytrivia.model.QuestionCategory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Board {

    private Map<Integer, QuestionCategory> boardQuestions;

    /**
     * To be used if you have a specific board setup you want to use
     *
     * @param boardQuestions
     */
    public Board(Map<Integer, QuestionCategory> boardQuestions) {
        this.boardQuestions = boardQuestions;
    }

    // Looks familiar?
    public Board() {
        boardQuestions = new HashMap<>();
        boardQuestions.put(0, QuestionCategory.POP);
        boardQuestions.put(1, QuestionCategory.SCIENCE);
        boardQuestions.put(2, QuestionCategory.SPORTS);
        boardQuestions.put(3, QuestionCategory.ROCK);
        boardQuestions.put(4, QuestionCategory.POP);
        boardQuestions.put(5, QuestionCategory.SCIENCE);
        boardQuestions.put(6, QuestionCategory.SPORTS);
        boardQuestions.put(7, QuestionCategory.ROCK);
        boardQuestions.put(8, QuestionCategory.POP);
        boardQuestions.put(9, QuestionCategory.SCIENCE);
        boardQuestions.put(10, QuestionCategory.SPORTS);
    }

    // TODO
    public Board randomBoard(int boardSize) {
        throw new RuntimeException("Not implemented yet");
    }


    public Optional<QuestionCategory> getQuestionCategory(Integer place) {
        return Optional.ofNullable(boardQuestions.get(place));
    }
}
