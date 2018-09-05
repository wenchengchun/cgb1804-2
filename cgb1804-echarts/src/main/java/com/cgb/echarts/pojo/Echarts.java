package com.cgb.echarts.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="housesrc")
public class Echarts {
	@Id
	private Integer id;
	private Integer price;
	private String loc;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	@Override
	public String toString() {
		return "Echarts [id=" + id + ", price=" + price + ", loc=" + loc + "]";
	}
	

	
	
}
