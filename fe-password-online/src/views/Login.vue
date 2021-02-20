<template>
  <div class="login">
    <h1>This is an login page</h1>
    <Box msg="登录" />
  </div>
</template>

<script>
// @ is an alias to /src
import Box from "@/components/Pages/Login/Box.vue";

export default {
  name: "Login",
  components: {
    Box,
  },
};
</script>