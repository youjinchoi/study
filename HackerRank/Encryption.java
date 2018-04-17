import java.util.*;

/**
 * https://www.hackerrank.com/challenges/encryption/problem
 */
public class Encryption {
    static String encryption(String s) {
        String str = s.replaceAll("\\s+", "");
        double sqrt = Math.sqrt((double)str.length());
        int row = (int)Math.floor(sqrt);
        int column = (int)Math.ceil(sqrt);

        if (row * column < str.length()) {
            row++;
        }

        String[][] arr = new String[row][column];
        int index = 0;
        for (int i=0; i<row; i++) {
            for (int j=0; j<column; j++) {
                arr[i][j] = index >= str.length() ? "" : String.valueOf(str.charAt(index));
                index++;
            }
        }

        String result = "";
        for (int i=0; i<column; i++) {
            for (int j=0; j<row; j++) {
                result += arr[j][i];
            }
            result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = encryption(s);
        System.out.println(result);
        in.close();
    }
}
