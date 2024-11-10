import javax.management.RuntimeErrorException;
public class CheckDigit
{
    public static int getCheck(int num)
    {
        String digits = "" + num;
        int checkSum = 0;

        if (getNumberOfDigits(num) >= 1 && getNumberOfDigits(num) <= 6)
        {
            int multiplier = 7;
            for (int i = 0; i < getNumberOfDigits(num); i++)
            {
                checkSum += getDigit(num, i + 1) * multiplier;
                multiplier--;
            }
        }

        String checkDigit = "" + checkSum;
        return Integer.parseInt("" + checkDigit.charAt(checkDigit.length() - 1));
    }

    public static boolean isValid(int numWithCheckDigit)
    {
        String digitsToCheck = "" + numWithCheckDigit;
        int checkDigit = Integer.parseInt("" + digitsToCheck.charAt(digitsToCheck.length()));
        int otherDigits = Integer.parseInt(digitsToCheck.substring(0, digitsToCheck.length() - 1));

        if (checkDigit == getCheck(otherDigits))
            return true;
        else
            return false;
    }

    public static int getNumberOfDigits(int num)
    {
        String digits = "" + num;
        return digits.length();
    }

    public static int getDigit(int num, int n)
    {
        // If number is 0 or less
        if (n <= 0)
            throw new java.lang.Error("Number less than or equal to 0 not allowed.");

        String digits = "" + num;

        // Converts the character at whatever position back to an integer
        return Integer.parseInt("" + digits.charAt(n - 1));
    }

    public static void main(String[] args)
    {
        System.out.println(getCheck(2));
    }
}
