public class Operation {
    private String name;
    private int status;
    private int type;

    public Operation() {
        status = Config.UNUSED;
    }

    public Operation(String name, int type) {
        this();
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStrAfterName(String str) {
        name += " " + str;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
