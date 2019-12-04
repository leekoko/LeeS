<template>

    <div id="card-div">
        <a-row>
            <a-col :span="6">
                <router-link to="/home">
                    <h2 style="font-weight: bold;padding-left: 5px;">LifeGame</h2>
                </router-link>
            </a-col>
            <a-col :span="18"></a-col>
        </a-row>
        <a-list itemLayout="horizontal" :dataSource="data" class="cardContent">
            <a-list-item slot="renderItem" slot-scope="item" style="text-align: right">
                <a-list-item-meta :description=item.description>
                    <a slot="title" :href=item.url style="font-weight: bold">{{item.title}}</a>
                    <a slot="title" v-if="item.title2" :href=item.url2 style="font-weight: bold"> | {{item.title2}}</a>
                    <a-avatar slot="avatar" :size="50" :icon=item.icon />
                </a-list-item-meta>
            </a-list-item>
        </a-list>
    </div>
</template>

<script>
    const data = [
        {
            title: '日常记录',
            description: '把每天发生的事情告诉我',
            icon: 'home',
            url: '/lifegame/diary'
        },
        {
            title: '任务列表',
            description: '测试文本内容',
            icon: 'flag',
            url: '/lifegame/plan',
            title2: '计划设定',
            url2: '/lifegame/editPlan'
        },
        {
            title: '账单本',
            description: '测试文本内容',
            icon: 'shopping-cart'
        }
    ]
    export default {
        data () {
            return {
                data,
            }
        },
        methods: {
        }
    }

</script>

<style scoped>
    #card-div{
        margin-top: 20px;
    }
    .cardContent{
        padding-left: 10px;
        padding-right: 10px;
    }
</style>