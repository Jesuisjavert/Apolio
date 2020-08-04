<template>
  <v-container
    id="contact"
    class="pa-0 grey lighten-3 flex-wrap align-start fill-height"
    fluid
    tag="section"
  >
    <iframe
      allowfullscreen
      frameborder="0"
      height="500"
      src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d193595.15951967583!2d-74.12010542954445!3d40.69766333203375!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c24fa5d33f083b%3A0xc80b8f06e177fe62!2sNew+York%2C+NY!5e0!3m2!1sen!2sus!4v1566422061048!5m2!1sen!2sus"
      style="border:0"
      width="100%"
    />

    <v-row
      class="ma-0"
      justify="center"
    >
      <v-col
        cols="12"
        md="4"
      >
        <h1 class="display-1 mb-8 font-weight-bold">
          Contact Info:
        </h1>

        <div class="mb-8">
          광주광역시 광산구 비아동 삼성 사업장
        </div>

        <div class="mb-4">
          <strong>Address</strong> 광주 광산구 하남산단6번로 107
        </div>

        <div class="mb-4">
          <strong>Phone</strong> (062) 950-6114
        </div>

        <div class="mb-4">
          <strong>Email</strong> ssafy7@gmail.com
        </div>

        <div class="mb-4">
          <strong>Fax</strong> (062) 950-6114
        </div>
      </v-col>

      <v-col
        cols="12"
        md="5"
      >
        <v-form>
          <v-row class="mb-6">
            <v-col
              cols="12"
              md="6"
            >
              <v-sheet>
                <v-text-field
                  flat
                  hide-details
                  label="Your Name"
                  solo
                />
              </v-sheet>
            </v-col>

            <v-col
              cols="12"
              md="6"
            >
              <v-sheet>
                <v-text-field
                  flat
                  hide-details
                  label="Your Email"
                  solo
                />
              </v-sheet>
            </v-col>

            <v-col cols="12">
              <v-sheet>
                <v-text-field
                  flat
                  hide-details
                  label="Your Title"
                  solo
                />
              </v-sheet>
            </v-col>

            <v-col cols="12">
              <v-sheet>
                <v-textarea
                  flat
                  hide-details
                  label="Your Message"
                  solo
                />
              </v-sheet>
            </v-col>
          </v-row>

          <v-btn
            :block="$vuetify.breakpoint.smAndDown"
            class="white--text"
            color="black"
            x-large
          >
            Send Message
          </v-btn>
        </v-form>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  export default {
    name: 'Contact',
  }
</script>
