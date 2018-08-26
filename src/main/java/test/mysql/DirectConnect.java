package test.mysql;

import java.sql.*;

/*
 *  1直接连接
 */

public class DirectConnect{
		public static void main(String[] args)  throws SQLException, ClassNotFoundException{
        String ssql ="SELECT * FROM book;";
		String addsql1="INSERT INTO book VALUES(1,'lisi')";
		String addsql2="INSERT INTO book VALUES(2,'wangwu')";
		String updatesql="UPDATE book SET name='zhangsan' WHERE id='2'";
		String delsql="DELETE FROM book WHERE id='1'";
		String url="jdbc:mysql://localhost:3306/cj?useSSL=true&verifyServerCertificate=false&useLegacyDatetimeCode=false&serverTimezone=GMT";
		String user="root";
		String password="root";
		//1.加载驱动程序
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				}
				catch(Exception ex){
					
				}
			//2.获取数据库连接
			Connection conn=DriverManager.getConnection(url, user, password);	
		 	
			//3.操作数据库，进行增删改查
		    DirectConnect.selConn(conn, ssql);//查询
		    updateConn(conn,addsql1);//增加
		    updateConn(conn,addsql2);//增加
		    System.out.println("增加后-------");
		    DirectConnect.selConn(conn, ssql);//查询
		    updateConn(conn,updatesql);//修改
		    System.out.println("修改后-------");
		    DirectConnect.selConn(conn, ssql);//查询
		    updateConn(conn,delsql);//删除
		    System.out.println("删除后-------");
		    DirectConnect.selConn(conn, ssql);//查询
		    
		    conn.close();
//		sta.executeUpdate(updatesql);//更新
//		sta.executeUpdate(delsql);//删除
//		
//		ResultSet rs=sta.executeQuery(ssql);		
//		//4.处理数据库返回的结果
//		while(rs.next()) {
//			System.out.println(rs.getString("id")+" "+rs.getString("name"));
//		}
//		
//		//5.关闭资源
//		rs.close();
//		sta.close();
//		conn.close();
	}
		
    public static void selConn(Connection conn,String sql) throws SQLException {
    	Statement sta = conn.createStatement();
    	ResultSet rs = sta.executeQuery(sql);
    	while (rs.next()) {
    		System.out.print("id:"+rs.getString("id")+";name:"+rs.getString("name")+"\n");
    		
    	}
    	
    	rs.close();   	
    	sta.close();
    }
    
    public static void updateConn(Connection conn,String sql) throws SQLException {
    	Statement sta = conn.createStatement();
    	sta.executeUpdate(sql);
   	
    	sta.close();
    }
    

}
