// Utilities
import { make } from 'vuex-pathify'

let image = 0
const categories = [
  'All',
  'Vue',
  'Python',
  'Algorithm',
  'Django',
  'Etc',
]

const state = {
  categories,
  filter: 'All',
  picture: null,
  pictures: Array.from({ length: 30 }).map(() => {
    image++

    return {
      src: `images/pic/pic${image}.png`,
      category: categories[Math.floor(Math.random() * categories.length)],
    }
  }),
}

const mutations = make.mutations(state)

export default {
  namespaced: true,
  state,
  mutations,
}
