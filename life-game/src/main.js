import Vue from 'vue'
import VueRouter from 'vue-router'
import App from './App.vue'
import routes from './router'
import antd from "ant-design-vue";
import "ant-design-vue/dist/antd.css";
import ref from "vue-ref";


Vue.config.productionTip = false

Vue.use(VueRouter);
Vue.use(antd);
Vue.use(ref, { name: "ant-ref" });


const router = new VueRouter({
  mode: 'history',
  routes,
})

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
