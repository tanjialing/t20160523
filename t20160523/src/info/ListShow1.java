package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ListShow1 extends TagSupport {
	private String DBTab = null; // 默认值：白色
	private String field = null; // 字体默认黑色
	private String showNum = null; // 默认居中
	private String linkTo, linkID, linkField;

	public String getLinkTo() {
		return linkTo;
	}

	public void setLinkTo(String linkTo) {
		this.linkTo = linkTo;
	}

	public String getLinkID() {
		return linkID;
	}

	public void setLinkID(String linkID) {
		this.linkID = linkID;
	}

	public String getLinkField() {
		return linkField;
	}

	public void setLinkField(String linkField) {
		this.linkField = linkField;
	}

	public String getDBTab() {
		return DBTab;
	}

	public void setDBTab(String dBTab) {
		DBTab = dBTab;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getShowNum() {
		return showNum;
	}

	public void setShowNum(String showNum) {
		this.showNum = showNum;
	}

	public int doStartTag() {
		try {
			JspWriter out = pageContext.getOut();
			// from DB get data
			// 第一步：加载驱动（驱动jar包必须加入classpath中）
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
			String sql = "select ";
			String[] field1 = field.split(",");
			for (String f : field1) {
				sql = sql + f + ",";
			}
			sql = sql.substring(0, sql.length() - 1);
			sql = sql + " from " + DBTab + " limit " + showNum;

			ResultSet rs = stmt.executeQuery(sql);
			out.print("<table>");
			int i = 0;
			while (rs.next()) {
				// tr td
				out.print("<tr>");
				for (String f : field1) {
					if (f.equals(linkField)) {
						out.print("<td><a href='" + linkTo + "?" + linkID + "="
								+ rs.getInt(linkID) +"'>"+ rs.getString(f));
						out.print("</a></td>");
					} else {
						out.print("<td>" + rs.getString(f));
						out.print("</td>");
					}
				}
				out.print("</tr>");
				i++;
			}
			// 第五步：关闭连接
			conn.close();
		} catch (Exception e) {
			System.out.println("Error in doStartTag of Myfont Handler Class: "
					+ e);
		}
		return (EVAL_BODY_INCLUDE);
	}

	public int doEndTag() {
		try {
			JspWriter out = pageContext.getOut();
			out.print("</table>");
		} catch (Exception e) {
			System.out.println("Error in doEndTag of Myfont Handler Class: "
					+ e);
		}
		return (EVAL_PAGE);
	}
}