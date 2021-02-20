<template>
  <div class="box cc-display">
    <div class="outside">
      <div class="top cc-display">
        <img src="@/assets/img/login/user.svg" alt="top" />
      </div>
      <div class="item cs-display">
        <LoginInput type="email" class="input" />
      </div>
      <div class="item cs-display">
        <LoginInput type="password" class="input" />
      </div>
      <div class="item cc-display">
        <Button @click="fnLogin">登录</Button>
      </div>
    </div>
  </div>
</template>

<script>
import LoginInput from "@/components/common/LoginInput.vue";
import Button from "@/components/common/Button.vue";
import { post_ } from "@/http/api.js";

export default {
  name: "Box",
  components: {
    LoginInput,
    Button,
  },
  props: {
    msg: String,
  },
  methods: {
    fnLogin() {
      console.log("1");
      post_("login", {
        userName: "jing",
        password: "jing",
      }).then((res) => {
        console.log(res);
      });
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.box {
  width: 100%;
  height: 50%;
  background-color: rgab(255, 255, 255, 0.5);

  .outside {
    width: 50%;
    max-width: 700px;
    min-width: 500px;
    height: 70%;
    min-height: 400px;
    background-color: rgba(250, 250, 250, 0.875);
    border-radius: 10px;

    .top {
      height: 50%;
      overflow: hidden;

      img {
        width: 160px;
        height: 160px;
        border-radius: 80px;
        background-color: #eee;
      }
    }

    .item {
      height: 15%;

      .input {
        width: 80%;
        height: 50px;
      }
    }
  }
}
</style>
