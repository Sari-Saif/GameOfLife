package GameOfLife;

import static org.junit.jupiter.api.Assertions.*;

class CordintaTest
{

    @org.junit.jupiter.api.Test
    void get_x()
    {
      Cordinta v1 = new Cordinta(12,45);
      int v11 = v1.get_x();
      assertTrue(12 == v11);


    }

    @org.junit.jupiter.api.Test
    void get_y()
    {
        Cordinta v1 = new Cordinta(12,45);
        int v11 = v1.get_y();
        assertFalse(12 == v11);
    }
}