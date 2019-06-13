package info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public class ListShow1 extends TagSupport {
	private String DBTab = null; // Ĭ��ֵ����ɫ
	private String field = null; // ����Ĭ�Ϻ�ɫ
	private String showNum = null; // Ĭ�Ͼ���
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
			// ��һ������������������jar���������classpath�У�
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
			// ���岽���ر�����
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