-- 菜单SQL
INSERT INTO `sys_menu` (`parent_id`, `name`, `path`, `component`, `visible`, `icon`, `sort`,`gmt_create`,`gmt_modified`)
VALUES ('0', '${tableRemarks?default("")}', '/${moduleName}/${className?uncap_first}', NULL, '1', 'config', '6','${.now}','${.now}');

-- 按钮父菜单ID
set @parentId = @@identity;

-- 菜单对应按钮SQL
INSERT INTO `sys_permission` (`menu_id`, `name`, `btn_perm`,`url_perm`,`gmt_create`,`gmt_modified`)
SELECT @parentId, '查看${tableRemarks!}', '${moduleName}:${className?uncap_first}:list,${moduleName}:${className?uncap_first}:info','GET:/${moduleName}/${className?uncap_first}/list,GET:/${moduleName}/${className?uncap_first}/info','${.now}','${.now}';
INSERT INTO `sys_permission` (`menu_id`, `name`, `btn_perm`,`url_perm`,`gmt_create`,`gmt_modified`)
SELECT @parentId, '新增${tableRemarks!}', '${moduleName}:${className?uncap_first}:save', 'POST:/${moduleName}/${className?uncap_first}/save','${.now}','${.now}';
INSERT INTO `sys_permission` (`menu_id`, `name`, `btn_perm`,`url_perm`,`gmt_create`,`gmt_modified`)
SELECT @parentId, '修改${tableRemarks!}', '${moduleName}:${className?uncap_first}:update', 'PUT:/${moduleName}/${className?uncap_first}/update','${.now}','${.now}';
INSERT INTO `sys_permission` (`menu_id`, `name`, `btn_perm`,`url_perm`,`gmt_create`,`gmt_modified`)
SELECT @parentId, '删除${tableRemarks!}', '${moduleName}:${className?uncap_first}:delete', 'DELETE:/${moduleName}/${className?uncap_first}/delete','${.now}','${.now}';
