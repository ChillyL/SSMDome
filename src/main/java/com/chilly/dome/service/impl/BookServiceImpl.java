package com.chilly.dome.service.impl;

import com.chilly.dome.dao.BookDao;
import com.chilly.dome.entity.Book;
import com.chilly.dome.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//服务注释
@Service
public class BookServiceImpl implements BookService {

    //注入Dao实现类依赖
    //    @Resource
    @Autowired
    private BookDao bookDao;

    //也可以注入别的dao,例如对应post_tab表的PostDao，这样就可以根据需求整合多表的增删改查

//    @Resource
//    @Autowired
//    private UserDao userDao;

    /**添加
     * 通过 bookname和bookintro 来添加 Book
     * @param bookname
     * @param bookintro
     * @return 插入的行数
     */
    public int addBookByNameIntro(String bookname, String bookintro) {
        return bookDao.addBookByNameIntro(bookname,bookintro);
    }

    /**
     * 通过 bookname 查找 Book
     * @param bookname
     * @return
     */
    public Book findBookByName(String bookname){
        return bookDao.findBookByName(bookname);
    }

}
