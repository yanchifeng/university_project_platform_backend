package com.example.university_project_platform_backend.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Data:声明数据类
 * @NoArgsConstructor:无参构造方法
 * @AllArgsConstructor:有参构造方法
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> JsonResult<T> ResultSuccess(){
        return new JsonResult<>(200,"Success",null);
    }
    public static <T> JsonResult<T> ResultSuccess(String message ){
        return new JsonResult<>(200,message,null);
    }
    public static <T> JsonResult<T> ResultSuccess( T data){
        return new JsonResult<>(200,"Success",data);
    }
    public static <T> JsonResult<T> ResultSuccess(String message , T data){
        return new JsonResult<>(200,message,data);
    }

    public static <T> JsonResult<T> ResultFail(){
        return new JsonResult<>(204,"Fail",null);
    }
    public static <T> JsonResult<T> ResultFail(String message ){
        return new JsonResult<>(204,message,null);
    }
    public static <T> JsonResult<T> ResultFail(int code,String message ){
        return new JsonResult<>(code,message,null);
    }
    public static <T> JsonResult<T> ResultFail(Integer code,String message , T data){
        return new JsonResult<>(code,message,data);
    }
    public static <T> JsonResult<T> ResultFail(String message , T data){
        return new JsonResult<>(204,message,data);
    }
}
