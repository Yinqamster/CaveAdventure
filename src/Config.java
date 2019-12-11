public class Config {

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static final int LEVEL = 3;

    public static final int UNFINISHED = 0;
    public static final int FINISHED = 1;

    public static final int KILLED = 0;
    public static final int ALIVE = 1;

    //operation status
    public static final int USED = 1;
    public static final int UNUSED = 0;

    //operation type
    public static final int ATTACK = 0;
    public static final int PICKTREASURE = 1;
    public static final int PICKTRICK = 2;
    public static final int MOVENEXT = 3;

    //operation
    public static final int CONTINUE = 0;
    public static final int NEXTLEVEL = 1;

    //special word
    public static final String SPECIALWORD = "bye";

    //animals
    public static final String[][] animalArray = {{"cow", "moo"}, {"duck", "quack"}, {"pig", "oink"},
            {"horse", "neigh"}, {"lamb", "baa"}};

    public static final String SINGCHRISMAS = "sing the 12 days of Christmas";
    public static final int NUMOFMATH = 5;
    public static final String MATHEQUATION = "perform " + NUMOFMATH + " random math equations";
}
