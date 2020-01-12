package com.bingai.service.impl;

import com.bingai.dao.UserDao;
import com.bingai.dao.impl.UserDaoImpl;
import com.bingai.domain.PageBean;
import com.bingai.domain.User;
import com.bingai.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @author bingai
 * @create 2019-12-02 16:02
 */
public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();


    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if(ids != null && ids.length > 0){
            //1.遍历数组
            for (String id : ids) {
                //2.调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){
            currentPage = 1;
        }

        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.finByPage(start,rows,condition);
        pb.setList(list);

        //5.计算总页码
        int totalPage = (totalCount % rows) == 0 ? (totalCount/rows) : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }


}
