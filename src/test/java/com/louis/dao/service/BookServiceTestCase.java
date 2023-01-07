package com.louis.dao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.louis.domain.Book;
import com.louis.service.BookService;
import com.louis.service.IBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private IBookService bookService;
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
        book.setType("--------------");
        book.setName("测试数据abc");
        book.setDescription("测试数据abc");
        bookService.updateById(book);

    }
    @Test
    void testDelete(){
       bookService.removeById(3);
    }
    @Test
    void testGetAll(){

        bookService.list();
    }
    @Test
    void testGetPage(){
        Page<Book> page = new Page<Book>(1,4);
        //queryWrapper可以设置条件分页查询
         bookService.page(page);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }

}
