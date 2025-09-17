import java.util.Scanner;

public class SetMatrixZero {
  public static void setZero(int mat[][]) {
    int rows = mat.length;
    int cols = mat[0].length;
    boolean rowZero[] = new boolean[rows];
    boolean colZero[] = new boolean[cols];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (mat[i][j] == 0) {
          rowZero[i] = true;
          colZero[j] = true;
        }
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (rowZero[i] == true || colZero[j] == true) {
          mat[i][j] = 0;
        }
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of rows and columns");
    int rows = sc.nextInt();
    int cols = sc.nextInt();
    int mat[][] = new int[rows][cols];
    System.out.println("Enter the matrix");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        mat[i][j] = sc.nextInt();
      }
    }
    setZero(mat);
    System.out.println("Matrix after setting zeros:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
