package com.lf.generate.vo;

import com.lf.generate.entity.PackInfo;
import com.lf.generate.entity.TableInfo;
import lombok.Data;

import java.util.List;

/**
 * @author lufeifan
 * @date 2021/10/28 19:32
 **/
@Data
public class PreviewInfoVo {

    private PackInfo packInfo;

    private TableInfo tableInfos;
}
