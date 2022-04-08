package com.spring.petshop.cart.vo;

import org.springframework.stereotype.Component;

@Component("cartVO")
public class CartVO {

	private int cartNo;			// 장바구니 번호
	private String user_id;		// 사용자ID
	private String itemno;		// 상품번호
	private int c_amount;		// 수량
	
	private String u_name;		// 사용자이름
	private String i_name;
	private int i_price;		// 상품단가
	private int money;			// 상품가격
	
	public CartVO() {}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
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

	public int getC_amount() {
		return c_amount;
	}

	public void setC_amount(int c_amount) {
		this.c_amount = c_amount;
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

	public int getI_price() {
		return i_price;
	}

	public void setI_price(int i_price) {
		this.i_price = i_price;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}