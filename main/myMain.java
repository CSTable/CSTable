package main;

import Managable.Member;
import Menu.MainMenu;
import Managable.Menu;
import Managable.Reservation;
import mgr.Factory;
import mgr.Manager;
import java.util.Scanner;

public class myMain {
    static Scanner scan = new Scanner(System.in);
    public static Manager<Member> memberMgr = new Manager<>();
    public static Manager<Reservation> reservationMgr = new Manager<>();
    public static Manager<Menu> menuMgr = new Manager<>();

    private void run() {
        init();
        MainMenu mainMenu = new MainMenu(scan);
        mainMenu.menu();
    }

    public void init(){
        memberMgr.readAll("data/member.txt", new Factory<Member>() {
            @Override
            public Member create(Scanner scan) {
                return new Member();
            }
        });
        memberMgr.setMain(this);

        reservationMgr.readAll("data/reserve.txt", new Factory<Reservation>() {
            @Override
            public Reservation create(Scanner scan) {
                return new Reservation();
            }
        });
        reservationMgr.setMain(this);

        // TODO 메뉴는 수정해야함 임시임

        menuMgr.readAll("sampleData/chinese/chinese_all.txt", new Factory<Menu>() {
            @Override
            public Menu create(Scanner scan) {
                return new Menu();
            }
        });
        menuMgr.readAll("sampleData/western/western_all.txt", new Factory<Menu>() {
            @Override
            public Menu create(Scanner scan) {
                return new Menu();
            }
        });
//        menuMgr.readAll("menu.txt", new Factory<Menu>() {
//            @Override
//            public Menu create(Scanner scan) {
//                return new Menu();
//            }
//        });
        menuMgr.setMain(this);
    }

    public static void main(String[] args){
        myMain myMain = new myMain();
        myMain.run();

    }
}
