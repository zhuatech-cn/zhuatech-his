/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;

import cn.zhuatech.his.common.ApiResponse;
import cn.zhuatech.his.service.BedTurnoverService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/bed-turnover")
public class BedTurnoverController {
    private final BedTurnoverService service;
    public BedTurnoverController(BedTurnoverService service) { this.service = service; }
    @PostMapping
    ApiResponse<BedTurnoverService.TurnoverResult> evaluate(
        @Valid @RequestBody BedTurnoverService.TurnoverRequest request) {
        return ApiResponse.ok(service.evaluate(request));
    }
}
