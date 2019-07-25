package com.chilly.dome.dao;


import com.chilly.dome.entity.Book;
import org.apache.ibatis.annotations.Param;


public interface BookDao {//添加BookDao的test时，选中类名BookDao，右键go to->test-创建->选择Junit4,选择添加的测试方法，finish

    /**
     * 通过 bookname和bookintro 来添加 Book
     * @param bookname
     * @param bookintro
     * @return 插入的行数
     */
    int addBookByNameIntro(@Param("bookname") String bookname, @Param("bookintro") String bookintro);

    /**
     * 通过 bookname 查找 Book
     * @param bookname
     * @return
     */
    Book findBookByName(@Param("bookname") String bookname);


}
