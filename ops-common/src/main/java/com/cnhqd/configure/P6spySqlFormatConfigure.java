package com.cnhqd.configure;

import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;


import com.cnhqd.utils.DateUtils;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;


/**
 * 自定义 p6spy sql输出格式
 *
 * @author afj
 */
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StringUtils.isNotBlank(sql) ? DateUtils.formatFullTime(LocalDateTime.now(), DateUtils.DATETIME_PATTERN)
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + StringUtils.LF + sql.replaceAll("[\\s]+", StringUtils.SPACE) + ";" : StringUtils.EMPTY;
    }
}
