import java.util.*;

public class CaveAdventure extends LevelGame {

    private Knight knight;
    private List<EvilMonster> evilMonsters = new ArrayList<>();
    private List<Level> levels = new ArrayList<>();
    public static List<Animals> animals = new ArrayList<>();
    public static List<Penance> penances = new ArrayList<>();

    public void init() {
        initLevel();
        initAnimal();
        initPenance();
    }

    public void initLevel() {
        Name name1 = new Name("Marcel");
        Equipment treasure1 = new Equipment("golden sword");
        Name name2 = new Name("Limpian");
        Equipment treasure2 = new Equipment("golden shield");
        Name name3 = new Name("DivaDon");
        Equipment treasure3 = new Equipment("golden helmet");
        EvilMonster evilMonster1 = new EvilMonster(treasure1, name1, "evil goblin");
        EvilMonster evilMonster2 = new EvilMonster(treasure2, name2, "evil wombat");
        EvilMonster evilMonster3 = new EvilMonster(treasure3, name3, "hobgoblin lord");
        evilMonsters.add(evilMonster1);
        evilMonsters.add(evilMonster2);
        evilMonsters.add(evilMonster3);

        Operation operation1 = new Operation("Attack the evil goblin", Config.ATTACK);
        Operation operation2 = new Operation("Pick up the golden sword", Config.PICKTREASURE);
        Operation operation3 = new Operation("Move on to the next adventure", Config.MOVENEXT);
        List<Operation> operations1 = new ArrayList<>();
        operations1.add(operation1);
        operations1.add(operation2);
        operations1.add(operation3);
        Level level1 = new Level(operations1, evilMonster1);

        Operation operation4 = new Operation("Attack the evil wombat", Config.ATTACK);
        Operation operation5 = new Operation("Pick up the golden shield", Config.PICKTREASURE);
        List<Operation> operations2 = new ArrayList<>();
        operations2.add(operation4);
        operations2.add(operation5);
        operations2.add(operation3);
        Level level2 = new Level(operations2, evilMonster2);

        Operation operation7 = new Operation("Attack the hobgoblin lord", Config.ATTACK);
        Operation operation8 = new Operation("Pick up the golden helmet", Config.PICKTREASURE);
        List<Operation> operations3 = new ArrayList<>();
        operations3.add(operation7);
        operations3.add(operation8);
        operations3.add(operation3);
        Level level3 = new Level(operations3, evilMonster3);

        levels.add(level1);
        levels.add(level2);
        levels.add(level3);

        levels.get(Util.getRandom(3)).getOperationList().add(new Operation("Pick up the silver tray of life", Config.PICKTRICK));
        Collections.shuffle(levels);
        levels.get(0).setDescription("You are now entering the mouth of the cave, what would you like to do?");
        levels.get(0).getOperationList().get(0).addStrAfterName("and clean all the cob webs");
        levels.get(1).setDescription("You have ventured deeper into the cave, what would you like to do?");
        levels.get(1).getOperationList().get(0).addStrAfterName("and turn off the goblin's water supply");
        levels.get(2).setDescription("You have now reached the depths of the caves, what would you like to do?");
    }

    public void initAnimal() {
        for(int i = 0; i < Config.animalArray.length; i++) {
            animals.add(new Animals(Config.animalArray[i][0], Config.animalArray[i][1]));
        }
        Collections.shuffle(animals);
    }

    public void initPenance() {
        penances.add(new Penance(Config.SINGCHRISMAS));
        penances.add(new Penance(Config.MATHEQUATION));
        Collections.shuffle(penances);
    }




    public void run() {
        knight = new Knight();
        System.out.println("Cave Adventure!");
        System.out.print("Brave knight!!! What is your name? ");
        Scanner scanner = new Scanner(System.in);
        Name name = new Name(scanner.nextLine());
        knight.setName(name);
        System.out.println("We are in need of your help, " + knight.getName().getNickName() + "!");
        System.out.println("Our village is being overrun by the goblins of the NorthernCaves. We need you to defeat them!");
        System.out.print("Will you accept the challenge (Y/N)? ");
        String res = scanner.nextLine();
        while (!res.equals("Y")) {
            if(res.equals("N")) {
                System.out.print(".... Please, please help up brave knight, will you accept the challenge (Y/N)? ");
            }
            else {
                System.out.print("Will you accept the challenge (Y/N)? ");
            }
            res = scanner.nextLine();
        }
        System.out.print("Thank You Thank You Oh brave knight, are you ready to enter the mouth of the caves (Y/N)? ");
        res = scanner.nextLine();
        while (!res.equals("Y")) {
            if(res.equals("N")) {
                System.out.print(".... Please, please help up brave knight, are you ready to enter the mouth of the caves (Y/N)? ");
            }
            else {
                System.out.print("Thank You Thank You Oh brave knight, are you ready to enter the mouth of the caves (Y/N)? ");
            }
            res = scanner.nextLine();
        }

        for(Level level : levels) {
            System.out.println(level.getDescription());

            int op = Config.CONTINUE;
            while (op == Config.CONTINUE) {
                List<Operation> operations = level.selectOperation();
                for (int i = 0; i < operations.size(); i++) {
                    System.out.println((i+1) + ") " + operations.get(i).getName());
                }
                System.out.print(">> ");
                res = scanner.nextLine();
                while(!Util.isNumber(res)) {
                    System.out.print(">> ");
                    res = scanner.nextLine();
                }
                int choice = Integer.parseInt(res);
                while(!(choice >= 1 && choice <= operations.size())) {
                    System.out.print(">> ");
                    res = scanner.nextLine();
                    while(!Util.isNumber(res)) {
                        System.out.print(">> ");
                        res = scanner.nextLine();
                    }
                    choice = Integer.parseInt(res);
                }
                op = level.checkSelection(operations.get(choice-1).getType());
            }

        }


        //final mission
        System.out.print("Are you ready for the final mission (Y/N)? ");
        res = scanner.nextLine();
        while (!res.equals("Y")) {
            if(res.equals("N")) {
                System.out.print(".... Please, please help up brave knight, are you ready for the final mission (Y/N)? ");
            }
            else {
                System.out.print("Are you ready for the final mission (Y/N)? ");
            }
            res = scanner.nextLine();
        }
        System.out.println("The special character is " + Config.SPECIALWORD + ".");
        List<String> finalStr = new ArrayList<>();
        int index = 1;
        System.out.print("Village Idiot #" + index + ", what is your special word? ");
        res = scanner.nextLine();
        while(!res.equals(Config.SPECIALWORD)) {
            finalStr.add(res);
            index ++;
            System.out.print("Village Idiot #" + index + ", what is your special word? ");
            res = scanner.nextLine();
        }
        Collections.shuffle(finalStr);
        System.out.print("Poem: ");
        for(String s : finalStr) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Game over!");
    }


}
