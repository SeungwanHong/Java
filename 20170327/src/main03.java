import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class main03 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//보조 스트림(버퍼)
		// => 주스트림을 보조해주는 스트림이다.
		// => 스트림에는 없는 여러가지 기능을 제공 해준다.
		// BufferedReader / InputStream
		// ByfferedWriter / OuputStream
		
		File file = new File("bufferedTest.txt");
		
		if(file.exists()){
			file.createNewFile();
		}
		
		//1) 주 스트림을 설정한다.
		FileWriter out = new FileWriter(file);
		//2) 보조 스트림을 만든다. 매개변수로 주수트림의 객체가 들어간다.
		BufferedWriter bufferwriter = new BufferedWriter(out);
		
		bufferwriter.write("Hello");		//char [] 버퍼를 만든다. 해당 문자열의 갯수만큼의 char형 배열을 만들고
											//해당 데이터를 복사한 후에 파일에 전송한다. \n또는 문자열이 끝난것을 기준으로
											//BufferedWrite에서 자동으로 배열을 만들어 낸다.
		bufferwriter.write("World");
		
		//보조스트림을 닫으면 주스트림은 자동으로 닫힌다.
		bufferwriter.close();
		System.out.println("프로그램 종료");
	}

}
