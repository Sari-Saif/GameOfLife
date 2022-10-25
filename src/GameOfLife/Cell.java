package GameOfLife;

public class Cell
{
    private boolean _isAlive;
    //default contracture
    public Cell()
    {
        this._isAlive = false;
    }
    //return his state
    public boolean isAlive()
    {
        return _isAlive;
    }
    // it will be alive
    public  void revive()
    {
        this._isAlive = true;
    }
    // bye bye to die
    public  void Kill()
    {
        this._isAlive = false;
    }
}
