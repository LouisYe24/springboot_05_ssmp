package com.louis.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.louis.domain.Book;
//继承IService接口
public interface IBookService extends IService<Book> {

    boolean saveBook(Book book);
    boolean modify(Book book);
    boolean delete(Integer id);
    IPage<Book> getPage(int currentPage, int pageSize);
    IPage<Book> getPage(int currentPage, int pageSize, Book book);

}
