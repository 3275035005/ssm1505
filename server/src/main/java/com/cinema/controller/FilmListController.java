package com.cinema.controller;

import com.cinema.entity.FilmList;
import com.cinema.service.FilmListService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 电影榜单管理接口
 */
@RequestMapping("filmList")
@RestController
public class FilmListController {


    @Autowired
    private FilmListService filmListService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param filmList 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody FilmList filmList){
        PageResult<FilmList> pageResult = filmListService.pageQuery(filmList, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param filmList
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody FilmList filmList){
        filmListService.save(filmList);
        return R.ok();
    }

    /**
     * 修改数据
     * @param filmList
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody FilmList filmList){
        filmListService.update(filmList);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        filmListService.delete(id);
        return R.ok();
    }
}
