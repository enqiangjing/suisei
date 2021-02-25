<template>
  <div class="content cc-display">
    <div class="content-m br-8">
      <div class="one-line cc-display fs-20 ls-8 fw-6 color-primary">
        {{ title }}
      </div>
      <div class="one-line cc-display">
        <LoginInput
          type="sysname"
          class="input"
          v-model="systemName"
          placeholder="请输入系统/软件名称"
        />
      </div>
      <div class="one-line cc-display">
        <LoginInput
          type="accin"
          class="input"
          v-model="account"
          placeholder="请输入账号"
        />
      </div>
      <div class="one-line cc-display">
        <LoginInput
          type="passin"
          class="input"
          v-model="password"
          placeholder="请输入密码"
        />
      </div>
      <div class="one-line cc-display">
        <LoginInput
          type="more"
          class="input"
          v-model="extra"
          placeholder="请输入备注信息"
        />
      </div>
      <div class="one-line cc-display">
        <Button @click="fnSave">保存</Button>
      </div>
    </div>
  </div>
</template>

<script>
import LoginInput from "@/components/common/LoginInput.vue";
import Button from "@/components/common/Button.vue";
import { post_ } from "@/http/api.js";
import { fnKeyRead } from "@/http/store.js";
import { sessionData } from "@/http/store.js";

export default {
  name: "Content",
  components: {
    LoginInput,
    Button,
  },
  props: {
    msg: String,
  },
  data() {
    return {
      title: "增加",
      systemName: "",
      account: "",
      password: "",
      extra: "",
      id: "",
    };
  },
  created() {
    if (
      this.$route.name === "HomeContentEdit" &&
      this.$store.state.editStatus
    ) {
      this.$store.commit("upEditStatus", false);
      let itemInfo = this.$store.state.editItem;
      this.systemName = itemInfo.systemName;
      this.account = itemInfo.account;
      this.password = itemInfo.password;
      this.extra = itemInfo.extra;
      this.id = itemInfo.id;
      this.title = "修改";
    }
  },
  methods: {
    fnSave() {
      if (this.$store.state.publicKey === "") {
        this.$message.run("未读入公钥", "error");
        this.$router.push("/home/" + this.$user.userName + "/cipher");
        return;
      }
      // 加密
      this.$rsa.setPublicKey(
        "-----BEGIN PUBLIC KEY-----" +
          this.$store.state.publicKey +
          "-----END PUBLIC KEY-----"
      );

      // 保存
      let sendData = {
        userName: this.$store.state.userName,
        systemName: this.$rsa.encrypt(this.systemName),
        account: this.$rsa.encrypt(this.account),
        password: this.$rsa.encrypt(this.password),
        extra: this.$rsa.encrypt(this.extra),
      };
      let sendUrl = "api/insertData";
      if (this.title === "修改") {
        sendData.id = this.id;
        sendUrl = "api/upDateInfo";
      }
      post_(this.$baseUrl + sendUrl, sendData);
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.content {
  width: 100%;
  min-width: 680px;

  .content-m {
    margin-top: 30px;
    padding: 10px 0;
    width: 50%;
    min-width: 500px;
    background-color: rgba(240, 240, 240, 0.85);

    .one-line {
      height: 60px;
      width: 100%;

      .input {
        height: 40px;
        width: 80%;
      }
    }
  }
}
</style>
