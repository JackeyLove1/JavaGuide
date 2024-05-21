<template>
    <el-upload
        v-model="fileList"
        class="w-12 h-12 "
    >
    </el-upload>
  
    <el-badge :value="12" class="mt-4 ml-4">
      <el-button> Commens</el-button>
    </el-badge>
  
    <el-card class="w-48 text-center">
      <template #header>
        <div>Header</div>
      </template>
      <template #default>
        <p
            v-for="item in 5"
            :key="item"
            class="mb-2"
        >
          Item{{ item }}
        </p>
      </template>
      <template #footer>
        footer
      </template>
    </el-card>
  
    <el-pagination
        :page-size="20"
        :page-count="11"
        layout="prev, pager, next"
        :total="100"
    >
    </el-pagination>
  
    <el-progress
        type="circle"
        :percentage="0"
    >
    </el-progress>
  
    <el-result
        icon="success"
        title="Title"
        sub-title="sub-title"
    >
      <template #extra>
        <el-button type="primary">Back</el-button>
      </template>
    </el-result>
  
    <el-tag
        type="primary"
        closable
    >
      Tag1
    </el-tag>
  
    <el-affix
        :offset="120"
    >
      <el-button type="primary">Offset 120</el-button>
    </el-affix>
  
    <el-breadcrumb :separator-icon="ArrowRight" class="mt-4">
      <el-breadcrumb-item to="{path: '/'}">homepage</el-breadcrumb-item>
      <el-breadcrumb-item >management</el-breadcrumb-item>
    </el-breadcrumb>
  </template>
  
  <script setup lang="ts">
  import {ref} from 'vue'
  import {ArrowRight} from "@element-plus/icons-vue";
  
  const fileList = ref([])
  </script>
  
  <style scoped>
  
  </style>
  