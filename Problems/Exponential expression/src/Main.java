import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        final double x = scanner.nextDouble();
        System.out.println(Math.pow(x, 3) + Math.pow(x, 2) + x + 1);
    }
}