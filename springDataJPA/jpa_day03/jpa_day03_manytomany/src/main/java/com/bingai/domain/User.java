package com.bingai.domain;

import org.springframework.test.annotation.Rollback;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author bingai
 * @create 2020-01-02 22:35
 */
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id")
    private Long userId;

    @Column(name = "use_name")
    private String userName;

    @Column(name = "age")
    private Integer age;


    /**
     * 配置用户到角色的多对多关系
     *      配置多对多的映射关系
     *          1.声明表关系
     *              @ManyToMany:配置多对多
     *                  targetEntity：代表对方的实体类字节码
     *
     *          2.配置中间表(包含两个外键)
     *          @JoinTable:
     *          name:中间表的名称
     *          joinColumns:当前对象在中间表中的外键
     *              @JoinColumn数组：
     *                  name：外键名
     *                  referencedColumnName：参照的主表的主键名
     *          inverseJoinColumns：对方对象在中间表的外键
     *
     */
    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name="sys_user_id",referencedColumnName = "use_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<Role>();




    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
