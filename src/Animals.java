import java.util.ArrayList;
import java.util.List;

public class Animals {
    private String name;
    private String voice;

    public Animals() {

    }

    public Animals(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
