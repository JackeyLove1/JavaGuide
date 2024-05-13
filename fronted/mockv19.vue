<template>
    <div class="flex flex-col gap-y-2">
      <div class="inline-flex items-center justify-center gap-x-2">
        <span>username: </span>
        <el-input
            v-model="input"
            placeholder="Input"
            clearable
            class="w-32"
        />
      </div>
      <div class="inline-flex items-center justify-center gap-x-2">
        <span>password: </span>
        <el-input
            v-model="pwd"
            placeholder="password"
            type="password"
            clearable
            class="w-32"
            show-password
        />
      </div>
    </div>
  </template>
  
  <script setup lang="ts">
  import {ref, watch} from "vue";
  
  const input = ref('')
  const pwd = ref('')
  watch(input, () => {
    console.log(`input: ${input.value}`)
  })
  </script>
  
  <style scoped>
  
  </style>
  