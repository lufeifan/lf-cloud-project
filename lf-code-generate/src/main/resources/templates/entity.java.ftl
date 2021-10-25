package ${packageName}.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
*  @author ${userName}
*  ${date}
**/

@Data
@TableName("${tableName}")
@ApiModel(value="${className}对象", description="${tableRemarks?default("")}")
public class ${className} implements Serializable {
<#if columnInfos ??>
    <#list columnInfos as li>
    /**
    *   ${li.columnRemarks?default("")}
    **/
    <#if primaryKey??>
        <#if "${primaryKey}"==li.columnName>
    @TableId(type = IdType.AUTO)
        </#if>
    </#if>
    @ApiModelProperty(value = "${li.columnRemarks?default("")} ")
    private ${li.columnType} ${li.columnName};

    </#list>
</#if>

}