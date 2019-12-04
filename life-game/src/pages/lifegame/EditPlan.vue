<template>
    <div>
        <a-row>
            <a-col :span="8">
                <router-link to="/lifegame">
                    <h3 style="font-weight: bold;padding-left: 5px;">计划设定</h3>
                </router-link>
            </a-col>
            <a-col :span="16"></a-col>
        </a-row>
        <div id="textContent">
            <a-table :dataSource="data">

                <a-table-column
                        title="任务名"
                        dataIndex="name"
                        key="name"
                />
                <a-table-column
                        title="金额"
                        dataIndex="money"
                        key="money"
                />
                <a-table-column
                        title="类别"
                        dataIndex="type"
                        key="type"
                />
                <a-table-column
                        title="操作"
                        key="action"
                >
                    <template slot-scope="text, record">
                        <span>
                          <a @click=delData(record.code)>删除</a>
                        </span>
                    </template>
                </a-table-column>

            </a-table>
            <a-button type="primary" block  @click="showModal">新增</a-button>

        </div>
        <div>
            <a-modal
                    title="新增事项"
                    :visible="visible"
                    @ok="handleOk"
                    :confirmLoading="confirmLoading"
                    @cancel="handleCancel"
                    okText="确定"
            >
                <p v-html="ModalText" id="ModalText"></p>
            </a-modal>
        </div>


    </div>

</template>

<script>

    const data = [{
        code: 'a1',
        key: '1',
        name: 'John Brown',
        money: 32,
        type: 1,
    }, {
        code: 'a2',
        key: '2',
        name: 'Jim Green',
        money: 42,
        type: 1,
    }, {
        code: 'a3',
        key: '3',
        name: 'Joe Black',
        money: 32,
        type: 0,
    }];

    export default {
        name: "EditPlan",
        data () {
            return {
                data,

                ModalText: '',
                visible: false,
                confirmLoading: false,
            };
        },
        methods: {
            delData(code){
                alert(code);
            },
            showModal() {
                this.visible = true
            },
            handleOk() {
                //复制显示文本
                this.ModalText = '已保存';
                this.confirmLoading = true;
                setTimeout(() => {
                    this.visible = false;
                    this.confirmLoading = false;
                }, 1000);
            },
            handleCancel() {
                this.visible = false
            },
        },



    }
</script>

<style scoped>
#textContent{
    width: 100%;
    padding-left: 10px;
    padding-right: 10px;
}
.text-wrapper {
    white-space: pre-wrap;
}
</style>