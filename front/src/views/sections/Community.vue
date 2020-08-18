<template>
  <v-container
    id="community"
    class="pa-0"
    fluid
    tag="section"
  >
    <blog-hero
      class="text-center white--text align-center"
      height="30vh"
    >
      <h1 class="display-2">
        jesuisjavert's Blog
      </h1>
    </blog-hero>
    <v-row
      align="center"
      justify="center"
    >
      <v-col
        cols="12"
      >
        <v-simple-table>
          <thead>
            <tr>
              <th class="body-1 font-weight-bold text-center">
                게시글
              </th>
              <th class="body-1 font-weight-bold text-center">
                작성자
              </th>
              <th class="body-1 font-weight-bold text-center">
                작성일
              </th>
            </tr>
          </thead>
          <tbody>
            <tr
              v-for="feature in features"
              :key="feature.id"
            >
              <v-dialog
                v-model="dialog"
                width="600px"
              >
                <template v-slot:activator="{ on, attrs }">
                  <td
                    v-bind="attrs"
                    v-on="on"
                    v-text="feature.title"
                  />
                </template>
                <v-card>
                  <v-card-title>
                    <span class="headline">{{ feature.title }}</span>
                  </v-card-title>
                  <v-card-text>
                    <span> {{ feature.username }}</span>
                  </v-card-text>
                  <v-card-text>
                    <span> {{ feature.username }}</span>
                  </v-card-text>
                  <v-card-actions>
                    <v-spacer />
                  </v-card-actions>
                </v-card>
              </v-dialog>
              <!-- <td class="text-center">
                {{ feature.user.name }}
              </td> -->
            </tr>
          </tbody>
        </v-simple-table>
        <v-spacer />
        <base-card-create
          fluid
          class="pa-0"
        />
        <!--
        <v-container class="text-center">
          <v-btn
            text
            medium
            to="/card-create"
          >
            Write
          </v-btn>
        </v-container>
         -->
        <!-- <v-container class="text-center">
          <v-btn
            text
            medium
            to="/community-post"
          >
            Write
          </v-btn>
        </v-container> -->
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
  import axios from 'axios'

  const API_URL = 'http://localhost:4000'
  export default {
    name: 'Community',

    components: {
      BlogHero: () => import('@/components/base/BlogHero'),
      CardCreate: () => import('@/components/base/CardCreate'),
      // eslint-disable-next-line vue/no-unused-components
      // ArticleCreate: () => import('@/components/base/ArticleCreate'),
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
        axios.get(`${API_URL}/api/community`).then((res) => {
          this.features = res.data
          console.log(res.data)
          console.log('----------------')
        })
          .catch((err) => {
            console.log(err.response)
          })
        console.log("features : " + this.features)
      },
    },
  }
</script>
