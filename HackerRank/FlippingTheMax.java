import java.util.Scanner;

/*
* https://www.hackerrank.com/challenges/flipping-the-matrix/problem
* */
public class FlippingTheMax {

	static int flippingMatrix(int[][] matrix) {
		boolean shouldSwitch = false;
		do {
			shouldSwitch = false;
            int rowMaxDiff = 0, rowMaxDiffIndex = 0;
			int colMaxDiff = 0, colMaxDiffIndex = 0;
			for(int i=0; i<matrix.length; i++) {
				int rowSumLeft = 0, rowSumRight = 0;
				int colSumTop = 0, colSumBottom = 0;
				for(int j=0; j<matrix.length/2; j++) {
					rowSumLeft += matrix[i][j];
					rowSumRight += matrix[i][matrix.length-1-j];
					colSumTop += matrix[j][i];
					colSumBottom += matrix[matrix.length-1-j][i];
				}
				int rowDiff = rowSumRight - rowSumLeft;
				if (rowDiff > 0 && shouldSwitch == false) {
					shouldSwitch = true;
				}
				if (rowDiff > rowMaxDiff) {
					rowMaxDiff = rowDiff;
					rowMaxDiffIndex = i;
				}
				int colDiff = colSumBottom - colSumTop;
				if (colDiff > 0 && shouldSwitch == false) {
					shouldSwitch = true;
				}
				if (colDiff > colMaxDiff) {
					colMaxDiff = colDiff;
					colMaxDiffIndex = i;
				}
			}
			
			if (shouldSwitch) {
                if (rowMaxDiff > colMaxDiff) {
					reverseRow(matrix, rowMaxDiffIndex);
				} else {
					reverseCol(matrix, colMaxDiffIndex);
				}
			}
		} while(shouldSwitch);
		
		int sumUpperLeft = 0;
		for (int i=0; i<matrix.length/2; i++) {
			for (int j=0; j<matrix.length/2; j++) {
				sumUpperLeft += matrix[i][j];
			}
		}
		
		return sumUpperLeft;
    }
	
	static void reverseCol(int[][] matrix, int index) {
		for(int i=0; i<matrix.length/2; i++) {
			int temp = matrix[i][index];
			int indexToSwitch = matrix.length-1-i;
			matrix[i][index] = matrix[indexToSwitch][index];
			matrix[indexToSwitch][index] = temp;
		}
	}
	
	static void reverseRow(int[][] matrix, int index) {
		for(int i=0; i<matrix.length/2; i++) {
			int temp = matrix[index][i];
			int indexToSwitch = matrix.length-1-i;
			matrix[index][i] = matrix[index][indexToSwitch];
			matrix[index][indexToSwitch] = temp;
		}
	}

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] matrix = new int[2*n][2*n];
            for(int matrix_i = 0; matrix_i < 2*n; matrix_i++){
                for(int matrix_j = 0; matrix_j < 2*n; matrix_j++){
                    matrix[matrix_i][matrix_j] = in.nextInt();
                }
            }
            int result = flippingMatrix(matrix);
            System.out.println(result);
        }
        in.close();
    }
}