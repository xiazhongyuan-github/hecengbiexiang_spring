package com.hitachi.elderly.entity;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Version;
import java.util.Date;

/**
 * @ClassName: BaseEntity
 * @Description: 数据库表的基础类
 * @Author: lizhe
 * @Date: 2018/9/4
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @CreatedDate
    @Column(name = "created_at",columnDefinition = "datetime COMMENT '创建时间'")
    private Date created_at;

    @CreatedBy
    @Column(name = "created_by",columnDefinition = "varchar(255) COMMENT '此数据的创建者'")
    private String created_by;

    @LastModifiedDate
    @Column(name = "updated_at",columnDefinition = "datetime COMMENT '更新时间'")
    private Date updated_at;

    @LastModifiedBy
    @Column(name = "updated_by",columnDefinition = "varchar(255) COMMENT '此数据的更新者'")
    private String updated_by;


    @Version
    @Column(columnDefinition = "bigint(20) COMMENT '版本号'")
    private long version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }
}
