package com.example.criminalintent.database;

public class CrimeDbSchema {
    public static final class CrimeTable {    //定义描述数据表元素的常量
        public static final String NAME = "crimes";      //数据表库名

        public static final class Cols{      //定义数据表字段
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solved";

        }
    }
}
