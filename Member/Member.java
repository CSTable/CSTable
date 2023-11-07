package Member;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;
import mgr.MemberSpecific;

public class Member implements Manageable, MemberSpecific{
	String name;
	String birth;
	String id;
	String password;
	String email;
	ArrayList<String> code = new ArrayList<>();
	int point;


	@Override
	public void read(Scanner scan) {
		name = scan.next();
		birth = scan.next();
		id = "A" + scan.next();
		password = scan.next();
		email = scan.next();
		while(true) {
			String input = scan.next();
			if(input.equals("0")) break;
			code.add(input);
		}
	}

	@Override
	public boolean matches(String kwd) {
		if(email.equals(kwd))
			return true;
		return false;
	}

	@Override
	public void print() {
		if(code.size()==0) System.out.printf("이름 : %s\n생년월일 : %s\n아이디 : %s\n"
				+ "비밀번호 : %s\n이메일 : %s\n예약정보 : [없음]\n", name, birth, id, password, email);
		else System.out.printf("이름 : %s\n생년월일 : %s\n아이디 : %s\n"
				+ "비밀번호 : %s\n이메일 : %s\n예약정보 : %s\n", name, birth, id, password, email, code);
	}
	
	
	@Override
	public boolean matchesId(String kwd) {
		if(id.equals(kwd))
			return true;
		return false;
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
