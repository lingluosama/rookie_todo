<template>
  <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      @select="handleSelect"

  >
      <el-text class="title">rookie_todo</el-text>

  </el-menu>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue'
import {getweather} from "@/apis/getweather";
const activeIndex = ref('1')
const temperature = ref<number>(0)
const weatherData = ref<string>('')
onMounted(async ()=>{
  const res = await getweather({key:"S9rF6In9SvgiGSuF2",location:"ip"})
    temperature.value=res.results[0].now.temperature
    weatherData.value=res.results[0].now.text
})
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>
<style>
.title {
  color: #002238;
  font-size: 20px;
  -webkit-animation: shining 0.5s alternate infinite;
  animation: shining 0.5s alternate infinite;
}
@-webkit-keyframes shining {
  from {
    text-shadow: 0 0 10px lightblue, 0 0 10px lightblue, 0 0 20px lightblue, 0 0 30px skyblue, 0 0 40px skyblue, 0 0 50px skyblue;
  }

  to {
    text-shadow: 0 0 5px lightblue, 0 0 10px lightblue, 0 0 15px lightblue, 0 0 20px skyblue, 0 0 25px skyblue, 0 0 30px skyblue;
  }
}
</style>