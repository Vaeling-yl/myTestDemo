package com.yl;

import lombok.Data;

/**
 * @program: t8t-dcp-crm
 * @description:
 * @author: vaeling.you
 * @create: 2021/2/25
 */
@Data
class Project {
    Integer id;
    //	项目 id
    String name;
    //	项目名称
    String status;
    //	项目状态
    String beginDate;
    //	项目开始时间
    String endDate;
    //	项目结束时间
    String created;
    //	项目创建时间

    Integer creatorId;
    //	项目创建者 id
    String creator;
    //	项目创建者的名字和邮箱
    Integer memberCount;
    //	项目人数
}
