/*
 * Copyright (c) 2014, Baidu and/or its affiliates. All rights reserved.
 * Baidu PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.yvan.utils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * This ConstantUtil class is used to define constant variables.
 *
 * @author chenjiawen@baidu.com
 *
 */
public class ConstantUtil {

    // Define the return codes
    public static final int RETCODE_ERROR = 1;
    public static final int RETCODE_CORRECT = 0;
    public static final String RETMSG_CORRECT = "获取信息成功";
    public static final String RETMSG_MARK_SYNC_CORRECT = "标注数据同步成功";
    
    // Define rest request prefix
    public static final String REST_PREFIX = "/action";
    
    public static final String REST_AUTH_TYPE_PASSPORT = "PASSPORT";
    
    public static final String REST_AUTH_TYPE_UC = "UC";

    // Define http request type
    public static final int HTTP_POST   = 0;
    public static final int HTTP_GET    = 1;
    public static final int HTTP_PUT    = 2;
    public static final int HTTP_DELETE = 3;

    // Define return message for http execution
    public static final String RETMSG_HTTP_POST_FAIL   = "http post请求执行失败:";
    public static final String RETMSG_HTTP_GET_FAIL    = "http get请求执行失败:";
    public static final String RETMSG_HTTP_PUT_FAIL    = "http put请求执行失败:";
    public static final String RETMSG_HTTP_DELETE_FAIL = "http delete请求执行失败:";
    
    // Define the project default charset
    public static final String DEFAULT_CHARSET = "UTF-8";
    
    // Define the other charset
    public static final String CHARSET_ISO = "iso8859-1";
    
    // Define the parameter key for post body
    public static final String POST_BODY_FLAG = "messageBody";

    public static final String RETMSG_NO_LOGIN = "请先登录";
    public static final String RETMSG_DOCKERCLUSTER_CREATE_ERR = "创建私有集群失败";
    public static final String RETMSG_DOCKERCLUSTER_NAME_DUPLICATION = "创建失败, 集群名称已被使用";
    public static final String RETMSG_DOCKERCLUSTER_ERROR = "操作失败, 调用k8s集群失败";
    public static final String RETMSG_DOCKERCLUSTER_NAME_NOTEXIST = "删除失败, 集群名称不存在";
    public static final String RETMSG_DOCKERCLUSTER_DELETE_ERR = "删除私有集群失败";
    public static final String RETMSG_DOCKERCLUSTER_MACHINE_NOTEXIST = "添加机器失败, 机器不存在";
    public static final String RETMSG_DOCKERCLUSTER_MACHINE_REPEAT = "添加机器失败, 已重复添加，请删除后重新添加";
    public static final String RETMSG_DOCKERCLUSTER_MACHINE_ERR = "向私有集群添加机器失败";
    public static final String RETMSG_DOCKERCLUSTER_CLUSTER_NOTEXIST = "添加机器失败, 集群不存在";
    public static final String RETMSG_DOCKERCLUSTER_DATASET_NOTEXIST = "添加机器失败, 数据集不存在";

    public static final String RETMSG_NO_CONFIG = "无此配置信息";
    
    public static final String STATUS_CLUSTERMACHINE_ADDING = "adding";
    public static final String STATUS_CLUSTERMACHINE_FAILED = "failed";
    public static final String STATUS_CLUSTERMACHINE_ACTIVE = "active";
    
    public static final String RETMSG_DOCKERJOB_CREATE_ERR = "创建作业失败";
    public static final String RETMSG_DOCKERJOB_CREATE_NAMEREPEATED = "创建作业失败, 作业名字重复";
    public static final String RETMSG_DOCKERJOB_CREATE_CONFIG_NOTEXIST = "创建任务失败, 模型配置不存在";

    public static final String RETMSG_TRAININGJOB_CREATE_ERR = "创建训练任务失败";
    public static final String RETMSG_TRAININGJOB_CREATE_NAMEREPEATED = "创建训练任务失败, 作业名字重复";

    public static final String RETMSG_DOCKERAPP_CREATE_ERR = "创建应用失败";
    public static final String RETMSG_DOCKERAPP_CREATE_NAMEREPEATED = "创建应用失败, 作业名字重复";
    public static final String RETMSG_DOCKERAPP_CREATE_PORTERR = "创建应用失败, 端口不足";
    
    public static final String RETMSG_DEPLOYJOB_CREATE_ERR = "创建部署服务失败";
    public static final String RETMSG_DEPLOYJOB_CREATE_NAMEREPEATED = "创建部署服务失败, 服务名字重复";
    
    // 消息队列的 topic 和 tag
    public static final String MQ_TOPIC_GATEWAY       = "zc-topic-gateway";
    public static final String MQ_TAG_EXCEPTION       = "apigateway-exception-tag";
    public static final String MQ_TAG_AUTH_FILTER     = "apigateway-auth-filter-tag";
    // 表示购买的 appkey 的授权时间段已过期
    public static final String MQ_TAG_AUTH_INVALID_TIME    = "apigateway-auth-invalid-time-tag";  
    // 表示购买的 appkey 的调用次数以达到上限
    public static final String MQ_TAG_AUTH_INVALID_COUNT   = "apigateway-auth-invalid-count-tag"; 
    public static final String MQ_TAG_GET_FILTER      = "apigateway-get-filter-tag";
    public static final String MQ_TAG_POST_FILTER     = "apigateway-post-filter-tag";
    public static final String MQ_TAG_RESPONSE_FILTER = "apigateway-response-filter-tag";

