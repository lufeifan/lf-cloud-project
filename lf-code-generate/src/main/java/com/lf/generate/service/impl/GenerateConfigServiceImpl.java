package com.lf.generate.service.impl;

import com.google.common.base.CaseFormat;
import com.lf.generate.entity.ColumnInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.GenerateConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lufeifan
 * @date 2021/10/25 19:47
 **/
@Service
public class GenerateConfigServiceImpl implements GenerateConfigService {


    @Override
    public void classGenerateConfig(TableInfo tableInfo) {
        String tableName = tableInfo.getTableName();
//            去除表前缀
        if (tableInfo.getIsRemovePrefix()) {
            String[] strings = tableName.split("_");
            String className;
            if (strings.length > 1) {
                String tablePrefix = strings[0];
                className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, StringUtils.stripStart(tableName, tablePrefix));
            }else {
                className = CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_CAMEL,tableName);
            }
            tableInfo.setClassName(className);
        } else {
            String className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, tableName);
            tableInfo.setClassName(className);
        }
    }

    @Override
    public void fieldGenerateConfig(List<ColumnInfo> columnInfoList) {

    }

}
