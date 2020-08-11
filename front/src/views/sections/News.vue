<template>
  <div>
    {{korea[0].title}}<br>
    {{usa[0].title}}<br>
    {{france[0].title}}<br>
    {{singapore[0].title}}<br>
    {{canada[0].title}}<br>
    {{uk[0].title}}<br>
  </div>
</template>

<script>
import axios from 'axios'
import {
get,
sync,
} from 'vuex-pathify'

const API_URL = 'http://127.0.0.1:8080'

export default {
    data () {
        return {
        korea: [],
        usa: [],
        france: [],
        singapore: [],
        canada: [],
        uk: [],
        }
    },
    created () {
        this.loadCrawling()
    },
    methods: {
        loadCrawling () {
        axios.get(`${API_URL}/api/news/korea`).then((res) => {
            this.korea = res.data
        })
        axios.get(`${API_URL}/api/news/usa`).then((res) => {
            this.usa = res.data
        })
        axios.get(`${API_URL}/api/news/france`).then((res) => {
            this.france = res.data
        })
        axios.get(`${API_URL}/api/news/singapore`).then((res) => {
            this.singapore = res.data
        })
        axios.get(`${API_URL}/api/news/canada`).then((res) => {
            this.canada = res.data
        })
        axios.get(`${API_URL}/api/news/uk`).then((res) => {
            this.uk = res.data
        })
        },
    },
}
</script>

<style>

</style>