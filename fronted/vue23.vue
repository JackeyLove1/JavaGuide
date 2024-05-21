<template>
    <div class="w-32">
      <el-alert
          :type="'success'"
          :title="title"
      >
      </el-alert>
    </div>
  
    <el-button
        @click="handleOpen"
    >
      Show Dialog
    </el-button>
    <el-dialog
        v-model="showDialog"
        title="Warning"
        class="w-[20rem]"
    >
      <span>FBI Warning</span>
      <template #footer>
        <div class="flex flex-row space-x-2">
          <el-button @click="handleClose"> Cancel</el-button>
          <el-button @click="handleClose"> Confirm</el-button>
        </div>
      </template>
    </el-dialog>
  
    <el-button @click="openElMessage"> Click Message</el-button>
  
    <el-button @click="openElNotification"> Click Notification</el-button>
  </template>
  
  <script lang="ts" setup>
  import {ref} from 'vue'
  import {ElMessage, ElNotification} from "element-plus";
  
  const title = ref('title')
  
  const showDialog = ref(false)
  
  function handleClose() {
    showDialog.value = false
  }
  
  const handleOpen = () => showDialog.value = true
  
  const openElMessage = () => {
    ElMessage("This is a message")
  }
  
  const openElNotification = () => {
    ElNotification({
      type: "success",
      message: "Notification",
      title: "Success"
    })
  }
  </script>
  
  <style>
  </style>
  