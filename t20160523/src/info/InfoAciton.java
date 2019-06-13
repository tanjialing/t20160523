package info;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InfoAciton extends ActionSupport {
	private String id, time, title, contents;
	private Info info;
	
	private InfoDao infoDao;
	
	public InfoDao getInfoDao() {
		return infoDao;
	}

	public void setInfoDao(InfoDao infoDao) {
		this.infoDao = infoDao;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String addInfo() throws Exception {
		/*System.out.println(title);
		System.out.println(contents);

		Info info = new Info();
		info.setTitle(title);
		info.setContents(contents);

		InfoDao infoDao = new InfoDao();
		*/
		info.setTs(new Timestamp(System.currentTimeMillis()));
		int flag = infoDao.addInfo(info);
		
		if (flag == 1)
			return "success";
		else
			return "fail";
	}

	public String updateInfo() throws Exception {
		InfoDao infoDao = new InfoDao();
		int flag = infoDao.updateInfo(info);

		if (flag == 1)
			return "success";
		else
			return "fail";

		
	}

	public String delInfo() throws Exception {

		return null;
	}

	public String infoShow() throws Exception {
		InfoDao infoDao = new InfoDao();
		Info info = infoDao.showInfo(Integer.parseInt(id));
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("info", info);
		return "infoShow";
	}
}
