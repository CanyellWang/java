package com.zhao.esayui.domain;

import java.io.Serializable;

public class ResultEntity implements Serializable{
	private String status;//״̬0�ɹ�,1ʧ��
	private String msg;
	private Object data;//Ҫ����ȥ������
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
