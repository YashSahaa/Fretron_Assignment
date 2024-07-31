package org.example;
import java.util.Scanner;

public class Problem3 {
    static int count = 0;

    static class Edge {
        int x;
        int y;

        Edge(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfSoldiers = sc.nextInt();

        Edge[] soldiers = new Edge[noOfSoldiers];
        int maxCoordinate = 0; // size of matrix

        for (int i = 0; i < noOfSoldiers; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            soldiers[i] = new Edge(y-1, x-1);
            if (x > maxCoordinate) maxCoordinate = x;
            if (y > maxCoordinate) maxCoordinate = y;
        }

        int startY = sc.nextInt() - 1;
        int startX = sc.nextInt() - 1;

        boolean[][] board = new boolean[maxCoordinate][maxCoordinate];

        for (Edge soldier : soldiers) {
            board[soldier.x][soldier.y] = true;
        }

        findPath(board, startX, startY, startX, startY, 1, 0);
        System.out.println("Total unique paths: " + count);
    }

    public static void findPath(boolean[][] board, int startX, int startY, int currX, int currY, int xDir, int yDir) {
        int n = board.length;


        if (currX < 0 || currX >= n || currY < 0 || currY >= n) return;

        // Base case
        if (currX == startX && currY == startY && (xDir != 1 || yDir != 0)) {
            count++;
            return;
        }

        //  encounters a soldier
        if (board[currX][currY]) {
            //Kill the soldier and turn left
            int newXDir = xDir;
            int newYDir = yDir;

            // Turn left
            if (xDir == 1) { newXDir = 0; newYDir = 1; }       // Right -> Down
            else if (yDir == 1) { newXDir = -1; newYDir = 0; } // Down -> Left
            else if (xDir == -1) { newXDir = 0; newYDir = -1; } // Left -> Up
            else if (yDir == -1) { newXDir = 1; newYDir = 0; }  // Up -> Right

            board[currX][currY] = false;  // Soldier is killed
            findPath(board, startX, startY, currX + newXDir, currY + newYDir, newXDir, newYDir);
            board[currX][currY] = true;   // Backtrack (soldier restore)

            // Skip the soldier and continue in the same direction
            findPath(board, startX, startY, currX + xDir, currY + yDir, xDir, yDir);
        } else {
            // No soldier encountered, continue moving in the current direction
            findPath(board, startX, startY, currX + xDir, currY + yDir, xDir, yDir);
        }
    }

}



