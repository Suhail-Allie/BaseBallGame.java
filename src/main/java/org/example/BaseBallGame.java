package org.example;


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
            BaseBallGame game = new BaseBallGame("Team A", "Team B");

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



