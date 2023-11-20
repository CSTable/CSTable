package main;

import Managable.Member;
import Managable.Menu;
import Managable.Reservation;
import mgr.Factory;
import mgr.Manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class myMain {
    static Scanner scan = new Scanner(System.in);
    public static Manager<Member> memberMgr = new Manager<>();
    public static Manager<Reservation> reservationMgr = new Manager<>();
    public static Manager<Menu> menuMgr = new Manager<>();

    public static ArrayList<String> allergyList = new ArrayList<>();

    private void run() {
        init();
        menuMgr.printAll();
//        MainMenu mainMenu = new MainMenu(scan);
//        mainMenu.menu();
    }

    public void init(){
        allergyList = readAllergy("sampleData/allergy.txt");
//        memberMgr.readAll("data/member.txt", new Factory<Member>() {
//            @Override
//            public Member create(Scanner scan) {
//                return new Member();
//            }
//        });
//        memberMgr.setMain(this);
//
//        reservationMgr.readAll("data/reserve.txt", new Factory<Reservation>() {
//            @Override
//            public Reservation create(Scanner scan) {
//                return new Reservation();
//            }
//        });
//        reservationMgr.setMain(this);

        // TODO 메뉴는 수정해야함 임시임


        /*
        4가지 메뉴를 txt파일에 따라서 각각 가져옵니다
         */
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

        menuMgr.readAll("sampleData/korean/korean_all.txt", new Factory<Menu>() {
            @Override
            public Menu create(Scanner scan) {
                return new Menu();
            }
        });

        menuMgr.readAll("sampleData/japanese/japanese_all.txt", new Factory<Menu>() {
            @Override
            public Menu create(Scanner scan) {
                return new Menu();
            }
        });
        menuMgr.setMain(this);

    }

    ArrayList<String> readAllergy(String filepath){
        Scanner filein = openFile(filepath);
        ArrayList<String> allList = new ArrayList<>();
        while(filein.hasNext()) {
            allList.add(filein.next());
        }
        filein.close();
        return allList;
    }

    Scanner openFile(String filepath) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filepath));
        } catch (IOException e)
        {
            System.out.println("파일 입력 오류");
            System.exit(0);
        }
        return filein;
    }



    public static void main(String[] args){
        myMain myMain = new myMain();
        myMain.run();

    }
}
