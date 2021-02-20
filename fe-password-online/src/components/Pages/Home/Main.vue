<template>
  <main class="cc-display">
    <ul>
      <li v-for="(item, index) in list" :key="index" class="common-bg-r85 br-8">
        <div class="item cc-display">
          <div class="left ec-display">系统名：</div>
          <div class="right sc-display">
            {{ item.systemName }}<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">用户号：</div>
          <div class="right sc-display">
            {{ item.account }}<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">密码：</div>
          <div class="right sc-display">
            {{ item.password }}<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">其他信息：</div>
          <div class="right sc-display">
            {{ item.extra }}<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
      </li>
    </ul>
  </main>
</template>

<script>
export default {
  name: "Content",
  props: ["msgList"],
  data() {
    return {
      list: [],
    };
  },
  created() {
    this.list = this.msgList;
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

  ul {
    width: 50%;
    min-width: 500px;
    list-style: none;

    li {
      list-style: none;
      height: 180px;
      margin-top: 30px;
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
    }
  }
}
</style>
