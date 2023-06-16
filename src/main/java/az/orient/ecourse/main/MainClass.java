package az.orient.ecourse.main;

import az.orient.ecourse.dao.TeacherDao;
import az.orient.ecourse.dao.TeacherDaoImpl;
import az.orient.ecourse.model.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class MainClass {
    public static void main(String[] args)  {
        Scanner scanner=new Scanner(System.in);
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        TeacherDao teacherDao= (TeacherDao) context.getBean("teacherDao");
        try {
            System.out.println("view or add");
            switch (scanner.next()){
                case "view":
                    teacherDao.getTeacherList().forEach(teacher -> System.out.println(teacher));
                    break;
                case "add":
                    Teacher teacher=new Teacher();
                    teacher.setName(scanner.nextLine());
                    teacher.setSurname(scanner.nextLine());
                    teacher.setEmail(scanner.nextLine());
                    teacherDao.addTeacher(teacher);
                    System.out.println("success");
                        break;

            }
            main(args);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
