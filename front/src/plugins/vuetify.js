import Vue from 'vue'
import Vuetify, { VRow } from 'vuetify/lib'
// import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify, {
  components: { VRow },
})
// primary 빨간 / secondary 짙은 남색 / accent 흰색
export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#CE1F39',
        secondary: '#270949',
        accent: '#FFFFFF',
        error: '#FF5252',
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FFC107',
      },
    },
  },
})
