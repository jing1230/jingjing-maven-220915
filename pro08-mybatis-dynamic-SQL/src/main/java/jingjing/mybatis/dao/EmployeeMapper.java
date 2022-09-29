package jingjing.mybatis.dao;

import jingjing.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    List<Emp> selectEmpByCondition(Emp condition);

    void updateEmpCondition(Emp condition);

    List<Emp> selectEmpByConditionByTrim(Emp condition);

    List<Emp> selectEmpByChooseCondition(Emp condition);

    void batchInsert(@Param("empList") List<Emp> empList);

    void batchUpdate(@Param("empList") List<Emp> empList);

    void commonUpdate(Emp emp);
}
