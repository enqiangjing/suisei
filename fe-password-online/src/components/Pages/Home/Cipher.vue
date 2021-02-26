<template>
  <div class="content cc-display">
    <div class="content-m br-8">
      <div class="one-line cc-display fs-20 ls-8 fw-6 color-primary">公钥</div>
      <div class="more-line cc-display">
        <Textarea class="textarea" v-model="publicKey" />
      </div>
      <div style="display: none">
        <input
          type="file"
          id="files_publicKey"
          @change="fnReadFile('publicKey')"
        />
      </div>
      <div class="one-line cc-display">
        <Button @click="fileLoad('files_publicKey')">加载</Button>
        <!-- <Button @click="fnSave('temporary')" style="margin-left:10px"
          >暂存</Button
        > -->
        <Button @click="fnSave('forever')" style="margin-left: 10px"
          >保存</Button
        >
        <!-- <Button @click="fnKeyLoad('other')" style="margin-left:10px"
          >加载</Button
        > -->
      </div>

      <div class="line"></div>

      <div class="one-line cc-display fs-20 ls-8 fw-6 color-primary">私钥</div>
      <div class="one-line cc-display fs-18">{{ privateKeyMsg }}</div>
      <div style="display: none">
        <input
          type="file"
          id="files_privateKey"
          @change="fnReadFile('privateKey')"
        />
      </div>
      <div class="one-line cc-display">
        <Button @click="fileLoad('files_privateKey')">加载</Button>
        <!-- <Button @click="fnUse" style="margin-left:10px">加载</Button> -->
      </div>
    </div>
  </div>
</template>

<script>
import LoginInput from "@/components/common/LoginInput.vue";
import Button from "@/components/common/Button.vue";
import { post_ } from "@/http/api.js";
import { localStore, localData } from "@/http/store.js";
import Textarea from "@/components/common/Textarea.vue";

export default {
  name: "Content",
  components: {
    LoginInput,
    Button,
    Textarea,
  },
  props: {
    msg: String,
  },
  data() {
    return {
      privateKeyMsg: "请先加载私钥！",
    };
  },
  created() {
    if (this.$store.state.isLogin) {
      this.privateKeyMsg = "私钥已缓存！";
    }
  },
  computed: {
    publicKey() {
      return this.$store.state.publicKey;
    },
  },
  methods: {
    // 公钥保存
    fnSave(val) {
      this.$publicKey = this.publicKey;
      if (val === "forever") {
        post_(this.$baseUrl + "api/upDateUser", {
          userName: this.$user.userName,
          publicKey: this.publicKey,
        });
        return;
      }
    },

    // 打开文件选择器
    fileLoad(val) {
      let btn = document.getElementById(val);
      btn.click();
    },

    // 文件读取
    fnReadFile(val) {
      let self = this;
      let selectedFile = document.getElementById("files_" + val).files[0];
      let reader = new FileReader();
      reader.readAsText(selectedFile);
      reader.onload = function () {
        if (val === "publicKey") {
          let localUser = localData("poUserInfo");
          localUser.publicKey = this.result;
          localStore("poUserInfo", localUser); // 私钥写入本地
          self.$store.commit("upPublicKey", this.result); // 公钥写入内容
        } else {
          self.privateKeyMsg = "私钥文件应用成功！";
          self.$store.commit("upPrivateKey", this.result); // 私钥写入内存
          localStore("poPrivateKey", this.result); // 本地存储私钥
        }
      };
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

    .more-line {
      height: 140px;
      width: 100%;

      .textarea {
        height: 120px;
        width: 80%;
      }
    }
  }
}

.line {
  height: 0;
  margin: 20px 0 10px 0;
  border-top: 2px solid #67c23a;
}
</style>
