import java.util.Set;
import java.util.HashSet;

public class Chapter1 {
    public static void main(String args[]) {
        println("Hello World!");
        newLine();

        // problem 1: hasOnlyUniqueChars
        println("problem 1: hasOnlyUniqueChars");
        println("hasOnlyUniqueChars(\"asfdasd\") = " + hasOnlyUniqueChars("asfdasd"));
        println("hasOnlyUniqueChars(\"asfd\") = " + hasOnlyUniqueChars("asfd"));
        newLine();

        // problem 2: reverse c-string
        println("problem 2: reverse c-string");
        char[] cstr1 = {'a', 'b', 'c', '\0'};
        char[] cstr2 = {'a', 'b', 'c', 'd', '\0'};

        handleAndReverseCString(cstr1);
        handleAndReverseCString(cstr2);
        newLine();

        // problem 3: remove duplicates from string
        println("problem 3: remove duplicates from string");
        String stringWithDuplicates = "banana";
        println(stringWithDuplicates + " duplicates removed = " + removeDuplicates(stringWithDuplicates));

        stringWithDuplicates = "asssadasdaaasss";
        println(stringWithDuplicates + " duplicates removed = " + removeDuplicates(stringWithDuplicates));

        // problem 4: is anagram
        println("problem 4: is anagram");
        String maybeAnagram1 = "anagram";
        String maybeAnagram2 = "anagrama";
        println("isAnagram(" + maybeAnagram1 + ", " + maybeAnagram2 + ") = " + isAnagram(maybeAnagram1, maybeAnagram2));

        String maybeAnagram3 = "anagram";
        String maybeAnagram4 = "gramana";
        println("isAnagram(" + maybeAnagram3 + ", " + maybeAnagram4 + ") = " + isAnagram(maybeAnagram3, maybeAnagram4));

        // problem 5: replace spaces
        println("problem 5: replace spaces");
        String stringWithSpaces = "Trying my luck";
        println(stringWithSpaces + " spaces replaced = " + replaceSpaces(stringWithSpaces));

        // problem 6: rotate matrix
        println("problem 6: rotate matrix");
        int[][] m = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        println("before: ");
        printMatrix(m, 4);
        rotateMatrix(m, 4);
        printMatrix(m, 4);
    }

    private static void printMatrix(int[][] matrix, int side) {
        for (int i = 0; i < side; i++) {
            String s = "";
            for (int j = 0; j < side; j++) {
                s += matrix[i][j] + " ";
            }
            println(s);
        }
    }

    private static void rotateMatrix(int[][] matrix, int side) {
        for (int i = 0; i < side/2; i++) {
            for (int j = i; j < side - 1 - i; j++) {
                int first = matrix[j][side - 1 - i];
                matrix[j][side - 1 - i] = matrix[i][j];

                int second = matrix[side - i - 1][side - 1 - i - j];
                matrix[side - i - 1][side - 1 - i - j] = first;

                int third = matrix[side - 1 - i - j][i];
                matrix[side - 1 - i - j][i] = second;

                matrix[i][j] = third;
            }
        }
    }

    private static String replaceSpaces(String s) {
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1, s.length());
                i += 2;
            }
            i++;
        }
        return s;
    }

    private static Boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] allChars = new int[256];
        
        for (int i = 0; i < s1.length(); i++) {
            int place1 = (int) s1.charAt(i);
            int place2 = (int) s2.charAt(i);

            allChars[place1] = allChars[place1] + 1;
            allChars[place2] = allChars[place2] - 1;
        }
        
        for (int i = 0; i < 256; i++) {
            if (allChars[i] != 0) return false;
        }
        return true;
    }

    private static String removeDuplicates(String s) {
        Set<Character> allChars = new HashSet<>();

        int i = 0;
        while (i < s.length()) {
            if (allChars.contains(s.charAt(i))) {
                s = s.substring(0, i) + s.substring(i + 1, s.length()); 
            } else {
                allChars.add(s.charAt(i));
                i++;
            }
        }
        return s;
    }

    private static void handleAndReverseCString(char[] s) {
        int len = getCStrLen(s);
        printCString(s, len);
        reverseCString(s, len);
        printCString(s, len);
    }

    private static int getCStrLen(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            i++;
        }
        return i;
    }

    private static void reverseCString(char[] s, int length) {
        for (int i = 0; i < length/2; i++) {
            char temp = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = temp;
        }
    }

    private static void printCString(char[] s, int length) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < length - 1; i++) {
            sb.append(s[i] + ", ");
        }
        sb.append(s[length - 1] + "}");
        println(sb.toString());
    }

    private static void println(Object o) {
        System.out.println(o);
    }

    private static void newLine() {
        println("");
    }

    private static Boolean hasOnlyUniqueChars(String s) {
        int[] allChars = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int pos = (int) s.charAt(i);
            allChars[pos] = allChars[pos] + 1;
        }

        for (int i = 0; i < 256; i++) {
            if (allChars[i] > 1) return false;
        }

        return true;
    }
}