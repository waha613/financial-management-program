package com.fms2.fms2.json;

public class ReturnJSONObject {
	protected Boolean success = false;
	protected Object errors;
	protected Object data;
	protected Object data1;
	protected Object data2;

	public Object getErrors() {
		return errors;
	}

	public void setErrors(Object errors) {
		this.errors = errors;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getData1() {
		return data1;
	}
	public void setData1(Object data1) {
		this.data1 = data1;
	}
	public Object getData2() {
		return data2;
	}
	public void setData2(Object data2) {
		this.data2 = data2;
	}
}
