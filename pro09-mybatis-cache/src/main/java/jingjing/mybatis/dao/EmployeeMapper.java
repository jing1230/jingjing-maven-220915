package jingjing.mybatis.dao;

import jingjing.mybatis.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    Emp selectEmpById(Integer empId);

    void updateEmp(Emp emp);
}
