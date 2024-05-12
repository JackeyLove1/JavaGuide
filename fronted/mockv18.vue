<template>
    <div class="flex flex-col items-center justify-center gap-y-2">
      <el-radio-group v-model="size" aria-label="size control">
        <el-button value="large">large</el-button>
        <el-button value="default">default</el-button>
        <el-button value="small">small</el-button>
      </el-radio-group>
  
      <span>Pick A Time</span>
      <el-date-picker
          v-model="value1"
          type="date"
          placeholder="Pick A Day"
          :size="size"
      />
    </div>
  
  </template>
  
  <script setup lang="ts">
  import {ref, watch} from "vue";
  
  const size = ref<'default' | 'large' | 'small'>('default')
  const value1 = ref('')
  watch(size, () => {
    console.log(`size:${size}`)
  })
  </script>
  
  <style scoped>
  
  </style>
  