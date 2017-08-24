package vo;

public class Goods {
	private int goodsId;
	private String goodsName;
	private double goodsPrice;
	private String goodsPictureId;
	private String seller;
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Goods(int goodsId, String goodsName, double goodsPrice, String goodsPictureId, String seller) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsPictureId = goodsPictureId;
		this.setSeller(seller);
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsPictureId() {
		return goodsPictureId;
	}
	public void setGoodsPictureId(String goodsPictureId) {
		this.goodsPictureId = goodsPictureId;
	}


}
