package GameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void isAlive()
    {
       Cell c = new Cell();
       assertFalse(c.isAlive());
    }

    @Test
    void revive()
    {
    Cell c1 = new Cell();
    assertFalse(c1.isAlive());
    c1.revive();
    assertFalse(!c1.isAlive());
    }

    @Test
    void kill()
    {
    Cell c2 = new Cell();
    c2.revive();
    c2.Kill();
    assertFalse(c2.isAlive());
    }
}