import Vue from 'vue'
import Vuetify, { VRow } from 'vuetify/lib'
// import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify, {
  components: { VRow },
})
export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#CC5163',
        secondary: '#FFFFFF',
        accent: '#3AAA1D',
        error: '#FF5252', 
        info: '#2196F3',
        success: '#4CAF50',
        warning: '#FFC107',
      },
    },
  },
})

// Error : 빨간색
// info : 짙하늘색
// success: 에메랄드초록
// warning: 바나나노랑