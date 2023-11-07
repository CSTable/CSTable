package main;

import Member.Member;
import Menu.MainMenu;
import Reservation.Reservation;
import Restaurant.Restaurant;
import mgr.Factory;
import mgr.Manager;
import java.util.Scanner;

public class myMain {
    static Scanner scan = new Scanner(System.in);
    public static Manager<Member> memberMgr = new Manager<>();
    public static Manager<Reservation> reservationMgr = new Manager<>();
    public static Manager<Restaurant> restaurantMgr = new Manager<>();

    private void run() {
        init();
        MainMenu mainMenu = new MainMenu(scan);
        mainMenu.menu();
    }

    public void init(){
        memberMgr.readAll("member.txt", new Factory<Member>() {
            @Override
            public Member create(Scanner scan) {
                return new Member();
            }
        });
        memberMgr.setMain(this);

        reservationMgr.readAll("reserve.txt", new Factory<Reservation>() {
            @Override
            public Reservation create(Scanner scan) {
                return new Reservation();
            }
        });
        reservationMgr.setMain(this);

        restaurantMgr.readAll("restaurant.txt", new Factory<Restaurant>() {
            @Override
            public Restaurant create(Scanner scan) {
                return new Restaurant();
            }
        });
        restaurantMgr.setMain(this);
    }

    public static void main(String[] args){
        myMain myMain = new myMain();
        myMain.run();

    }
}
