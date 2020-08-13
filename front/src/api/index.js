import axios from 'axios'

export default {
  Korea() {
    return axios.get(`http://localhost:8080/api/news/korea`)
  },
  USA() {
    return axios.get(`http://localhost:8080/api/news/usa`)
  },
  France() {
    return axios.get(`http://localhost:8080/api/news/france`)
  },
  Singapore() {
    return axios.get(`http://localhost:8080/api/news/singapore`)
  },
  Canada() {
    return axios.get(`http://localhost:8080/api/news/canada`)
  },
  UK() {
    return axios.get(`http://localhost:8080/api/news/uk`)
  },
}