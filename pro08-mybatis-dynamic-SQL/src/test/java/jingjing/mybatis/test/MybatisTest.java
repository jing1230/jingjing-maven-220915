package jingjing.mybatis.test;

import com.sun.tools.corba.se.idl.constExpr.Or;
import jingjing.mybatis.dao.EmployeeMapper;
import jingjing.mybatis.entity.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {

    private SqlSession session;

    /**
     * 普通更新
     */
    @Test
    public void testCommonUpdate(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        for (int i = 15; i < 25 ; i++) {
            Emp emp = new Emp((long) i, "smallTiger" + i, i * 2500.00);
            employeeMapper.commonUpdate(emp);
        }
    }


    /**
     * 批量更新
     */
    @Test
    public void testBatchUpdate(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = new ArrayList<>();
        for (int i = 15; i < 25 ; i++) {
            Emp emp = new Emp((long) i, "bigTiger" + i, i * 3500.00);
            empList.add(emp);
        }
        employeeMapper.batchUpdate(empList);

    }


    @Test
    public void testBatchInsert(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        List<Emp> empList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Emp emp = new Emp(null,"cat"+i,i*1000.00);
            empList.add(emp);
        }
        employeeMapper.batchInsert(empList);

    }

    @Test
    public void testSelectEmpByChoose(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp condition = new Emp();

        /* 两个条件都满足 */
        /*condition.setEmpName("harry");
        condition.setEmpSalary(2500.00);*/

        /* 一个条件满足一个条件不满足 */
        /*condition.setEmpName("harry");
        condition.setEmpSalary(900.00);*/

        condition.setEmpName(null);
        condition.setEmpSalary(9900.00);


        /* 两个条件都不满足 */
        /*condition.setEmpName(null);
        condition.setEmpSalary(500.00);*/


        List<Emp> empList = employeeMapper.selectEmpByChooseCondition(condition);
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }

    @Test
    public void testSelectEmpConditional(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp condition = new Emp();

        /* 两个条件都满足 */
        condition.setEmpName("harry");
        condition.setEmpSalary(2500.00);

        /* 一个条件满足一个条件不满足 */
        /*condition.setEmpName("harry");
        condition.setEmpSalary(900.00);*/

        /*condition.setEmpName(null);
        condition.setEmpSalary(9900.00);*/


        /* 两个条件都不满足 */
        /*condition.setEmpName(null);
        condition.setEmpSalary(500.00);*/


        List<Emp> empList = employeeMapper.selectEmpByConditionByTrim(condition);
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }


    @Test
    public void testUpdateEmpCondition(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp condition = new Emp();

        /* 两个条件都满足 */
        condition.setEmpName("harry");
        condition.setEmpSalary(2500.00);

        /* 一个条件满足一个条件不满足 */
        /*condition.setEmpName("harry");
        condition.setEmpSalary(900.00);*/


        /* 两个条件都不满足 */
        /*condition.setEmpName(null);
        condition.setEmpSalary(500.00);*/


        List<Emp> empList = employeeMapper.selectEmpByCondition(condition);
        for (Emp emp : empList) {
            System.out.println("emp = " + emp);
        }
    }



    @Test
    public void testQueryEmp(){
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Emp condition = new Emp();

        /* 两个条件都满足 */
        condition.setEmpName("harry");
        condition.setEmpSalary(55000.00);
        /* 一个条件满足一个条件不满足 */
        /*condition.setEmpName("harry");
        condition.setEmpSalary(900.00);*/

         /*condition.setEmpName(null);
        condition.setEmpSalary(2900.00);*/


        /* 两个条件都不满足 */
        /*condition.setEmpName(null);
        condition.setEmpSalary(500.00);*/

        employeeMapper.updateEmpCondition(condition);

    }





    @Before
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder().build(Resources
                        .getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @After
    public void clear(){
        session.commit();
        session.close();
    }
}
