import java.util.Scanner;

public class TheStarFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int target = input -1;
        String[][] matrix = new String[input][input];

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (i == j || i == input - j - 1 || i == target / 2 || j == target / 2) {
                    matrix[i][j] = "*";
                } else {
                    matrix[i][j] = ".";
                }

            }
        }
        for (int k = 0; k < input; k++) {
            for (int l = 0; l < input; l++) {
                System.out.print(matrix[k][l] + " ");
            }
            System.out.println('\n');
        }
    }
}
