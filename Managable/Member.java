package Managable;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;
import mgr.MemberSpecific;

public class Member implements Manageable, MemberSpecific{
	String name;		// 이름
	String birth;		// 생년월일
	String gender;		// 성별
	String phoneNumber;	// 전화번호
	int point; 			// 포인트(소수점 버림)
	ArrayList<Reservation> reservations;	// 예약 정보
	ArrayList<String> allergy; 	// 알레르기 목록
	ArrayList<String> preffedIng; 	// 선호 식재료 목록
	ArrayList<String> nPrefferedIng; 	// 비선호 식재료 목록

	String id;		// 아이디
	String password;	// 비밀번호
	String email;	// 이메일


	@Override
	public void read(Scanner scan) {
		// TODO 새로운 데이터 형식 맞춰서 작성
	}

	@Override
	public boolean matches(String kwd) {
		if(email.equals(kwd))
			return true;
		return false;
	}

	@Override
	public void print() {
		// TODO 새로운 데이터 형식 맞춰서 작성
	}
	
	

	public boolean findMemberById(String id) {
        return this.id.equals(id);
    }

	@Override
	public boolean matchesId(String kwd) {
		return id.equals(kwd);
	}

	@Override
	public boolean matchesPassword(String kwd) {
		if(password.equals(kwd))
			return true;
		return false;
	}

	@Override
	public void printId() {
		System.out.printf("당신의 Id는 %s 입니다.\n", id);
	}

	@Override
	public void printPassword() {
		System.out.printf("당신의 Password는 %s 입니다.\n", password);
	}
}