    public static final String MQ_TOPIC_HIGH               = "zc-topic-high";
    public static final String MQ_CLUSTER_TAG              = "cluster-addmachine-tag";
    public static final String MQ_JOB_TAG                  = "job-tag";
    public static final String MQ_APP_TAG                  = "app-tag";
    public static final String MQ_ARCHIVE_TAG              = "archive-tag";             // 发起归档任务
    public static final String MQ_DATASET_CLEAN_TAG        = "datasetclean-tag";        // 发起数据清洗任务
    public static final String MQ_HANDLE_UPLOAD_TASK_FILE_TAG  = "handle-upload-task-file-tag"; // 处理本地上传交付数据
    public static final String MQ_DATASET_CLEAN_TASK_POD_CREATE_TAG = "cleantaskpodcreate-tag"; // pod资源不足等待重试
    public static final String MQ_DATASET_CLEAN_RESULT_TAG = "datasetclean-result-tag"; // 处理数据清洗结果

    public static final String STATUS_ADDING = "ADDING";
    public static final String STATUS_JOB_DELETED = "DELETED";
    public static final String STATUS_JOB_DELETING = "DELETING";
    
    public static final int RESOURCE_TYPE_CPU = 1;
    public static final int RESOURCE_TYPE_GPU = 2;
    
    public static final String RETMSG_DOCKERJOB_LOG_ERR = "获取日志失败";
    public static final String RETMSG_DOCKERJOB_REGISTERURL_ERR = "创建作业失败";
    public static final String RETMSG_DOCKERJOB_REDIRECTURL_ERR = "日志跳转失败";
    
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_FAILED = "failed";
    
    public static final String RETMSG_ORIGINALDATASET_CREATE_ERR = "同步数据失败";
    public static final String RETMSG_ORIGINALDATASET_QUERYPROJECT_ERR = "获取项目列表失败";
    public static final String RETMSG_ORIGINALDATASET_DELETETASK_ERR = "删除任务失败";

    public static final String RETMSG_ORIGINALDATASET_CREATECOMMONPROJECTTASK_ERR = "提交本地上传数据失败";
    public static final String RETMSG_ORIGINALDATASET_CREATECOMMONPROJECTTASK_NEEDSOURCE = "请先上传原始文件";
    public static final String RETMSG_ORIGINALDATASET_CREATECOMMONPROJECTTASK_NEEDRESULT = "请先上传标注结果文件或说明文件";

    public static final String RETMSG_TRAININGJOB_QUERYJOB_ERR = "获取训练任务列表失败";
    public static final String RETMSG_TRAININGJOB_DELETEJOB_ERR = "删除训练任务失败";
    public static final String RETMSG_DOCKERJOB_NOTFOUND_ERR = "底层作业不存在";
    public static final String RETMSG_POD_NOTFOUND_ERR = "底层POD不存在";
    
    public static final String RETMSG_DEPLOYJOB_QUERYJOB_ERR = "获取发布服务列表失败";
    public static final String RETMSG_DEPLOYJOB_DELETEJOB_ERR = "删除发布服务失败";
    
    public static final String RETMSG_APP_PREDICT_ERR = "获取预测信息失败";

    public static final String ARCHIVE_TASK_TPL_GET_ERR = "获取归档数据模板失败";
    public static final String RETMSG_ARCHIVE_TASK_ILLEGAL = "任务属性（数据格式、数据分类、数据类型、所属项目）不一致";
    public static final String RETMSG_ARCHIVE_TASK_AT_LEAST_ONE = "至少要有一份待归档的数据";
    public static final String RETMSG_ARCHIVE_TASK_NOT_COMBINE = "只能对单个任务数据进行归档操作";
    public static final String RETMSG_USER_HAS_NOT_TASK_AUTH = "当前用户没有改交付数据的操作权限";
    public static final String TASK_STATUS_NORMAL = "NORMAL";
    public static final String TASK_STATUS_TO_ARCHIVE = "TO_ARCHIVE";
    public static final String TASK_STATUS_ARCHIVING = "ARCHIVING";
    public static final String TASK_STATUS_ARCHIVED = "ARCHIVED";

    public static final int TASK_UPLOAD_STATUS_UPLOADING  = 1; // 上传中
    public static final int TASK_UPLOAD_STATUS_HANDLING   = 2; // 处理中
    public static final int TASK_UPLOAD_STATUS_TO_CONFIRM = 3; // 待确认上传数据
    public static final int TASK_UPLOAD_STATUS_CONFIRMED  = 4; // 已确认上传数据
    public static final int TASK_UPLOAD_STATUS_FAILED     = 5; // 处理失败

    public static final String RETMSG_TASK_NOT_FIND = "找不到任务记录";

