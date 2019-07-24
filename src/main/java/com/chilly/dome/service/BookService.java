package com.chilly.dome.service;


import com.chilly.dome.entity.Book;

/**
 * 定义方法，只需要定义，实现在对应的*ServiceImpl.java里实现，这就是spring做的工作
 */
public interface BookService {

    /**
     * 添加Book
     * 通过 bookname和bookintro 来添加 Book
     *
     * @param bookname
     * @param bookintro
     * @return 插入的行数
     */
    int addBookByNameIntro(String bookname, String bookintro);

    /**
     * 通过 bookname 查找 Book
     * @param bookname
     * @return
     */
    Book findBookByName(String bookname);

}