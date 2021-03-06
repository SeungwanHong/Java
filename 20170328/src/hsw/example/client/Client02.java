package hsw.example.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

//입력하면서 받을수 없으니깐 쓰래드 필요

public class Client02 {

	static final String HOST = "192.168.1.2";
	static final int PORT = 8080;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//클라이언트 서버 요청
		Socket socket = new Socket(HOST, PORT);
		//요청이 완료(서버에  접속이)되야 아래쪽 코드가 진행된다.
		
		System.out.println("[접속 성공]");
		System.out.print("닉네임 입력 : ");
		String nickname = sc.nextLine();
		
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		
		dos.writeUTF(nickname);
		
		dos.close();
		socket.close();
		
	}

}
