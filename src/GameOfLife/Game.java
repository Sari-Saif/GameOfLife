package GameOfLife;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Game {

    private int _Height;
    private int _Width;
    private boolean _Done;
    private Cell[][] _Board;
    private boolean[][] _TableOfChanges;
    private ArrayList<Cordinta> _IniteCordinta;

    /**
     * @param height
     * @param width
     * @param _IniteCordinta
     */

    public Game(int height, int width, ArrayList<Cordinta> _IniteCordinta) {
        this._Height = height;
        this._Width = width;
        this._Done = true;
        _Board = new Cell[height][];
        _TableOfChanges = new boolean[height][];
        this._IniteCordinta = _IniteCordinta;

        for (int i = 0; i < height; i++) {
            _Board[i] = new Cell[this._Width];
            _TableOfChanges[i] = new boolean[width];
        }
        for (int i = 0; i < this._Height; i++) {
            for (int j = 0; j < this._Width; j++) {
                _Board[i][j] = new Cell();
            }


        }
    }

    /*
    print a nice board :))

     */
    public void PrintBoard() {

        for (int i = 0; i < this._Height; i++) {
            System.out.print("+");

            for (int j = 0; j < this._Width; j++) {
                System.out.print("---+");
            }

            System.out.println();

            for (int j = 0; j < this._Width; j++) {

                System.out.print("|");
                if (this._Board[i][j].isAlive()) {
                    System.out.print(" @ ");
                } else {
                    System.out.print("   ");
                }

            }
            System.out.println("|");
        }

        System.out.print("+");

        for (int j = 0; j < this._Width; j++) {
            System.out.print("---+");
        }
        System.out.println();
    }

     /*
          -in every board we have cells
          -we will init the board and add them
         */

    public void initBoard() {
        Iterator<Cordinta> cord = this._IniteCordinta.iterator();
       while(cord.hasNext())
       {
           Cordinta a = (Cordinta) cord.next();
           this._Board[a.get_x()][a.get_y()].revive();
       }

    }
    /*
        to check number of alive neighbors to
        every cell in board
     */

    public int _getNumOfliveNeighbors(Cordinta c) {
        int count = 0;
        int hight = c.get_x();
        int width = c.get_y();

        for (int i = hight - 1; i <= hight + 1; i++) {
            for (int j = width - 1; j <= width + 1; j++) {
                // that we will be out border of the board
                if (i < 0 || j < 0 || (j >= this._Width) || i >= this._Height) {
                    continue;
                }

                if (this._Board[i][j].isAlive()) {
                    count++;
                }
            }
        }

        return this._Board[hight][width].isAlive() ? count-1 : count;
    }

    /*
     to decide in every generation who will live or die
     need to check the changes of boolean state to every cell
     and save the information by table ( matrix )
     */

    private void CheckForChanges() {

        for (int i = 0; i < this._Height; i++) {
            for (int j = 0; j < this._Width; j++) {
                int numberOfalive = _getNumOfliveNeighbors(new Cordinta(i, j));
                if (this._Board[i][j].isAlive()) {
                    if (numberOfalive == 2 || numberOfalive == 3) {
                        this._TableOfChanges[i][j] = false;
                    }
                    else
                    {
                        this._TableOfChanges[i][j] = true;
                        this._Done = false;
                    }

                }
                else
                {
                    if (numberOfalive == 3)
                    {
                        this._TableOfChanges[i][j] = true;
                        this._Done = false;

                    }
                    else
                    {
                        this._TableOfChanges[i][j] = false;
                    }
                }

            }


        }
    }
    
     /*
    the engine of game that run generations
     */
    private void RunGen() {
        for (int i = 0; i < this._Height; i++) {
            for (int j = 0; j < this._Width; j++) {
                if (true == this._TableOfChanges[i][j])
                {
                    // if it false and there contraction with tableofchanges
                    if (this._Board[i][j].isAlive())
                    {
                        this._Board[i][j].Kill();
                    } else {
                        this._Board[i][j].revive();
                    }
                }


            }


        }


    }

    /*
     the main function that start the game :)
     */

    public  void start()
    {
        initBoard();

        while (true)
        {
            PrintBoard();
            CheckForChanges();

            if (!this._Done)
            {
                RunGen();
                // wait for second
            }
            else
            {
                break;
            }
        }

    }


}

