package com.louis.service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.louis.domain.Book;

import java.util.List;

public interface BookService {
   Boolean save(Book book);
   Boolean updata(Book book);
   Boolean delete(Integer id);
   Book getById(Integer id);
   List<Book> getAll();
   IPage<Book> getPage(int currentPage, int pageSize);
}
