package jingjing.mybatis.dao;

import jingjing.mybatis.entity.Emp;

public interface EmployeeMapper {

    Emp selectEmpById(Integer empId);

    void updateEmp(Emp emp);
}
