public class EvilMonster extends Person {
    private Equipment treasure;
    private Name name;
    private String type;
    private int status;

    public EvilMonster() {
        status = Config.ALIVE;
    }

    public EvilMonster(Equipment treasure, Name name, String type) {
        this();
        this.treasure = treasure;
        this.name = name;
        this.type = type;
    }

    public Equipment getTreasure() {
        return treasure;
    }

    public void setTreasure(Equipment treasure) {
        this.treasure = treasure;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
