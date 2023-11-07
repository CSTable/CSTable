package mgr;

import java.util.Scanner;

public interface Manageable {
	public void read(Scanner scan);
	public boolean matches(String kwd);
	public void print();
}
