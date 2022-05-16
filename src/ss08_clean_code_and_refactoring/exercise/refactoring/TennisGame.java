package ss08_clean_code_and_refactoring.exercise.refactoring;

public class TennisGame {
    public static String getScore(String player1Name, String player2Name, int mScore1, int mScore2) {
        StringBuilder score = new StringBuilder();
        int tempScore;
        if (mScore1 == mScore2) {
            switch (mScore1) {
                case 0:
                    score = new StringBuilder("Love-All");
                    break;
                case 1:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case 2:
                    score = new StringBuilder("Thirty-All");
                    break;
                case 3:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;

            }
        } else {
            boolean check1 = mScore1 >= 4;
            boolean check2 = mScore2 >= 4;
            if (check1 || check2) {
                score = new StringBuilder(getScore(mScore1, mScore2));
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = mScore1;
                    else {
                        score.append("-");
                        tempScore = mScore2;
                    }
                    switch (tempScore) {
                        case 0:
                            score.append("Love");
                            break;
                        case 1:
                            score.append("Fifteen");
                            break;
                        case 2:
                            score.append("Thirty");
                            break;
                        case 3:
                            score.append("Forty");
                            break;
                    }
                }
            }
        }
        return score.toString();
    }

    private static String getScore(int mScore1, int mScore2) {
        String score;
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
