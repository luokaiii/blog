package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 文章分类
 *
 * @Date 2021/1/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "blog_article_genre")
public class ArticleGenre extends AbstractEntity {
    /**
     * 文章ID
     */
    private Integer articleId;
    /**
     * 类型ID
     */
    private Integer genreId;

    public ArticleGenre() {
    }

    public ArticleGenre(Integer articleId, Integer genreId) {
        this.articleId = articleId;
        this.genreId = genreId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
