
 
public class Main {
    public static void main(String[] args){
        AStar aStar=new AStar();
        aStar.test(5, 5, 0, 0, 3, 2, new int[][]{{0,4},{2,2},{3,1},{3,3}});
        aStar.test(5, 5, 0, 0, 4, 4, new int[][]{{0,4},{2,2},{3,1},{3,3}});
        aStar.test(7, 7, 2, 1, 5, 4, new int[][]{{4,1},{4,3},{5,3},{2,3}});
        aStar.test(5, 5, 0, 0, 4, 4, new int[][]{{3,4},{3,3},{4,3}});
    }
}
