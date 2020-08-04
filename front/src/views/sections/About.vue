<template>
  <v-container
    id="about"
    class="pa-0"
    fluid
    tag="section"
  >
    <v-row
      class="ma-0"
      no-gutters
    >
      <v-col
        cols="12"
        md="6"
      >
        <v-img
          height="calc(100vh - 96px - 156px)"
          src="@/assets/apolio.jpg"
        />
      </v-col>

      <v-col
        class="d-block d-md-flex align-center grey lighten-3 pa-6"
        cols="12"
        md="6"
      >
        <v-responsive
          class="mx-auto px-3 px-md-12"
          max-width="750"
        >
          <h1
            class="mb-6"
            :class="$vuetify.breakpoint.mdAndUp ? 'display-1' : 'display-1'"
          >
            Hello. This is javert<br>
            I'm a master of front-end develop.
          </h1>

          <p>
            저는 어렸을 때부터 美(미)에 관심이 많았습니다.
            특히 프랑스로 유학을 가서 '美'의 끝을 접하게 되었습니다.
            이후 저의 모든 역량을 프론트에 전념하고 있습니다.
            잘 감상해주세요!
          </p>

          <p>
            Ma devise est «La vie est belle». Nous avons toute la beauté fondue sur le web,<br>
            Alors profitez-en.
          </p>

          <div class="signature">
            jesuisjavert
          </div>
        </v-responsive>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'About',
  }
</script>

<style lang="sass">
  .signature
    font-family: 'Cedarville Cursive', cursive !important
    font-size: 2rem
    font-style: italic
</style>
