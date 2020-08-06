<template>
  <v-container
    id="home"
    class="pt-12 pb-0 px-0"
    fluid
    tag="section"
  >
    <home-headline />
    <div>
      {{crawling.title}}
    </div>
  </v-container>
</template>

<script>
  import axios from 'axios'

  const API_URL = 'http://127.0.0.1:8080'

  export default {
    name: 'Home',

    components: {
      HomeHeadline: () => import('@/components/base/HomeHeadline'),
    },

    data () {
      return {
        crawling: [],
      }
    },
    created () {
      this.loadCrawling()
    },
    methods: {
      loadCrawling () {
            axios.get(`${API_URL}/api/`).then((res) => {
          this.crawling = res.data
        })
        console.log(this.crawling)
      },
    },
  }
</script>
