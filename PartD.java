import java.util.Scanner;

public class PartD {
public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    // Enum for Roman numeral values
    enum RomanNumeral {
        M(1000), CM(900), D(500), CD(400),
        C(100), XC(90), L(50), XL(40),
        X(10), IX(9), V(5), IV(4), I(1);

        int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }
    }


        System.out.print("Enter a positive integer (1-3999): ");
        int num = in.nextInt();

        String roman = "";

        if (num < 1) {
            System.out.println("Number must be at least 1.");
        } else if (num > 3999) {
            System.out.println("Number must be 3999 or less.");
        } else {
            // Thousands
            if (num >= 3000) {
                roman = "MMM";
                num = num - 3000;
            } else if (num >= 2000) {
                roman = "MM";
                num = num - 2000;
            } else if (num >= 1000) {
                roman = "M";
                num = num - 1000;
            }

            // Hundreds
            if (num >= 900) {
                roman = roman + "CM";
                num = num - 900;
            } else if (num >= 500) {
                roman = roman + "D";
                if (num >= 600 && num < 700) roman = roman + "C";
                if (num >= 700 && num < 800) roman = roman + "CC";
                if (num >= 800 && num < 900) roman = roman + "CCC";
                num = num - (num / 100) * 100;
            } else if (num >= 400) {
                roman = roman + "CD";
                num = num - 400;
            } else if (num >= 100) {
                if (num >= 300) roman = roman + "CCC";
                else if (num >= 200) roman = roman + "CC";
                else roman = roman + "C";
                num = num - (num / 100) * 100;
            }

            // Tens
            if (num >= 90) {
                roman = roman + "XC";
                num = num - 90;
            } else if (num >= 50) {
                roman = roman + "L";
                if (num >= 60 && num < 70) roman = roman + "X";
                if (num >= 70 && num < 80) roman = roman + "XX";
                if (num >= 80 && num < 90) roman = roman + "XXX";
                num = num - (num / 10) * 10;
            } else if (num >= 40) {
                roman = roman + "XL";
                num = num - 40;
            } else if (num >= 10) {
                if (num >= 30) roman = roman + "XXX";
                else if (num >= 20) roman = roman + "XX";
                else roman = roman + "X";
                num = num - (num / 10) * 10;
            }

            // Ones
            if (num == 9) {
                roman = roman + "IX";
            } else if (num >= 5) {
                roman = roman + "V";
                if (num == 6) roman = roman + "I";
                if (num == 7) roman = roman + "II";
                if (num == 8) roman = roman + "III";
            } else if (num == 4) {
                roman = roman + "IV";
            } else if (num >= 1) {
                if (num == 3) roman = roman + "III";
                else if (num == 2) roman = roman + "II";
                else roman = roman + "I";
            }

            // Show result
            System.out.println("Roman numeral: " + roman);
        }

        in.close();
    }
}