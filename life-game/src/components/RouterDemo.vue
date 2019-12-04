<template>
  <div id="card-div">
    <a-row>
      <a-col :span="6"><h2 style="font-weight: bold">LeeS</h2></a-col>
      <a-col :span="18"></a-col>
    </a-row>
    <a-row>
      <router-link to="/lifegame">
        <a-card hoverable style="width: 100%;" class="cardContent">
          <img id="pic" alt="example" src="../assets/images/lifegame.png" slot="cover" />
          <template class="ant-card-actions" slot="actions">
            <a-icon type="setting" />
            <a-icon type="edit" />
            <a-icon type="ellipsis" />
          </template>
          <a-card-meta title="LifeGame" description="生活记录">
<!--            <a-avatar slot="avatar" src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />-->
          </a-card-meta>
        </a-card>
      </router-link>

    </a-row>



  </div>
</template>
<script>
export default {
  props: [],
  computed: {

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

