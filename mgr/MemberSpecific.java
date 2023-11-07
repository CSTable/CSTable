package mgr;

public interface MemberSpecific {
	public boolean matchesId(String kwd);
	public boolean matchesPassword(String kwd);
	public void printId();
	public void printPassword();
}