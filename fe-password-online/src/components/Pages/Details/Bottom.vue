<template>
  <div class="bottom cc-display">
    <div class="block cc-display br-4 pmb0 border-none" @click="fnToGitHub">
      <img src="@/assets/img/details/github_left.svg" alt="" />
      <img src="@/assets/img/details/GitHub.svg" alt="" />
    </div>
  </div>
</template>

<script>
export default {
  name: "Bottom",
  props: {
    msg: String,
  },
  methods: {
    fnToGitHub() {
      window.open("https://github.com/enqiangjing/suisei", "_blank");
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="less" scoped>
.bottom {
  position: fixed;
  bottom: 0;
  height: 40px;
  width: 100%;
  background-color: rgba(255, 255, 255, 0.85);
  box-shadow: 0 0 6px #ddd;

  .block {
    height: 90%;
    cursor: pointer;
    overflow: hidden;
    border: 5px solid rgba(0, 0, 0, 0);

    &:hover {
      background: #ccc;
    }

    img {
      height: 20px;
      margin: 0 5px;
    }
  }
}
</style>
