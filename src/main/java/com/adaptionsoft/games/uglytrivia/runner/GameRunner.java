package com.adaptionsoft.games.uglytrivia.runner;

import com.adaptionsoft.games.uglytrivia.game.Board;
import com.adaptionsoft.games.uglytrivia.game.Game;
import com.adaptionsoft.games.uglytrivia.service.implementation.QuestionServiceImpl;

import java.util.Random;


public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        Random rand = new Random();
        playGame(rand);
    }

    public static void playGame(Random rand) {
        Game aGame = new Game(0, 12, new QuestionServiceImpl(), new Board());

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");


        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }


        } while (notAWinner);
    }
}
