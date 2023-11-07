package Restaurant;

import main.myMain;
import mgr.Manager;

import java.util.ArrayList;
import java.util.Scanner;

public class RestaurantMenu {
    Scanner scan = null;
    Manager<Restaurant> restaurantMgr = myMain.restaurantMgr;

    public RestaurantMenu(Scanner scan) {
        this.scan = scan;
    }

    public void run() {
        int menu;
        while (true) {
            System.out.println("(1)음식점 목록 출력 (2) 음식점 자세히 조회 (기타) 종료");
            System.out.print(">> ");
            menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    printRestaurantName();
                }
                case 2 -> {
                    seeDetail();
                }
                default -> {
                    return;
                }
            }
        }
    }

    private void seeDetail() {
        while (true) {
            System.out.print("음식점 이름을 입력하세요 \n >>");
            String inp = scan.next();
            ArrayList<Restaurant> resList = restaurantMgr.matches(inp);
            if (resList.isEmpty()) {
                System.out.println("없는 이름입니다.");
            }else{
                for(Restaurant res:resList)
                    res.print();
                break;
            }
        }
    }

    private void printRestaurantName() {
        for (Restaurant restaurant : restaurantMgr.manageableList)
            System.out.println(restaurant.name);
    }


//    private void reservationRestaurant() {
//        Restaurant nowRes = null;
//        while (true){
//            System.out.println("예약할 식당의 이름을 입력하세요 : ");
//            String rest = scan.nextLine();
//            for (Restaurant restaurant: restaurantMgr.manageableList){
//                // 식당 찾음. 임시. 여러 변수 고려하지 않음/
//                if (restaurant.matches(rest)){
//                    nowRes = restaurant;
//                }
//            }
//            if (nowRes != null){
//                break;
//            }
//        }
//
//        System.out.print("예약 가능한 시간 : ");
//        for(int i = 0; i < nowRes.availableTime.size(); i++){
//            System.out.printf("(%d) %s\n", i + 1, nowRes.availableTime.get(i));
//        }
//
//        System.out.println("예약하고 싶은 시간의 숫자를 입력하세요.\n>>");
//        int resTime = -1;
//        while (true){
//            resTime = scan.nextInt();
//            if (resTime < 0 || resTime > nowRes.availableTime.size() + 1)
//                System.out.println("다시 입력하세요. \n>>");
//            else break;
//        }
//        String nowTime = nowRes.availableTime.get(resTime);
//        nowRes.availableTime.remove(resTime);
//        nowRes.reservedTime.add(nowTime);
//        System.out.printf("%s 식당 %s 시간이 예약되었습니다.\n", nowRes.name, nowTime);
//    }
}
