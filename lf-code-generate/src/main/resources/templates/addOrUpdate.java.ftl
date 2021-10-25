<template>
    <el-dialog :title="!dataForm.id ? '新增' : '修改'" :close-on-click-modal="false" :visible.sync="visible">
        <el-form :model="dataForm" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="160px">
        <#if columnInfos??>
            <#list columnInfos as li>
                <#if primaryKey??>
                    <#if "${primaryKey}"!=li.columnName>
                        <#if li.columnType != 'Boolean'>
                            <el-form-item label="${li.columnRemarks!}" prop="${li.columnName}">
                                <el-input v-model="dataForm.${li.columnName}" placeholder="${li.columnRemarks!}"></el-input>
                            </el-form-item>
                        </#if>
                        <#if li.columnType == 'Boolean'>
                            <el-form-item label="${li.columnRemarks!}" prop="${li.columnName}">
                                <el-switch v-model="dataForm.${li.columnName}" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
                            </el-form-item>
                        </#if>
                    </#if>
                <#else >
                    <#if li.columnType != 'Boolean'>
                        <el-form-item label="${li.columnRemarks!}" prop="${li.columnName}">
                            <el-input v-model="dataForm.${li.columnName}" placeholder="${li.columnRemarks!}"></el-input>
                        </el-form-item>
                    </#if>
                    <#if li.columnType == 'Boolean'>
                        <el-form-item label="${li.columnRemarks!}" prop="${li.columnName}">
                            <el-switch v-model="dataForm.${li.columnName}" active-color="#13ce66" inactive-color="#ff4949"></el-switch>
                        </el-form-item>
                    </#if>
                </#if>


            </#list>
        </#if>
        </el-form>
        <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
    </el-dialog>
</template>

<script>
    import { getById, save, list, update, delById } from "@/api/${className?uncap_first}";
    export default {
        data() {
            return {
                visible: false,
                dataForm: {
                    <#if columnInfos??>
                        <#list columnInfos as li>
                            ${li.columnName}:"",
                        </#list>
                    </#if>
                },
                dataRule: {
                <#if columnInfos??>
                <#list columnInfos as li>
                    <#if primaryKey??>
                    <#if "${primaryKey}"!=li.columnName>
                    ${li.columnName}: [
                        { required: true, message: '${li.columnRemarks!} 不能为空', trigger: 'blur' }
                    ],
                    </#if>
                    <#else >
                    ${li.columnName}: [
                        { required: true, message: '${li.columnRemarks!} 不能为空', trigger: 'blur' }
                    ],
                    </#if>


                </#list>
                </#if>
                }
            }
        },
        methods: {
            init(id) {
                this.dataForm.id = id || 0
                this.visible = true
                this.$nextTick(() => {
                    this.$refs['dataForm'].resetFields()
                    if (this.dataForm.id) {
                        getById(id)
                            .then(({ data }) => {
                                <#if columnInfos??>
                                <#list columnInfos as li>
                                this.dataForm.${li.columnName} = data.${li.columnName}
                                </#list>
                                </#if>
                            })
                    }
                })
            },
            // 表单提交
            dataFormSubmit() {
                this.$refs['dataForm'].validate((valid) => {
                    if (valid) {
                        (this.dataForm.id ? update(this.dataForm) : save(this.dataForm))
                            .then(data => {
                                if (data && data.code === 0) {
                                    this.$message({
                                        message: '操作成功',
                                        type: 'success',
                                        duration: 1500,
                                        onClose: () => {
                                            this.visible = false
                                            this.$emit('refreshDataList')
                                        }
                                    })
                                } else {
                                    this.$message.error(data.msg)
                                }
                            })
                    }
                })
            }
        }
    }
</script>