package ch.hslu.ad.sw02.ex3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackMachineTest {

    @Test
    void testCase1() {
        StackMachine sm = new StackMachine();
        sm.load(2);
        sm.load(3);
        sm.add();
        sm.load(4);
        sm.mul();
        assertEquals(20, sm.print());
    }

    @Test
    void testCase2() {
        StackMachine sm = new StackMachine();
        sm.load(4);
        sm.load(5);
        sm.add();
        sm.load(2);
        sm.load(3);
        sm.add();
        sm.mul();
        assertEquals(45, sm.print());
    }

    @Test
    void testCase3() {
        StackMachine sm = new StackMachine();
        sm.load(4);
        sm.load(7);
        sm.sub();
        sm.load(6);
        sm.div();
        sm.load(5);
        sm.mul();
        assertEquals(10, sm.print());
    }
}