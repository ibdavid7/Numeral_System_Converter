package converter;

import java.util.BitSet;

public class Number {

    public static String toString(double decimal, int radix) {
        if (radix <= 0 || radix > 36) {
            throw new IllegalArgumentException("Radix must be between 1 and 36 inclusive");
        } else if (radix == 1) {
            if (decimal == 0) {
                return "0";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < Math.floor(decimal); i++) {
                    sb.append("1");
                }
                return sb.toString();
            }
        } else {
            if (decimal == 0.0) {
                return Double.toString(decimal);
            } else {
                String digits = "0123456789abcdefghijklmnopqrstuvwxyz";
                //1. Convert integer part
                int integer = (int) decimal;
                StringBuilder sb = new StringBuilder();
                if (integer == 0) {
                    sb.append(0);
                } else {
                    while (integer != 0) {
                        sb.insert(0, digits.substring(integer % radix, integer % radix + 1));
                        integer /= radix;
                    }
                }
                //2. Convert fractional part
                if (decimal < Math.ceil(decimal)) {
                    double fraction = decimal - Math.floor(decimal);
                    sb.append(".");
                    for (int i = 0; i < 5; i++) {
                        fraction = fraction * radix;
                        int n =  (int) fraction;
                        sb.append(digits.charAt(n));
                        fraction = fraction - n;
                    }
                }
                return sb.toString();
            }
        }
    }

    public static Double toDecimalInt(String number, int sourceBase) {
        String[] input = number.split("\\.", 2);
        System.out.println(input.length);
        if (sourceBase == 1) {
            return (double) input[0].length();
        } else {
            //Process fractional part
            String digits = "0123456789abcdefghijklmnopqrstuvwxyz";
            double fraction = 0.0;
            if (input.length > 1 && Integer.parseInt(input[1], sourceBase) > 0) {
                for (int i = 0; i < input[1].length(); i++) {
                    char ch = input[1].charAt(i);
                    int val = digits.indexOf(ch);
                    if (val == -1) {
                        throw new IllegalArgumentException("Invalid input, value \"" + ch + "\" doesn't exist");
                    };
                    fraction += val / Math.pow(sourceBase, i + 1);
                }
            }
            return (double) Integer.parseInt(input[0], sourceBase) + fraction;
        }
    }
}
