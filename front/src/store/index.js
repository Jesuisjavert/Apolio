import Vue from 'vue'
import Vuex from 'vuex'
import pathify from 'vuex-pathify'
import * as modules from './modules'
import axios from 'axios'
import router from '../router'
// import { $cookies } from 'vue/types/umd'

Vue.use(Vuex)

export default new Vuex.Store({
  modules,

  state: {
    drawer: false,
    links: [
      'Home',
      'About me',
      'Portfolio',
      'Blog',
      'Community',
      'Contact',
      'Login',
    ],
    token: ''
  },

  mutations: {
    SET_DRAWER (state, payload) {
      state.drawer = payload
    },
  },

  plugins: [pathify.plugin],
})
