package az.orient.ecourse.dao;

import az.orient.ecourse.model.Teacher;

import java.util.List;

public interface TeacherDao {
    List<Teacher> getTeacherList() throws Exception;
    void addTeacher(Teacher teacher)throws Exception;

    void addTeacher() throws Exception;
}
