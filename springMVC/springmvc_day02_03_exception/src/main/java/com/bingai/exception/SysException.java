package com.bingai.exception;

/**自定义异常类
 * @author bingai
 * @create 2019-12-25 9:32
 */
public class SysException extends Exception{

    //存储提示信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
