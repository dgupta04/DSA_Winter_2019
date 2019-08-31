import java.util.Scanner;

public class Main {

    public static int moveDown(char grid[][], int vertPos, int horizPos){
        if(grid[horizPos][vertPos+1] == 'x'){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static int moveRight(char grid[][], int vertPos, int horizPos){
        if(grid[horizPos+1][vertPos] == 'x'){
            return 1;
        }
        else{
            return 0;
        }
    }

    // Please change return type, and arguments to the recur function as necessary
    public static void recur(char grid[][], int points, int vertPos, int horizPos, int n){
        if(horizPos == n && vertPos == n)
        {
            return points;
        }
        else if(hoirzPos == n && vertPos != n){
            points += moveDown(grid, vertPos, horizPos);
            vertPos+=1;
            recur(grid, points, vertPos, horizPos, n);
        }
        else if(horizPos != n && vertPos == n){
            points += moveRight(grid, vertPos, horizPos);
            horizPos += 1;
            recur(grid, points, vertPos, horizPos, n);
        }
        else{
          points += moveRight(grid, vertPos, horizPos);
          recur(grid, points, vertPos, horizPos+1, n); 
          points -= moveRight(grid, vertPos, horizPos); 
          points += moveDown(grid, vertPos, horizPos);
          recur(grid, points, vertPos+1, horizPos, n); 
        }
    }

    public static int solve(char matr[][], int n){
        int ans = 0;
        return recur(matr, n);
    }

    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        char matr[][] = new char[n][n];
        for (int i=0;i<n;i++){
            String temp = s.next();
            for (int j=0;j<n;j++){
                matr[i][j] = temp.charAt(j);
            }
        }
        System.out.println(solve(matr,n));
    }

}