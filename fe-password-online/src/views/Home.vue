<template>
  <div class="home">
    <nav class="primary-bg cc-display">
      <div class="menu cc-display">
        <img src="@/assets/img/home/menu.svg" alt="" />
      </div>
      <div class="logo cc-display">
        <img src="@/assets/img/home/mlogo.svg" alt="" />
      </div>
      <div class="search cc-display">
        <LoginInput type="search" class="input" />
      </div>
    </nav>

    <router-view></router-view>
  </div>
</template>

<script>
import LoginInput from "@/components/common/LoginInput.vue";

export default {
  name: "Home",
  components: {
    LoginInput,
  },
};
</script>

<style lang="less" scoped>
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
