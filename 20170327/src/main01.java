import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public class main01 {
	public static void main(String[] args) throws IOException {
		//1)file class
		// => 디스크상에 존재하는 파일을 다루기 위한 클래스
		//				file의 경로
		File file = new File("test.txt");
		
		//만약에 파일이 존재하지 않으면
		//file.exists() => 파일이 존재하면 true, 존재하지 않으면 false
		if(file.exists()){
			System.out.println("파일이 존재하지 않습니다.");
			file.createNewFile();		//파일을 새로 만든다.
		}
		//1) 목적지 : file -> test.txt에다가
		//2) 데이터를 출력 할거다.(write, outputStream)
		
		//byte 전용
		//OutputStream
		
		//파일(file)에 텍스트 형태의 데이터를 출력하기 위해서
		//Writer 객체를 만든다. 1,2)단계 동시에 수행
		//무엇을						목적지
		Writer out = new FileWriter(file,true);
		
		//목적지에 데이터 전송(write라는 메소드 활용)
		//Input 이후 확인 ㅌ내부적으로 한글자씩 옮긴다.
		out.write("ABCD\n");
		out.write("안녕히 가세요\n");
		
		//목적지와 무엇을 할건지 설정이 완료되면 바로 닫아준다.
		out.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
}
