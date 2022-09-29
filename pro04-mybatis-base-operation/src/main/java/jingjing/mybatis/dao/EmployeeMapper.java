package jingjing.mybatis.dao;

import jingjing.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/*  声明这个接口是为了方便上层代码调用Mybatis的具体功能
* 接口全类名要与Mapper配置文件的namespace属性一致，才能通过接口找到Mapper配置
* 方法名要与配置文件中SQL语句标签的id属性一致，才能通过方法名找到sql语句
* id不能重复，故方法名不能相同，故接口不能重载*/
public interface EmployeeMapper {
    /**
     *
     * @param empId 参数对应SQL语句中#{empId}声明的参数
     * @return 返回类型与resultType属性指定的类型一致
     */
    Emp selectEmpById(Long empId);

    /**
     * 执行插入操作
     * @param emp
     * @return  受影响的行数
     */
    int insertEmp(Emp emp);

    int deleteById(long empId);

    int updateEmp(Emp harry);

    /**
     * 模糊查询，根据员工姓名片段查询对应数据
     * @param o 查询条件
     * @return 查询结果
     */
    Emp selectEmpByName(String empName);

    /*  @Param注解给参数命名 */
    void updateSalaryById(@Param("empId") Long empId, @Param("empSalary") Double salary);

    void updateByMap(Map<String, Object> paramMap);

    Integer selectCount();

    Map<String, Object> selectForMap(int empId);

    List<Emp> selectAll();

    int insertWithKey(Emp emp);

    List<Emp> selectWithResultMap();
}
