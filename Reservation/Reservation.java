package Reservation;
import mgr.Manageable;
import mgr.Manager;

import java.util.Scanner;

public class Reservation implements Manageable {
	String reservationID; 	// 예약번호
	String name; 			// 예약자이름
	String id; 				// 예약자 ID
	String email; 			// 예약자 email
	String date; 			// 예약날짜
	int num; 				// 예약인원수
	String[] seat = new String[20]; //예약좌석
	static int nonMemberId = 0;
	public Reservation(){

	}
	public Reservation(String n){
		// n은 회원 비회원 구분을 위한 임의값 (임시)
		this.id = "B" + ++nonMemberId;
	}

	@Override
	public void read(Scanner scan) {
		// 텍스트 파일 읽을 때 쓰는 메소드
		reservationID = scan.next();
		name = scan.next();
		id = scan.next();
		email = scan.next();
		date = scan.next();
		num = scan.nextInt();

		for (int i = 0; i < num; i++)
			seat[i] = scan.next();
	}

	public void readNew(Scanner scan) {
		// 새로운 회원 가입 메소드
		System.out.print("이름을 입력해주세요: ");
		name = scan.next();
		System.out.print("이메일을 입력해주세요: ");
		email = scan.next();
		System.out.print("날짜을 입력해주세요: ");
		date = scan.next();
		System.out.print("인원을 입력해주세요: ");
		num = scan.nextInt();
		System.out.print("좌석을 입력해주세요(띄어쓰기로 구분): ");

		for (int i = 0; i < num; i++) {
			seat[i] = scan.next();
		}
	}

	@Override
	public void print() {
		System.out.format("예약번호: %s, 예약자명: [%s], 날짜: %s\n", reservationID, name, date);

		System.out.format("예약한 좌석(%d명): [", num);
		for (int i = 0; i < num; i++) {
			if (i > 0)
				System.out.print(", ");
			System.out.print(seat[i]);
		}
		System.out.println("]\n");
	}

	@Override
	public boolean matches(String searchword) {
		if (reservationID.contains(searchword))
			return true;
		if (name.contains(searchword))
			return true;
		if (id.contains(searchword))
			return true;
		if (email.contains(searchword))
			return true;
		return false;
	}

	public boolean matchnum(String num) {
		//예약번호 매치
		if (reservationID.equals(num))
			return true;
		return false;
	}
}