    public static final String RETMSG_DATAHUB_NEED_USER_LOGIN = "请先登录系统";
    public static final String RETMSG_DATAHUB_UNKNOWN_ROLE    = "未知的用户角色，请尝试重新登录";
    public static final String RETMST_DATAHUB_USER_GET_ERROR = "获取用户信息失败";

    public static final String RETMSG_DATAHUB_PAGE_INFO_ILLEGE = "请求的分页信息不正确";

    public static final String RETMSG_DATASET_QUERYPROJECT_ERR = "获取数据集列表失败";
    public static final String RETMSG_DATASET_STATISTICS_ERR = "获取数据集统计失败";
    public static final String RETMSG_DATASET_DETAIL_ERR = "获取数据集详情失败";
    public static final String RETMSG_DATASET_LIST_ERR = "获取数据列表失败";
    public static final String RETMSG_DATA_DETAIL_ERR = "获取数据详情失败";
    public static final String RETMSG_DATASET_PROPS_LIST_ERR = "获取数据集属性列表失败";
    public static final String RETMSG_DATASET_PROPS_TREE_DATA_GET_ERR = "获取数据集树类型数据失败";
    public static final String RETMSG_DATASET_PROPS_TREE_DATA_UPDATE_ERR = "更新数据集树类型数据失败";
    public static final String RETMSG_GET_DATASET_COMBINE_TPL_ERR = "获取数据集合并模板失败";

    public static final String RETMSG_USER_PROPS_DISMATCH = "用户与属性类型不匹配";

    public static final String RETMSG_CONTACTUS_ERR = "联系我们失败";

    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final Integer[] EMPTY_INTEGER_ARRAY = new Integer[0];
    public static final int COMMON_LIST_MAX_PAGE_SIZE = 50;
    
    public static final String DATASET_DATA_TYPE_IMAGE = "image";
    public static final String DATASET_DATA_TYPE_VIDEO = "video";

    public static final HashMap<Integer, Object> DATASET_DATATYPE_MAP = new HashMap<Integer, Object>() {
        {
            put(1, "image");
            put(2, "video");
            put(3, "audio");
            put(4, "other");
            put(5, "text");
            put(6, "3D");
        }
    };

    public static final int MARK_DATASET_DATA_TYPE_IMAGE = 1;
    public static final int MARK_DATASET_DATA_TYPE_VIDEO = 2;
    public static final int MARK_DATASET_DATA_TYPE_AUDIO = 3;
    public static final int MARK_DATASET_DATA_TYPE_OTHER = 4;

    // 平台数据集的数据类型
    public static final int PLATFORM_DATASET_DATA_TYPE_IMAGE = 1; // 图片
    public static final int PLATFORM_DATASET_DATA_TYPE_VIDEO = 2; // 视频
    public static final int PLATFORM_DATASET_DATA_TYPE_AUDIO = 3; // 音频
    public static final int PLATFORM_DATASET_DATA_TYPE_OTHER = 4; // 其他
    public static final int PLATFORM_DATASET_DATA_TYPE_TEXT  = 5; // 文本
    public static final int PLATFORM_DATASET_DATA_TYPE_3D    = 6; // 3d

    public static final int VALID_DETECT_MARK_TYPE_MAX_LIMIT = 10; // 有效检测标注题型的次数上限

    // 数据集（dataset_project）的数据来源 和 数据（originaldataset_task）的 类别（type）
    public static final int PLATFORM_DATASET_DATA_SOURCE_MARK               = 1; // 标注
    public static final int PLATFORM_DATASET_DATA_SOURCE_COLLECTION         = 2; // 采集
    public static final int PLATFORM_DATASET_DATA_SOURCE_LOCAL              = 3; // 本地上传
    public static final int PLATFORM_DATASET_DATA_SOURCE_OFFICIAL           = 4; // 官方数据集
    public static final int PLATFORM_DATASET_DATA_SOURCE_OPEN               = 5; // 开源数据集
    public static final int PLATFORM_DATASET_DATA_SOURCE_MARK_SERVICE       = 7; // 标注服务订单数据
    public static final int PLATFORM_DATASET_DATA_SOURCE_COLLECTION_SERVICE = 8; // 采集服务订单数据
    public static final int PLATFORM_DATASET_DATA_SOURCE_SELFMARK           = 9; // 自标注平台推送数据
    public static final int PLATFORM_DATASET_DATA_SOURCE_SHANXI_GOVERMENT   = 10; // 山西政府公共数据索引数据集
    public static final int PLATFORM_DATASET_DATA_SOURCE_PUDGE              = 11; // 众测平台推送数据（姗姗手动导出数据）
    public static final int PLATFORM_DATASET_DATA_SOURCE_API_SERVICE        = 12; // API 服务数据
    public static final int PLATFORM_DATASET_DATA_SOURCE_ZHONGCE            = 13; // 众测平台推送数据（曹宇提供的接口数据）

