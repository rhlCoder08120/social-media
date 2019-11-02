package com.nirsb.social.media.socialmedia.exception;

import java.util.Date;

public class ExceptionRespnse {
private Date timeStamp;
private String message;
private String status;
private String path;
public ExceptionRespnse(Date timeStamp, String message, String status, String path) {
	super();
	this.timeStamp = timeStamp;
	this.message = message;
	this.status = status;
	this.path = path;
}
public Date getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(Date timeStamp) {
	this.timeStamp = timeStamp;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}

}
