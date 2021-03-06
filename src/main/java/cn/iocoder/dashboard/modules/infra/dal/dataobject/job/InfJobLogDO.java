package cn.iocoder.dashboard.modules.infra.dal.dataobject.job;

import cn.iocoder.dashboard.framework.mybatis.core.dataobject.BaseDO;
import cn.iocoder.dashboard.framework.quartz.core.handler.JobHandler;
import cn.iocoder.dashboard.modules.infra.enums.job.InfJobLogStatusEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.Date;

/**
 * 定时任务的执行日志 sys_job_log
 *
 * @author 芋道源码
 */
@TableName("inf_job_log")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfJobLogDO extends BaseDO {

    /**
     * 日志编号
     */
    private Long id;
    /**
     * 任务编号
     *
     * 关联 {@link InfJobDO#getId()}
     */
    private Long jobId;
    /**
     * 处理器的名字
     *
     * 冗余字段 {@link InfJobDO#getHandlerName()}
     */
    private String handlerName;
    /**
     * 处理器的参数
     *
     * 冗余字段 {@link InfJobDO#getHandlerParam()}
     */
    private String handlerParam;

    /**
     * 开始执行时间
     */
    private Date beginTime;
    /**
     * 结束执行时间
     */
    private Date endTime;
    /**
     * 执行时长，单位：毫秒
     */
    private Integer duration;
    /**
     * 状态
     *
     * 枚举 {@link InfJobLogStatusEnum}
     */
    private Integer status;
    /**
     * 结果数据
     *
     * 成功时，使用 {@link JobHandler#execute(String)} 的结果
     * 失败时，使用 {@link JobHandler#execute(String)} 的异常堆栈
     */
    private String result;

}
