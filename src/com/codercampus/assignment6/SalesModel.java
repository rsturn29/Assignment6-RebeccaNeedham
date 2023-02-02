package com.codercampus.assignment6;

import java.util.Date;

public class SalesModel {

	private Date date;
	private int sales;
	
	
	public SalesModel(Date date, int sales) {
		this.date =date;
		this.sales = sales;
	}

	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "SalesModel [date=" + date + ", sales=" + sales + "]";
	}
	
}
