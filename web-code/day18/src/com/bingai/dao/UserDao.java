package com.bingai.dao;

import com.bingai.domain.User;

import java.util.List;
import java.util.Map;

/**用户操作的dao
 * @author bingai
 * @create 2019-12-02 16:04
 */
public interface UserDao {

    public List<User> findAll();

    User findUserByUsernameAndPassword(String username, String password);

    void add(User user);

    void delete(int i);

    User findById(int i);

    void update(User user);

    /**
     * 分页查询每页记录数
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<User> finByPage(int start, int rows, Map<String, String[]> condition);

    /**
     * 查询总记录数
     * @return
     * @param condition
     */
    int findTotalCount(Map<String, String[]> condition);
}
