<template>
  <main class="cc-display">
    <div
      class="no-data cc-display common-bg-r85 br-20"
      v-if="list.length === 0"
    >
      <img src="@/assets/img/details/no_data.svg" alt="无数据" />
      <span class="fs-20 ls-8">还没有账号数据~~~</span>
    </div>
    <ul v-else>
      <li v-for="(item, index) in list" :key="index" class="common-bg-r85 br-8">
        <img
          class="edit"
          src="@/assets/img/home/edit.svg"
          alt="修改"
          @click="fnToEdit(item)"
        />
        <div class="item cc-display">
          <div class="left ec-display fs-14 fw-6">系统名：</div>
          <div class="right sc-display fs-14">
            {{ item.systemName }}
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display fs-14 fw-6">用户号：</div>
          <div class="right sc-display fs-14">
            {{ item.account
            }}<img
              src="@/assets/img/home/copy.svg"
              data-clipboard-action="copy"
              :class="'userName' + item.id"
              :data-clipboard-text="item.account"
              @click="copyLink('userName' + item.id)"
            />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display fs-14 fw-6">密码：</div>
          <div class="right sc-display fs-14">
            {{
              item.password.charAt(0) +
              "******" +
              item.password.charAt(item.password.length - 1)
            }}<img
              src="@/assets/img/home/copy.svg"
              data-clipboard-action="copy"
              :class="'password' + item.id"
              :data-clipboard-text="item.password"
              @click="copyLink('password' + item.id)"
            />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display fs-14 fw-6">其他信息：</div>
          <div class="right sc-display fs-14">
            {{ item.extra }}
          </div>
        </div>
      </li>
    </ul>
  </main>
</template>

<script>
import { sessionStore } from "@/http/store.js";

export default {
  name: "Main",
  props: ["msgList"],
  data() {
    return {
      list: [],
    };
  },
  created() {
    this.list = this.msgList;
  },
  methods: {
    // 复制
    copyLink(val) {
      let _this = this;
      let clipboard = new this.$clipboard("." + val);
      clipboard.on("success", function () {
        _this.$message.run("复制成功");
      });
      clipboard.on("error", function () {
        _this.$message("复制失败", "error");
      });
    },

    // edit
    fnToEdit(item) {
      this.$store.commit("upEditItem", item);
      this.$store.commit("upEditStatus", true);
      this.$router.push("/home/" + this.$store.state.userName + "/edit");
    },
  },
  watch: {
    msgList(newVal) {
      this.list = newVal;
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
main {
  width: 100%;
  min-width: 680px;
  padding-bottom: 60px;

  ul {
    width: 50%;
    min-width: 500px;
    list-style: none;

    li {
      position: relative;
      list-style: none;
      height: 120px;
      margin-top: 30px;
      box-shadow: 0 0 8px #999;
      background-image: url("../../../assets/img/home/bk/world.svg"),
        url("../../../assets/img/home/bk/home.svg");
      background-position: 10px 10px, right bottom;
      background-repeat: no-repeat, no-repeat;
      background-size: 40px, 60px;
      padding: 10px 0;

      .edit {
        position: absolute;
        top: 10px;
        right: 10px;
        height: 20px;
        width: 20px;

        &:hover {
          cursor: pointer;
          box-shadow: 0 0 6px #999;
        }
      }
    }
  }
}

.item {
  width: 100%;
  height: 25%;

  .left {
    width: 40%;
    height: 100%;
  }

  .right {
    width: 60%;
    height: 100%;

    img {
      margin-left: 10px;
      width: 20px;
      height: 20px;

      &:hover {
        cursor: pointer;
        box-shadow: 0 0 6px #999;
      }
    }
  }
}

.no-data {
  margin-top: 30px;
  width: 50%;
  min-width: 500px;
  height: 200px;
  box-shadow: 0 0 6px #999;
  color: #409eff;

  img {
    width: 30px;
    height: 30px;
    margin-right: 20px;
  }
}
</style>
