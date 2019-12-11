public class Knight extends Person {

    private Operation operation;
    int status;

    public Knight() {
        status = Config.ALIVE;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
