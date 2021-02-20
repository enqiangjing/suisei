<template>
  <div class="lii cc-display">
    <div class="cc-display">
      <img :src="src" alt="email.ico" />
    </div>
    <input
      :type="iType"
      class="pbm0 border-none ls-2 fs-16"
      :value="value"
      @input="$emit('v_input', $event.target.value)"
    />
  </div>
</template>

<script>
let srcEmail = () => import("@/assets/img/login/email.svg");
let srcPassword = () => import("@/assets/img/login/password.svg");
let srcSrarch = () => import("@/assets/img/login/search.svg");

export default {
  name: "LoginInput",
  props: ["type", "value"],
  model: { prop: "value", event: "v_input" },
  data(props) {
    return {
      src: "",
      iType: "",
    };
  },
  created() {
    if (this.type && this.type === "password") {
      this.iType = "password";
      srcPassword().then((url) => {
        this.src = url.default;
      });
      return;
    }
    if (this.type && this.type === "email") {
      this.iType = "email";
      srcEmail().then((url) => {
        this.src = url.default;
      });
      return;
    }
    if (this.type && this.type === "search") {
      this.iType = "text";
      srcSrarch().then((url) => {
        this.src = url.default;
      });
      return;
    }
  },
};
</script>

<style lang="less" scoped>
.lii {
  position: relative;
  border: 1px solid rgb(200, 200, 200);
  border-radius: 4px;
  overflow: hidden;

  div {
    position: absolute;
    left: 0;
    top: 0;
    width: 50px;
    height: 100%;

    img {
      margin-left: 1.5%;
      width: 30px;
      height: 30px;
    }
  }

  input {
    padding: 0 10px 0 50px;
    width: 100%;
    height: 100%;
    border: none;
    outline: 0;
  }

  &:hover {
    border: 1px solid #409eff;
  }
}
</style>
