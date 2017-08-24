package vo;

public class User {
	private String userAccount;
	private String password;
	private String nickname;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userAccount, String password, String nickname) {
		super();
		this.userAccount = userAccount;
		this.password = password;
		this.nickname = nickname;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
