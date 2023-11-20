package Menu;

import java.util.ArrayList;
import java.util.Scanner;

import Managable.Reservation;
import main.myMain;

public class ReservationMenu {
    Scanner scan;

    public ArrayList<Reservation> reserveList = myMain.reservationMgr.manageableList;


    public ReservationMenu(Scanner scan) {
        this.scan = scan;
    }


    public void run() {
        int menu;
        while (true) {
            System.out.println("(1)예약하기 (3)예약조회 (4)예약취소 (5)전체예약보기(관리자) (기타) 종료");
            System.out.print(">> ");
            menu = scan.nextInt();
            switch (menu) {
                case 1 -> {
                    newReservation();
                }
                case 2 -> {
                    run();
                }
                case 3 -> {
                    searchReservation();
                }
                case 4 -> {
                    cancelReservation();
                }
                case 5 -> {
                    printReservation();
                }
                default -> {
                    return;
                }
            }
        }
    }

    private void newReservation() {
        System.out.println("(1) 회원 예약 (2) 비회원 예약");
        int isMember = scan.nextInt();
        // TODO 관련 기능 미구현, 추후 기존 회원 객체 연결 또는 새로운 회원 가입 기능 필요
    }

    private void searchReservation() { // 예약 검색
        String word;
        while (true) {
            System.out.print("회원이름, 아이디, 이메일, 예약번호로 검색 가능합니다.(종료: end): ");
            word = scan.next();
            if (word.equals("end"))
                break;
            for (Reservation re : reserveList)
                if (re.matches(word)) {
                    re.print();
                }
        }
    }

    private void cancelReservation() { // 예약 취소
        String word;
//        Iterator<Reservation> iterator = reserveList.iterator();
//        while (true) {
//            System.out.print("취소하실 예약의 예약번호을 입력해주세요.(종료: end): ");
//            word = scan.next();
//            if (word.equals("end"))
//                break;
//            while (iterator.hasNext()) {
//                Reservation re = iterator.next();
//                if (re.matchnum(word)) {
//                    iterator.remove(); // Iterator를 사용하여 요소를 삭제
//                }
//            }
//        }
    }

    private void printReservation() { // 예약 전체 출력
        for (Reservation re : reserveList)
            re.print();
    }

}
