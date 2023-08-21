package com.example.spring_controller_basic.dto;

public class ChatMessage {
	private String content;
    private String sendid;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSendid() {
		return sendid;
	}
	public void setSendid(String sendid) {
		this.sendid = sendid;
	}
	@Override
	public String toString() {
		return "ChatMessage [content=" + content + ", sendid=" + sendid + "]";
	}
}
