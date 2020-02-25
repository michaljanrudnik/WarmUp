import java.util.Scanner;

public class TicTacToeNxN {

    public int[][] board;
    int n;

    void setN(int n){
        this.n = n;
        boardBuilding();
    }

    void boardBuilding(){
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }
        playGame();
    }

    void playGame(){
        Scanner scan = new Scanner(System.in);
        int a,b;
        char win = '.';
        boolean end = false;
        while(!end){
            System.out.println("Enter O co-ordinates(example: 2 3)");
            a = scan.nextInt();
            b = scan.nextInt();
            if (canMove(a,b,1)) {
                drawBoard();
                if (ifWin(a, b, 1)) {
                    win = 'O';
                    end = true;
                    break;
                }
            }
            System.out.println("Enter X co-ordinates(example: 2 3)");
            a = scan.nextInt();
            b = scan.nextInt();
            if (canMove(a,b,2)) {
                drawBoard();
                if (ifWin(a, b, 2)) {
                    win = 'X';
                    end = true;
                    break;
                }
            }

        }
        System.out.println("Congratulation " + win + " wins!!!");
    }

    void drawBoard(){
        System.out.print("   ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < n; j++) {
                if(board[i][j] == 0)
                    System.out.print(". ");
                else if(board[i][j] == 1)
                    System.out.print("O ");
                else
                    System.out.print("X ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    boolean canMove(int x, int y, int state){
        boolean move = false;
        if (board[x][y] == 0) {
            board[x][y] = state;
            move = true;
        }

        return move;
    }

    boolean ifWin(int x, int y, int state){
        boolean win = false;


        for (int i = 0; i < n; i++) {
            if (board[x][i] != state)
                break;
            if (i == n-1)
                win = true;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][y] != state)
                break;
            if (i == n-1)
                win = true;
        }

        if (x == y){
            for (int i = 0; i < n; i++) {
                if (board[i][i] != state)
                    break;
                if (i == n-1)
                    win = true;
            }
        }
        //check anti diagonal
        if (x + y == n-1){
            for (int i = 0; i < n; i++) {
                if (board[i][(n-1)-i] != state)
                    break;
                if (i == n-1)
                    win = true;
            }
        }

        return win;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TicTacToeNxN start = new TicTacToeNxN();
        System.out.println("Enter the board size");
        int n = scan.nextInt();
        start.setN(n);

    }
}
