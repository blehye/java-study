package user;

import java.util.Scanner;

import game.GameManager;

public class User {
	private String userName = "기본닉네임";
	private int cash = 0;
	private int couponNum = 0;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getCash() {
		return cash;
	}


	public void setCash(int cash) {
		this.cash = cash;
	}


	public int getCouponNum() {
		return couponNum;
	}


	public void setCouponNum(int couponNum) {
		this.couponNum = couponNum;
	}

}