    // 数据集数据格式（source_type），类似于题型的概念，目前在 task 中双写在 extra 字段的 sourceType 中
    public static final int PLATFORM_DATASET_SOURCE_TYPE_UNKNOWN    = 0; // 未知
    public static final int PLATFORM_DATASET_SOURCE_TYPE_MARK       = 1; // 标注
    public static final int PLATFORM_DATASET_SOURCE_TYPE_COLLECTION = 2; // 采集
    public static final int PLATFORM_DATASET_SOURCE_TYPE_OPEN       = 3; // 开源

    // 数据集的可视化类别，对应 dataset_project 的 show_type 字段
    public static final int PLATFORM_DATASET_SHOW_TYPE_ALL_VISUALIZATION  = 1; // 全可视化
    public static final int PLATFORM_DATASET_SHOW_TYPE_NO_VISUALIZATION   = 2; // 非可视化
    public static final int PLATFORM_DATASET_SHOW_TYPE_HALF_VISUALIZATION = 3; // 半可视化

    // 不同数据来源对应的 originaldataset_project 中的 project_id
    public static final BigInteger PLATFORM_ORIGINALDATASET_PROJECT_PUDGE_ID   = new BigInteger("5"); // datasource 11
    public static final BigInteger PLATFORM_ORIGINALDATASET_PROJECT_ZHONGCE_ID = new BigInteger("6"); // datasource 13

    // 不同数据来源对应的 originaldataset_project 中的 project_name
    public static final String PLATFORM_ORIGINALDATASET_PROJECT_PUDGE_NAME      = "pudge_project";   // project_id: 5
    public static final String PLATFORM_ORIGINALDATASET_PROJECT_ZHONGCE_NAME    = "zhongce_project"; // project_id: 6

    // 平台内sourceType的值（可以理解代表着数据格式）
    public static final int PLATFORM_SOURCE_TYPE_UNKNOW             = 0;    // 未知
    public static final int PLATFORM_SOURCE_TYPE_MARK               = 1;    // 标注
    public static final int PLATFORM_SOURCE_TYPE_COLLECTION         = 2;    // 采集

    // 交付数据（originaldataset_task）的是否删除（is_deleted）
    public static final int ORIGINALDATASET_TASK_IS_DELETED_NORMAL = 0;
    public static final int ORIGINALDATASET_TASK_IS_DELETED_DELETED = 1;

    // 上传 task 文件的类别
    public static final int UPLOAD_TASK_SOURCE_FILE = 1; // 上传原始数据文件
    public static final int UPLOAD_TASK_RESULT_FILE = 2; // 上传标注结果文件或者是说明文件
    
    public static final String DATASET_IDENTIFIER_PREFIX          = "SSJ0000";
    public static final String OFFICIAL_DATASET_IDENTIFIER_PREFIX = "SQJ00"; // 官方数据集标识符前缀
    public static final String OPEN_DATASET_IDENTIFIER_PREFIX     = "SPJ00"; // 开源数据集标识符前缀

    public static final String API_SERVICE_IDENTIFIER_PREFIX = "API";

    public static final int DATASET_STATUS_CREATING = 1;
    public static final int DATASET_STATUS_CREATED = 2;

    public static final int DATASET_SAMPLE_MAX_COUNT = 3;
    public static final int COLLECTION_DATASET_SAMPLE_MAX_COUNT = 10; // 采集推送和本地上传的采集数据集最多展示 10 个样例 
    public static final int OFFICIAL_COLLECTION_DATASET_SAMPLE_MAX_COUNT = 6; // 官方采集数据集最多展示 6 个样例 

    public static final String DATASET_MARK_TOPIC_2D = "2D";
    public static final int DATASET_DATASOURCE_MARK = 1;
    public static final int DATASET_DATASOURCE_COLLECT = 2;

    public static final String RETMSG_CONFIG_ERR = "获取配置信息失败";
    
    public static final String RETMSG_INVALID_TOKEN = "不合理的token";
    public static final String RETMSG_INVALID_FILE = "不合理的文件";
    
    public static final int DATA_TYPE_MARK = 1;
    public static final int DATA_TYPE_COLLECTION = 2;
    public static final int DATA_TYPE_LOCAL = 3;
    public static final int DATA_TYPE_PUBLIC = 4;
    public static final int DATA_TYPE_OPENSOURCE = 5;

    public static final int USER_DATASET_RELATION_CREATOR   = 0; // 数据集的创建者
    public static final int USER_DATASET_RELATION_COLLECTOR = 1; // 数据集的收藏者

    public static final int DATAHUB_DATABASE_RECORD_INVALID = 0; // 数据库中的记录无效
    public static final int DATAHUB_DATABASE_RECORD_VALID   = 1; // 数据库中的记录有效

    public static final byte DATAHUB_DATABASE_RECORD_TINYINT_INVALID = 0;
    public static final byte DATAHUB_DATABASE_RECORD_TINYINT_VALID = 1;

    public static final int DATAHUB_DATABASE_RECORD_HIDDEN = 1;         // 数据库中的记录隐藏
    public static final int DATAHUB_DATABASE_RECORD_NOT_HIDDEN = 0;     // 数据库中的记录显示

