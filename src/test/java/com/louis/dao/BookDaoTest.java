package com.louis.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.louis.domain.Book;
import org.assertj.core.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTest {
    @Autowired
    private BookDao bookDao;
    @Test
    void testById(){
        System.out.println(bookDao.selectById(1));
    }
    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);

    }
    @Test
    void testUpdata(){
        Book book = new Book();
        book.setId(6);
        book.setType("测试数据abc");
        book.setName("测试数据abc");
        book.setDescription("测试数据abc");
        bookDao.updateById(book);

    }
    @Test
    void testDelete(){
        bookDao.deleteById(6);
    }
    @Test
    void testGetAll(){

        bookDao.selectList(null);
    }
    @Test
    void testGetPage(){
        IPage page = new Page(2,2);
        //queryWrapper可以设置条件分页查询
      bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
    }
    @Test
    void testGetBy(){
        //条件匹配QueryWrapper对象,相关大于小于等于分组都可以
        //方法一
//        QueryWrapper<Book> qw = new QueryWrapper<>();
//        qw.like("name","spring");
//        bookDao.selectList(qw);
//
        //方法二：lamda
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
//        if (name!=null) 防止传null，查询空参数
        //qw对象封装对象查询条件
        //推荐使用lamdaquerywrapper对象，因为可以动态获取column，动态条件拼接也可以添加condition
        lqw.like(Strings.isNullOrEmpty(name),Book::getName,name);//LamdaQueryWrapper的对象like第一个arg可以设置条件判断空值
        bookDao.selectList(lqw);
    }

}
