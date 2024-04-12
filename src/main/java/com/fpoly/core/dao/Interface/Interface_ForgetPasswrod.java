/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpoly.core.dao.Interface;

/**
 *
 * @author acer
 */
public interface Interface_ForgetPasswrod{
    public void checkSendMail();
    public boolean checkNull();
    public boolean checkCode(String code);
    public boolean checkConFirmNewPassword(String newPassword, String conFirmPass);
    public boolean checkCodeNumberFormat(String code);
    public boolean checkCode(int code);
}
