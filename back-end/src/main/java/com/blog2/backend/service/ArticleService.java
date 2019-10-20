package com.blog2.backend.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog2.backend.model.entity.Article;


/**
 * @Author: goodtimp
 * @Date: 2019/9/24 19:18
 * @description :  文章
 */
public interface ArticleService extends IService<Article> {
    /**
     * 通过分类Id获取文章
     *
     * @param page 分页信息
     * @param id id==0时获取所有
     * @return
     */
    IPage<Article> getByCategoryId(Page<Article> page, Long id);

    /**
     * 增加文章
     *
     * @param article
     * @return
     */
    void addArticle(Article article);

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    void updateArticle(Article article);

    /**
     * 逻辑删除文章
     *
     * @param id
     */
    void deleteArticle(Long id);

    /**
     * 通过关键字搜索文章
     *
     * @param page
     * @param search
     * @return
     */
    IPage<Article> searchArticle(Page<Article> page, String search);

}
