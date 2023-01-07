package com.louis.dao.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.louis.domain.Book;
import com.louis.service.BookService;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(4));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookService.save(book);

    }
    @Test
    void testUpdata(){
        Book book = new Book();
        book.setId(6);
        book.setType("测试数据abc");
        book.setName("测试数据abc");
        book.setDescription("测试数据abc");
        bookService.updata(book);

    }
    @Test
    void testDelete(){
       bookService.delete(4);
    }
    @Test
    void testGetAll(){

        bookService.getAll();
    }
    @Test
    void testGetPage(){
        //queryWrapper可以设置条件分页查询
        IPage<Book> page = bookService.getPage(1, 5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

}
