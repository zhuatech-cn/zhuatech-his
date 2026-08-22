/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
export const domain = {
  code: 'HIS',
  product: '医院运营协同平台',
  shortName: '知华 HIS',
  scene: '门诊、住院、床位与护理运营',
  accent: '#146c5a',
  accentSoft: '#e7f2ef',
  greeting: '早上好，运营中心',
  notice: '今日门诊预计较常态增长 8%，建议 10:00 前完成高峰资源复核。',
  metrics: [
    { label: '今日门诊', value: '1,286', unit: '人次', trend: '+8.2%' },
    { label: '在院患者', value: '624', unit: '人', trend: '稳定' },
    { label: '可用床位', value: '86', unit: '张', trend: '+12' },
    { label: '待协调事项', value: '18', unit: '项', trend: '-6' }
  ],
  stages: [
    { name: '预约与分诊', value: 92 }, { name: '诊疗执行', value: 78 },
    { name: '检查协同', value: 66 }, { name: '住院服务', value: 84 }, { name: '出院准备', value: 71 }
  ],
  tasks: [
    { no: 'HIS-0801-001', title: '急诊留观床位协调', owner: '急诊协调组', status: '处理中', priority: '紧急' },
    { no: 'HIS-0801-002', title: '三病区今日出院准备', owner: '住院服务组', status: '待处理', priority: '高' },
    { no: 'HIS-0801-003', title: '门诊高峰分诊支援', owner: '门诊运营组', status: '已完成', priority: '中' },
    { no: 'HIS-0801-004', title: '重点患者检查路径跟进', owner: '医务协同组', status: '处理中', priority: '高' }
  ],
  mobileActions: ['床位协调', '患者路径', '护理交接', '异常上报'],
  mobileStats: [{ label: '我的待办', value: 6 }, { label: '今日完成', value: 11 }, { label: '协同消息', value: 3 }]
}

