
public class Cell {
    public int heuristicCost = 0;
    public int finalCost = 0;
    public int i, j;
    public Cell parent;

    public Cell(int i, int j){
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString(){
        return "["+this.i+", "+this.j+"]";
    }
}

