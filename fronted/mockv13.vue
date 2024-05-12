<template>
    <el-text class="mx-1" type="primary">Default</el-text>
  
    <el-scrollbar>
      <div v-for="item in 20" :key="item" class="h-10 w-full rounded-md bg-gray-300 mt-4"></div>
    </el-scrollbar>

    <el-scrollbar>
    <div class="flex flex-row space-x-2 h-8">
      <div v-for="item in 50" :key="item" class="w-10 bg-gray-300 items-center justify-center rounded-md text-center px-2 py-1">
        {{ item }}
      </div>
    </div>
  </el-scrollbar>
    
  </template>
  
  <script setup lang="ts">
  
  
  
  </script>
  
  <style scoped>
  
  </style>
  