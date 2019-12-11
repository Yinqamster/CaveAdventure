import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {




//    public enum penance {
//        SINGCHRISMAS("Sing the 12 days of Christmas"),
//        MATHEQUATION("Perform 5 random math equations");
//        private String description;
//
//        private penance(){
//        }
//
//        private penance(String description) {
//            this.description = description;
//        }
//
//        public String getDescription() {
//            return this.description;
//        }
//
//    }

    public static int getRandom(int n) {
        Random random = new Random();
        return random.nextInt(n);
    }

    public static String getThByInt(int n) {
        switch (n) {
            case 1:
                return "first";
            case 2:
                return "second";
            case 3:
                return "third";
            case 4:
                return "forth";
            case 5:
                return "fifth";
            case 6:
                return "sixth";
            case 7:
                return "seventh";
            case 8:
                return "eighth";
            case 9:
                return "ninth";
            case 10:
                return "tenth";
            case 11:
                return "eleventh";
            case 12:
                return "twelfth";
            default:
                return "";
        }
    }

    public static String getNumByInt(int n) {
        switch (n) {
            case 1:
                return "a";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            default:
                return "";
        }
    }



//    public static boolean isNumber(String str) {
//        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
//        Matcher isNum = pattern.matcher(str);
//        if (!isNum.matches()) {
//            return false;
//        }
//        return true;
//    }

    //integer
    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("(\\-)?[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }


}
