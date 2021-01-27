package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 标签
 *
 * @Date 2021/1/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "blog_tag")
public class Tag extends AbstractEntity {
    /**
     * 名称
     */
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
