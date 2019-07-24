package com.chilly.dome.controller;

import com.chilly.dome.dto.ResultDto;
import com.chilly.dome.entity.Book;
import com.chilly.dome.exception.BaseExceptionHandleAction;
import com.chilly.dome.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//tomcat配置好的项目地址是 + controller配好的RequestMapping + controller里面的接口方法配置好的RequestMapping
//    就是网络请求时的地址，即访问controller中某方法的网络地址URL
//    例如：http://localhost:8080/user/allUser --》就访问了findAllUserDESC（）方法
@Controller
@RequestMapping("/book")//Controller类继承BaseExceptionHandleAction这个类即可在产生异常时返回数据获取失败的异常类信息
public class BookController extends BaseExceptionHandleAction {

    //这里写的每个方法都要注释好是干什么的，有复杂的逻辑处理关系的也要注释好，便于别人读懂你的代码
    //PS:controller一般只处理获取数据，将数据传到service业务层，不做复杂的数据处理，复杂的数据处理交给service业务层

    //注入Service实现类依赖，可注入多个Service依赖
    @Autowired
    private BookService bookService;

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/addBookByNameIntro")
    //@RequestMapping(value = "/addBookByNameIntro",method = RequestMethod.POST)//可以指定请求方式,如果不指定，默认post，get都可以
    public ResultDto addBookByNameIntro(HttpServletRequest request, HttpServletResponse response) {
        //request.getParameter("bookname")就是APP端传过来的请求参数
        String bookname = request.getParameter("bookname");
        String bookintro = request.getParameter("bookintro");

        bookService.addBookByNameIntro(bookname,bookintro);
        //ResultDto返回数据的封装类，参数使用规则可自定义
        //例：
        // stauts:状态返回码，200：URL访问请求成功，并成功返回数据；500：URL访问请求成功但内部程序出错
        // msg：信息提示
        // data：需要的数据
        return new ResultDto(200, "success");
    }

    /**
     *
     * @param request
     * @param response
     * @return
     * @throws IOException 这些参数就是APP那边请求的参数  HttpServletResponse是用来返回数据的，不是APP那边请求的参数，这里暂时用不到
     */
    @ResponseBody//将返回的数据处理为json
    @RequestMapping(value = "/findBookByName")
    //@RequestMapping(value = "/addBookByNameIntro",method = RequestMethod.POST)//可以指定请求方式,如果不指定，默认post，get都可以
    public ResultDto findBookByName(HttpServletRequest request, HttpServletResponse response) {
        Book book;
        //request.getParameter("bookname")就是APP端传过来的请求参数
        String bookname = request.getParameter("bookname");

        book = bookService.findBookByName(bookname);

        //ResultDto返回数据的封装类，参数使用规则可自定义
        //例：
        // stauts:状态返回码，200：URL访问请求成功，并成功返回数据；500：URL访问请求成功但内部程序出错
        // msg：信息提示
        // data：需要的数据
        if (book != null){
            return new ResultDto(200, "success",book);
        }else {
            return new ResultDto(200,"fail",null);
        }

    }


}
