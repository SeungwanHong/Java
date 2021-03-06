package kr.co.smh.vo.user;

//VO : Value Object 또는 Visual Object
// DAO가 데이터베이스에 접근해서 가지고온 데이터의 값을 저장할 용도로 사용한다.
// 어떠한 데이터를 가지고 올지 결정하고 VO를 작성하는 일을 모델링이라 한다.

public class LoginVO {
	
	private String userid;
	private String username;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "LoginVO [userid=" + userid + ", username=" + username + "]";
	}
	
}
