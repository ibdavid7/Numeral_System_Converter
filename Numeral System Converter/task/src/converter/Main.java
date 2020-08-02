package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            int sourceRadix = in.nextInt();
            String number = in.next();
            int targetRadix = in.nextInt();
            System.out.printf("%s", Number.toString(Number.toDecimalInt(number, sourceRadix), targetRadix));
        } catch (Exception e) {
            System.out.println("error");
        }

    }
}
