package com.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void testNoScore() {
        rollRepeat(21, 0);
        assertEquals(0, bowlingGame.score());
    }

    @Test
    void testAllOnes() {
        rollRepeat(20, 1);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    void testNormalScore() {
        rollRepeat(2, 4);
        assertEquals(8, bowlingGame.score());
    }

    @Test
    void testSpare() {
        rollSpare();
        bowlingGame.roll(5);
        rollRepeat(17, 0);
        assertEquals(20, bowlingGame.score());
    }

    @Test
    void testStrike() {
        rollStrike();
        bowlingGame.roll(5);
        bowlingGame.roll(4);
        assertEquals(28, bowlingGame.score());
    }

    @Test
    void testLastFrameWithSpare(){
        rollRepeat(18, 0);
        rollSpare();
        bowlingGame.roll(5);
        assertEquals(15, bowlingGame.score());
    }

    @Test
    void testLastFramewithStrike(){
        rollRepeat(18, 0);
        rollStrike();
        bowlingGame.roll(5);
        bowlingGame.roll(3);
        assertEquals(18, bowlingGame.score());
    }

    @Test
    void testAllStrike() {
        rollRepeat(12, 10);
        assertEquals(300, bowlingGame.score());
    }


    private void rollRepeat(Integer times, int noOfPins) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll(noOfPins);
        }
    }

    private void rollSpare() {
        bowlingGame.roll(4);
        bowlingGame.roll(6);
    }

    private void rollStrike() {
        bowlingGame.roll(10);
    }
}