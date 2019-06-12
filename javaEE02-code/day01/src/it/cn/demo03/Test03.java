package it.cn.demo03;

import JDBCUtils.JTool;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
@SuppressWarnings("all")
public class Test03 {
    //注册驱动,获取jdbc连接池,释放资源.
    private JdbcTemplate template = new JdbcTemplate(JTool.getDataScore());
    @Test
    public void Test001(){
            String sql = "update emp set salary=? where id=1001";
            int count = template.update(sql, 10000);
            System.out.println(count);
    }
    @Test
    public void Test002(){
        String sql = "insert into emp(id,ename,salary) values(?,?,?)";
        int i = template.update(sql, 1015, "周瑜", 9999);
        System.out.println(i);
    }
    @Test
    public void Test003(){
        String sql = "delete from emp where id=? ";
        int update = template.update(sql, 1015);
        System.out.println(update);
    }
    //// 6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void Test006(){
        String sql = "select * from emp ";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                System.out.println(id);
                String ename = rs.getString("ename");
                System.out.println(ename);
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");
                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
@Test
    public void Test00601(){
        String sql = "select * from emp ";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void Test006_01(){
        String sql = "select * from emp ";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void Test08(){
        String sql = "select count(id) from emp";
        Integer integer = template.queryForObject(sql, Integer.class);
        System.out.println(integer);
    }
}
