<template>
    <div>
        <a-row>
            <a-col :span="6">
                <router-link to="/lifegame">
                    <h3 style="font-weight: bold;padding-left: 5px;">任务列表</h3>
                </router-link>
            </a-col>
            <a-col :span="18"></a-col>
        </a-row>
        <ul class="list-group">
                <div id="textContent" v-for="item in items" :key=item.code>
                    <li class="list-group-item">
                        <p class="checkboxP"><a-checkbox @change="onChange" :value=item.name>{{item.name}}</a-checkbox></p>
                    </li>
                </div>
        </ul>

    </div>
</template>

<script>
    export default {
        name: "Plan",
        data () {
            return {
                items: [
                    {name: '内容1', code: 1, amount:2, isChose: true},
                    {name: '内容2', code: 2, amount:3, isChose: false},
                    {name: '内容3', code: 3, amount:4, isChose: false},
                    {name: '内容4', code: 4, amount:5, isChose: false},
                    {name: '内容5', code: 5, amount:6, isChose: false},
                    {name: '内容6', code: 6, amount:7, isChose: false},
                ]
            };
        },
        methods: {
            onChange (e) {
                console.table(e.va)
            },
        }

    }
</script>

<style scoped>
#textContent{
    width: 100%;
    padding-left: 10px;
    padding-right: 10px;
}
.checkboxP{
    text-align: left;
}
li{
    list-style-type:none;
    margin-top: 20px;
}
</style>