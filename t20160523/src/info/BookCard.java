package info;

import java.sql.Timestamp;

	import java.math.BigDecimal;
	import java.util.Date;

	/*
	 * 跟数据库表一致，作为一个java对象
	 * 1个对象代表的是数据库表中的一行记录
	 * 1个属性代表的是表中的一个字段
	 */
	public class BookCard {
	    private int cid  ;
	    private String name;
	    private String sex ;
	    private Date cardDate;
	    private BigDecimal deposit;
	    
	    //定义get()、set()方法
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
