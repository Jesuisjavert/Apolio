<template>

</template>

<script>
  import axios from 'axios'

  const API_URL = 'http://i3c103.p.ssafy.io:8080'

  export default {
    name: 'HomeCrawling',

    components: {
      ArticleCreate: () => import('@/components/base/ArticleCreate'),
    },

    data () {
      return {
        features: [],
      }
    },
    created () {
      this.loadArticle()
    },
    methods: {
      loadArticle () {
        axios.get(`${API_URL}/articles/`).then((res) => {
          this.features = res.data
        })
        console.log(this.features)
      },
    },
  }
</script>

<style>

</style>