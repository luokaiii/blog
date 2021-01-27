package cn.luokaiii.blog.dto.article;

import lombok.Getter;
import lombok.Setter;

/**
 * 文章搜索对象
 *
 * @Date 2021/1/27
 */
@Getter
@Setter
public class ArticleQueryDTO {
    /**
     * 搜索框内容
     */
    private String search;
    /**
     * 上架状态
     */
    private Boolean shelves;
    /**
     * 删除状态
     */
    private Boolean deleted = true;
}
