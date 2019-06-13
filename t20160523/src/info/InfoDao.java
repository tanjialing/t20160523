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
	}//һ��Ҫдset����

	public int addInfo(Info info) throws Exception {
/*		// ��һ������������������jar���������classpath�У�
		Class.forName("com.mysql.jdbc.Driver");
		// �ڶ������������ӣ�����ʵ������滻���ݿ��������ַ���˿ںš����ݿ�������¼�������룩
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", "ailab3313");
		System.out.println("��ǰ���ӵ������ݿ�=" + conn.getCatalog());// �鿴��ǰ���ӵ������ݿ���
		// ������������Statement����
		Statement stmt = conn.createStatement();// ֻ���Ľ����
		// ���Ĳ���ִ�в�������ɾ�Ĳ飩

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String sql = "insert info values(null,'" + info.getTitle() + "','"
				+ info.getContents() + "','" + ts + "')";
		System.out.println(sql);
		int line = stmt.executeUpdate(sql);
		// int rs = stmt.executeUpdate("insert into student value(5,2,'3')");

		// ���岽���ر�����
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
		// ��һ������������������jar���������classpath�У�
		Class.forName("com.mysql.jdbc.Driver");
		// �ڶ������������ӣ�����ʵ������滻���ݿ��������ַ���˿ںš����ݿ�������¼�������룩
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", ""); //rootΪ�û����������
		System.out.println("��ǰ���ӵ������ݿ�=" + conn.getCatalog());// �鿴��ǰ���ӵ������ݿ���
		// ������������Statement����
		Statement stmt = conn.createStatement();// ֻ���Ľ����
		// ���Ĳ���ִ�в�������ɾ�Ĳ飩
		String sql = "select * from info where id= "+infoId;
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
	
		Info info = new Info();
		while(rs.next()){
			info.setId(rs.getInt("���ߺ�"));
			info.setContents(rs.getString("��������"));
		//	info.setTitle(rs.getString("title"));
		//	info.setTs(rs.getTimestamp("time"));
		}
		
		// ���岽���ر�����
		conn.close();

		return info;
	}
	
	public int updateInfo(Info info) throws Exception {
		// ��һ������������������jar���������classpath�У�
		Class.forName("com.mysql.jdbc.Driver");
		// �ڶ������������ӣ�����ʵ������滻���ݿ��������ַ���˿ںš����ݿ�������¼�������룩
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=utf-8",
						"root", "");
		System.out.println("��ǰ���ӵ������ݿ�=" + conn.getCatalog());// �鿴��ǰ���ӵ������ݿ���
		// ������������Statement����
		Statement stmt = conn.createStatement();// ֻ���Ľ����
		// ���Ĳ���ִ�в�������ɾ�Ĳ飩

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String sql = "update info set title= '" + info.getTitle() + "',contents='"
				+ info.getContents() + "',time='"+ts+"' where id="+info.getId();
		System.out.println(sql);
		int line = stmt.executeUpdate(sql);
		// int rs = stmt.executeUpdate("insert into student value(5,2,'3')");

		// ���岽���ر�����
		conn.close();

		return line;
	}
}
