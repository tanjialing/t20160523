package info;

import java.sql.Timestamp;

public class Info {

	private int id;
	private String title,contents;

	private Timestamp ts;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
}
