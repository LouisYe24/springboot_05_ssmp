package com.louis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.louis.dao.BookDao;
import com.louis.domain.Book;
import com.louis.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//继承ServiceImpl实现类将BookService接口中所有的方法都实现了，省去了重写一大堆堆叠在方法体中
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    @Autowired
private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {

        return bookDao.insert(book)>0;
    }

    @Override
    public boolean modify(Book book) {

        return bookDao.updateById(book)>0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        return null;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book) {
//查询匹配
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,lqw);

        return page;
    }
}
