package com.bingai.jdbctemplate;

import com.bingai.datasource.utils.JDBCUtils;

import com.bingai.domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.print.DocFlavor;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author bingai
 * @create 2019-11-20 23:18
 */
/*
需求：
    1. 修改1号数据的 salary 为 10000
    2. 添加一条记录
    3. 删除刚才添加的记录
    4. 查询id为1的记录，将其封装为Map集合
    5. 查询所有记录，将其封装为List
    6. 查询所有记录，将其封装为Emp对象的List集合
    7. 查询总记录数
 */

public class JDBCTemplateDemo2 {

    //1.获取JDBCTemplate对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //Junit单元测试,可以让方法独立执行

    /**
     * 1. 修改1号数据的 salary 为 10000
     */
    @Test
    public void test1() {

        //2.定义sql
        String sql = "update emp set salary = 10000 where id = 1001";
        //3.执行sql
        int count = template.update(sql);
        System.out.println(count);

    }

    /*
        2. 添加一条记录
     */
    @Test
    public void test2() {

        String sql = "insert into emp (id,ename,dept_id) values (?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }

    /*
        3. 删除刚才添加的记录
     */
    @Test
    public void test3() {
        String sql = "delete from emp where id = ? ";
        int count = template.update(sql, 1015);
        System.out.println(count);

    }

    /*
        4. 查询id为1001的记录，将其封装为Map集合
        【注意】这个方法的查询的结果集长度只能是1
     */
    @Test
    public void test4() {
        String sql = "select * from emp where id = ? ";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
        //{id=1001, ename=孙悟空, job_id=4, mgr=1004, joindate=2000-12-17, salary=10000.00, bonus=null, dept_id=20}

    }

    /*
        5. 查询所有记录，将其封装为List
     */
    @Test
    public void test5() {
        String sql = "select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        list.forEach(System.out::println);
    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
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
                emp.setJob_id(job_id);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });


        list.forEach(System.out::println);

    }

    /**
     * 6. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void test6_2() {
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        list.forEach(System.out::println);
    }

    /*
        7. 查询总记录数
     */
    @Test
    public void test7(){
        String sql = "select count(id) from emp";
        Long total = template.queryForObject(sql, Long.class);//执行聚合函数
        System.out.println(total);

    }


}
