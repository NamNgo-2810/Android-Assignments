package com.hust.emailinterface;

public class EmailItem {
    String sender, content, time;

    public String getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public EmailItem(String sender, String content, String time) {
        this.sender = sender;
        this.content = content;
        this.time = time;
    }
}
