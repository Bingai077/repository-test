package com.xuecheng.framework.exception;

import com.xuecheng.framework.model.response.ResultCode;

/**自定义异常类
 * @author bingai
 * @create 2020-02-09 14:07
 */
public class CustomException extends RuntimeException {

    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}
