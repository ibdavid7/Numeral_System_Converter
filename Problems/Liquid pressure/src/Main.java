import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        final double gravity = 9.8;
        final double density = scanner.nextDouble();
        final double height = scanner.nextDouble();
        System.out.println(gravity * density * height);
    }
}