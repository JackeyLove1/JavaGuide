<template>
    <el-container class="h-[400px] border border-black">
      <el-header>
        <div class="flex flex-row items-center justify-center gap-x-2">
          <el-button type="primary" @click="addItem" class="rounded-sm">Add Item</el-button>
          <el-button type="warning" @click="deleteItem" class="rounded-sm">Delete Item</el-button>
          <el-button type="info" @click="clearItem" class="rounded-sm">Clear Item</el-button>
        </div>
      </el-header>
      <el-main>
        <el-scrollbar>
          <div v-for="item in counter" :key="item" class="w-8 h-8 rounded-md text-center bg-indigo-300 mt-2">
            {{item}}
          </div>
        </el-scrollbar>
      </el-main>
    </el-container>
  </template>

<script setup lang="ts">
import { ref } from 'vue'

const counter = ref(10)

function addItem() {
    counter.value += 1
}

function deleteItem() {
    counter.value -= 1
}

function clearItem() {
    counter.value = 0
}
</script>

<style scoped></style>
<template>
    <el-container class="h-[400px] border border-black">
        <el-header>
            <div class="flex flex-row items-center justify-center gap-x-2">
                <el-button type="primary" @click="addItem" class="rounded-sm">Add Item</el-button>
                <el-button type="warning" @click="deleteItem" class="rounded-sm">Delete Item</el-button>
                <el-button type="info" @click="clearItem" class="rounded-sm">Clear Item</el-button>
            </div>
        </el-header>
        <el-main>
            <el-scrollbar>
                <div v-for="item in counter" :key="item" class="w-8 h-8 rounded-md text-center bg-indigo-300 mt-2">
                    {{ item }}
                </div>
            </el-scrollbar>
        </el-main>
    </el-container>
</template>

<script setup lang="ts">
  import {ref} from 'vue'
  
  const counter = ref(10)
  
  function addItem() {
    counter.value += 1
  }
  
  function deleteItem() {
    counter.value -= 1
  }
  
  function clearItem() {
    counter.value = 0
  }
  </script>

<style scoped></style>