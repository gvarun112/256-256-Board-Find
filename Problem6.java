package grandfinale;
public class Problem6 {
    public static int Left = 2, Right = 2, Up = 2, Down = 2; //declare the number of moves in all directions
    public static boolean [][] game = new boolean[256][256];
    public static void main (String args[]) {
        for ( int i = 0 ; i < 256 ; i++) {
            for ( int j = 0 ; j < 256 ; j++) {
                game[i][j] = solve(i,j); //check whether the fly can be reached from each position
                System.out.print(game[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static boolean solve(int i, int j) {
        int x = 63 - i, y = 63 - j; 
        if (x%Left == 0 || x%Right == 0 ) return true; //return true if the row number can be divided by (left or right) respectively
        if (y%Up == 0 || y%Down == 0 ) return true; //return true if the column number can be divided by (up or down) respectively
        int xL = x%Left, yU = y%Up, xR = x%Right, yD = y%Down; //declare xL, yU, xR, yD as reminder of row divided by left, reminder of column divided by up, row divided by right, reminder of column divided by down
        if (xL%Right == 0) return true; //return true if reminder of xL divided by right is zero
        if (yU%Down == 0) return true; //return true if reminder of yU divided by down is zero
        if (xR%Left == 0) return true; //return true if reminder of xR divided by left is zero
        if (yD%Up == 0) return true; //return true if reminder of yD divided by up is zero
        
        return false; //return false if all the other conditions fail
    } 
}