package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 分类
 *
 * @Date 2021/1/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "blog_genre")
public class Genre extends AbstractEntity {
    /**
     * 父分类
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String title;
    /**
     * 删除状态
     */
    private Boolean deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
