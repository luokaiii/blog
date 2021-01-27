package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章统计
 * - 网站统计
 * - 指定文章统计
 *
 * @Date 2021/1/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Statistics extends AbstractEntity {
    /**
     * 统计地址
     * - 页面相对地址
     * - 文章ID
     */
    private String link;
    /**
     * 访问次数（不做去重）
     */
    private Long time;
    /**
     * 统计类型
     */
    private Type type;

    public enum Type {
        /**
         * 网页
         */
        WEBPAGE,
        /**
         * 文章
         */
        ARTICLE
    }
}
