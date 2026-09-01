# 企业级患者出院准备治理

`POST /api/enterprise/his/patient-discharge-readiness` 检查医师批准、用药核对、随访、出院小结、危急结果、患者宣教、转运、床位周转和费用结算，返回 `DISCHARGE / COORDINATE / BLOCKED`。

本模块提供流程治理骨架，不替代临床判断。实际部署须与医嘱、EMR、检验检查、医保结算和床位系统集成，并依照医疗机构制度配置责任角色。
