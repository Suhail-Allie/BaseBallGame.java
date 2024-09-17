package org.example;
import java.util.Scanner;

public class DemoBaseBallGame {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            // Choose the type of baseball game
            System.out.println("Select the type of Baseball Game:");
            System.out.println("1. High School Baseball Game (7 innings)");
            System.out.println("2. Little League Baseball Game (6 innings)");
            int innings = (input.nextInt() == 1) ? 7 : 6;
            input.nextLine(); // Consume newline

            // Enter team names
            System.out.print("Enter the name for Team 1: ");
            String team1 = input.nextLine();
            System.out.print("Enter the name for Team 2: ");
            String team2 = input.nextLine();

            // Create the BaseballGame object
            BaseBallGame game = (innings == 7) ? new HighSchoolBaseBallGame(team1, team2) : new LittleLeagueBaseBallGame(team1, team2);

            // Input scores and display results
            for (int inning = 1; inning <= innings; inning++) {
                System.out.println("Inning " + inning + ":");
                System.out.print("Score for " + team1 + ": ");
                int score1 = input.nextInt();
                System.out.print("Score for " + team2 + ": ");
                int score2 = input.nextInt();
                input.nextLine(); // Consume newline

                game.setScore(1, inning, score1);
                game.setScore(2, inning, score2);

                int totalScore1 = 0, totalScore2 = 0;
                for (int i = 1; i <= inning; i++) {
                    totalScore1 += game.getScore(1, i);
                    totalScore2 += game.getScore(2, i);
                }
                System.out.println(team1 + " Total Score: " + totalScore1);
                System.out.println(team2 + " Total Score: " + totalScore2);
            }

            // Final scores and winner
            int finalScore1 = 0, finalScore2 = 0;
            for (int i = 1; i <= innings; i++) {
                finalScore1 += game.getScore(1, i);
                finalScore2 += game.getScore(2, i);
            }

            System.out.println("\nFinal Scores:");
            System.out.println(team1 + ": " + finalScore1);
            System.out.println(team2 + ": " + finalScore2);

            if (finalScore1 > finalScore2) System.out.println(team1 + " wins!");
            else if (finalScore2 > finalScore1) System.out.println(team2 + " wins!");
            else System.out.println("The game is a tie!");

            input.close();
        }
    }


