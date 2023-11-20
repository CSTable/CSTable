package Managable;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static main.myMain.allergyList;

public class Menu implements Manageable {
    String name;           // 이름
    ArrayList<String> ingredient = new ArrayList<>();      // 재료
    ArrayList<String> allergy = new ArrayList<>();  //알러지 정보
    String countryCategory; // 한중일양식
    String courseCategory;  // 5가지 코스 중
    int price;  // 가격

    @Override
    public void read(Scanner scan) {
        String nextLine = scan.nextLine();
        List<String> tokens = Arrays.asList(nextLine.split(" "));
        name = tokens.get(0);
        countryCategory = tokens.get(1);
        courseCategory = tokens.get(2);
        price = Integer.parseInt(tokens.get(3));
        for (int i = 4; i < tokens.size(); i++) {
            String nowIng = tokens.get(i);
            ingredient.add(nowIng);
        }
        for (String ing : ingredient)
            for (String allIng : allergyList)
                if (allIng.equals(ing))
                    allergy.add(ing);
    }

    @Override
    public boolean matches(String kwd) {
        // TODO 새로운 데이터 형식 맞춰서 작성
        return false;
    }

    @Override
    public void print() {
        System.out.printf("%s [%s] %s (%d원)\n", name, countryCategory, courseCategory, price);
        System.out.print("-식재료 : ");
        for (String str : ingredient)
            System.out.print(str + " ");
        System.out.println();

        System.out.print("-알러지 : ");
        for (String str : allergy)
            System.out.print(str + " ");
        System.out.println();
    }
}
