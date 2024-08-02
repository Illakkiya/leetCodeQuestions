import java.util.Collection;
import java.util.Collections;

public class findLostCharacter {
    public static char findExtraCharacter(String sent, String received) {
        char extraChar = 0;


        // XOR all characters in both strings
        for (int i = 0; i < sent.length(); i++) {
            extraChar ^= sent.charAt(i);
        }
        for (int i = 0; i < received.length(); i++) {
            extraChar ^= received.charAt(i);
        }

        return extraChar;
    }

    public static void main(String[] args) {
        String sent = "string"; // length = 6
        String received = "strin"; // length = 5

        char extraChar = findExtraCharacter(sent, received);
        System.out.println("Extra character: " + extraChar);
        int a =0;
        int b = 12;
        System.out.println(a^b);
    }
}

