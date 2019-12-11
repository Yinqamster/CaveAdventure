import java.util.ArrayList;
import java.util.List;

public class Level {
    private String description;
    private List<Operation> operationList;
    private EvilMonster evilMonster;

    public Level() {
        operationList = new ArrayList<>();
    }

    public Level(String description, List<Operation> operationList, EvilMonster evilMonster) {
        this();
        this.description = description;
        this.operationList = operationList;
        this.evilMonster = evilMonster;
    }

    public Level(List<Operation> operationList, EvilMonster evilMonster) {
        this();
        this.operationList = operationList;
        this.evilMonster = evilMonster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public Operation getOperationByType(int type) {
        for(Operation operation : operationList) {
            if(operation.getType() == type) {
                return operation;
            }
        }

        return null;
    }

    public void setStatusByType(int type, int status) {
        for(Operation operation : operationList) {
            if(operation.getType() == type) {
                operation.setStatus(status);
            }
        }
    }

    public boolean isWin() {
        return getOperationByType(Config.ATTACK).getStatus() == Config.USED && getOperationByType(Config.PICKTREASURE).getStatus() == Config.USED;
    }

    public int checkSelection(int type) {
        switch (type){
            case Config.ATTACK:
                setStatusByType(type, Config.USED);
                System.out.println("You slayed the " + evilMonster.getType() + " and are sill alive, what would you like to do?");
                break;
            case Config.PICKTREASURE:
                setStatusByType(type, Config.USED);
                if(getOperationByType(Config.ATTACK).getStatus() == Config.UNUSED) {
                    System.out.println("You have picked up the " + evilMonster.getTreasure().getName() + ", now go rest before continuing the mission.");
                    for(int i = 0; i < CaveAdventure.animals.size(); i++) {
                        String name = CaveAdventure.animals.get(i).getName();
                        String voice = CaveAdventure.animals.get(i).getVoice();
                        System.out.println("Old MacDonald had a farm e-i-e-i-o, and on this farm he had a " + name + " e-i-e-i o, with a "+ voice + "-" + voice + " here and a "+ voice + "-" + voice + " there here a "+ voice + " there a "+ voice + " everywhere a "+ voice + "-" + voice + ". ");
                    }
                    System.out.println("Great! You are awake and rested what would you like to do?");
                }
                else {
                    System.out.println("You have picked up the " + evilMonster.getTreasure().getName() + " and are still alive, what would you like to do?");
                }
                break;
            case Config.PICKTRICK:
                setStatusByType(type, Config.USED);
                Penance penance = CaveAdventure.penances.get(Util.getRandom(CaveAdventure.penances.size()));
                System.out.println("They tricked you into picking up a second treasure, your penance is to " + penance.getDescription() + ".");
                Penance.getPenance(penance.getDescription());
                break;
            case Config.MOVENEXT:
                if(isWin()) {
                    System.out.print("Great! ");
                    return Config.NEXTLEVEL;
                }
                else {
                    System.out.println("You haven't finished all the missions!");
                    break;
                }
            default:
                break;

        }
        return Config.CONTINUE;
    }

    public List<Operation> selectOperation() {
        List<Operation> result = new ArrayList<>();
        if(getOperationByType(Config.ATTACK).getStatus() == Config.UNUSED
        && getOperationByType(Config.PICKTREASURE).getStatus() == Config.UNUSED) {
            result.add(getOperationByType(Config.ATTACK));
            result.add(getOperationByType(Config.PICKTREASURE));
        }
        else {
            for(Operation operation: operationList) {
                if(operation.getStatus() == Config.UNUSED) {
                    result.add(operation);
                }
            }
            if(result.size() == 3) {
                for(Operation o : result) {
                    if(o.getType() == Config.MOVENEXT) {
                        result.remove(o);
                    }
                }
            }
        }
        return result;
    }
}
