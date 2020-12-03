package com.cnhqd.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author afj
 * @Date 2020/9/2 11:42
 * @Version 1.0
 * @description:
 */
public class ExclusiveUtil {

    /**
     * 此功能函数是用来给字符串进行签名的
     *
     * @param str
     * @return
     */
    public static String GetMD5Str(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    /**
     * 此函数功能是把传入的字符串进行Base64编码
     *
     * @param str
     * @return
     */
    public static String Base64_encoded(String str) {

        byte[] temp = str.getBytes();
        String str_temp;
        Base64.Encoder encoder = Base64.getEncoder();
        str_temp = encoder.encodeToString(temp);
        return str_temp;
    }

    /**
     * 此功能函数是用来给字符串按照键首字母进行排序
     *
     * @param keyset
     * @param map
     * @return
     */
    public static String Str_range(Set<String> keyset, Map<String, String> map) {
        Iterator<String> iter = keyset.iterator();
        String str_params = "";
        do {
            String key = iter.next();
            str_params = str_params + key + "=" + map.get(key);
            if (iter.hasNext()) {
                str_params = str_params + "&";
            }
        }
        while (iter.hasNext());
        return str_params;
    }

    public static String GetUTC10() {
        // 取得本地时间：
        Calendar cal = Calendar.getInstance();
        // 取得时间偏移量：
        int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
        // 取得夏令时差：
        int dstOffset = cal.get(Calendar.DST_OFFSET);

        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));

        long mills = cal.getTimeInMillis() + 60 * 60 * 8 * 1000;

        String utc = mills + "";

        return utc.substring(0, 10);
    }
}
