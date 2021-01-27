package cn.luokaiii.blog.dto.article;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章内容更新对象
 *
 * @Date 2021/1/27
 */
@Getter
@Setter
public class ArticleContentUpdateDTO {
    /**
     * Markdown内容
     */
    private String content;
}
