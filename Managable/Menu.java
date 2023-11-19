package Managable;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Manageable {
    String name;           // 이름
    ArrayList<String> ingredient;      // 재료
    ArrayList<String> allergy;  //알러지 정보
    String countryCategory; // 한중일양식
    String courseCategory;  // 5가지 코스 중
    int price;  // 가격

    @Override
    public void read(Scanner scan) {
        name = scan.next();
        countryCategory = scan.next();
        courseCategory = scan.next();
        price = scan.nextInt();
        while(scan.hasNext())
            ingredient.add(scan.next());
        // TODO 알러지 정보 연결 필요
    }

    @Override
    public boolean matches(String kwd) {
        // TODO 새로운 데이터 형식 맞춰서 작성
        return false;
    }

    @Override
    public void print() {
        // TODO 새로운 데이터 형식 맞춰서 작성

    }
}
