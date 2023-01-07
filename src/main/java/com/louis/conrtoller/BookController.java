package com.louis.conrtoller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.louis.conrtoller.utils.R;
import com.louis.domain.Book;
import com.louis.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//1.实现前后台数据格式一致，所有返回类型设置为R
@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;
    //查询都是get请求 符合restful规则
    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());

    }
    @PostMapping
    //带参数的参数通过json异步通过请求体传参数过来所以加RequestBody
    public R save(@RequestBody Book book){
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
//        提供构造方法简化成一行
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功-v-":"添加失败qaq");

    }
    @PutMapping
    public R updata(@RequestBody Book book){
        return new R(bookService.modify(book));
    }
    //删除和查单个一般用路径变量方式传参数
    @DeleteMapping("{id}")
    public R delete( @PathVariable Integer id){
        return new R(bookService.delete(id));
    }
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
       return new R(true,bookService.getById(id));

    }
//    @GetMapping("{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage,pageSize);
//        //如果当前页码值大于总页码值，重新执行查询操作，使用最大页码值作为当前页码值,后台补救方案
//        if(currentPage > page.getPages()){
//            page = bookService.getPage((int)page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }
@GetMapping("{currentPage}/{pageSize}")
public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book){
    System.out.println(book);
    IPage<Book> page = bookService.getPage(currentPage,pageSize,book);
    //如果当前页码值大于总页码值，重新执行查询操作，使用最大页码值作为当前页码值,后台补救方案
    if(currentPage > page.getPages()){
        page = bookService.getPage((int)page.getPages(),pageSize,book);
    }
    return new R(true,page);
}


}
