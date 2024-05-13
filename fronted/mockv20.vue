<template>

    <el-switch
        v-model="value"
        size="large"
    >
    </el-switch>
  </template>
  
  <script setup lang="ts">
  import {ref} from "vue";
  
  const value = ref(true)
  </script>
  
  <style scoped>
  
  </style>
  