package cn.ylcto.test;

import cn.ylcto.student.service.IClassesService;
import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;


public class StudentServiceTest {
    private static ApplicationContext ctx ;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }
  @Test
    public void insert()throws Exception{
        for (int x = 0;x < 5;x++) {
            Student vo = new Student();
            vo.setSid("YLCTO87"+x);
            vo.setName("张杰"+x);
            vo.setAge(19+x);
            vo.setSex(0); // 1.表示男 ，0.表示女
            vo.setAddress("xxxxxxxxxx路"+x+"号");
            Classes classes = new Classes();
            classes.setCid(5);
            vo.setClasses(classes);
            TestCase.assertTrue(this.studentService.insert(vo));
        }
  }
  @Test
  public void list() throws Exception {
      Map<String,Object> map = this.studentService.listSplit(1,2);
      System.out.println( map.get("allStudent"));
      System.out.println( map.get("studentCount"));
      TestCase.assertTrue(map.size() == 2);
  }

  @Test
    public void update()throws Exception{
        Student vo = new Student();
        vo.setName("王五");
        vo.setAge(20);
        vo.setSex(1);
        vo.setAddress("联系地址");
        vo.setSid("YLCTo832");
        Classes classes = new Classes();
        classes.setCid(5);
        vo.setClasses(classes);
        TestCase.assertTrue(this.studentService.update(vo));
  }

@Test
  public void delete() throws Exception {
        List<String> all = new ArrayList<>();
        all.add("YLCTO873");
        TestCase.assertTrue(this.studentService.delete(all));
  }
}
