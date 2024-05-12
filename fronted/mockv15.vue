<template>
    <el-table :data="tableData" stripe class="w-screen">
        <el-table-column prop="date" label="Date" class="w-1/4"></el-table-column>
        <el-table-column prop="name" label="Name" class-name="1/3"></el-table-column>
        <el-table-column prop="address" label="Address"></el-table-column>
    </el-table>
</template>

<script setup lang="ts">
import { reactive } from "vue";

interface Props {
    date: string
    name: string
    address: string
}

const tableData: Array<Props> = reactive([
    {
        date: '2016-05-03',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-02',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
    {
        date: '2016-05-04',
        name: 'Tom',
        address: 'No. 189, Grove St, Los Angeles',
    },
])
</script>

<style scoped></style>