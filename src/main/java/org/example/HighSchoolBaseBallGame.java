package org.example;

public class HighSchoolBaseBallGame extends BaseBallGame {
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


