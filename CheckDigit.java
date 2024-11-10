public class CheckDigit
{
    public static int getCheck(int num)
    {
        // Converting digit string into a String
        String digits = "" + num;
        int checkSum = 0;

        // As long as string of digits has 6 digits or less
        if (getNumberOfDigits(num) <= 6)
        {
            // Multiplier represents what number each digit is multiplied by to find the check digit
            int multiplier = 7;
            for (int i = 0; i < getNumberOfDigits(num); i++)
            {
                // Multiplying each digit by its respective multiplier and adding it to checkSum
                checkSum += getDigit(num, i + 1) * multiplier;
                multiplier--;
            }
        }
        else
        {
            System.out.println("Digit string has to be six digits or less.")
        }

        // Changing the sum of the digits to a string to find the last number in the digit string
        String checkDigit = "" + checkSum;
        return Integer.parseInt("" + checkDigit.charAt(checkDigit.length() - 1));
    }

    public static boolean isValid(int numWithCheckDigit)
    {
        // Converts digits into string to seperate the last digit (check digit) and the other digits to check
        String digitsToCheck = "" + numWithCheckDigit;
        int checkDigit = Integer.parseInt("" + digitsToCheck.charAt(digitsToCheck.length()));
        int otherDigits = Integer.parseInt(digitsToCheck.substring(0, digitsToCheck.length() - 1));

        // If the check digit in the parameters matches what check digit is calculated
        if (checkDigit == getCheck(otherDigits))
            return true;
        else
            return false;
    }

    public static int getNumberOfDigits(int num)
    {
        // Gets number of digits by converting to a string
        String digits = "" + num;
        return digits.length();
    }

    public static int getDigit(int num, int n)
    {
        // If number is 0 or less
        if (n <= 0)
            throw new java.lang.RuntimeException("Number less than or equal to 0 not allowed.");

        String digits = "" + num;

        // Converts the character at whatever position back to an integer
        return Integer.parseInt("" + digits.charAt(n - 1));
    }

    public static void main(String[] args)
    {
        // Test cases 283415, 2183, 2, and 121242414 (does not process)
        System.out.println(getCheck(283415)); // -> 6
        System.out.println(getCheck(2183)); // -> 2
        System.out.println(getCheck(2)); // -> 4
        System.out.println(getCheck(121242414))

        // Check to see if each test case with their respective check digit is valid with isValid method
        System.out.println(isValid(2834156)); // -> True
        System.out.println(isValid(2834157)); // -> False

        System.out.println(isValid(21832)); // -> True
        System.out.println(isValid(24)); // -> True
        System.out.println(isValid(1212314124)); // -> False (too long of a digit sequence)
    }
}
