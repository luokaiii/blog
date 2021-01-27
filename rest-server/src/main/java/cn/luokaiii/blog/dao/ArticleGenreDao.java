package cn.luokaiii.blog.dao;

import cn.luokaiii.blog.entity.ArticleGenre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date 2021/1/27
 */
public interface ArticleGenreDao extends JpaRepository<ArticleGenre, Integer> {
}
