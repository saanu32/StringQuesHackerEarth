import java.util.Scanner;

public class RepeatedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string to repeat: ");
        String s = scanner.nextLine();

        System.out.print("Enter the number of characters to consider: ");
        long n = scanner.nextLong();

        long result = repeatedString(s, n);
        System.out.println("Frequency of 'a': " + result);

        scanner.close();
    }

    public static long repeatedString(String s, long n) {
        long length = s.length();
        long numOccurrences = n / length;
        long remainder = n % length;

        long count = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        count *= numOccurrences;

        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
        }

        return count;
    }
}
