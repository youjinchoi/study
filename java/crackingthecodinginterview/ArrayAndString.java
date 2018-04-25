package crackingthecodinginterview;

public class ArrayAndString {
    public static void main(String[] args) {

    }

    /**
     * 1.1 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
     * 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
     */
    public boolean isInUniqueChars2(String str) {
        if (str.length() > 256) {
            return false;
        }

        boolean[] char_set = new boolean[256];
        for (int i=0; i<str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }

    /**
     * 1.3 문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
     * 풀이 #1
     */
    public String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean permutation1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    /**
     * 1.3 문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
     * 풀이 #2
     */
    public boolean permutation2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letters = new int[256];
        char[] s_array = s.toCharArray();
        for (char c  : s_array) {
            letters[c]++;
        }

        for(int i=0; i<t.length(); i++) {
            int c = t.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1.4 주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라.
     * 문자열 끝에 추가로 필요한 문자들을 더할 수 있는 충분한 공간이 있다고 가정하라.
     * 그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라.
     * (주의: 만일 Java로 구현한다면 문자 배열을 사용하여 필요한 연산을 각 문자에 적용할 수 있도록 하라.)
     */
    public void replaceSpaces(char[] str, int length) {
        int spaceCount = 0, newLength, i = 0;
        for (i=0; i<length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;
        str[newLength] = '\0';

        for (i=length-1; i>=0; i--) {
            if (str[i] == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                str[newLength - 1] = str[i];
                newLength = newLength - 1;
            }
        }
    }

    /**
     * 1.5 같은 문자가 연속으로 반복될 경우 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라.
     * 가령 압축해야 할 문자열이 aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다.
     * 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우 이 메서드는 원래 문자열을 그대로 반환해야 한다.
     */
    public String compressBad(String str) {
        String mystr = "";
        char last = str.charAt(0);
        int count = 1;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr += last + "" + count;
                last = str.charAt(i);
                count = 1;
            }
        }
        return mystr + last + count;
    }

    public String compressBetter(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();
    }

    public int countCompression(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        char last = str.charAt(0);
        int size = 0;
        int count = 1;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                last = str.charAt(i);
                size += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }

    public String compressAlternate(String str) {
        int size = countCompression(str);
        if (size >= str.length()) {
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for (int i=1; i<str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                index = setChar(array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        index = setChar(array, last, index, count);
        return String.valueOf(array);
    }

    public int setChar(char[] array, char c, int index, int count) {
        array[index] = c;
        index++;

        char[] cnt = String.valueOf(count).toCharArray();

        for (char x : cnt) {
            array[index] = x;
            index++;
        }

        return index;
    }

    /**
     * 1.6 이미지를 표현하는 N x N 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다.
     * 이때 이미지를 90도 회전시키는 메서드를 작성하라.
     * 부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?
     */
    public void rotate(int[][] matrix, int n) {
        for (int layer=0; layer < n/2; ++layer) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // 위쪽을 저장
                matrix[first][i] = matrix[last - offset][first];    // 왼쪽 -> 위쪽
                matrix[last - offset][first] = matrix[last][last - offset]; // 아래 -> 왼쪽
                matrix[last][last - offset] = matrix[i][last];  // 오른쪽 -> 아래
                matrix[i][last] = top;  // 위 -> 오른쪽
            }
        }
    }

    /**
     * 1.7 M x N 행렬을 순회하면서 0인 원소를 발견하면, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라.
     */
    public void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 1.8 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메서드가 있다고 하자.
     * s1과 s2의 두 문자열이 주어졌을 때 s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstring을 한 번만 호출하도록 하여 작성하라.
     * (가령 'waterbottle'은 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다.)
     */
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public boolean isSubstring(String s1, String s2) {
        return true;    //  컴파일 오류 때문에 임시구현현
   }


}
