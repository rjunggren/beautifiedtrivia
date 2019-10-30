package com.adaptionsoft.games.uglytrivia.game;

import com.adaptionsoft.games.uglytrivia.model.Player;
import com.adaptionsoft.games.uglytrivia.model.Question;
import com.adaptionsoft.games.uglytrivia.model.QuestionCategory;
import com.adaptionsoft.games.uglytrivia.service.interfaces.QuestionService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    private static final int NUMBER_OF_QUESTIONS = 50;
    private int initialPurse;
    private Player currentPlayer;
    private int nextPlayerTurn;
    private int boardSize;
    // Normally this would be handled with dependency injection
    private QuestionService questionService;
    private List<Player> players;
    private LinkedList<Question> popQuestions;
    private LinkedList<Question> scienceQuestions;
    private LinkedList<Question> sportsQuestions;
    private LinkedList<Question> rockQuestions;
    private Board board;


    public Game(int initialPurse, int boardSize, QuestionService questionService, Board board) {
        this.initialPurse = initialPurse;
        this.questionService = questionService;
        this.board = board;
        this.popQuestions = this.questionService.getPopQuestions(NUMBER_OF_QUESTIONS);
        this.scienceQuestions = this.questionService.getScienceQuestions(NUMBER_OF_QUESTIONS);
        this.sportsQuestions = this.questionService.getSportsQuestions(NUMBER_OF_QUESTIONS);
        this.rockQuestions = this.questionService.getRockQuestions(NUMBER_OF_QUESTIONS);
        this.boardSize = boardSize;
        this.players = new ArrayList<>();
    }

    private boolean isPlayable() {
        return (howManyPlayers() == 2);
    }

    public void add(String playerName) {
        players.add(new Player(playerName, initialPurse, false));

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    private int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        if (!isPlayable()) {
            // handle case
        }
        if (currentPlayer == null) {
            selectFirstPlayer();
            nextPlayerTurn = 1;
        } else {
            setCurrentPlayer();
        }
        System.out.println(currentPlayer.getName() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInPenaltyBox()) {
            if (roll % 2 != 0) {
                currentPlayer.setGettingOutOfPenaltyBox(true);
                System.out.println(currentPlayer.getName() + " is getting out of the penalty box");
                movePlayerAndAskQuestion(roll);
            } else {
                System.out.println(currentPlayer.getName() + " is not getting out of the penalty box");
                currentPlayer.setGettingOutOfPenaltyBox(false);
            }
        } else {
            movePlayerAndAskQuestion(roll);
        }
    }

    private void setCurrentPlayer() {
        currentPlayer = players.get(nextPlayerTurn);
        nextPlayerTurn++;
        if (nextPlayerTurn == players.size()) {
            nextPlayerTurn = 0;
        }
    }

    private void selectFirstPlayer() {
        this.currentPlayer = players.get(0);
    }

    private void movePlayerAndAskQuestion(int roll) {
        currentPlayer.setPlace(currentPlayer.getPlace() + roll);
        if (currentPlayer.getPlace() > boardSize - 1) {
            currentPlayer.setPlace(currentPlayer.getPlace() - boardSize);
        }

        System.out.println(currentPlayer.getName()
                + "'s new location is "
                + currentPlayer.getPlace());
        System.out.println("The category is " + currentCategory().getLabel());
        askQuestion();
    }

    private void askQuestion() {
        // Default category ROCK is a bit redundant, seeing as the currentCategory will return ROCK if nothing else.. Oh well.
        switch (currentCategory()) {
            case POP:
                System.out.println(popQuestions.removeFirst().getQuestion());
                break;
            case SCIENCE:
                System.out.println(scienceQuestions.removeFirst().getQuestion());
                break;
            case SPORTS:
                System.out.println(sportsQuestions.removeFirst().getQuestion());
                break;
            case ROCK:
            default:
                System.out.println(rockQuestions.removeFirst().getQuestion());
        }
    }


    /**
     * @return The question category that is set on the current place. IF none, give the player a ROCK question.
     */
    private QuestionCategory currentCategory() {
        return board.getQuestionCategory(currentPlayer.getPlace()).orElse(QuestionCategory.ROCK);
    }

    public boolean wasCorrectlyAnswered() {
        if (currentPlayer.isInPenaltyBox()) {
            if (currentPlayer.isGettingOutOfPenaltyBox()) {
                currentPlayer.setInPenaltyBox(false);
                return handleCorrectAnswer();
            } else {
                return true;
            }
        } else {
            return handleCorrectAnswer();
        }
    }

    private boolean handleCorrectAnswer() {
        System.out.println("Answer was correct!!!!");

        currentPlayer.addToPurse(1);
        System.out.println(currentPlayer.getName()
                + " now has "
                + currentPlayer.getPurse()
                + " Gold Coins.");

        return didPlayerNotWin();
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer.getName() + " was sent to the penalty box");
        currentPlayer.setInPenaltyBox(true);
        currentPlayer.setGettingOutOfPenaltyBox(false);
        return true;
    }

    private boolean didPlayerNotWin() {
        return currentPlayer.getPurse() != 6;
    }
}
