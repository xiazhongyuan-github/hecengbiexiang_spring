package com.hitachi.elderly.utils;

import com.hitachi.elderly.constant.CommonCode;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/10 18:23
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Utils {
    public static String getCommentCode() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String format = simpleDateFormat.format(new Date());
        return CommonCode.COMMENT_CODE + format;
    }
}
