package cn.itcast.travel.service;

import cn.itcast.travel.domain.User; /**
 * @author bingai
 * @create 2019-12-09 13:21
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean regist(User user);

    boolean active(String code);

    User login(User user);
}
