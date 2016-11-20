package term;


import java.sql.*;
import java.util.Scanner;

public class DB {

	public static void main(String[] args) throws SQLException {
		
		Connection con=null;//db����
		PreparedStatement stmt1=null;
		Statement stmt2=null;//���ǹ� ����
		PreparedStatement stmt3=null;
		PreparedStatement stmt4=null;
		ResultSet result=null;//��� Ŭ����
		String get_id="Ji-young",get_pwd="1111";

		
		try{
			Class.forName("com.mysql.jdbc.Driver");//mysql driver �θ�
			con=DriverManager.getConnection("jdbc:mysql://localhost/test","root","12345");
			//Ŀ�ؼ� ���� �ѱ�� Ŀ�ؼ� ����
			
					
			stmt2=con.createStatement();		
			String query="INSERT INTO SAYING(saying) VALUES('Have a good day!^---^')";
			stmt2.executeUpdate(query);//���� ���� (update,insert,delete)
			
			stmt3=con.prepareStatement("SELECT SAYING FROM SAYING");
			result=stmt3.executeQuery();//���� ����(select)
			
		
			while(result.next()){
				//���̺��� �� �޾ƿ���
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