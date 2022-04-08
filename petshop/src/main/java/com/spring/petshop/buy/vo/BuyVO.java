package com.spring.petshop.buy.vo;

import org.springframework.stereotype.Component;

@Component("buyVO")
public class BuyVO {
	private int buyNo;			
	private String user_id;		// 사용자ID
	private String itemno;		// 상품번호
	private int b_amount;		// 수량
	
	private String u_name;		// 사용자이름
	private String i_name;
	private String i_price;		// 상품단가
	
	public BuyVO() {
		
	}

	public int getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getItemno() {
		return itemno;
	}

	public void setItemno(String itemno) {
		this.itemno = itemno;
	}

	public int getB_amount() {
		return b_amount;
	}

	public void setB_amount(int b_amount) {
		this.b_amount = b_amount;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getI_name() {
		return i_name;
	}

	public void setI_name(String i_name) {
		this.i_name = i_name;
	}

	public String getI_price() {
		return i_price;
	}

	public void setI_price(String i_price) {
		this.i_price = i_price;
	}

	
	
	
}
