import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

abstract class Player{
    private String name;
    private String initNumber;
    private List<String> fightList = new LinkedList<String>();
    private Boolean isEnd;
    public Player(String name, String initNumber) {
        this.name = name;
        this.initNumber = initNumber;
        this.isEnd = false;
    }
    public abstract void play(String number) throws Exception;
    public void addFightList(String number) { fightList.add(number); }
    public Boolean getIsEnd() { return isEnd; }
    public void setIsEnd(Boolean isEnd) { this.isEnd = isEnd; }
    public String getInitNumber() { return initNumber; }
    public String getName() { return name; }
    public void printFightList() {
        // TODO
    }
}
class PlayerATeam extends Player
{
    public PlayerATeam(String name, String number) {
        super(name, number);
    }

    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        int a = numbers.charAt(0);
        int b = numbers.charAt(1);
        int c = numbers.charAt(2);
        int d = numbers.charAt(3);

        for (int i=0; i<5; i++) {
            for (a in) {
                if (a == PlayerATeam.initNumber.charAt(i)) {
                    strike += 1;
                } else if (PlayerATeam.initNumber.contains("a")) {
                    ball += 1;
                } else {
                    out += 1;
                }
            }
        }

        if(strike == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+strike+", Ball :"+ball+", Out: "+out);
        }
    }
}

class PlayerBTeam extends Player
{
    public PlayerBTeam(String name, String number) {
        super(name, number);
    }
    @Override
    public void play(String number) throws Exception {
        int strike = 0;
        int ball = 0;
        int out = 0;

        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        int a = numbers.charAt(0);
        int b = numbers.charAt(1);
        int c = numbers.charAt(2);
        int d = numbers.charAt(3);

        for (int i=0; i<5; i++) {
            for (a in) {
                if (a == PlayerBTeam.initNumber.charAt(i)) {
                    ball += 1;
                } else if (PlayerBTeam.initNumber.contains("a")) {
                    strike += 1;
                } else {
                    out += 1;
                }
            }
        }

        if(ball == 4) {
            System.out.println("Congratulation!");
            super.setIsEnd(true);
        } else {
            System.out.println("Strike : "+ball+", Ball :"+strike+", Out: "+out);
        }
    }
}

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Player playerArray[] = {new PlayerATeam("A Team","1234"), new PlayerBTeam("B Team","5678")};
        int checkPlayer = 0;

        while(true) {
            checkPlayer = 0;
            for(Player player : playerArray) {
                if (player.getIsEnd() == false) {
                    System.out.print("Please enter a 4 digit number (" + player.getName() + ") defence : ");
                    String number = scanner.nextLine();
                    try {
                        player.play(number);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    checkPlayer++;
                }
            }
            if(checkPlayer == playerArray.length) break;
        }

        for(Player player : playerArray) {
            player.printFightList();
        }
    }
}