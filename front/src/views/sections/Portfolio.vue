<template>
  <v-container
    id="portfolio"
    class="pt-12 pb-0 px-0"
    fluid
    tag="section"
  >
    <portfolio-headline />

    <gallery />
  </v-container>
</template>

<script>
  export default {
    name: 'Portfolio',

    components: {
      Gallery: () => import('@/components/base/Gallery'),
      PortfolioHeadline: () => import('@/components/base/PortfolioHeadline'),
    },
  }
</script>
