package org.test.db.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.test.db.mysql.entity.DocumentEntity;

import java.util.List;

@Repository
public interface DocumentEntityRepository extends JpaRepository<DocumentEntity, Long> {

    @Query("SELECT d FROM DocumentEntity d WHERE " +
            "LOWER(d.title) LIKE %:keyword% OR " +
            "LOWER(d.author) LIKE %:keyword% OR " +
            "LOWER(d.date) LIKE %:keyword% OR " +
            "LOWER(d.content) LIKE %:keyword%")
    List<DocumentEntity> freeTextSearch(@Param("keyword") String keyword);
}
