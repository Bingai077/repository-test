package com.bingai.test;

import com.bingai.dao.CustomerDao;
import com.bingai.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;


/**
 * @author bingai
 * @create 2020-01-02 11:18
 */
@RunWith(SpringJUnit4ClassRunner.class)//声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;


    /**
     * 根据条件查询单个对象
     */
    @Test
    public void testSpec(){
        //匿名内部类
        /**
         * 自定义查询条件：
         *      1.实现Specification接口（提供泛型：查询对象类型）
         *      2.实现toPredicate方法（根据条件查询）
         *      2.需要借助方法参数中的两个参数
         *              root:获取需要查询的对象属性
         *              CriteriaBuilder：构造查询条件的，内部封装了很多查询条件（模糊查询，精准匹配）
         *   案例：根据客户名称查询，查询客户名为张三的客户
         *          查询条件
         *              1.查询方式
         *                  cb对象
         *              2.比较的属性名称
         *                  root对象
         *
         */
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                //1.获取比较的属性
                Path<Object> custName = root.get("custName");
                //2.构造查询条件：select * from cust_name where cust_name = '张三'
                /**
                 * 第一个参数：需要比较的属性
                 * 第二个参数：当前需要比较的取值
                 */
                Predicate predicate = criteriaBuilder.equal(custName, "张三");//进行精准匹配（比较的属性，比较的属性取值）
                return predicate;
            }
        };
        Customer customer = customerDao.findOne(spec);
        System.out.println(customer);
    }


    /**
     * 多条件查询
     *  案例：根据客户名和客户所属行业进行查询
     */
    @Test
    public void testspec1(){

        /**
         * root：获取属性
         *       客户名称
         *       所属行业
         * cb：构造查询
         *      1.构造客户名的精准匹配查询
         *      2.构造所属行业的精准匹配查询
         *      3.将以上两个查询联系起来
         */
        Specification spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");

                //构造查询
                //1.构造客户名的精准匹配查询
                Predicate p1 = criteriaBuilder.equal(custName, "张三");//第一个参数，path（属性），第二个参数，属性的取值
                //2.构造所属行业的精准匹配查询
                Predicate p2 = criteriaBuilder.equal(custIndustry, "IT");
                //3.将多个查询条件组合到一起：组合（满足条件1并且满足条件2：与，满足条件1或条件2：或）
                Predicate p = criteriaBuilder.and(p1, p2);//and:与 or：或
                return p;
            }
        };

        Customer customer = customerDao.findOne(spec);
        System.out.println(customer);
    }


    /**
     * 根据客户名称的模糊匹配，返回客户列表
     *
     *
     * equal：直接得到path对象（属性），然后进行比较即可
     * gt,lt,ge,le,like:得到path对象，根据path对象比较的数据类型，再进行比较
     *      指定参数类型：path.as(类型的字节码对象)
     */
    @Test
    public void testSpec3(){
        //构造查询条件
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                //查询属性：客户名
                Path<Object> custName = root.get("custName");
                //查询方式：模糊匹配
                Predicate predicate = cb.like(custName.as(String.class), "张%");
                return predicate;
            }
        };

//        List<Customer> list = customerDao.findAll(spec);
//        for (Customer customer : list) {
//            System.out.println(customer);

        //添加排序
        //创建排序对象,需要调用构造方法实例化sort对象
        //第一个参数：排序的顺序（正序，倒序）
            //Sort.Direction.DESC:倒序
            //Sort.Direction.ASC：正序
        //第二个参数：排序的属性名称
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> list = customerDao.findAll(spec, sort);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }


    /**
     * 分页查询
     *      Specification:查询条件
     *      Pageable：分页参数
     *          分页参数：查询的页码，每页查询的条数
     *      findAll(Specification,Pageable)：带条件的分页
     *      findAll(Pageable)：没有条件的分页
     *   返回：Page（springDataJpa为我们封装好的pageBean对象，数据列表，总条数）
     */
    @Test
    public void testSpec4(){

        Specification spec = null;
        //PageRequest对象是Pageable的实现类
        /**
         * 创建PageRequest的过程中，需要调用它的构造方法传入两个参数
         *      第一个参数：当前查询的页数（从0开始）
         *      第二个参数：每页查询的数量
         *
         */
        Pageable pageable = new PageRequest(0,2);
        //分页查询
        Page page = customerDao.findAll(spec, pageable);
        System.out.println(page.getContent());//得到数据集合列表
        System.out.println(page.getTotalElements());//得到总条数
        System.out.println(page.getTotalPages());//得到总页数

    }









}
