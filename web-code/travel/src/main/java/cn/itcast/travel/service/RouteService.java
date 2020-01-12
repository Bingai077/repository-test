package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**线路Service
 * @author bingai
 * @create 2019-12-10 23:16
 */
public interface RouteService {

    /**
     * 根据类别进行分页查询方法
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> pageQuery(int cid,int currentPage,int pageSize,String rname);

    /**
     * 根据id查询
     * @param rid
     * @return
     */
    public Route findOne(String rid);
}
