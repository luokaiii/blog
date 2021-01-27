package cn.luokaiii.blog.dao;

import cn.luokaiii.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签持久层
 *
 * @Date 2021/1/27
 */
public interface TagDao extends JpaRepository<Tag, Integer> {
}
