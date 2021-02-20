<template>
  <div class="home">
    <nav class="primary-bg cc-display">
      <div class="menu cc-display" @mouseleave="fnSonMenuShow">
        <img
          src="@/assets/img/home/menu.svg"
          alt=""
          @mouseenter="fnSonMenuShow"
        />
        <div class="son-menu br-8" v-if="sonMenu">
          <div
            class="s-item cc-display fs-18 ls-4"
            @click="fnToContent('main')"
          >
            主页
          </div>
          <div
            class="s-item cc-display fs-18 ls-4"
            @click="fnToContent('content')"
          >
            新增
          </div>
          <div class="s-item cc-display fs-18 ls-4">退出</div>
        </div>
      </div>
      <div class="logo cc-display">
        <img src="@/assets/img/home/mlogo.svg" alt="" />
      </div>
      <div class="search cc-display">
        <LoginInput type="search" class="input" v-model="searchInupt" />
      </div>
    </nav>

    <router-view :msgList="accountList"></router-view>
  </div>
</template>

<script>
import { post_ } from "@/http/api.js";
import LoginInput from "@/components/common/LoginInput.vue";

export default {
  name: "Home",
  components: {
    LoginInput,
  },
  data() {
    return {
      sonMenu: false,
      searchInupt: "",
      accountList: [],
      accountListCopy: [],
    };
  },
  created() {
    this.fnGetAccountList();
    this.accountSearch = _.debounce(this.fnSearchInCurrent, 500);
  },
  methods: {
    // 账户信息查询
    fnGetAccountList() {
      post_(this.$baseUrl + "api/getListLike", {
        userName: this.$user.userName,
      }).then((res) => {
        console.log(res);
        this.accountList = res;
        this.accountListCopy = res;
      });
    },

    // 搜索
    fnSearchInCurrent() {
      console.log(this.searchInupt.trim());
      this.accountList = this.accountListCopy.filter((x) => {
        let flag = false;
        for (let i in x) {
          if (String(x[i]).includes(this.searchInupt)) {
            flag = true;
            break;
          }
        }
        return flag;
      });
    },

    // 子菜单
    fnSonMenuShow() {
      this.sonMenu = !this.sonMenu;
    },

    // 新增条目
    fnToContent(val) {
      this.$router.push("/home/" + this.$user.userName + "/" + val);
    },
  },

  watch: {
    searchInupt(newVal, oldVal) {
      if (newVal !== oldVal && newVal.trim() !== "")
        return this.accountSearch();
      this.accountList = this.accountListCopy;
    },
  },
};
</script>

<style lang="less" scoped>
// 菜单按钮背景
@menu-bg: rgb(67, 148, 253);

.home {
  position: relative;
  height: 100%;
  width: 100%;
  background: url(../assets/logo.png) no-repeat top center;
  overflow: hidden;
  z-index: 1000;

  &:hover {
    overflow-y: auto;
    overflow-y: overlay;
    overflow-x: auto;
  }

  nav {
    width: 100%;
    min-width: 680px;
    height: 60px;
    position: relative;
    position: sticky;
    top: 0;

    .menu {
      position: absolute;
      right: 0;
      top: 0;
      height: 100%;
      width: 80px;

      img {
        width: 40px;
        height: 40px;

        &:hover {
          cursor: pointer;
          background-color: @menu-bg;
        }
      }

      .son-menu {
        position: absolute;
        right: 10px;
        top: 10px;
        width: 100px;
        padding: 10px 0;
        background-color: @menu-bg;
        box-shadow: 0 0 10px rgb(214, 220, 238);

        .s-item {
          width: 100%;
          height: 50px;
          color: #fff;

          &:hover {
            background-color: rgb(101, 162, 243);
            cursor: pointer;
          }
        }
      }
    }

    .logo {
      position: absolute;
      left: 0;
      top: 0;
      height: 100%;
      width: 80px;

      img {
        width: 40px;
        height: 40px;
      }
    }

    .search {
      width: 80%;
      height: 100%;

      .input {
        width: 50%;
        min-width: 500px;
        height: 45px;
      }
    }
  }
}
</style>
