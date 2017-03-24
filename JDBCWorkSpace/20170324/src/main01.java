import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class main01 {
	
	final static int WRITE = 1;
	final static int CHECK = 2;
	final static int JOIN = 3;
	final static int EXIT = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		
		final String DB_url = "jdbc:oracle:thin:@localhost:1521:orcl";
		final String DB_user = "hsw";
		final String DB_password = "hsw";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("���̺귯�� �ε� �Ϸ�");

			conn = DriverManager.getConnection(DB_url,DB_user,DB_password);
			System.out.println("���� ����");
			
			
			while(menu != EXIT){
				System.out.println("1. �Խñ� �ۼ� /2. �Խñ� Ȯ��/ 3.ȸ������ /4. ����");
				menu = sc.nextInt();
				sc.nextLine();
				switch(menu){
				case WRITE:
					System.out.println("�Խñ� �ۼ� ");
					String title;
					String contents;
					System.out.print("���� : ");
					title = sc.nextLine();
					System.out.print("����: ");
					contents = sc.nextLine();
					//���� ó�� insert
					sql ="INSERT INTO TB_BOARD_DEMO(BINDX,TITLE,CONTENTS,USERID,WRITEDATE,MODDATE) "
							+ "VALUES(BOARD_SEQ.NEXTVAL,?,?,'test2',SYSDATE,SYSDATE)";
						
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, title);
					pstmt.setString(2, contents);
					//���� ó��
					if(pstmt.executeUpdate()==1){
						System.out.println("�ۼ��Ϸ�");
					}else{
						System.out.println("�ۼ��ȵ�");
					}
					break;
				case CHECK:
					System.out.println("�Խñ� Ȯ�� ");
					//���� ó�� select
					sql ="SELECT * "
						+ "FROM TB_BOARD_DEMO "
						+ "where userid ='test2'";
					
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					while(rs.next()){
						String bindx = rs.getString("BINDX");
						String chktitle = rs.getString("TITLE");
						String chkcontents = rs.getString("CONTENTS");
						String wdate = rs.getString("WRITEDATE");
						String mdate = rs.getString("MODDATE");
						int cnt = rs.getInt("HITCNT");
						System.out.println(bindx+"/"+chktitle+"/"+chkcontents+"/"+wdate+"/"+mdate+"/"+cnt);
					}
					//cnt ++
					
					break;
				case JOIN:
					System.out.println("ȸ������");
					String userid;
					String userpw;
					String username;
					String email;
					System.out.print("id : ");
					userid = sc.nextLine();
					System.out.print("password: ");
					userpw = sc.nextLine();
					System.out.print("username : ");
					username = sc.nextLine();
					System.out.print("email: ");
					email = sc.nextLine();
					//���� ó�� insert
					sql ="INSERT INTO TB_USER(USERID,USERPW,USERNAME,EMAIL,JOINDATE) "
							+ "VALUES(?,?,?,?,SYSDATE)";
						
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, userid);
					pstmt.setString(2, userpw);
					pstmt.setString(3, username);
					pstmt.setString(4, email);
					//���� ó��
					if(pstmt.executeUpdate()==1){
						System.out.println("���� ����");
					}else{
						System.out.println("���� ����");
					}
					break;
				case EXIT:
					System.out.println("���� ");
					rs.close();
					pstmt.close();
					conn.close();
					break;
				}
			}
			
			
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("���̺귯�� �ε� ����");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("���� ����");
		}
		
		
	}

}