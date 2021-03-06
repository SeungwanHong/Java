package hsw.example.server.thread;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ServerThread03 extends Thread{

	private Socket clientSocket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Map<String, DataOutputStream> mClientMap;

	private String clientKey="";
	private String nickName="";

	public ServerThread03(Socket clientSocket, Map<String, DataOutputStream> mClientMap){
		this.clientSocket = clientSocket;

		//클라이언트가 접속 할 때마다 Map에 등록 시킬것.
		this.mClientMap = mClientMap;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//접속한 클라이언트가 보내는 메세지를 받아내는 작업
			dis = new DataInputStream(clientSocket.getInputStream());
			//닉네임 받아오기
			nickName = dis.readUTF();
			//map의 키값 설정 (닉네임 + 아이피)
			clientKey = nickName + clientSocket.getInetAddress();
			//접속한 클라이언트에게 데이터를 전송하기 위한 DataOutputStream 생성
			dos = new DataOutputStream(clientSocket.getOutputStream());
			//접속한 클라이언트들에 대한 정보가 들어있는 map에 추가
			mClientMap.put(clientKey, dos);

			System.out.println(clientSocket + "["+ nickName+ "님 접속]");

			//클라이언트가 보내는 채팅매세지를 받아와야 한다.
			//클라이언트가 exit을 입력하면 방을 나가기(채팅 종료)

			String msg = "";

			while(!msg.toLowerCase().equals("exit")){
				//클라이언트가 메세지를 보내면 받는다.
				msg = dis.readUTF();
				//받아낸 메세지를 접속한 모든 사람에게 전송한다.
				sendBroadCasting(msg);
			}
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				mClientMap.remove(clientKey);
				dos.close();
				dis.close();
				clientSocket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//접속한 서버 입장에서, 모든 사람에게 데이터를 전송하는 방식 : BroadCasting
	//
	private void sendBroadCasting(String msg){
		Set<String> keyset = mClientMap.keySet();
		Iterator<String> keyIterator = keyset.iterator();
		
		while(keyIterator.hasNext()){
			String key = keyIterator.next();
			DataOutputStream tempDos = mClientMap.get(key);
			try {
				tempDos.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(key+"에게 메세지를 보내는 중에 에러 발생");
				mClientMap.remove(key);
			}
		}
	}

}
