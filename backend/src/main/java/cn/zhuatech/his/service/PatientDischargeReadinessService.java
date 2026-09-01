/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.service;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class PatientDischargeReadinessService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.attendingApproval()) blockers.add("主诊医师尚未批准出院");
        if (!request.medicationReconciled()) blockers.add("出院用药未完成核对");
        if (!request.followUpArranged()) blockers.add("随访计划未安排");
        if (!request.dischargeSummarySigned()) blockers.add("出院小结未签署");
        if (request.outstandingCriticalResults() > 0) blockers.add("存在未处置的危急检查或检验结果");
        if (!request.patientEducationCompleted()) blockers.add("患者或照护者出院宣教未完成");
        if (!blockers.isEmpty()) {
            actions.add("阻断出院并由临床团队关闭医疗安全缺口");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.transportConfirmed() || !request.bedCleaningTaskCreated()
                || !request.billingReconciled()) {
            if (!request.transportConfirmed()) actions.add("确认患者离院交通或转运安排");
            if (!request.bedCleaningTaskCreated()) actions.add("创建床位清洁与周转任务");
            if (!request.billingReconciled()) actions.add("完成费用清单和医保结算核对");
            return new Assessment(Decision.COORDINATE, blockers, actions);
        }
        actions.add("批准出院并归档医嘱、宣教、随访和结算证据");
        return new Assessment(Decision.DISCHARGE, blockers, actions);
    }

    public record Request(@NotBlank String patientEncounterId, boolean attendingApproval,
                          boolean medicationReconciled, boolean followUpArranged,
                          boolean dischargeSummarySigned, @Min(0) int outstandingCriticalResults,
                          boolean patientEducationCompleted, boolean transportConfirmed,
                          boolean bedCleaningTaskCreated, boolean billingReconciled) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { DISCHARGE, COORDINATE, BLOCKED }
}
