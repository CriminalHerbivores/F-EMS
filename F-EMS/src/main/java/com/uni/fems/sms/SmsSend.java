package com.uni.fems.sms;

import java.util.HashMap;

import org.json.simple.JSONObject;

public class SmsSend {
    
    public void send(String message, String hp){
    	
    	String api_key = "NCS5880CE7517EC8";
        String api_secret = "C9684A6058C858F7BCF422DC8FB64C75";
        Coolsms coolsms = new Coolsms(api_key, api_secret);
    
        HashMap<String, String> set = new HashMap<String, String>();
        set.put("to", hp); // 수신번호
        set.put("from", "01074571287"); // 발신번호 
        set.put("text", message); // 문자내용
        set.put("type", "sms"); // 문자 타입

        JSONObject result = coolsms.send(set); // 보내기&전송결과받기
        
    }
}
