public class TennisGame {

    public static final int Advantage = 4;

    public static String getScore(String player1Name, String player2Name, int player_1_score, int player_2_score) {
        String score = "";
        int tempScore = 0;
        boolean isSameScore = player_1_score == player_2_score;


        if (isSameScore) {
            score = getDeuceScore(player_1_score);
        } else if (player_1_score >= Advantage || player_2_score >= Advantage) {
            score = getSpecialScore(player_1_score, player_2_score);
        } else {
            score = getSingelPlayerScore(player_1_score, player_2_score);
        }
        return score;
    }



    private static String getSingelPlayerScore(int player_1_score, int player_2_score) {
        String stringSinglePlayerScore = "";
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player_1_score;
            else {
                stringSinglePlayerScore += "-";
                tempScore = player_2_score;
            }
            switch (tempScore) {
                case 0:
                    stringSinglePlayerScore += "Love";
                    break;
                case 1:
                    stringSinglePlayerScore += "Fifteen";
                    break;
                case 2:
                    stringSinglePlayerScore += "Thirty";
                    break;
                case 3:
                    stringSinglePlayerScore += "Forty";
                    break;
            }
        }
        return stringSinglePlayerScore;
    }


    private static String getSpecialScore ( int player_1_score, int player_2_score){
            String stringScoreSpecial = "";
            int minusResult = player_1_score - player_2_score;
            if (minusResult == 1) stringScoreSpecial = "Advantage player1";
            else if (minusResult == -1) stringScoreSpecial = "Advantage player2";
            else if (minusResult >= 2) stringScoreSpecial = "Win for player1";
            else stringScoreSpecial = "Win for player2";
            return stringScoreSpecial;
    }

    private static String getDeuceScore ( int player_1_score){
            String stringScoreDeuce;
            switch (player_1_score) {
                case 0:
                    stringScoreDeuce = "Love-All";
                    break;
                case 1:
                    stringScoreDeuce = "Fifteen-All";
                    break;
                case 2:
                    stringScoreDeuce = "Thirty-All";
                    break;
                case 3:
                    stringScoreDeuce = "Forty-All";
                    break;
                default:
                    stringScoreDeuce = "Deuce";
                    break;

            }
            return stringScoreDeuce;
        }
    }

