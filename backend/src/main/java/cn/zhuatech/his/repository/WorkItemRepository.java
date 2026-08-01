/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.his.repository;

import cn.zhuatech.his.model.WorkItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkItemRepository extends JpaRepository<WorkItem, Long> {
    long countByStatus(String status);
    List<WorkItem> findTop8ByOrderByUpdatedAtDesc();
}

