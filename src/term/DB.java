package term;


import java.sql.*;
import java.util.Scanner;

public class DB {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;//db접속
		PreparedStatement stmt1=null;
		Statement stmt2=null;//질의문 실행
		PreparedStatement stmt3=null;
		PreparedStatement stmt4=null;
		ResultSet result=null;//결과 클래스
		String get_id="Ji-young",get_pwd="1111";

		
		try{
			Class.forName("com.mysql.jdbc.Driver");//mysql driver 부름
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","12345");
			//커넥션 정보 넘기며 커넥션 얻음
			
					
			stmt2=con.createStatement();		
			String query="INSERT INTO SAYING(saying) VALUES('Have a good day!^---^')";
			stmt2.executeUpdate(query);//쿼리 실행 (update,insert,delete)
			
			stmt3=con.prepareStatement("SELECT SAYING FROM SAYING");
			result=stmt3.executeQuery();//쿼리 실행(select)
			
		
			while(result.next()){
				//테이블에서 값 받아오기
				String saying=result.getString("saying");				
				System.out.println(saying);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(stmt1!=null)
				stmt1.close();
			if(con!=null)
				con.close();
			if(stmt2!=null)
				stmt2.close();
			if(result!=null)
				result.close();
		}		
		
		
	}


}