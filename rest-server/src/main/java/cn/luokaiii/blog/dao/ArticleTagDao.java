package cn.luokaiii.blog.dao;

import cn.luokaiii.blog.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date 2021/1/27
 */
public interface ArticleTagDao extends JpaRepository<ArticleTag, Integer> {
}
