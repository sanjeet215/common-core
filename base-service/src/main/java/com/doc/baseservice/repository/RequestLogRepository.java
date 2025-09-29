package com.doc.baseservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.doc.baseservice.entity.RequestLogEntity;

public interface RequestLogRepository extends JpaRepository<RequestLogEntity, Long> {
}