    public static final int DATAHUB_DATABASE_RECORD_NOT_DELETED = 0; // 数据库中的记录未删除
    public static final int DATAHUB_DATABASE_RECORD_DELETED     = 1; // 数据库中的记录已删除

    public static final int DATAHUB_EMAIL_STATUS_TOSEND = 0; // 邮件发送状态，待发送
    public static final int DATAHUB_EMAIL_STATUS_SENT   = 1; // 邮件发送状态，已发送
    
    public static final int DATAHUB_DATABASE_REPLACE_STEP = 1000; // 数据库单次执行 replace 的数据量
    
    public static final String RETMSG_COLLECTIONPROJECT_EXIST = "同步失败, 项目ID存在";

    // datasource
    public static final String DATASET_SOURCE_COLLECTION = "COLLECTION";
    public static final String DATASET_SOURCE_MARK = "MARK";
    public static final String DATASET_SOURCE_LOCAL = "LOCAL";
    
    public static final String MAIL_STATUS_STAGE = "STAGE";
    public static final String MAIL_STATUS_SENDING = "SENDING";
    public static final String MAIL_STATUS_SENT = "SENT";
    public static final short NEED_SEND_MAIL = 0;
    public static final short HAS_SENT_MAIL = 1;
    public static final short NO_NEED_SEND_MAIL = 2;
    public static final String USER_MAIL_SEPARATOR = ",";
    public static final String USER_MAIL_AT_SYMBOL = "@";
    public static final String TABLE_COLUMN_SEPARATOR = ".";
    public static final String EQUAL_SEPARATOR = "=";
    public static final String MAIL_TITLE_SEPARATOR = ";";
    public static final String DOMAIN_BAIDU = "baidu.com";

    // 数据集清洗相关常量
    public static final String DATASET_CLEAN_TASK_AUTH_FAIL = "用户没有清洗任务权限";

    public static final int DATASET_CLEAN_PROCESS_TODO   = 1; // 待算法处理
    public static final int DATASET_CLEAN_PROCESS_DOING  = 2; // 算法处理中
    public static final int DATASET_CLEAN_PROCESS_DONE   = 3; // 算法处理完成
    public static final int DATASET_CLEAN_PROCESS_SAVED  = 4; // 结果转存完成
    public static final int DATASET_CLEAN_PROCESS_FAILED = 5; // 算法处理失败

    public static final int DATASET_CLEAN_TASK_REQUEST_STATUS_ALL        = 0; // 全部状态
    public static final int DATASET_CLEAN_TASK_REQUEST_STATUS_TO_CLEAN   = 1; // 待启动
    public static final int DATASET_CLEAN_TASK_REQUEST_STATUS_PROCESSING = 2; // 运行中
    public static final int DATASET_CLEAN_TASK_REQUEST_STATUS_FINISH     = 3; // 清洗完成
    public static final int DATASET_CLEAN_TASK_REQUEST_STATUS_CHECK_FAIL = 4; // 审核不通过

    public static final int DATASET_CLEAN_TASK_STATUS_ALL        = 0; // 全部状态
    public static final int DATASET_CLEAN_TASK_STATUS_TO_CLEAN   = 1; // 待启动
    public static final int DATASET_CLEAN_TASK_STATUS_TO_CHECK   = 2; // 待审核（运行中）
    public static final int DATASET_CLEAN_TASK_STATUS_CHECKING   = 3; // 审核中（运行中）
    public static final int DATASET_CLEAN_TASK_STATUS_PROCESSING = 4; // 清洗中（运行中）
    public static final int DATASET_CLEAN_TASK_STATUS_FINISH     = 5; // 清洗完成
    public static final int DATASET_CLEAN_TASK_STATUS_CHECK_FAIL = 6; // 审核不通过

    public static final Map<Integer, Object> DATASET_CLEAN_TASK_REQUEST_STATUS_MAP = new HashMap<Integer, Object>() {
        private static final long serialVersionUID = 6064978460592552560L;

        {
            put(DATASET_CLEAN_TASK_REQUEST_STATUS_ALL,          DATASET_CLEAN_TASK_STATUS_ALL);
            put(DATASET_CLEAN_TASK_REQUEST_STATUS_TO_CLEAN,     DATASET_CLEAN_TASK_STATUS_TO_CLEAN);
            put(DATASET_CLEAN_TASK_REQUEST_STATUS_PROCESSING,   Arrays.asList(
                                                                    DATASET_CLEAN_TASK_STATUS_TO_CHECK,
                                                                    DATASET_CLEAN_TASK_STATUS_CHECKING,
                                                                    DATASET_CLEAN_TASK_STATUS_PROCESSING
            ));
            put(DATASET_CLEAN_TASK_REQUEST_STATUS_FINISH,       DATASET_CLEAN_TASK_STATUS_FINISH);
            put(DATASET_CLEAN_TASK_REQUEST_STATUS_CHECK_FAIL,   DATASET_CLEAN_TASK_STATUS_CHECK_FAIL);  
        }
    };

