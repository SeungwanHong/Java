import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main09 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dataFile = new File("test2.txt");
		
		if(dataFile.exists()){
			FileInputStream in = new FileInputStream(dataFile);
			//기본 자료형태의 데이터를 읽어오기 위해 dataInputStream 필요
			DataInputStream dis = new DataInputStream(in);
			
			int int_data = dis.readInt();
			long long_data = dis.readLong();
			double double_data = dis.readDouble();
			String String_data = dis.readUTF();
			
			System.out.println(int_data);
			System.out.println(long_data);
			System.out.println(double_data);
			System.out.println(String_data);
			
			dis.close();
		}else{
			System.out.println("파일이 없습니다.");
		}
	}

}