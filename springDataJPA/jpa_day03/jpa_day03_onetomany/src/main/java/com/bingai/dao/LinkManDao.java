package com.bingai.dao;

import com.bingai.domain.LinkMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**联系人Dao接口
 * @author bingai
 * @create 2020-01-02 17:53
 */
public interface LinkManDao extends JpaRepository<LinkMan,Long>,JpaSpecificationExecutor<LinkMan> {

}
