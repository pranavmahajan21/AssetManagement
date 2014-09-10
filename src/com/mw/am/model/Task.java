package com.mw.am.model;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Task implements Serializable {

	private static final long serialVersionUID = -4884958297063893829L;

	int id;

	@SerializedName("po_number")
	int poNumber;

	@SerializedName("serial_number")
	int serialNo;

	@SerializedName("transaction_id")
	int transactionId;

	@SerializedName("client_name")
	String clientName;
	
	@SerializedName("product_type")
	String productType;

	@SerializedName("department_name")
	String departmentName;

	String address;
	String city;
	String state;
	String zip;

	String email;

	@SerializedName("phone_number")
	String phoneNo;

	String url;

	@Override
	public String toString() {
		return "Task [id=" + id + ", poNumber=" + poNumber + ", serialNo="
				+ serialNo + ", transactionId=" + transactionId
				+ ", productType=" + productType + ", departmentName="
				+ departmentName + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zip=" + zip + ", email=" + email
				+ ", phoneNo=" + phoneNo + ", url=" + url + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

}
