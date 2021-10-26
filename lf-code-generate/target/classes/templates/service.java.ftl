package ${packageName}.service;

import ${packageName}.entity.${className};
import com.baomidou.mybatisplus.extension.service.IService;
import com.lf.common.core.utils.PageUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;

/**
*  @author ${userName}
*  ${date}
**/
public interface ${className}Service extends IService<${className}> {
    /**
    * 分页查询
    * @param params
    * @param queryWrapper
    * @return
    */
    PageUtils queryPage(Map<String, Object> params, Wrapper<${className}> queryWrapper);
}

