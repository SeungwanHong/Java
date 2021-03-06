/**

객체 설계 방법
 * 
 */
package example_class;

/**
 * @author bit
 *
 */
public class Person2 {
	//객체 설계 방법
	//(1)클래스를 만들 때는 항상 데이터부터
	// => 맴버변수 부터 만들자.
	private int age = 10;
	private String name = "A";
	private String job = "B";
	
	//(2)기능에 대한 정의
	// => 메소드 정의
	
	//1 매개변수 x 리턴값 x
	public void printPersonInfo(){
		System.out.println(age);
		System.out.println(name);
		System.out.println(job);
	}
	//2 매개변수 o 리턴값 x
	public void changePersonAge(int age){
		this.age = age;
		System.out.println("나이가 변경 되었습니다.");
	}
	//3 매개변수 x 리턴값 o
	public String getPersonName(){
		System.out.println("이름이 호출 되었습니다.");
		return name;
	}
	//4 매개변수o 리턴값 o
	public String changePersonJob(String job){
		this.job = job;
		System.out.println("직업이 변경 되었습니다.");
		return job;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getJob() {
		return job;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJob(String job) {
		this.job = job;
	}

		
	
	//1-2 맴버 변수에 대한 getter/setter의 정의
	// => 모든 클래스의 맴버변수는 private 형태로 정의가 되어야 하기 때문에(정보은닉 특성)
	//		내부에서만 접근 할 수가 있다.
	
	//필요에 따라서 외부에서 맴버변수에 접근을 하고자 getter와 setter를 정의한다.
	//getter : 외부에서 데이터를 얻는 기능
	//setter : 외부에서 데이터를 입력 받아 세팅 하는 기능
	
	//getter / setter를 이용함으로써 외부에서 맴버변수에 대한 접근을 제어 할 수 있다.
	//맴버변수의 값을 가지고 오게만 하고 싶다. => getter만 정의
	//맴버변수의 값을 세팅만 하게 하고 싶다. => setter만 정의
	///둘다 하고 싶다. => 둘다 정의(getter / setter);
	
	//모든 getter / setter는 public으로 지정 되어 진다.
	//코딩 규칙 get, set은 소문자 다음 맴버변수명 첫 철자는 대문자
	
	

	
	
}