    public static final Map<Integer, Integer> DATASET_CLEAN_TASK_STATUS_MAP_REQUEST = new HashMap<Integer, Integer>() {
        private static final long serialVersionUID = 7900542915691463371L;

        {
            put(DATASET_CLEAN_TASK_STATUS_ALL,        DATASET_CLEAN_TASK_REQUEST_STATUS_ALL);
            put(DATASET_CLEAN_TASK_STATUS_TO_CLEAN,   DATASET_CLEAN_TASK_REQUEST_STATUS_TO_CLEAN);
            put(DATASET_CLEAN_TASK_STATUS_TO_CHECK,   DATASET_CLEAN_TASK_REQUEST_STATUS_PROCESSING);
            put(DATASET_CLEAN_TASK_STATUS_CHECKING,   DATASET_CLEAN_TASK_REQUEST_STATUS_PROCESSING);
            put(DATASET_CLEAN_TASK_STATUS_PROCESSING, DATASET_CLEAN_TASK_REQUEST_STATUS_PROCESSING);
            put(DATASET_CLEAN_TASK_STATUS_FINISH,     DATASET_CLEAN_TASK_REQUEST_STATUS_FINISH);
            put(DATASET_CLEAN_TASK_STATUS_CHECK_FAIL, DATASET_CLEAN_TASK_REQUEST_STATUS_CHECK_FAIL);  
        }
    };

    public static final Map<String, String> DATASET_CLEAN_TASK_CONFIG_CLEANTYPE_MAP = new HashMap<String, String>() {
        {
            put("1", "障碍物标注结果");
        }
    };

    public static final Map<String, String> OBSTACLE_MISS_MARK_MAP = new HashMap<String, String>() {
        {
            put("1", "小汽车");
            put("2", "卡车/货车");
            put("3", "面包车");
            put("4", "大货车");
            put("5", "行人");
            put("6", "自行车");
            put("7", "三轮车");
            put("8", "摩托车/电动车");
            put("9", "手推车");
            put("10", "交通锥桶");
        }
    };

    public static final Map<String, Map> DATASET_CLEAN_TASK_CONFIG_QUALIFICATIONTYPE_MAP = new HashMap<String, Map>() {
        {
            put("obstacleMissMark", OBSTACLE_MISS_MARK_MAP);
        }
    };

    public static final int DATASET_CLEAN_CONFIG_CLEAN_TYPE_OBSTACLE_MARK_RET = 1;  // 清洗数据类型-障碍物标注结果

    // 数据清洗中 2d 图片漏标的 mark 球的 y 轴针对框的向上偏移量
    public static final BigDecimal DATASET_CLEAN_MISS_IMAGE_MARK_ANNOTATION_Y_OFFSET = new BigDecimal(10);

    // 数据清洗回调的 code

    public static final int DATASET_CLEAN_CALLBACK_CODE_SUCCESS             =  1; // 数据清洗成功
    public static final int DATASET_CLEAN_CALLBACK_CODE_ERROR_NEED_PARAM    = -1; // 欠缺参数
    public static final int DATASET_CLEAN_CALLBACK_CODE_ERROR_PREDICT_FAIL  = -2; // 模型处理失败
    public static final int DATASET_CLEAN_CALLBACK_CODE_ERROR_UPLOAD_FAIL   = -3; // 上传结果文件失败

    // trade
    public static final List<Integer> USER_ROLES_LIST = Arrays.asList(1, 2, 3);
    public static final int USER_ROLE_NORMAL   = 0; // 交易平台的角色 - 普通用户
    public static final int USER_ROLE_OPERATOR = 1; // 交易平台的角色 - 运营
    public static final int USER_ROLE_SUPPLIER = 2; // 交易平台的角色 - 卖家
    public static final int USER_ROLE_BUYER    = 3; // 交易平台的角色 - 买家

    // 用户到平台的角色映射map
    public static final Map<Integer, Integer> PLATFORM_USER_ROLE_MAP = new HashMap<Integer, Integer>() {
        {
            put(0, 0);
            put(1, 3);
            put(2, 2);
            put(3, 1);
        }
    };

    // 用户操作类型
    public static  final int TRADE_OPERATION_CREATE         = 0;    // 新建
    public static  final int TRADE_OPERATION_EDIT           = 1;    // 编辑/删除
    public static  final int TRADE_OPERATION_READ           = 2;    // 查看详情
    public static  final int TRADE_OPERATION_CHECK          = 3;    // 审核
    public static  final int TRADE_OPERATION_PUBLISH        = 4;    // 发布/下架
    public static  final int TRADE_OPERATION_PUBLISH_EDIT   = 5;    // 编辑发布信息

    // 返回客户端的错误信息
    public static final String RETMSG_API_SERVICE_CREATE_ERR = "创建 API 服务失败";
    public static final String RETMSG_API_SERVICE_EDIT_ERR = "编辑 API 服务失败";
    public static final String RETMSG_API_SERVICE_PUBLISH_ERR = "发布 API 服务失败";
    public static final String RETMSG_API_SERVICE_DOWN_ERR = "下架 API 服务失败";
    public static final String RETMSG_API_SERVICE_DELETE_ERR = "删除失败，仅支持删除未发布、已驳回和已停用API服务";
    public static final String RETMSG_API_SERVICE_LIST_ERR = "获取 API 服务列表失败";
    public static final String RETMSG_API_SERVICE_AUDIT_LIST_ERR = "获取 API 服务待审核列表失败";
    public static final String RETMSG_API_SERVICE_DETAIL_ERR = "获取 API 服务详情失败";
    public static final String RETMSG_API_SERVICE_CATEGORY_ERR = "获取商城分类树失败";
    public static final String RETMSG_API_SERVICE_SYNC_ERR = "同步 API 服务信息失败";

