package com.hitachi.elderly.repository;

import com.hitachi.elderly.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/9 18:22
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface CommentRepository extends JpaRepository<CommentsEntity, String> {
}
