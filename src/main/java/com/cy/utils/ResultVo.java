package com.cy.utils;

import lombok.Data;

@Data
public class ResultVo {
    private boolean flag;
    private String message;
    private Object data;

    /**
     * 成功不添加data
     * @return
     */
    public static ResultVo ok(String message){
        ResultVo resultVo=new ResultVo();
        resultVo.setMessage(message);
        resultVo.setFlag(true);
        return  resultVo;
    }

    /**
     * 成功添加data
     * @return
     */
    public static ResultVo ok(Object data){
//    public static<T> ResultVo ok(T data){
        ResultVo resultVo=new ResultVo();
        resultVo.setData(data);
        resultVo.setFlag(true);
        return  resultVo;
    }

    /**
     * 成功添加data和message
     * @return
     */
    public static ResultVo ok(Object data,String message){
//    public static<T> ResultVo ok(T data,String message){
        ResultVo resultVo=new ResultVo();
        resultVo.setData(data);
        resultVo.setFlag(true);
        resultVo.setMessage(message);
        return  resultVo;
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static ResultVo fail(String message){
        ResultVo resultVo=new ResultVo();
        resultVo.setFlag(false);
        resultVo.setMessage(message);
        return  resultVo;
    }
    /**
     * 失败返回状态数据
     * @param message
     * @return
     */
    public static ResultVo fail(String message,Object data){
        ResultVo resultVo=new ResultVo();
        resultVo.setFlag(false);
        resultVo.setMessage(message);
        resultVo.setData(data);
        return  resultVo;
    }

    /**
     * 异常
     * @param e
     * @return
     */
    public static ResultVo error(Exception e){
        ResultVo resultVo=new ResultVo();
        resultVo.setMessage("系统异常:"+e.getMessage());
        resultVo.setFlag(false);
        return  resultVo;
    }
}
