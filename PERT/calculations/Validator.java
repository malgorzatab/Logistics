package calculations;

public class Validator {

    public static boolean doubleOrIntMatches(String s){
        try
        {
            double d = Double.parseDouble(s);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static boolean letterMatches(String s){
        return s.matches("[A-Z]");
    }
}
