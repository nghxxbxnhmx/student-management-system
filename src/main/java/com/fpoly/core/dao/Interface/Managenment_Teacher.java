package com.fpoly.core.dao.Interface;

import com.fpoly.core.models.TeacherModel;

public interface Managenment_Teacher {
    public boolean checkNull(String[] information);
    public boolean checkInformationFormaDate(String ngayVaoLam, String ngaySinh);
    public TeacherModel getInformationTeacher();
}
