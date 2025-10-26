import java.util.Scanner;
public class PartD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
// Ask for user input
        System.out.print("Enter a positive integer (1-3999): ");
        int num = in.nextInt();

        // Check if the number is valid
        if (num < 1) {
            System.out.println("Number must be at least 1.");
        } else if (num > 3999) {
            System.out.println("Number must be 3999 or less.");
        } else {
            String roman = "";

            // Handle thousands
            if (num >= 1000) {
                int thousands = num / 1000;
                if (thousands == 1) {
                    roman = roman + "M";
                } else if (thousands == 2) {
                    roman = roman + "MM";
                } else if (thousands == 3) {
                    roman = roman + "MMM";
                }
                num = num % 1000;
            }

            // Handle hundreds
            if (num >= 900) {
                roman = roman + "CM";
                num = num - 900;
            } else if (num >= 500) {
                roman = roman + "D";
                int count = (num - 500) / 100;
                int i = 0;
                while (i < count) {
                    roman = roman + "C";
                    i = i + 1;
                }
                num = num % 100;
            } else if (num >= 400) {
                roman = roman + "CD";
                num = num - 400;
            } else {
                int count = num / 100;
                int i = 0;
                while (i < count) {
                    roman = roman + "C";
                    i = i + 1;
                }
                num = num % 100;
            }

            // Handle tens
            if (num >= 90) {
                roman = roman + "XC";
                num = num - 90;
            } else if (num >= 50) {
                roman = roman + "L";
                int count = (num - 50) / 10;
                int i = 0;
                while (i < count) {
                    roman = roman + "X";
                    i = i + 1;
                }
                num = num % 10;
            } else if (num >= 40) {
                roman = roman + "XL";
                num = num - 40;
            } else {
                int count = num / 10;
                int i = 0;
                while (i < count) {
                    roman = roman + "X";
                    i = i + 1;
                }
                num = num % 10;
            }

            // Handle ones
            if (num == 9) {
                roman = roman + "IX";
            } else if (num >= 5) {
                roman = roman + "V";
                int count = num - 5;
                int i = 0;
                while (i < count) {
                    roman = roman + "I";
                    i = i + 1;
                }
            } else if (num == 4) {
                roman = roman + "IV";
            } else {
                int i = 0;
                while (i < num) {
                    roman = roman + "I";
                    i = i + 1;
                }
            }

            // Show result
            System.out.println("Roman numeral: " + roman);
        }

        in.close();
    }
}
