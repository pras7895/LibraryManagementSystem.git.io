package com.pack;

import java.sql.Date;

public class IssuedBean {
private String CallNo,StudentName,Mobile,Returnstatus;
int StudentId;
Date date;
public IssuedBean() {
	super();
	// TODO Auto-generated constructor stub
}
public IssuedBean(String callNo, String studentName, int studentId, String mobile) {
	super();
	CallNo = callNo;
	StudentName = studentName;
	Mobile = mobile;
	StudentId = studentId;
}
public String getCallNo() {
	return CallNo;
}
public void setCallNo(String callNo) {
	CallNo = callNo;
}
public String getStudentName() {
	return StudentName;
}
public void setStudentName(String studentName) {
	StudentName = studentName;
}
public String getMobile() {
	return Mobile;
}
public void setMobile(String mobile) {
	Mobile = mobile;
}
public String getReturnstatus() {
	return Returnstatus;
}
public void setReturnstatus(String returnstatus) {
	Returnstatus = returnstatus;
}
public int getStudentId() {
	return StudentId;
}
public void setStudentId(int studentId) {
	StudentId = studentId;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}

}
