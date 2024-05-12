<template>
    <div class="flex flex-col items-center">
      <p>Child options expand when hovered</p>
      <el-cascader
          v-model="value"
          :options="options"
          :placeholder="placeHolder"
          @change="handleChange"
          clearable
          class="mt-4"
      />
    </div>
  
  
  </template>
  
  <script setup lang="ts">
  import {ref} from "vue";
  const value = ref([])
  const placeHolder = ref("PlaceHolder")
  const options = [
    {
      value: "value1",
      label: "label1",
      children: [
        {
          value: "value1-1",
          label: "label1-1"
        }
      ]
    }
  ]
  
  function handleChange(value : any) : void {
    console.log(value)
  }
  </script>
  
  <style scoped>
  
  </style>
  