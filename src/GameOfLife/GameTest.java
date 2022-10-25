package GameOfLife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest
{

    @Test
    void printBoard()
    {

        Cordinta c =new Cordinta(1,2);
        ArrayList<Cordinta> initCordinata = new ArrayList<Cordinta>();
        initCordinata.add(c);
        Game g =new Game(10,10,initCordinata);
        g.PrintBoard();






    }
}