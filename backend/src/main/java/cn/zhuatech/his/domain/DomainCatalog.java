/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.domain;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DomainCatalog {
    public String systemName() { return "知华 HIS 医院运营协同平台"; }
    public String sceneName() { return "门诊、住院、床位与护理运营"; }
    public List<SeedItem> seedItems() {
        return List.of(
            new SeedItem("HIS-20260801-001", "急诊留观床位协调", "处理中", "急诊协调组", "紧急"),
            new SeedItem("HIS-20260801-002", "三病区今日出院准备", "待处理", "住院服务组", "高"),
            new SeedItem("HIS-20260801-003", "门诊高峰分诊支援", "已完成", "门诊运营组", "中"),
            new SeedItem("HIS-20260801-004", "重点患者检查路径跟进", "处理中", "医务协同组", "高")
        );
    }
    public List<String> recommendedActions() {
        return List.of("优先协调急诊与住院床位资源", "复核超时诊疗节点并通知责任组", "关注关键患者路径的数据完整性");
    }
    public record SeedItem(String recordNo, String title, String status, String owner, String priority) {}
}

