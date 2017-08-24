package vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Record {
	private int recordId;
	private String goodsName;
	private String buyerId;
	private String sellerId;
	private String time;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Record(int recordId, String goodsName, String buyerId, String sellerId) {
		super();
		this.recordId = recordId;
		this.goodsName = goodsName;
		this.buyerId = buyerId;
		this.sellerId = sellerId;	
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
