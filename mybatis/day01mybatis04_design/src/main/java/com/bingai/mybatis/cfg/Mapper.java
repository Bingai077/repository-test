package com.bingai.mybatis.cfg;

/**用于封装执行的sql语句和结果类型的全限定名
 * @author bingai
 * @create 2019-12-18 9:21
 */
public class Mapper {

    private String queryString;//SQL
    private String resultType;//实体类的权限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
