package cn.luokaiii.blog.dao;

import cn.luokaiii.blog.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * 文章持久层
 *
 * @Date 2021/1/27
 */
public interface ArticleDao extends JpaRepository<Article, Integer> {

    @Query("select a from Article a left join ArticleGenre g on a.id=g.articleId where g.genreId=?1")
    Page<Article> findAllByGenreId(Integer genreId, Pageable pageable);

    @Query("select a from Article a left join ArticleTag t on a.id=t.articleId where t.tagId=?1")
    Page<Article> findAllByTagId(Integer tagId, Pageable pageable);
}
