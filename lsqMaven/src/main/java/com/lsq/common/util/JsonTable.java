package com.lsq.common.util;

import java.util.List;

public class JsonTable {  
    List<JsonRow> rows;  
    int total_count;  
    int pos;  
  
    public int getPos() {  
        return pos;  
    }  
  
    public void setPos(int pos) {  
        this.pos = pos;  
    }  
  
    public int getTotal_count() {  
        return total_count;  
    }  
  
    public void setTotal_count(int total_count) {  
        this.total_count = total_count;  
    }  
  
    public List<JsonRow> getRows() {  
        return rows;  
    }  
  
    public void setRows(List<JsonRow> rows) {  
        this.rows = rows;  
    }  
} 