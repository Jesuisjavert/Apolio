// Utilities
import { make } from 'vuex-pathify'
import axios from 'axios'

const API_URL = 'http://127.0.0.1:8080';

let news = 0

const countries = [
  'All',
  'Korea',
  'U.S.A',
  'Austrailia',
  'Singapore',
  'Canada',
  'U.K'
]

const state = {
  crawling: [],
  loading: true,
  countries,
  filter: 'All',
  thumbnail: null,
}

const mutations = make.mutations(state)

const actions = {
  loadCrawling () {
    axios.get(`${API_URL}/api/news/korea`).then((res) => {
      console.log(res)
      state.crawling = res.data
    })
    console.log(state.crawling)
    },
  }

export default {
  namespaced: true,
  state,
  mutations,
}
