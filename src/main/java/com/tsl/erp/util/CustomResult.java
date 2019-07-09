package com.tsl.erp.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/9 9:51
 * @Description: 自定义返回结果
 */

public class CustomResult {

    // 定义jackSon对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private Integer status; // 业务相应状态

    private String msg;

    private Object data;

    public CustomResult() {
    }

    public CustomResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }



    public CustomResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static CustomResult build(Integer status, String msg,Object data){
        return new CustomResult(status,msg,data);
    }

    public static CustomResult ok(Object data) {

        return new CustomResult(data);
    }

    public static CustomResult ok() {

        return new CustomResult(null);
    }

    public static CustomResult build(Integer status, String msg) {

        return new CustomResult(status, msg, null);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    /**
     * @Date
     * @Description 将json结果转化为TaotaoResult对象
     * @Param null
     * @return
     **/
    public static CustomResult formatToPojo(String jsonData, Class<?> clazz){
        try{
            if (clazz == null){
                return  MAPPER.readValue(jsonData,CustomResult.class);
            }

            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null){
                if (data.isObject()){
                    obj = MAPPER.readValue(data.traverse(),clazz);
                } else if(data.isTextual()){
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e){
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static CustomResult format(String json) {
        try {
            return MAPPER.readValue(json, CustomResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static CustomResult formatToList(String jsonData, Class<?> clazz){
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;

            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz)); // 创建一个clazz对象列表
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
