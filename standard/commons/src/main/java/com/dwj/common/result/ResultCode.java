package com.dwj.common.result;

public class ResultCode {

    public static final int SUCCESS = 0;

    public static final int SYSTEM_ERROR = 1;
    /**
     * 数据库连接异常
     */
    public static final int DB_CONNECT_ERROR = 2;
    /**
     * 参数异常
     */
    public static final int ARGUMENT_EXCEPTION = 3;

    /**
     * 主键冲突
     */
    public static final int DUPLICATE_KEY = 4;

    /**
     * 链接一场
     */
    public static final int CONNECTOR_ERROR = 5;

    public static final int USER_NOT_FOUNT = 13;

    private ResultCode() {
        //do nothing
    }
}
