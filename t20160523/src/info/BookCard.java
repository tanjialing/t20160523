package info;

import java.sql.Timestamp;

	import java.math.BigDecimal;
	import java.util.Date;

	/*
	 * �����ݿ��һ�£���Ϊһ��java����
	 * 1���������������ݿ���е�һ�м�¼
	 * 1�����Դ�����Ǳ��е�һ���ֶ�
	 */
	public class BookCard {
	    private int cid  ;
	    private String name;
	    private String sex ;
	    private Date cardDate;
	    private BigDecimal deposit;
	    
	    //����get()��set()����
	    public int getCid() {
	        return cid;
	    }
	    public void setCid(int cid) {
	        this.cid = cid;
	    }
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSex() {
	        return sex;
	    }
	    public void setSex(String sex) {
	        this.sex = sex;
	    }
	    public Date getCardDate() {
	        return cardDate;
	    }
	    public void setCardDate(Date cardDate) {
	        this.cardDate = cardDate;
	    }
	    public BigDecimal getDeposit() {
	        return deposit;
	    }
	    public void setDeposit(BigDecimal deposit) {
	        this.deposit = deposit;
	    }

	}
