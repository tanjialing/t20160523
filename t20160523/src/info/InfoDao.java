package info;

import java.sql.Connection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

public class InfoDao {
	
	private SessionFactory factory;	

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}//一定要写set方法

	public int addInfo(Info info) throws Exception {
/*		// 第一步：加载驱动（驱动jar包必须加入classpath中）
		Class.forName("com.mysql.jdbc.Driver");
		// 第二步：建立连接（根据实际情况替换数据库的主机地址、端口号、数据库明、登录名、密码）
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", "ailab3313");
		System.out.println("当前连接到的数据库=" + conn.getCatalog());// 查看当前连接到的数据库名
		// 第三步：创建Statement对象
		Statement stmt = conn.createStatement();// 只读的结果集
		// 第四步：执行操作（增删改查）

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String sql = "insert info values(null,'" + info.getTitle() + "','"
				+ info.getContents() + "','" + ts + "')";
		System.out.println(sql);
		int line = stmt.executeUpdate(sql);
		// int rs = stmt.executeUpdate("insert into student value(5,2,'3')");

		// 第五步：关闭连接
		conn.close();

		return line;*/
		
//		Session session = HibernateSessionFactory.getSession();
//		session.beginTransaction();
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		info.setTs(ts);
//
//		int line = (Integer) session.save(info);
//		
//		session.getTransaction().commit();
//		if (line > 0)
//			return 1;
//		else
//			return 0;
		Session session = factory.openSession();

		int line = (Integer) session.save(info);
		
		session.flush();

		if (line > 0)
			return 1;
		else
			return 0;

	}

	public Info showInfo(int infoId) throws Exception{
		// 第一步：加载驱动（驱动jar包必须加入classpath中）
		Class.forName("com.mysql.jdbc.Driver");
		// 第二步：建立连接（根据实际情况替换数据库的主机地址、端口号、数据库明、登录名、密码）
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", ""); //root为用户名，密码空
		System.out.println("当前连接到的数据库=" + conn.getCatalog());// 查看当前连接到的数据库名
		// 第三步：创建Statement对象
		Statement stmt = conn.createStatement();// 只读的结果集
		// 第四步：执行操作（增删改查）
		String sql = "select * from info where id= "+infoId;
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
	
		Info info = new Info();
		while(rs.next()){
			info.setId(rs.getInt("读者号"));
			info.setContents(rs.getString("借书日期"));
		//	info.setTitle(rs.getString("title"));
		//	info.setTs(rs.getTimestamp("time"));
		}
		
		// 第五步：关闭连接
		conn.close();

		return info;
	}
	
	public int updateInfo(Info info) throws Exception {
		// 第一步：加载驱动（驱动jar包必须加入classpath中）
		Class.forName("com.mysql.jdbc.Driver");
		// 第二步：建立连接（根据实际情况替换数据库的主机地址、端口号、数据库明、登录名、密码）
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", "");
		System.out.println("当前连接到的数据库=" + conn.getCatalog());// 查看当前连接到的数据库名
		// 第三步：创建Statement对象
		Statement stmt = conn.createStatement();// 只读的结果集
		// 第四步：执行操作（增删改查）

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String sql = "update info set title= '" + info.getTitle() + "',contents='"
				+ info.getContents() + "',time='"+ts+"' where id="+info.getId();
		System.out.println(sql);
		int line = stmt.executeUpdate(sql);
		// int rs = stmt.executeUpdate("insert into student value(5,2,'3')");

		// 第五步：关闭连接
		conn.close();

		return line;
	}
}
