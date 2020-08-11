<template>
  <div>
    <v-row justify="center">
      <v-dialog
        v-model="dialog"
        persistent
        max-width="450"
      >
        <template v-slot:activator="{ on, attrs }">
          <base-btn
            :color="!theme.isDark ? 'accent' : 'white'"
            outlined
            v-bind="attrs"
            v-on="on"
          >
            Write
          </base-btn>
        </template>
        <v-card>
          <v-toolbar
            dark
          >
            <v-btn
              icon
              dark
              @click="dialog = false"
            >
              <v-icon>mdi-close</v-icon>
            </v-btn>
            <v-toolbar-title>Create</v-toolbar-title>
            <v-spacer />
            <v-toolbar-items>
              <v-btn
                dark
                text
                @click="createArticle"
              >
                Save
              </v-btn>
            </v-toolbar-items>
          </v-toolbar>
          <v-list
            three-line
            subheader
          >
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>글 제목</v-list-item-title>
                <!-- <base-text-field
                  id="title"
                  v-model="title"
                  label="title"
                  required
                /> -->
                <v-text-field
                  id="title"
                  v-model="title"
                  label="title"
                  required
                />
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-content>
                <v-list-item-title>내 용</v-list-item-title>
                <v-textarea
                  id="content"
                  v-model="content"
                  outlined
                  name="input-7-4"
                  label="content"
                />
              </v-list-item-content>
            </v-list-item>
          </v-list>
          <v-divider />
          <v-list
            three-line
            subheader
          />
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
  import axios from 'axios'

  const API_URL = 'http://127.0.0.1:8080'

  export default {
    name: 'ArticleCreate',

    inject: ['theme'],

    data () {
      return {
        dialog: false,
        title: null,
        content: null,
      }
    },
    methods: {
      createArticle () {
        this.dialog = false
        const articleData = {
          title: this.title,
          content: this.content,
        }
        console.log(articleData)
        // const RequestHeader = {
        //   headers: {
        //     Authorization: `Token ${this.$cookies.get('auth-token')}`,
        //   },
        // }
        axios.post(API_URL + '/api/blog/', articleData) // , RequestHeader
          .then((res) => {
            console.log('잘 가는거')
            this.$router.go(0)
          })
          .catch((err) => {
            console.log('못가는거')
            console.log(err.response)
          })
      },
    },
  }
</script>

<style>

</style>
