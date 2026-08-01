/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.his.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BedTurnoverService {
    public TurnoverResult evaluate(TurnoverRequest request) {
        int readyBeds = Math.max(0, Math.min(request.dischargedBeds(), request.cleaningCompleted())
            - request.isolationBeds());
        int shortage = Math.max(0, request.incomingPatients() - readyBeds);
        int pressureScore = Math.min(100,
            shortage * 12 + Math.max(0, request.averageCleaningMinutes() - 45)
            + Math.min(20, request.incomingPatients() * 100 / request.staffedBeds()));
        String status = shortage > 0 && (request.averageCleaningMinutes() > 60 || pressureScore >= 70)
            ? "SURGE" : shortage > 0 ? "COORDINATE" : "READY";
        List<String> actions = new ArrayList<>();
        if (request.averageCleaningMinutes() > 60) actions.add("协调保洁班组优先完成高需求病区床位周转");
        if (shortage > 0) actions.add("联动入院中心调整候床顺序和病区容量");
        if (request.isolationBeds() > 0) actions.add("保留隔离床位并核验院感开放条件");
        if (actions.isEmpty()) actions.add("床位准备满足当前入院需求，持续监测变化");
        return new TurnoverResult(readyBeds, shortage, pressureScore, status, actions);
    }

    public record TurnoverRequest(@NotNull @Min(0) @Max(10000) Integer dischargedBeds,
        @NotNull @Min(0) @Max(10000) Integer cleaningCompleted,
        @NotNull @Min(0) @Max(10000) Integer isolationBeds,
        @NotNull @Min(0) @Max(10000) Integer incomingPatients,
        @NotNull @Min(0) @Max(1440) Integer averageCleaningMinutes,
        @NotNull @Positive Integer staffedBeds) {}
    public record TurnoverResult(int readyBeds, int shortage, int pressureScore,
        String status, List<String> actions) {}
}
