package ${packageName}.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import ${packageName}.entity.${className};
import ${packageName}.service.${className}Service;
import com.lf.common.core.group.AddGroup;
import com.lf.common.core.group.AddUpdateGroup;
import com.lf.common.core.group.UpdateGroup;
import com.lf.common.core.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.security.access.prepost.PreAuthorize;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Arrays;

/**
*  @author ${userName}
*  ${date}
**/

@Api(tags = "${tableRemarks?default("")}管理模块")
@RestController
@RequestMapping("/${moduleName}/${className?uncap_first}")
public class ${className}Controller {
    @Resource
    private ${className}Service service;

//    @PreAuthorize("hasAnyAuthority('${moduleName}:${className?uncap_first}:info','admin')")
    @GetMapping("/info/{id}")
    private R getById(@PathVariable("id") Integer id){
        return R.setData(service.getById(id));
    }

    /**
    * 保存 ${tableRemarks?default("")}
    **/
//    @PreAuthorize("hasAnyAuthority('${moduleName}:${className?uncap_first}:save','admin')")
    @ApiOperation(value = "保存${tableRemarks?default("")}")
    @PostMapping("/save")
    public R save(@Validated({AddGroup.class, AddUpdateGroup.class}) @RequestBody ${className} entity) {
        service.save(entity);
        return R.ok("保存成功");
    }

    /**
    *  ${tableRemarks?default("")} 列表
    **/
//    @PreAuthorize("hasAnyAuthority('${moduleName}:${className?uncap_first}:list','admin')")
    @ApiOperation(value = " ${tableRemarks?default("")} 列表")
    @ApiImplicitParams({
    @ApiImplicitParam(name = "limit",value = "一页的条数",paramType = "query",dataType = "string"),
    @ApiImplicitParam(name = "page",value = "当前页数",paramType = "query",dataType = "string")
    })
    @GetMapping("/list")
    public R list(@ApiIgnore @RequestParam Map<String, Object> params) {
        return R.setData(service.queryPage(params, null));
    }

    /**
    * 更新 ${tableRemarks?default("")}
    **/
  //  @PreAuthorize("hasAnyAuthority('${moduleName}:${className?uncap_first}:update','admin')")
    @ApiOperation(value = "更新 ${tableRemarks?default("")}")
    @PutMapping("/update")
    public R update(@Validated({UpdateGroup.class,AddUpdateGroup.class}) @RequestBody ${className} entity) {
        <#if primaryKey??>
        return R.setData(service.update(entity, new LambdaQueryWrapper<${className}>().eq(${className}::get${dashedToCamel(primaryKey)?cap_first}, entity.get${dashedToCamel(primaryKey)?cap_first}())));
        <#else >
        return R.ok();
        </#if>
    }

    /**
    *  删除 ${tableRemarks?default("")}
    **/
  //  @PreAuthorize("hasAnyAuthority('${moduleName}:${className?uncap_first}:delete','admin')")
    @ApiOperation(value = "删除 ${tableRemarks?default("")}")
    @ApiImplicitParam(name = "id",value = "id")
    @DeleteMapping("/delete")
    public R delete(@RequestParam("ids") Integer[] ids){
        return R.setData(service.removeByIds(Arrays.asList(ids)));
    }

}

<#function dashedToCamel(s)>
    <#return s
    ?replace('(^_+)|(_+$)', '', 'r')
    ?replace('\\_+(\\w)?', ' $1', 'r')
    ?replace('([A-Z])', ' $1', 'r')
    ?capitalize
    ?replace(' ' , '')
    ?uncap_first
    >
</#function>