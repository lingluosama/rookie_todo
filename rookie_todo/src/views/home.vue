<template>
  <el-container style="position: absolute; left: 0; top: 0; width: 100%; height: 100%;">
    <el-header>
      <headmeun></headmeun>
    </el-header>
    <el-main>
      <div style="display: flex; flex-wrap: nowrap;width: auto">
        <leftbar style="flex: 0 0 auto;"></leftbar>
        <RouterView style="flex: 1 1 0;"></RouterView>
      </div>
    </el-main>
  </el-container>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import leftbar from "@/views/leftbar.vue";
import headmeun from "@/views/headmeun.vue"
const isCollapse = ref(true)
</script>

<style scoped>


</style>
