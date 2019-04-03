package com.game;

public class BowlingGame {

    private int rolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int noOfPins) {
        rolls[currentRoll++] = noOfPins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) {
                score += 10 + strikeExtra(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) {
                score += 10 + spareExtra(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfPinsByFrame(frameIndex);
                frameIndex += 2;
            }
        }

        return score;

    }

    private int spareExtra(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeExtra(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private int sumOfPinsByFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return sumOfPinsByFrame(frameIndex) == 10;
    }
}
