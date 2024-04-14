package com.fpoly.core.services;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CallApiService {
    //kiem tra rong
    public boolean checkNull(String text){
        return text.equals(""); 
    }
    //kiem tra confirmpass == new pass
    public boolean checkConfrimPassWhenForgetpassword(String newPassword, String conFirmPass){
        return newPassword.equals(conFirmPass);
    }
    //kiem tra ngay thang nam
    public boolean checkDateFormat(String textDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = (Date) dateFormat.parse(textDate);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
