package com.cinema.controller;

import com.cinema.entity.FilmClassification;
import com.cinema.service.FilmClassificationService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对管理平台提供 电影分类管理接口
 */
@RequestMapping("filmClassification")
@RestController
public class FilmClassificationController {


    @Autowired
    private FilmClassificationService filmClassificationService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param filmClassification 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody FilmClassification filmClassification){
        PageResult<FilmClassification> pageResult = filmClassificationService.pageQuery(filmClassification, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param filmClassification
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody FilmClassification filmClassification){
        filmClassificationService.save(filmClassification);
        return R.ok();
    }

    /**
     * 修改数据
     * @param filmClassification
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody FilmClassification filmClassification){
        filmClassificationService.update(filmClassification);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        filmClassificationService.delete(id);
        return R.ok();
    }

    /**
     * 查询所有分类
     * @param
     * @return
     */
    @GetMapping("getAll")
    public R getAll(){
        return R.ok().put("row", filmClassificationService.getAll());
    }
}
