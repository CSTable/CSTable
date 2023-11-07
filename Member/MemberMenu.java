package Member;

import java.util.ArrayList;
import java.util.Scanner;

import Reservation.Reservation;
import main.myMain;
import mgr.Manager;

public class MemberMenu {

    Scanner scan;
    public ArrayList<Member> memberList = myMain.memberMgr.manageableList;


    public MemberMenu(Scanner scan) {
        this.scan = scan;
    }


    public void run() {
        startMenu();
    }

    public void startMenu() {
        while (true) {
            System.out.print("(1) 로그인 (2) 아이디 찾기 (3) 비밀번호 찾기 (4) 전체 회원 조회(관리자) (기타) 종료\n>> ");
            int n = scan.nextInt();
            switch (n) {
                case 1 -> {
                    login();
                } //로그인
                case 2 -> {
                    memberFindId();
                } //ID 찾기
                case 3 -> {
                    memberFindPassword();
                } //비밀번호 찾기
                case 4 ->{
                    printAllMember();
                }
                default -> {
                    return;
                }
            }
        }
    }

    private void printAllMember() {
        myMain.memberMgr.printAll();
    }

    //예약 메뉴
    public void reservationMenu() {
        while (true) {
            System.out.print("(1) 예약하기 (2) 예약 조회 (3) 예약 취소 (4) 종료\n>> ");
            int n = scan.nextInt();
            if (n == 4) break;
            switch (n) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }

    //로그인
    private void login() {
        while (true) {
            System.out.print("ID 입력 >> ");
            String kwd = scan.next();
            if (kwd.equals("end")) return;
            for (Member member : memberList) {
                if (member.matchesId(kwd)) {
                    System.out.print("Password 입력 >> ");
                    kwd = scan.next();
                    if (member.matchesPassword(kwd)) {
                        System.out.println();
                        member.print();
                        System.out.println();
                        reservationMenu();
                        return;
                    }
                }
            }
            System.out.println("일치하지 않습니다.");
        }
    }

    //아이디 찾기
    private void memberFindId() {
        while (true) {
            System.out.print("Email 입력 >> ");
            String kwd = scan.next();
            if (kwd.equals("end")) return;
            for (Member member : memberList) {
                if (member.matches(kwd)) {
                    System.out.println();
                    member.printId();
                    System.out.println();
                    return;
                }
            }
            System.out.println("회원정보가 없습니다.");
        }
    }

    //비밀번호 찾기
    private void memberFindPassword() {
        while (true) {
            System.out.print("Email 입력 >> ");
            String kwd = scan.next();
            if (kwd.equals("end")) return;
            for (Member member : memberList) {
                if (member.matches(kwd)) {
                    System.out.print("ID 입력 >> ");
                    kwd = scan.next();
                    if (member.matchesId(kwd)) {
                        System.out.println();
                        member.printPassword();
                        System.out.println();
                        return;
                    }
                }
            }
            System.out.println("일치하지 않습니다.");
        }
    }
}
