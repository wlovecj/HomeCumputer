package test.mysql;

import java.sql.*;
import java.util.Scanner;

/**
 * @author 83889 1直接连接
 * 
 */

public class DirectConnect {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String url = "jdbc:mysql://localhost:3306/cj?useSSL=true&verifyServerCertificate=false&useLegacyDatetimeCode=false&serverTimezone=GMT";
		String user = "root";
		String password = "root";
		// 1.加载驱动程序
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception ex) {

		}
		// 2.获取数据库连接
		Connection conn = DriverManager.getConnection(url, user, password);

		// 3.操作数据库，进行增删改查
		DirectConnect.selConn(conn);
		updateConn(conn);
		DirectConnect.selConn(conn);

		conn.close();
	}

	public static void selConn(Connection conn) throws SQLException {
		// 获取查询id
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入查询id：");
		String bookInfo = sc.next();

		String sql = "SELECT * FROM book WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookInfo);
		ResultSet rs = ps.executeQuery();
		// 4.处理结果集
		while (rs.next()) {
			System.out.print("id:" + rs.getString("id") + ";name:" + rs.getString("name") + ";book_info:"
					+ rs.getString("book_info") + "\n");

		}
		// 5.关闭资源
		rs.close();
		ps.close();
	}

	public static void updateConn(Connection conn) throws SQLException {
		String add = "INSERT INTO book VALUES(?,?,?)";
		String update = "UPDATE book SET name=? WHERE id=?";
		String del = "DELETE FROM book WHERE id=?";

		Statement sta = conn.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入要操作的类型：");
		String str = sc.next();
		switch (str) {
		case "add":
			Scanner sc1 = new Scanner(System.in);
			System.out.print("请输入要增加的数据：");
			int int1 = sc.nextInt();
			String str2 = sc.next();
			String str3 = sc.next();
			PreparedStatement ps = conn.prepareStatement(add);
			ps.setInt(1, int1);
			ps.setString(2, str2);
			ps.setString(3, str3);
			ps.executeUpdate();
			System.out.println("执行新增操作成功");
			break;
		case "update":
			System.out.println("执行修改操作");
			break;
		case "delete":
			System.out.println("执行删除操作");
			break;
		default:
			System.out.println("请输入正确的操作类型");
			break;
		}

		sta.close();
	}

}
