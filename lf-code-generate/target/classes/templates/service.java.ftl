package ${packageName}.service;

import ${packageName}.entity.${className};
import com.baomidou.mybatisplus.extension.service.IService;
import com.lf.common.utils.PageUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;

/**
*  @author ${userName}
*  ${date}
**/
public interface ${className}Service extends IService<${className}> {
    PageUtils queryPage(Map<String, Object> params, Wrapper<${className}> queryWrapper);
}