    public static final String RETMSG_API_SERVICE_ROUTE_LIST_ERR = "获取API接口列表失败";
    public static final String RETMSG_API_SERVICE_ROUTE_DETAIL_ERR = "获取API详情失败";
    public static final String RETMSG_API_SERVICE_ROUTE_UPDATE_ERR = "保存API接口失败";
    public static final String RETMSG_API_SERVICE_ROUTE_DELETE_ERR = "删除API接口失败";
    public static final String RETMSG_API_SERVICE_ROUTE_CREATE_ERR = "新增API接口失败";

    public static final String RETMSG_API_SERVICE_AUTH_GET_ERR = "获取 API 授权失败";
    public static final String RETMSG_API_SERVICE_AUTH_CREATE_ERR = "创建 API 服务授权失败";
    public static final String RETMSG_API_SERVICE_AUTH_EDIT_ERR = "更新 API 服务授权失败";

    // 交易平台 应用领域 二级节点 默认 图片地址
    public static final String TRADE_PROPS_TREE_DEFAULT_ICON_URL =
            "https://datahub.bj.bcebos.com/trade/icons/category/mallCate61.svg";

    /**
     * @v_zhangbo11 2020/0910
     * 当前存在对全部状态的两种解释，一种是此处 0 表示任意状态，另一种是获取 API 服务列表的 getList
     * 方法调用的 appendQuery 方法中认为 -1 为任意状态不过滤
     * 为保证两处的兼容性，认定小于等于 0 的情况均为任意状态
     */

    public static final int TRADE_API_SERVICE_NOT_PUBLISH   = 0; // 新建、编辑 API 服务时不发布
    public static final int TRADE_API_SERVICE_PUBLISH   = 1; //     新建、编辑 API 服务之后立即发布

    public static final int TRADE_DATASET_PUBLISH_PUBLIC_METHOD_DATASET = 0;    // 数据公开方式 - 数据集
    public static final int TRADE_DATASET_PUBLISH_PUBLIC_METHOD_API = 1;        // 数据公开方式 - api
    public static final int TRADE_DATASET_PUBLISH_PUBLIC_METHOD_INDEX = 2;      // 数据公开方式 - 数据索引

    // 发布数据集时默认的封面地址（和数据类型对应）
    public static final Map<Integer, String> TRADE_DATASET_PUBLISH_IMAGE_URL_MAP = new HashMap<Integer, String>() {
        {
            put(ConstantUtil.PLATFORM_DATASET_DATA_TYPE_AUDIO,
                    "http://data.zgsfqxcx.cn/site/assets/images/supply/dataset-audio-icon.png");
            put(ConstantUtil.PLATFORM_DATASET_DATA_TYPE_IMAGE,
                    "http://data.zgsfqxcx.cn/site/assets/images/supply/dataset-pic-icon.png");
            put(ConstantUtil.PLATFORM_DATASET_DATA_TYPE_VIDEO,
                    "http://data.zgsfqxcx.cn/site/assets/images/supply/dataset-video-icon.png");
            put(ConstantUtil.PLATFORM_DATASET_DATA_TYPE_TEXT,
                    "http://data.zgsfqxcx.cn/site/assets/images/supply/dataset-text-icon.png");
            put(ConstantUtil.PLATFORM_DATASET_DATA_TYPE_OTHER,
                    "http://data.zgsfqxcx.cn/site/assets/images/supply/dataset-other-icon.png");
        }
    };

    public static final String TRADE_DATASET_PUBLISH_DEFAULT_MALL_CATEGORY = "其他";  // 发布数据集时默认的商城分类

    public static final int TRADE_DATASET_PUBLISH_MAX_SAMPLE_COUNT = 10; // 允许的最大发布样例数

    public static final int DATASET_PROPS_TYPE_TREE = 1;

    public static final int DATASET_PROPS_NOT_ONLY_OPERATOR = 0;
    public static final int DATASET_MALL_CATEGORY_PROPS_ID = 3;
    public static final int DATASET_CATEGORY_PROPS_ID = 1;
    public static final int DATASET_GOVERNMENT_CATEGORY_PROPS_ID = 4;
    public static final int DATASET_INDUSTRY_CATEGORY_PROPS_ID = 5; // 行业数据分类，对应 dataset_props 表的 id

    public static final int MALL_DATASET_SOURCE_OPERATOR = 1;
    public static final int MALL_DATASET_SOURCE_SUPPLIER = 2;

    public static final int ORIGINALDATASET_TASK_EXTRA_ZHONGCE_FORMAT = 1;

