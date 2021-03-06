package application.model;

public class Option {
    // Ex: Batter and Pitcher
    public Choice[] choices;

    public Option() {
        choices = new Choice[3];
        genBatterOption();
    }

    //since gameplay outcomes are determined by the batter,
    //an outcome is generated for the batter as well as the RPS (rock paper scissors) matrix
    public void genBatterOption() {
        genRockPaperScissors();
        genBatterOutcome();

    }

    //0 is rock, 1 is paper, 2 is scissors
    public void genBatterOutcome() {
        choices[0].genBatterRock();
        choices[1].genBatterPaper();
        choices[2].genBatterScissors();

    }

    //pitcher just needs RPS matrix
    public void genPitcherOption() {
        genRockPaperScissors();

    }


    // rock loses paper loses scissors loses rock
    public void genRockPaperScissors() {
        choices[0] = new Choice(Rps.ROCK, Rps.SCISSORS, Rps.PAPER, "Screwball", "Power Swing");
        choices[1] = new Choice(Rps.PAPER, Rps.ROCK, Rps.SCISSORS, "Curveball", "Wild Swing");
        choices[2] = new Choice(Rps.SCISSORS, Rps.PAPER, Rps.ROCK, "Fastball", "Thoughtful Swing");
    }


    public void printOptions() {
        int i = 0;
        while (printCondition(i)) {
            // implement button update
            System.out.print(i + " ");
            System.out.print(choices[i].Name);
            i++;
        }
        System.out.println("\n");

    }

    public Choice getChoice(int i) {
        return choices[i];
    }

    //companion boolean method for print options
    public boolean printCondition(int i) {
        if (i < 3) {
            return true;
        }
        return false;
    }

}
