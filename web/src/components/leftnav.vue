/**
* 左边菜单
*/
<template>
  <el-menu default-active="2" :collapse="collapsed" collapse-transition router :default-active="$route.path" unique-opened class="el-menu-vertical-demo" background-color="#334157" text-color="#fff" active-text-color="#ffd04b">
    <div class="logobox">
      <!-- <img class="logoimg" src="../assets/img/logo.png" alt="">-->
      在线影院网址管理系统
    </div>
    <el-submenu v-for="menu in allmenu" :key="menu.menuid" :index="menu.menuname">
      <template slot="title">
        <i class="iconfont" :class="menu.icon"></i>
        <span>{{menu.menuname}}</span>
      </template>
      <el-menu-item-group>
        <el-menu-item v-for="chmenu in menu.menus" :index="'/'+chmenu.url" :key="chmenu.menuid">
          <i class="iconfont" :class="chmenu.icon"></i>
          <span>{{chmenu.menuname}}</span>
        </el-menu-item>
      </el-menu-item-group>
    </el-submenu>
  </el-menu>
</template>
<script>
export default {
  name: 'leftnav',
  data() {
    return {
      collapsed: false,
      allmenu: []
    }
  },
  // 创建完毕状态(里面是操作)
  created() {
    this.allmenu = [
      {
        menuid: 128,
        icon: 'li-icon-shangchengxitongtubiaozitihuayuanwenjian91',
        menuname: '电影管理',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 129,
            icon: 'icon-provider-manage',
            menuname: '电影信息',
            hasThird: 'N',
            url: 'filmInfo/index',
            menus: null
          },
          {
            menuid: 130,
            icon: 'icon-provider-manage',
            menuname: '电影分类信息',
            hasThird: 'N',
            url: 'filmClassification/index',
            menus: null
          },
        ]
      },
      {
        menuid: 29,
        icon: 'li-icon-xiangmuguanli',
        menuname: '广告管理',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 31,
            icon: 'icon-cat-skuQuery',
            menuname: '轮播图信息',
            hasThird: 'N',
            url: 'bannerInfo/index',
            menus: null
          }
        ]
      },
      {
        menuid: 33,
        icon: 'li-icon-xiangmuguanli',
        menuname: '意见反馈管理',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 34,
            icon: 'icon-cat-skuQuery',
            menuname: '意见反馈信息',
            hasThird: 'N',
            url: 'feedbackInfo/index',
            menus: null
          }
        ]
      },
      {
        menuid: 35,
        icon: 'li-icon-xiangmuguanli',
        menuname: '电影排行榜',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 36,
            icon: 'icon-cat-skuQuery',
            menuname: '电影总榜',
            hasThird: 'N',
            url: 'filmList1/index',
            menus: null
          },
          {
            menuid: 37,
            icon: 'icon-cat-skuQuery',
            menuname: '电影亲情榜',
            hasThird: 'N',
            url: 'filmList2/index',
            menus: null
          },
          {
            menuid: 371,
            icon: 'icon-cat-skuQuery',
            menuname: '电影经典榜',
            hasThird: 'N',
            url: 'filmList3/index',
            menus: null
          },
          {
            menuid: 372,
            icon: 'icon-cat-skuQuery',
            menuname: '电影剧情榜',
            hasThird: 'N',
            url: 'filmList4/index',
            menus: null
          }
        ]
      },
      {
        menuid: 38,
        icon: 'li-icon-xiangmuguanli',
        menuname: '电影新闻百科',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 39,
            icon: 'icon-cat-skuQuery',
            menuname: '电影新闻',
            hasThird: 'N',
            url: 'journalismInfo/index',
            menus: null
          },
          {
            menuid: 40,
            icon: 'icon-cat-skuQuery',
            menuname: '电影百科',
            hasThird: 'N',
            url: 'filmEncyclopedia/index',
            menus: null
          }
        ]
      },
      {
        menuid: 41,
        icon: 'li-icon-xiangmuguanli',
        menuname: '系统管理',
        hasThird: null,
        url: null,
        menus: [
          {
            menuid: 42,
            icon: 'icon-cat-skuQuery',
            menuname: '用户信息',
            hasThird: 'N',
            url: 'userInfo/index',
            menus: null
          },{
            menuid: 43,
            icon: 'icon-provider-manage',
            menuname: '个人信息',
            hasThird: 'N',
            url: 'personage/index',
            menus: null
          }
        ]
      }
    ]

    // 监听
    this.$root.Bus.$on('toggle', value => {
      this.collapsed = !value
    })
  }
}
</script>
<style>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 240px;
  min-height: 400px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  border: none;
  text-align: left;
}
.el-menu-item-group__title {
  padding: 0px;
}
.el-menu-bg {
  background-color: #1f2d3d !important;
}
.el-menu {
  border: none;
}
.logobox {
  height: 40px;
  font-weight: bold;
  line-height: 40px;
  color: #9d9d9d;
  font-size: 20px;
  text-align: center;
  padding: 20px 0px;
}
.logoimg {
  height: 40px;
}
</style>
