package com.mw.am.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class TaskDetail implements Serializable {

	private static final long serialVersionUID = 6566093118932419842L;

	int id;
	
	@SerializedName("task_id")
	int taskId;
	
	@SerializedName("serial_number")
	int serialNo;
	
	boolean powerOn;
	boolean dataWipe;
	boolean newSerialNo;
	boolean hdDestroyed;
	
	@SerializedName("product_type")
	String productType;
	
	String accessories;
	String barCode;
	String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public boolean isPowerOn() {
		return powerOn;
	}

	public void setPowerOn(boolean powerOn) {
		this.powerOn = powerOn;
	}

	public boolean isDataWipe() {
		return dataWipe;
	}

	public void setDataWipe(boolean dataWipe) {
		this.dataWipe = dataWipe;
	}

	public boolean isNewSerialNo() {
		return newSerialNo;
	}

	public void setNewSerialNo(boolean newSerialNo) {
		this.newSerialNo = newSerialNo;
	}

	public boolean isHdDestroyed() {
		return hdDestroyed;
	}

	public void setHdDestroyed(boolean hdDestroyed) {
		this.hdDestroyed = hdDestroyed;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getAccessories() {
		return accessories;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
