package Restaurant;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant implements Manageable {
    String name; // 식당 이름
    String category; // 식당 카테고리 (일식, 한우 등)
    String location; // 식당 위치 (추후 세부 속성으로 나눌 수 있음)
    String rating; // 별점 몇 개인지 (나중에 리뷰를 만들어 추가해도 좋을듯
    String phoneNumber; // 식장 전화번호
    Manager<Course> courseMgr = new Manager<>();
    ArrayList<String> availableTime = new ArrayList<>(); // 예약 가능 시간
    ArrayList<String> reservedTime = new ArrayList<>(); //예약 된 시간

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        category = scan.next();
        location = scan.next();
        rating = scan.next();
        phoneNumber = scan.next();
        courseMgr.readAll(name+".txt", new Factory<Course>() {
            @Override
            public Course create(Scanner scan) {
                return new Course();
            }
        });

        while (true){
            String time = scan.next();
            if (time.equals("0")) break;
            availableTime.add(time);
        }
    }

    @Override
    public boolean matches(String kwd) {
        return name.equals(kwd);
    }

    @Override
    public void print() {
        System.out.printf("""
                [%s] %s (%s)
                별점 %s 전화번호 : %s
                
                """,
                name, category, location, rating, phoneNumber);
        System.out.print("예약 가능 시간 : ");
        for(String time : availableTime)
            System.out.print(time + " ");
        System.out.println();
        System.out.print("이미 예약된 시간 : ");
        for(String time : reservedTime)
            System.out.print(time + " ");
        System.out.println();
        System.out.println();

        courseMgr.printAll();
    }
}
