package ${packageName}.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import ${packageName}.entity.${className};
import ${packageName}.mapper.${className}Mapper;
import ${packageName}.service.${className}Service;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lf.common.utils.PageUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lf.common.utils.Query;
import java.util.Map;

/**
*  @author ${userName}
*  ${date}
**/
@Service
public class ${className}ServiceImpl extends ServiceImpl<${className}Mapper, ${className}> implements ${className}Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<${className}> queryWrapper) {
        IPage<${className}> page = this.page(new Query<${className}>().getPage(params),queryWrapper);
        return new PageUtils(page);
    }
}
