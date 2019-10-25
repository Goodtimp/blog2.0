package com.blog2.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog2.backend.dao.ArticleMapper;
import com.blog2.backend.enums.DelFlagEnum;
import com.blog2.backend.model.entity.Article;
import com.blog2.backend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: goodtimp
 * @Date: 2019/10/11 16:00
 * @description :
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    private final ArticleMapper articleMapper;

    @Override
    public IPage<Article> getByCategoryId(Page<Article> page, Long id) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(id > 0, Article::getArticleId, id).eq(Article::getDelFlag, DelFlagEnum.NORMAL.getCode());
        return articleMapper.selectPage(page, queryWrapper);
    }

    @Override
    public void addArticle(Article article) {
        article.setArticleId(null);
        article.setCreate();
        article.setDelFlag(DelFlagEnum.NORMAL.getCode());
        this.save(article);
    }

    @Override
    public void updateArticle(Article article) {
        if (article.getArticleId() != null) {
            article.setUpdate();
            article.setDelFlag(DelFlagEnum.NORMAL.getCode());
            this.updateById(article);
        }
    }

    @Override
    public void deleteArticle(Long id) {

    }

    @Override
    public IPage<Article> searchArticle(Page<Article> page, String search) {
        return null;
    }
}
