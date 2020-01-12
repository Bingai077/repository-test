package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

/**
 * @author bingai
 * @create 2019-12-12 18:04
 */
public interface FavoriteDao {
    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    void add(int rid, int uid);

}
