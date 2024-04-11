package com.fpoly.core;

import com.fpoly.core.dao.StudentDAO;
import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        
//        System.out.println(new Gson().toJson(studentDAO.checkEmail(email)));
    }
}
