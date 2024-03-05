<template>
  <body>
  <el-container style="position: absolute; top: 0; left: 0; width: 100%; height: 100%;">
    <el-header><headmeun></headmeun></el-header>
    <el-aside><leftbar></leftbar></el-aside>
  </el-container>
  </body>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import leftbar from "@/views/leftbar.vue";
import headmeun from "@/views/headmeun.vue"
const isCollapse = ref(true)
</script>

<style scoped>

</style>
