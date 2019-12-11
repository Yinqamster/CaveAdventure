import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Penance {
    private String description;

    public Penance() {

    }

    public Penance(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static void getPenance(String name) {
        switch (name){
            case Config.SINGCHRISMAS:
                singChrismas();
                break;
            case Config.MATHEQUATION:
                mathQuation();
                break;
            default:
                break;

        }
    }


    private static void singChrismas() {
        String[] items = {"Partridge in a Pear Tree", "Turtle Doves", "French Hens", "Calling Birds", "Golden Rings", "Geese a Laying",
                "Swans a Swimming", "Maids a Milking", "Ladies Dancing", "Lords a Leaping", "Pipers Piping", "Drummers Drumming"};
        List<String> itemList = new ArrayList<>();
        for(int i = 0; i < items.length; i++) {
            itemList.add(items[i]);
        }

        Collections.shuffle(itemList);
        for(int i = 0; i < items.length; i++) {
            System.out.print("On the "+ Util.getThByInt(i+1) + " day of Christmas my true love gave to me");
            for(int j = i; j >= 0; j--) {
                System.out.print(", " + Util.getNumByInt(j+1) + " " + itemList.get(j));
            }
            System.out.println(".");
        }

//        System.out.println("On the first day of Christmas my true love gave to me, a Partridge in a Pear Tree");
//        System.out.println("On the second day of Christmas my true love gave to me, two Turtle Doves and a Partridge in a Pear Tree");
//        System.out.println("On the third day of Christmas my true love gave to me, three French Hens, " +
//                "two Turtle Doves and a Partridge in a Pear Tree");
//        System.out.println("On the fourth day of Christmas my true love gave to me, four Calling Birds, three French Hens, two Turtle Doves and a Partridge in a Pear Tree");
//        System.out.println("On the fifth day of Christmas my true love gave to me, five Golden Rings, four Calling Birds, three French Hens, two Turtle Doves, and a Partridge in a Pear Tree");
//        System.out.println("On the sixth day of Christmas my true love gave to me,six Geese a Laying,five Golden Rings," +
//                "four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the seventh day of Christmas my true love gave to me,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the eighth day of Christmas my true love gave to me,eight Maids a Milking,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the ninth day of Christmas my true love gave to me," +
//                "nine Ladies Dancing,eight Maids a Milking,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the tenth day of Christmas my true love gave to me,ten Lords a Leaping,nine Ladies Dancing,eight Maids a Milking,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the eleventh day of Christmas my true love gave to me,eleven Pipers Piping,ten Lords a Leaping,nine Ladies Dancing,eight Maids a Milking,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
//        System.out.println("On the twelfth day of Christmas my true love gave to me,twelve two Drummers Drumming,eleven Pipers Piping,ten Lords a Leaping,nine Ladies Dancing,eight Maids a Milking,seven Swans a Swimming,six Geese a Laying,five Golden Rings,four Calling Birds,three French Hens,two Turtle Doves,and a Partridge in a Pear Tree");
    }

    private static void mathQuation() {
        System.out.println("math");
        for(int i = 0; i < Config.NUMOFMATH; i++) {
            Scanner scanner = new Scanner(System.in);
            String[] operations = {"+", "-", "*"};
            int num1 = Util.getRandom(100);
            int num2 = Util.getRandom(100);
            String op = operations[Util.getRandom(operations.length)];
            String quation = num1 + " " + op + " " + num2 + " = ";
            System.out.print(quation);
            String res = scanner.nextLine();
            while (!Util.isNumber(res)) {
                System.out.print("Answer invalid! Enter the answer: ");
                res = scanner.nextLine();
            }
            int c = Integer.parseInt(res);

            int answer = 0;
            switch (op) {
                case "+":
                    answer = num1 + num2;
                    break;
                case "-":
                    answer = num1 - num2;
                    break;
                case "*":
                    answer = num1 * num2;
                    break;
                case "/":
                    answer = num1 / num2;
                    break;
                default:
                    break;
            }
            while(c != answer) {
                System.out.print("Wrong answer! Enter the answer: ");
                res = scanner.nextLine();
                while (!Util.isNumber(res)) {
                    System.out.print("Answer invalid! Enter the answer: ");
                    res = scanner.nextLine();
                }
                c = Integer.parseInt(res);
            }
        }

    }
}
