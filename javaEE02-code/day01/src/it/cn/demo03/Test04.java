package it.cn.demo03;

import JDBCUtils.JTool;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test04 {
    private JdbcTemplate template = new JdbcTemplate(JTool.getDataScore());
    /*
                1. 修改1号数据的 salary 为 10000
				2. 添加一条记录
				3. 删除刚才添加的记录
     */
    @Test
    public void Test001(){
        String sql = "update emp set salary=? where id=1001";
        int update = template.update(sql, 5000);
        System.out.println(update);
    }
    @Test
    public void Test002(){
        String sql = "insert into emp(id,ename,salary) value(?,?,?)";
        int c = template.update(sql, 1688, "大西瓜", 77777);
        System.out.println(c);
    }
    @Test
    public void Test003(){
        String sql = "delete from emp where id=?";
        int update = template.update(sql, 1688);
        System.out.println(update);
    }
    //4. 查询id为1的记录，将其封装为Map集合
    @Test
    public void Test004(){
        String sql = "select * from emp where id = ? ";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
        Set<String> set = map.keySet();
        for (String s : set) {
            Object o = map.get(s);
            System.out.println(s+":"+o);
        }
    }
    @Test
    public void Test005(){
        String sql = "select * from emp ";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> so : list) {
            System.out.println(so);
        }
    }
    // 6. 查询所有记录，将其封装为Emp对象的List集合
    @Test
    public void Test006(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp e : list) {
            System.out.println(e);
        }
    }
    //查询总记录数
    @Test
    public void Test007(){
        String sql = "select count(id) from emp";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }

}
