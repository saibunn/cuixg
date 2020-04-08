package com.pgyhr.core.common.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @author cuixg
 * @title: CommonUtil
 * @projectName pgyhr-module
 * @description: todo
 * @date 2020/4/3  11:33
 */
@Slf4j
public class CommonUtil {

    /**
     * 以UUID重命名
     *
     * @param fileName
     * @return
     */
    public static String renamePic(String fileName) {
        String extName = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString().replace("-", "") + extName;
    }

    /**
     * 随机6位数生成
     */
    public static String getRandomNum() {

        Random random = new Random();
        int num = random.nextInt(999999);
        //不足六位前面补0
        String str = String.format("%06d", num);
        return str;
    }

    /**
     * 批量递归删除时 判断target是否在ids中 避免重复删除
     * @param target
     * @param ids
     * @return
     */
    public static Boolean judgeIds(String target, String[] ids){

        Boolean flag = false;
        for(String id : ids){
            if(id.equals(target)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 根据指定前缀生成ID
     * @param preStr
     * @return
     */
    public static String buildId(String preStr){
        if (StringUtils.isEmpty(preStr)){
            log.error("buildId preStr is error, preStr = " + preStr);
            return null;
        }
        //获取UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀
        long prefix = Long.parseLong(time) * 100000000;
        return preStr + String.valueOf(prefix + suffix);
    }
}
