package Restaurant;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;

public class Course implements Manageable {
    String name;
    int price;
    ArrayList<String> menus = new ArrayList<>();
    //메뉴는 나중에 Managerable로 변경하여 구현
    @Override
    public void read(Scanner scan) {
        name = scan.next();
        price = scan.nextInt();
        scan.nextLine();
        while (true){
            String next = scan.nextLine();
            if (next.equals("0")) return;
            menus.add(next);
        }
    }

    @Override
    public boolean matches(String kwd) {
        // TODO not yet
        return false;
    }

    @Override
    public void print() {
        System.out.printf("코스 이름 : %s [%d원]\n", name, price);
        for (String menu : menus){
            System.out.printf("\t%s\n", menu);
        }
    }
}
