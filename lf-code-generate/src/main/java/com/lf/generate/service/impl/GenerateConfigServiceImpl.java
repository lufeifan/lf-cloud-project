package com.lf.generate.service.impl;

import com.google.common.base.CaseFormat;
import com.lf.generate.entity.GenerateInfo;
import com.lf.generate.entity.TableInfo;
import com.lf.generate.service.GenerateConfigService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author lufeifan
 * @date 2021/10/25 19:47
 **/
@Service
public class GenerateConfigServiceImpl implements GenerateConfigService {


    @Override
    public GenerateInfo generateConfig(GenerateInfo info) {
//       表信息
        List<TableInfo> tableInfoList = info.getTableInfo();
        for (TableInfo  tableInfo: tableInfoList) {
            String tableName = tableInfo.getTableName();
//            去除表前缀
            if (tableInfo.getIsRemovePrefix()) {
                String tablePrefix = tableName.split("_")[0];
                if (Optional.ofNullable(tableInfo).isPresent()){
                    String className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, StringUtils.stripStart(tableName, tablePrefix));
                    tableInfo.setClassName(className);
                }
            }else {
                String className = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL,tableName);
                tableInfo.setClassName(className);
            }
        }
        return info;
    }
}
