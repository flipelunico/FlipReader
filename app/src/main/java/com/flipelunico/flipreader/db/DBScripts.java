package com.flipelunico.flipreader.db;


/**
 * Created by Flipelunico on 11-10-16.
 */
public class DBScripts {
    /*
    Etiqueta para Depuración
     */
    private static final String TAG = DBScripts.class.getSimpleName();

    // Metainformación de la base de datos
    public static final String CATEGORY_TABLE_NAME = "CATEGORY";
    public static final String SUBSCRIPTIONS_TABLE_NAME = "SUBSCRIPTIONS";
    public static final String ENTRIES_TABLE_NAME = "ENTRIES";
    public static final String STREAMS_TABLE_NAME = "STREAMS";
    public static final String STRING_TYPE = "TEXT";
    public static final String DATE_TYPE = "DATE";
    public static final String INT_TYPE = "INTEGER";

    // Campos de la tabla CATEGORY
    public static class ColumnsCATEGORY {
        public static final String ID = "ID";
        public static final String LABEL = "LABEL";
    }

    // Comando CREATE para la tabla CATEGORY
    public static final String CREATE_CATEGORY =
            "CREATE TABLE " + CATEGORY_TABLE_NAME + "(" +
                    ColumnsCATEGORY.ID + " " + STRING_TYPE + " primary key," +
                    ColumnsCATEGORY.LABEL + " " + STRING_TYPE  + ")";

    // Campos de la tabla SUBSCRIPTION
    public static class ColumnsSUBSCRIPTION {
        public static final String ID = "ID";
        public static final String TITLE = "TITLE";
        public static final String WEBSITE = "WEBSITE";
        public static final String CATEGORY_ID = "CATEGORY_ID";
        public static final String CATEGORY_LABEL = "CATEGORY_LABEL";
        public static final String UPDATED = "UPDATED";
    }

    // Comando CREATE para la tabla SUBSCRIPTIONS
    public static final String CREATE_SUBSCRIPTIONS =
            "CREATE TABLE " + SUBSCRIPTIONS_TABLE_NAME + "(" +
                    ColumnsSUBSCRIPTION.ID + " " + STRING_TYPE + " primary key," +
                    ColumnsSUBSCRIPTION.TITLE + " " + STRING_TYPE  + "," +
                    ColumnsSUBSCRIPTION.WEBSITE + " " + STRING_TYPE  + "," +
                    ColumnsSUBSCRIPTION.CATEGORY_ID + " " + STRING_TYPE  + "," +
                    ColumnsSUBSCRIPTION.CATEGORY_LABEL + " " + STRING_TYPE  + "," +
                    ColumnsSUBSCRIPTION.UPDATED + " " + STRING_TYPE  + ")";

    // Campos de la tabla STREAMS
    public static class ColumnsSTREAMS {
        public static final String ID = "ID";
        public static final String UPDATED = "UPDATED";
        public static final String CONTINUATION = "CONTINUATION";
    }

    // Comando CREATE para la tabla STREAMS
    public static final String CREATE_STREAMS =
            "CREATE TABLE " + STREAMS_TABLE_NAME + "(" +
                    ColumnsSTREAMS.ID + " " + STRING_TYPE + " primary key," +
                    ColumnsSTREAMS.UPDATED + " " + STRING_TYPE  +
                    ColumnsSTREAMS.CONTINUATION + " " + STRING_TYPE  + ")";

    // Campos de la tabla ENTRIES
    public static class ColumnsENTRIES {
        public static final String ID = "ID";
        public static final String TITLE = "TITLE";
        public static final String CONTENT = "CONTENT";
        public static final String SUMMARY = "SUMMARY";
        public static final String AUTHOR = "AUTHOR";
        public static final String CRAWLED = "CRAWLED";
        public static final String RECRAWLED = "RECRAWLED";
        public static final String PUBLISHED = "PUBLISHED";
        public static final String UPDATED = "UPDATED";
        public static final String ALTERNATE_HREF = "ALTERNATE_HREF";
        public static final String ORIGIN_TITLE = "ORIGIN_TITLE";
        public static final String ORIGIN_HTMLURL = "ORIGIN_HTMLURL";
        public static final String VISUAL_URL = "VISUAL_URL";
        public static final String VISUAL_HEIGHT = "VISUAL_HEIGHT";
        public static final String VISUAL_WIDTH = "VISUAL_WIDTH";
        public static final String UNREAD = "UNREAD";
        public static final String CATEGORY_ID = "CATEGORY_ID";

    }

    // Comando CREATE para la tabla ENTRIES
    public static final String CREATE_ENTRIES =
            "CREATE TABLE " + ENTRIES_TABLE_NAME + "(" +
                    ColumnsENTRIES.ID + " " + STRING_TYPE + " primary key," +
                    ColumnsENTRIES.TITLE + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.CONTENT + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.SUMMARY + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.AUTHOR + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.CRAWLED + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.RECRAWLED + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.PUBLISHED + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.UPDATED + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.ALTERNATE_HREF + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.ORIGIN_TITLE + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.ORIGIN_HTMLURL + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.VISUAL_URL + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.VISUAL_HEIGHT + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.VISUAL_WIDTH + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.UNREAD + " " + STRING_TYPE  + "," +
                    ColumnsENTRIES.CATEGORY_ID + " " + STRING_TYPE  +")";



}
