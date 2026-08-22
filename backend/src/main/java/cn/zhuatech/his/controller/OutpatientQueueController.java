/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.his.controller;
import cn.zhuatech.his.common.ApiResponse;import cn.zhuatech.his.service.OutpatientQueueService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/his/insights/outpatient-queue") public class OutpatientQueueController {private final OutpatientQueueService service;public OutpatientQueueController(OutpatientQueueService service){this.service=service;}@PostMapping ApiResponse<OutpatientQueueService.Result> forecast(@Valid @RequestBody OutpatientQueueService.Request request){return ApiResponse.ok(service.forecast(request));}}
