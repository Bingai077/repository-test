package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @author bingai
 * @create 2019-12-09 13:22
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户保存
     * @param user
     */
    public void save(User user);

    User findByCode(String code);

    void updateStatus(User user);

    User findByUsernameAndPassword(String username, String password);
}
