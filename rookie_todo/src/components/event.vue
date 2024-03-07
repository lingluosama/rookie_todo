<template>
  <div style="width:100%;min-height: 700px;height: 100%; background-color: rgb(0, 0, 0, 0.2); display: flex; flex-wrap: wrap;">
    <div style="flex-basis: 100%; display: flex; align-items: center;margin-top: -250px">
      <div style="margin-right: auto;display: flex">
      <el-icon size="30" style="flex-shrink: 0;margin-bottom: 10px"><svg t="1709806172288" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7476" width="64" height="64"><path d="M590.701714 85.74781L843.093333 112.956952a73.142857 73.142857 0 0 1 64.877715 64.877715l27.209142 252.391619a73.142857 73.142857 0 0 1-21.01638 59.538285L489.764571 914.16381a73.142857 73.142857 0 0 1-103.424 0L106.76419 634.587429a73.142857 73.142857 0 0 1 0-103.424L531.163429 106.76419a73.142857 73.142857 0 0 1 59.538285-21.01638zM582.875429 158.47619L158.47619 582.875429l279.576381 279.576381 424.399239-424.399239-27.209143-252.367238L582.875429 158.47619z m68.486095 90.258286a109.714286 109.714286 0 1 1 0 219.428572 109.714286 109.714286 0 0 1 0-219.428572z m0 73.142857a36.571429 36.571429 0 1 0 0 73.142857 36.571429 36.571429 0 0 0 0-73.142857z" p-id="7477"></path></svg></el-icon>
      <h1 style="font-size: 30px; margin-left: 10px;">今天要做些什么？</h1>
      </div>
    </div>
    <p style="margin-top: -265px;margin-left: 50px">{{date}}</p>
    <el-icon size="25" style="margin-right: -500px;position: absolute;right: 800px" @click="history=!history" ><svg t="1709809538824" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2649" width="48" height="48"><path d="M511.998 64C264.574 64 64 264.574 64 511.998S264.574 960 511.998 960 960 759.422 960 511.998 759.422 64 511.998 64z m353.851 597.438c-82.215 194.648-306.657 285.794-501.306 203.579S78.749 558.36 160.964 363.711 467.621 77.917 662.27 160.132c168.009 70.963 262.57 250.652 225.926 429.313a383.995 383.995 0 0 1-22.347 71.993z" fill="#666666" p-id="2650"></path><path d="M543.311 498.639V256.121c0-17.657-14.314-31.97-31.97-31.97s-31.97 14.314-31.97 31.97v269.005l201.481 201.481c12.485 12.485 32.728 12.485 45.213 0s12.485-32.728 0-45.213L543.311 498.639z" fill="#666666" p-id="2651"></path></svg></el-icon>
  </div>
  <div v-if="history" style="width: 100px;height: 100px;background-color: #181818"></div>
</template>
<script setup lang="ts">
import {onMounted,ref} from "vue";

const date=ref<string>('')
const history=ref(false)
const formatDate = () => {
  const currentDate = new Date();
  const month = currentDate.toLocaleString('default', { month: 'long' });
  const day = currentDate.getDate();
  const dayOfWeek = currentDate.toLocaleString('default', { weekday: 'long' });
  date.value = `${month} ${day}, ${dayOfWeek}`;
};
onMounted(() => {
  formatDate();
});

</script>

<style scoped>

</style>