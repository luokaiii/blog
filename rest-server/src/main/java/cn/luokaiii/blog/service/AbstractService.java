package cn.luokaiii.blog.service;

import cn.luokaiii.blog.entity.AbstractEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * 抽象通用Service
 *
 * @Date 2021/1/27
 */
public interface AbstractService<T extends AbstractEntity, I extends Serializable> {

    JpaRepository<T, I> getRepository();

    default T create(T t) {
        t.setCreateTime(new Date());
        return getRepository().save(t);
    }

    default T update(T t) {
        t.setUpdateTime(new Date());
        return getRepository().save(t);
    }

    default Optional<T> findById(I i) {
        return getRepository().findById(i);
    }

    default T findExistsById(I i) {
        return getRepository().findById(i)
                .orElseThrow(() -> new RuntimeException("对象不存在！"));
    }

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<T> findAll(Sort sort) {
        return getRepository().findAll(sort);
    }

    default List<T> findAll(Example<T> example, Sort sort) {
        return getRepository().findAll(example, sort);
    }

    default Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    default Page<T> findAll(Example<T> example, Pageable pageable) {
        return getRepository().findAll(example, pageable);
    }
}