    public static final HashMap<Integer, String> DATASET_SERVICE_TYPE_DATASOURCE_MAP = new HashMap<Integer, String>() {
        {
            put(0, "order_collection_project");
            put(1, "order_mark_project");
        }
    };

    public static final HashMap<Integer, Integer> DATASET_SERVICE_TYPE_AND_SOURCETYPE_MAP =
            new HashMap<Integer, Integer>() {
                {
                    put(0, ConstantUtil.PLATFORM_DATASET_SOURCE_TYPE_COLLECTION);
                    put(1, ConstantUtil.PLATFORM_DATASET_SOURCE_TYPE_MARK);
                }
            };

    // Es相关常量
    public static final String ES_INDEX_TYPE_NONVISUAL      = "nonvisual";  // 非可视化数据index类型
    public static final String ES_INDEX_TYPE_COLLECTION     = "collection"; // 采集可视化数据index类型
    public static final String ES_INDEX_TYPE_MARK2D         = "mark2d";     // 标注2d图片可视化数据index类型
    public static final String ES_INDEX_TYPE_OFFICIAL_COLLECTION     = "official_collection"; // 官方数据集中采集可视化数据index类型
    // 网关日志归档相关的 ES 常量
    public static final String ES_INDEX_TYPE_GATEWAY_AUTH_FILTER    = "gateway_auth_filter";
    public static final String ES_INDEX_TYPE_GATEWAY_AUTH_INVALID   = "gateway_auth_invalid";
    public static final String ES_INDEX_TYPE_GATEWAY_GET_FILTER     = "gateway_get_filter";
    public static final String ES_INDEX_TYPE_GATEWAY_POST_FILTER    = "gateway_post_filter";
    public static final String ES_INDEX_TYPE_GATEWAY_RESPONSE_FILTER = "gateway_response_filter";
    public static final String ES_INDEX_TYPE_GATEWAY_EXCEPTION      = "gateway_exception";

    public static final int API_SERVICE_MAX_QUERY_COUNT = 10000000;

    public static final HashMap<Integer, Object> API_SERVICE_PARAM_REQUIRED_MAP = new HashMap<Integer, Object>() {
        {
            put(0, "no");
            put(1, "yes");
            put(2, "fixed");

        }
    };

    public static final byte API_SERVICE_PARAM_REQUIRED_NO = 0;
    public static final byte API_SERVICE_PARAM_REQUIRED_YES = 1;
    public static final byte API_SERVICE_PARAM_REQUIRED_FIXED = 2;

    // 请求头参数信息
    // 请求头的名字
    public static final String API_SERVICE_PARAM_HEADER_NAME = "X-Bce-Signature";
    // 请求头的类型
    public static final String API_SERVICE_PARAM_HEADER_TYPE = "string";
    // 请求头的 location 类型
    public static final String API_SERVICE_PARAM_HEADER_LOCATION = "header";
    // 请求头的 描述
    public static final String API_SERVICE_PARAM_HEADER_DESCRIPTION = "自动添加的header信息";


    public static final String ES_INDEX_TYPE_IMAGE    = "image";        // 图片
    public static final String ES_INDEX_TYPE_AUDIO    = "audio";        // 音频
    public static final String ES_INDEX_TYPE_VIDEO    = "video";        // 视频
    public static final String ES_INDEX_TYPE_TEXT     = "text";         // 文本
    public static final String ES_INDEX_TYPE_3D       = "3d";           // 3d
    public static final String ES_INDEX_TYPE_ORTHER   = "other";        // 其他

    // 采集、标注数据对应的样例数据量
    public static Map<Integer, Integer> DATASET_SAMPLE_MAX_COUNT_MAP = new HashMap<Integer, Integer>() {
        {
            put(ConstantUtil.PLATFORM_SOURCE_TYPE_UNKNOW,       10); // 未知数据集保留 10 个样例
            put(ConstantUtil.PLATFORM_SOURCE_TYPE_COLLECTION,   10); // 采集推送和本地上传的采集数据集最多展示 10 个样例 
            put(ConstantUtil.PLATFORM_SOURCE_TYPE_MARK,         1 ); // 标注最多展示 1 个样例 
            put(ConstantUtil.PLATFORM_DATASET_SOURCE_TYPE_OPEN, 10); // 开源数据集保留 10 个样例 
        }
    };

    public static int FACE_DATASET_FAIL_ORDER_INIT = 999999;    // 人脸打码失败的数据集排序向后的其实order


    public static final String RETMSG_DATASET_HOME_ERR = "获取门户首页数据失败";
    public static final String RETMSG_DATASET_ARTIFICIAL_ERR = "获取人工智能前8个标签对应的前5浏览量数据失败";

    public static final int DATASET_VIEW_START = 22000; // 数据集浏览量最小值
    public static final int DATASET_VIEW_INTERVAL = 28000; // 数据集浏览量最大值与最小值的差
    public static final double DATASET_RATE_START = 4.5; // 数据集评分最小值
    public static final double DATASET_RATE_INTERVAL = 0.5; // 数据集评分最大值与最小值的差
    public static final int DATASET_RATE_DIGIT = 10; // 数据集评分位数计算常量
}