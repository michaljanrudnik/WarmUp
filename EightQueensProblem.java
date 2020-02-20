public class EightQueensProblem {

    void findSolution(int[] q, int k){
        int n = q.length;
        if (k == n)
            printSolution(q);
        else{
            for (int i = 0; i < n; i++) {
                q[k] = i;
                if (checkQueens(q, k))
                    findSolution(q,k+1);
            }
        }

    }

    boolean checkQueens(int[] q, int n) {
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])
                return false;
            if ((q[i] - q[n]) == (n - i))
                return false;
            if ((q[n] - q[i]) == (n - i))
                return false;
        }
        return true;
    }

    void printSolution(int[] q){
        int n = q.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (q[i] == j)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }



    public static void main(String[] args) {
        EightQueensProblem cordinates = new EightQueensProblem();
        int[] a = new int[8];
        int b = 0;
        cordinates.findSolution(a,b);
    }
}
