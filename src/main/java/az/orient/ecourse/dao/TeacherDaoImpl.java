package az.orient.ecourse.dao;

import az.orient.ecourse.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor

public class TeacherDaoImpl implements TeacherDao{


    private DataSource dataSource;
    @Override
    public List<Teacher> getTeacherList() throws Exception {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        String sql= "select * from user ";
       List<Teacher> teacherList= jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Teacher.class));

        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
        String sql="insert into user(name,surname,email)"+
                "values(?,?,?)";
        jdbcTemplate.update(sql, teacher.getName(),teacher.getSurname(),teacher.getEmail());
    }

    @Override
    public void addTeacher() throws Exception {

    }


}
