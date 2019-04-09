/**
  * Copyright 2018 bejson.com
  */
package com.neu.yang.model;
import java.util.List;

/**
 * Auto-generated: 2018-11-22 19:28:39
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Table {

    private String comment;
    private List<ColumnList> columnList;
    private List<PrimayKey> primayKey;
    private String tableName;
    public void setComment(String comment) {
         this.comment = comment;
     }
     public String getComment() {
         return comment;
     }

    public void setColumnList(List<ColumnList> columnList) {
         this.columnList = columnList;
     }
     public List<ColumnList> getColumnList() {
         return columnList;
     }

    public void setPrimayKey(List<PrimayKey> primayKey) {
         this.primayKey = primayKey;
     }
     public List<PrimayKey> getPrimayKey() {
         return primayKey;
     }

    public void setTableName(String tableName) {
         this.tableName = tableName;
     }
     public String getTableName() {
         return tableName;
     }

}
