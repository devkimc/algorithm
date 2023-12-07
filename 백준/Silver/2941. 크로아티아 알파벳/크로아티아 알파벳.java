import java.util.*;

public class Main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        while (true) {
            String replaced = replaceAlphabet(str);

            if (str.equals(replaced)) {
                System.out.println(str.length());
                break;
            }

            str = replaced;
        }
    }

    private static String replaceAlphabet (String word) {
        String[] REGEX = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (int i = 0; i < REGEX.length; i++) {
            if (word.contains(REGEX[i])) {
                return word.replace(REGEX[i], "*");
            }
        }
        return word;
    }
}