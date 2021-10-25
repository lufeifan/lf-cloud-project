import request from "@/utils/request";
import qs from "qs";

// 通过 id 获取 单条数据
export function getById(id) {
    return request({
        url: "/${moduleName}/${className?uncap_first}/info/" + id,
        method: "get"
    });
}

//  保存 ${className?uncap_first}
export function save(data) {
    return request({
        url: "/${moduleName}/${className?uncap_first}/save",
        method: "post",
        data
    });
}


//  获取全部 ${className?uncap_first}
export function list({ limit, page }) {
    return request({
        url: "${moduleName}/${className?uncap_first}/list",
        method: "get",
        params: { limit ,page }
    });
}

//  更新 ${className?uncap_first}
export function update(data) {
    return request({
        url: "/${moduleName}/${className?uncap_first}/update",
        method: "put",
        data
    });
}

//  通过id 删除 ${className?uncap_first}
export function delById(ids) {
    return request({
        url: "${moduleName}/${className?uncap_first}/delete",
        method: "delete",
        params: { ids },
        paramsSerializer: params => {
        return qs.stringify(params, { indices: false });
        }
    });
}