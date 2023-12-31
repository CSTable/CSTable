package Menu;

import java.util.Scanner;

public class MainMenu {
    Scanner scan;


    public MainMenu(Scanner scan) {
        this.scan = scan;
    }

    public void menu() {
        System.out.printf("항목을 선택하세요.\n" +
                "(1) 회원 (2) 예약 (3) 음식점 (기타) 종료\n");
        int in = scan.nextInt();
        switch (in) {
            case 1 -> {
                memberMenu();
            }
            case 2 -> {
                reservationMenu();
            }
            default -> {
                System.exit(0);
            }
        }
    }

    private void memberMenu() {
        MemberMenu memberMenu = new MemberMenu(scan);
        memberMenu.run();
        menu();
    }

    private void reservationMenu() {
        ReservationMenu ReservationMenu = new ReservationMenu(scan);
        ReservationMenu.run();
        menu();
    }


}
