package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  //BaseBallGame
    public class BaseBallGame {
        // Constant for the number of innings
        private static final int NUMBER_OF_INNINGS = 9;


        private String team1Name;
        private String team2Name;
        private int[][] scores = new int[2][NUMBER_OF_INNINGS];

        // Constructor initializes the team names
        public BaseBallGame(String team1, String team2) {
            team1Name = team1;
            team2Name = team2;
        }

        // Set the name for Team 1
        public void setTeam1Name(String name) {
            team1Name = name;
        }

        // Set the name for Team 2
        public void setTeam2Name(String name) {
            team2Name = name;
        }

        // Set the score for a specific team and inning
        public void setScore(int team, int inning, int score) {
            if (team < 1 || team > 2 || inning < 1 || inning > NUMBER_OF_INNINGS) {
                System.out.println("Invalid team number or inning number.");
                return;
            }
            scores[team - 1][inning - 1] = score;
        }

        // Get the name of Team 1
        public String getTeam1Name() {
            return team1Name;
        }

        // Get the name of Team 2
        public String getTeam2Name() {
            return team2Name;
        }

        // Get the score for a specific team and inning
        public int getScore(int team, int inning) {
            if (team < 1 || team > 2 || inning < 1 || inning > NUMBER_OF_INNINGS) {
                System.out.println("Invalid team number or inning number.");
                return -1; // Return an invalid score
            }
            return scores[team - 1][inning - 1];
        }

        // Main method to test the BaseballGame class
        public static void main(String[] args) {
            org.example.BaseBallGame game = new org.example.BaseBallGame("Team A", "Team B");

            // Set some scores
            game.setScore(1, 1, 3); // Team 1, Inning 1
            game.setScore(2, 1, 2); // Team 2, Inning 1
            game.setScore(1, 2, 1); // Team 1, Inning 2
            game.setScore(2, 2, 4); // Team 2, Inning 2

            // Display team names and scores
            System.out.println("Team 1: " + game.getTeam1Name());
            System.out.println("Team 2: " + game.getTeam2Name());

            for (int inning = 1; inning <= NUMBER_OF_INNINGS; inning++) {
                System.out.println("Inning " + inning + ":");
                System.out.println(game.getTeam1Name() + " Score: " + game.getScore(1, inning));
                System.out.println(game.getTeam2Name() + " Score: " + game.getScore(2, inning));
            }
        }
    }

    //HighSchoolBaseBallGame

    public class HighSchoolBaseBallGame extends org.example.BaseBallGame {
        private static final int NUMBER_OF_INNINGS = 7;

        // Constructor initializes the team names and sets default scores
        public HighSchoolBaseBallGame(String team1, String team2) {
            super(team1, team2);
            // Set default scores for each inning
            for (int inning = 0; inning < NUMBER_OF_INNINGS; inning++) {
                setScore(1, inning + 1, 0); // Team 1
                setScore(2, inning + 1, 0); // Team 2
            }
        }

        @Override
        public int getScore(int team, int inning) {
            if (inning < 1 || inning > NUMBER_OF_INNINGS) {
                System.out.println("Invalid inning number.");
                return -1; // Return an invalid score
            }
            return super.getScore(team, inning);
        }
    }

    //LittleLeagueBaseBallGame

    public class LittleLeagueBaseBallGame extends org.example.BaseBallGame {
        private static final int NUMBER_OF_INNINGS = 6;

        // Constructor initializes the team names and sets default scores
        public LittleLeagueBaseBallGame(String team1, String team2) {
            super(team1, team2);
            // Set default scores for each inning
            for (int inning = 0; inning < NUMBER_OF_INNINGS; inning++) {
                setScore(1, inning + 1, 0); // Team 1
                setScore(2, inning + 1, 0); // Team 2
            }
        }

        @Override
        public int getScore(int team, int inning) {
            if (inning < 1 || inning > NUMBER_OF_INNINGS) {
                System.out.println("Invalid inning number.");
                return -1; // Return an invalid score
            }
            return super.getScore(team, inning);
        }
    }

    //DemoBaseBallGame

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
            org.example.BaseBallGame game = (innings == 7) ? new org.example.HighSchoolBaseBallGame(team1, team2) : new org.example.LittleLeagueBaseBallGame(team1, team2);

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

}
