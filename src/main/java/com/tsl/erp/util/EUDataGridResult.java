package com.tsl.erp.util;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2019/7/8 14:49
 * @Description:
 */

public class EUDataGridResult {
    private long total;
    private List<?> rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
