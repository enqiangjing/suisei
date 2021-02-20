<template>
  <main class="cc-display">
    <ul>
      <li v-for="(item, index) in list" :key="index" class="common-bg-r85 br-8">
        <div class="item cc-display">
          <div class="left ec-display">系统名：</div>
          <div class="right sc-display">
            qq<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">系统名：</div>
          <div class="right sc-display">
            qq<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">系统名：</div>
          <div class="right sc-display">
            qq<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
        <div class="item cc-display">
          <div class="left ec-display">系统名：</div>
          <div class="right sc-display">
            qq<img src="@/assets/img/home/copy.svg" />
          </div>
        </div>
      </li>
    </ul>
  </main>
</template>

<script>
export default {
  name: "Content",
  props: {
    msg: String,
  },
  data() {
    return {
      list: [1, 1, 1],
    };
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
