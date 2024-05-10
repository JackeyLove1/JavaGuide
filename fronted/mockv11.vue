<template>
    <el-button type="primary" icon="el-icon-search">搜索</el-button>
    <el-icon>
      <Edit></Edit>
    </el-icon>
    <el-icon>
      <Search></Search>
    </el-icon>
  
    <el-row>
      <el-button type="primary" round>
        Button
      </el-button>
  
      <el-button type="success" plain>
        Button
      </el-button>
  
      <el-button type="info" plain class="inline-flex">
        <el-icon>
          <Edit></Edit>
        </el-icon>
        <span>Edit</span>
      </el-button>
    </el-row>
  
    <div>
      <el-button type="warning" :icon="Check" circle>
      </el-button>
    </div>
  
    <div>
      <p> Disabled Button Link</p>
      <el-button
          v-for="button in buttons"
          :key="button.text"
          :type="button.type"
          link
          disabled
      >
        {{ button.text }}
      </el-button>
    </div>
  
    <div>
      <el-button type="primary">
        Upload
        <el-icon class="el-icon--right">
          <Upload></Upload>
        </el-icon>
      </el-button>
    </div>
  
    <div>
      <el-button-group>
        <el-button type="success" :icon="Check"></el-button>
        <el-button type="success" :icon="Share"></el-button>
        <el-button type="success" :icon="Delete"></el-button>
      </el-button-group>
    </div>
  </template>
  
  <script setup lang="ts">
  import {
    Check,
    Upload,
    Edit,
    Share,
    Delete,
    Search,
  } from '@element-plus/icons-vue'
  
  const buttons = [
    {type: '', text: 'plain'},
    {type: 'primary', text: 'primary'},
    {type: 'success', text: 'success'},
    {type: 'info', text: 'info'},
    {type: 'warning', text: 'warning'},
    {type: 'danger', text: 'danger'},
  ] as const
  
  
  </script>
  
  <style scoped>
  .el-row {
    @apply mt-4 ml-2 mr-2 flex flex-row
  }
  
  .grid-content {
    @apply min-h-[36px] w-full rounded-md
  }
  
  .bg-purple-dark {
    background: #99a9bf;
  }
  
  .bg-purple {
    background: #d3dce6;
  }
  
  .bg-purple-light {
    background: #e5e9f2;
  }
  
  </style>
  