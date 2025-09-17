import java.util.*;

public class RotateImage {
  public static void rotate(int arr[][]) {
    int rows = arr.length;
    int cols = arr[0].length;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        int temp = arr[i][j];
        arr[i][j] = temp;
        arr[j][i] = temp;
      }
    }
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols / 2; j++) {
        int temp = arr[i][j];
        arr[i][j] = arr[i][cols - j - 1];
        arr[i][cols - j - 1] = temp;
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
    rotate(mat);
    System.out.println("Matrix after rotation:");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        System.out.print(mat[i][j] + " ");
      }
      System.out.println();
    }
    sc.close();
  }

}
