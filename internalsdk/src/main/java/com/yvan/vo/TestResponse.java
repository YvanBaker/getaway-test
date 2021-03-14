package com.yvan.vo;

/**
 * @author v_yangfeng01
 * @date 2021/2/12
 */
public class TestResponse {
    private String code; // 错误码
    private Integer remain; // 当前 appkey 对当前 api 服务的剩余可用次数
    private String msg; // 错误信息
    private Object result; // 实际接口返回的 json 数据

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
