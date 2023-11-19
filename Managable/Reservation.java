package Managable;
import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;

import static main.myMain.memberMgr;
import static main.myMain.reservationMgr;

public class Reservation implements Manageable {

	String reservationID; 	// 예약번호
	Member rMember; // 예약한 회원
	String date; 			// 예약날짜
	int num; 				// 예약인원수
	ArrayList<String> seat = new ArrayList<>(); //예약좌석
	static int reservationNum = 0;

	@Override
	public void read(Scanner scan) {
		// txt 데이터 읽는 메소드
		// TODO 새로운 데이터 형식 맞춰서 작성

	}

	public void newReservation(Scanner scan){
		String inp;
		System.out.print("예약 회원 아이디 입력>>");
		while(true){
			inp = scan.next();
			for(Member member: memberMgr.manageableList){
				if(member.findMemberById(inp)){
					rMember = member;
					break;
				}
			}
			if (rMember != null) break;
			System.out.println();
			System.out.print("없는 아이디입니다. 다시 입력해주세요 >>");
		}
		System.out.println();

		System.out.print("예약 일시 입력(예시-230101)>>");
		date = scan.next();

		System.out.print("예약 인원수>>");
		num = scan.nextInt();

		for(int i = 1; i < num + 1; i++){
			System.out.printf("예약 좌석(%d번째)>>", i);
			seat.add(scan.next());
		}

		reservationID = Integer.toString(++reservationNum);

		// TODO 음식 메뉴 고르는 것도 만들어야함
	}


	public void cancel(Reservation reservation){
		reservationMgr.remove(reservation);
	}

	public boolean MatchByMember(Member member){
        return rMember == member;
    }

	@Override
	public void print() {
		// TODO 새로운 데이터 형식 맞춰서 작성

//		System.out.format("예약번호: %s, 예약자명: [%s], 날짜: %s\n", reservationID, name, date);
//
//		System.out.format("예약한 좌석(%d명): [", num);
//		for (int i = 0; i < num; i++) {
//			if (i > 0)
//				System.out.print(", ");
//			System.out.print(seat[i]);
//		}
//		System.out.println("]\n");
	}

	@Override
	public boolean matches(String searchword) {
//		if (reservationID.contains(searchword))
//			return true;
//		if (name.contains(searchword))
//			return true;
//		if (id.contains(searchword))
//			return true;
//		if (email.contains(searchword))
//			return true;
		return false;
	}

	public boolean matchId(String num) {
		//예약번호 매치
		if (reservationID.equals(num))
			return true;
		return false;
	}
}
