<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>单页面vue</title>
    <script src="https://cdn.jsdelivr.net/npm/vue@2.6.14/dist/vue.js"></script>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css" />
    <!-- 引入组件库 -->
    <script src="https://unpkg.com/element-ui/lib/index.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/axios/0.21.1/axios.js"></script>
</head>
<body>
<div id="app">
    <el-table>
<#if columnInfos??>
<#list columnInfos as li>
<#if li.columnJavaType != 'Boolean'>
         <el-table-column prop="${li.columnName}" header-align="center"  label="${li.columnRemarks?default("")}"></el-table-column>
</#if>
<#if li.columnJavaType == 'Boolean'>
         <el-table-column header-align="center"  label="${li.columnRemarks?default("")}">
            <template slot-scope="scope">
               <el-switch v-model="scope.row.${li.columnName}" disabled active-color="#13ce66" inactive-color="#ff4949"></el-switch>
            </template>
         </el-table-column>
</#if>
</#list>
</#if>
    </el-table>
    <el-button @click="method">test</el-button>
</div>
<script>
    // axios config
    axios.defaults.baseURL = 'http://localhost:15000/';
    // axios.defaults.headers=
    // axios.defaults.timeout=

    axios.interceptors.request.use(config => {
        // Do something before request is sent
        return config;
    }, error => {
        // Do something with request error
        return Promise.reject(error);
    });

    axios.interceptors.response.use(response => {
        // Do something before response is sent
        return response.data;
    }, error => {
        // Do something with response error
        return Promise.reject(error);
    });

    function myTest(url) {
        return axios.get(url)
    }

</script>
<script>
    new Vue({
        el: "#app",
        data() {
            return {

            }
        },
        methods: {
            method1() {
                axios({
                    method: 'post',
                    url: '/test',
                    data: {

                    },
                }).then(response => {
                    console.log(response);
                });
            },
            async method2() {
                let res = await axios.get("/test")
                console.log(res);
            },
            async method3() {
                let res = await myTest("/test")
                console.log(res);
            },
            method4() {
                let res = myTest("/test")
                console.log(res);
            }


        },
        watch: {
            data(newValue, oldValue) {

            }
        },
        computed: {
            name() {
                return this.data;
            }
        },
    })
</script>
</body>
</html>