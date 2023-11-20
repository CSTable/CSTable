package mgr;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import main.myMain;

import java.util.ArrayList;

public class Manager<T extends Manageable> {
	Scanner scan = new Scanner(System.in);
	myMain main = null;

	public ArrayList<T> manageableList = new ArrayList<>();
	
	public void printAll() {
		for(Manageable mgr : manageableList) {
			mgr.print();
			System.out.println();
		}
	}
	
	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T mgr = null;
		System.out.println(filename);
		while(filein.hasNext()) {
			mgr = fac.create(filein);
			mgr.read(filein);
			manageableList.add(mgr);
		}
		filein.close();
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e)
		{
			System.out.println("파일 입력 오류");
			System.exit(0);
		}
		return filein;
	}

	public ArrayList<T> matches(String kwd){
		ArrayList<T> returnList = new ArrayList<>();
		for (T t :manageableList){
			if(t.matches(kwd)) returnList.add(t);
		}
		return returnList;
	}

	public void remove(T delObj){
		for (T obj: manageableList){
			if (obj == delObj)
				manageableList.remove(delObj);
		}
	}

	public void setMain(myMain main){
		this.main = main;
	}
}
