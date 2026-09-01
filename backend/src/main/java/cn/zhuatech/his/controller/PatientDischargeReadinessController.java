/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;

import cn.zhuatech.his.common.ApiResponse;
import cn.zhuatech.his.service.PatientDischargeReadinessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/his")
public class PatientDischargeReadinessController {
    private final PatientDischargeReadinessService service;
    public PatientDischargeReadinessController(PatientDischargeReadinessService service) { this.service = service; }
    @PostMapping("/patient-discharge-readiness")
    public ApiResponse<PatientDischargeReadinessService.Assessment> assess(
            @Valid @RequestBody PatientDischargeReadinessService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
