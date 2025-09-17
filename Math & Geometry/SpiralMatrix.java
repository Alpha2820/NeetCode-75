import java.util.*;

public class SpiralMatrix {

  public static ArrayList<Integer> spiralOrder(int arr[][]) {
    int rows = arr.length;
    int cols = arr[0].length;
    int left = 0;
    int right = cols - 1;
    int top = 0;
    int bottom = rows - 1;
    ArrayList<Integer> result = new ArrayList<>();
    while (left <= right && top <= bottom) {
      for (int i = left; i <= right; i++) {
        result.add(arr[top][i]);
      }
      top++;
      for (int i = top; i <= bottom; i++) {
        result.add(arr[i][right]);
      }
      right--;
      if (!(left < right && top < bottom)) {
        break;
      }
      for (int i = right; i >= left; i--) {
        result.add(arr[bottom][i]);
      }
      bottom--;
      for (int i = bottom; i >= top; i--) {
        result.add(arr[i][left]);
      }
      left++;
    }
    return result;
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
    ArrayList<Integer> result = spiralOrder(mat);
    System.out.println("Spiral order of the matrix:");
    for (int num : result) {
      System.out.print(num + " ");
    }
    sc.close();
  }

}
