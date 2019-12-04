<template>
    <div>
        <a-row>
            <a-col :span="6">
                <router-link to="/lifegame">
                    <h3 style="font-weight: bold;padding-left: 5px;">详情页面</h3>
                </router-link>
            </a-col>
            <a-col :span="18"></a-col>
        </a-row>
        <div id="textContent">
            <a-form>
                <a-form-item label="今天流水账" :label-col="labelCol" ::wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入流水账内容" :autosize="{ minRows: 4, maxRows: 20 }" v-model="diaryContent"/>
                </a-form-item>
                <a-form-item label="今日感想" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入今日感想内容" :autosize="{ minRows: 4, maxRows: 20 }" v-model="impression" />
                </a-form-item>
                <a-form-item label="昨天安排检查" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入昨天安排检查内容" :autosize="{ minRows: 2, maxRows: 10 }" v-model="todayPlan" />
                </a-form-item>
                <a-form-item label="明天安排" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入明天安排内容" :autosize="{ minRows: 2, maxRows: 10 }" v-model="nextDayPlan"/>
                </a-form-item>
                <a-form-item label="昨天体验如何" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入昨天体验如何内容" :autosize="{ minRows: 2, maxRows: 10 }" v-model="todayExperience"/>
                </a-form-item>
                <a-form-item label="明天体验一下" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入明天体验一下内容" :autosize="{ minRows: 2, maxRows: 10 }" v-model="nextDayExperience"/>
                </a-form-item>
                <a-form-item label="我要感谢" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <a-textarea placeholder="请输入我要感谢内容" :autosize="{ minRows: 2, maxRows: 10 }" v-model="thanksGiving"/>
                </a-form-item>

                <a-form-item :wrapper-col="wrapperCol">
                    <a-button type="primary" @click="showModal">
                        create
                    </a-button>
                </a-form-item>


            </a-form>
        </div>

        <div>
            <a-modal
                    title="日记"
                    :visible="visible"
                    width="100%"
                    height="100%"
                    @ok="handleOk"
                    :confirmLoading="confirmLoading"
                    @cancel="handleCancel"
                    okText="Copy"
            >
                <p v-html="ModalText" id="ModalText"></p>
            </a-modal>
        </div>

    </div>
</template>

<script>
    export default {
        name: "Diary",
        data () {
            return {
                formLayout: 'inline',
                labelCol: {
                    xs: { span: 24 },
                    sm: { span: 5 },
                },
                wrapperCol: {
                    xs: { span: 24 },
                    sm: { span: 12 },
                },
                diaryContent: "",
                impression: "",
                todayPlan: "",
                nextDayPlan: "",
                todayExperience: "",
                nextDayExperience: "",
                thanksGiving: "",

                ModalText: '',
                visible: false,
                confirmLoading: false,
            };
        },
        methods: {
            showModal() {
                this.visible = true
                //生成显示文本
                this.createModalText();
            },
            handleOk() {
                //复制显示文本
                this.copyModalText();
                this.ModalText = '已复制到剪贴板';
                this.confirmLoading = true;
                setTimeout(() => {
                    this.visible = false;
                    this.confirmLoading = false;
                }, 1000);
            },
            handleCancel() {
                this.visible = false
            },
            //创建modal显示内容
            createModalText(){
                this.ModalText = "今天流水账：" + this.diaryContent + "<br/>" +
                    "今日感想：" + this.impression + "<br/>" +
                    "今天安排检查：" + this.todayPlan + "<br/>" +
                    "明天安排：" + this.nextDayPlan + "<br/>" +
                    "今天体验如何：" + this.todayExperience + "<br/>" +
                    "明天体验一下：" + this.nextDayExperience + "<br/>" +
                    "我要感谢：" + this.thanksGiving;
            },
            //复制显示文本
            copyModalText(){
                // console.log("复制功能未开放");
            }
        }

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