<template>
  <div class="container">
    <div class="welcome">
      <div class="pinkbox" :style="{transform: myTansfrom}">
        <div class="signup" :class="{nodisplay: !this.flag}">
          <h1>register</h1>
          <input type="email" placeholder="email" v-model="signupData.email">
          <input type="password" placeholder="password" v-model="signupData.passwrod">
          <input type="text" placeholder="nickname" v-model="signupData.nickname">
          <button class="button submit" @click="signup">create account </button>
        </div>
        <div class="signin" :class="{nodisplay: this.flag}">
          <h1>sign in</h1>
            <input type="email" placeholder="email" v-model="loginData.email">
            <input type="password" placeholder="password" v-model="loginData.password">

            <button class="button submit" @click="login">login</button>
        </div>
      </div>
      <div class="leftbox">
        <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
        <p class="desc">pick your perfect <span>bouquet</span></p>
        <img class="flower smaller" src="https://image.ibb.co/d5X6pn/1357d638624297b.jpg" alt="1357d638624297b" border="0">
        <p class="account">have an account?</p>
        <button class="button" id="signin" @click="flag = false">login</button>
      </div>
      <div class="rightbox">
        <h2 class="title"><span>BLOOM</span>&<br>BOUQUET</h2>
        <p class="desc"> pick your perfect <span>bouquet</span></p>
        <img class="flower" src="https://preview.ibb.co/jvu2Un/0057c1c1bab51a0.jpg"/>
        <p class="account">don't have an account?</p>
        <button class="button" id="signup" @click="flag = true">sign up</button>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  const API_URL = 'http://127.0.0.1:8080/auth'

  export default {
    name: 'Login',

    components: {
    },
    methods: {
      login() {
        console.log(this.loginData)
        axios.post(API_URL + "/login", this.loginData)
          .then((res) => {
            this.$cookies.set('accessToken', res.data.accessToken)
          })
      },
      signup() {
        console.log(this.signupData)
        axios.post(API_URL + "/signup", this.signupData)
      }
    },
    computed: {
      myTansfrom() {
        return this.flag ? 'translateX(80%)' : 'translateX(0%)'
      }
    },
    data() {
      return{
        flag: false,
        loginData: {
          email: null,
          password: null,
        },
        signupData: {
          email: null,
          password: null,
          nickname: null,
        }
      }
    }
  }
</script>

<style scoped lang="scss">
  $gray: #8E9AAF;
  $lavender: #CBC0D3;
  $pale: #EAC7CC;
  $white: #f6f6f6;

  $pink: darken($pale, 20%);

  @import url('https://fonts.googleapis.com/css?family=Open+Sans:300,400|Lora');

  $sans-serif: 'Open Sans', sans-serif;
  $serif: 'Lora', serif;

  body {
    background: $lavender;
  }

  /* div box styling */
  .container {
    margin: auto;
    width: 650px;
    height: 550px;
    position: relative;
  }

  .welcome {
    background: $white;
    width: 650px;
    height: 415px;
    position: absolute;
    top: 25%;
    border-radius: 5px;
    box-shadow: 5px 5px 5px rgba(0,0,0,.1);
  }

  .pinkbox {
    position: absolute;
    top: -10%;
    left: 5%;
    background: $pale;
    width: 320px;
    height: 500px;
    border-radius: 5px;
    box-shadow: 2px 0 10px rgba(0,0,0,.1);
    transition: all .5s ease-in-out;
    z-index: 2;
  }

  .nodisplay {
    display:none;
    transition: all .5s ease;
  }

  .leftbox, .rightbox {
    position: absolute;
    width: 50%;
    transition: 1s all ease;
  }

  .leftbox {
    left: -2%;
  }
  .rightbox {
    right: -2%;
  }

  /* font & button styling */
  h1 {
    font-family: $sans-serif;
    text-align: center;
    margin-top: 95px;
    text-transform: uppercase;
    color: $white;
    font-size: 2em;
    letter-spacing: 8px;
  }

  .title {
    font-family: $serif;
    color: $gray;
    font-size: 1.8em;
    line-height: 1.1em;
    letter-spacing: 3px;
    text-align: center;
    font-weight: 300;
    margin-top: 20%;
  }
  .desc {
    margin-top: -8px;
  }
  .account {
    margin-top: 45%;
    font-size: 10px;
  }
  p {
    font-family: $sans-serif;
    font-size: .7em;
    letter-spacing: 2px;
    color: $gray;
    text-align: center;
  }

  span {
    color: $pale;
  }

  .flower {
    position: absolute;
    width: 120px;
    height: 120px;
    top: 46%;
    left: 29%;
    opacity: .7;
  }

  .smaller {
    width: 90px;
    height: 100px;
    top: 48%;
    left: 38%;
    opacity: .9;
  }

  button {
    padding: 12px;
    font-family: $sans-serif;
    text-transform: uppercase;
    letter-spacing: 3px;
    font-size: 11px;
    border-radius: 10px;
    margin: auto;
    outline: none;
    display: block;
    &:hover {
      background: $pale;
      color: $white;
      transition: background-color 1s ease-out;
    }
  }

  .button {
    margin-top: 3%;
    background: $white;
    color: $pink;
    border: solid 1px $pale;
  }

  /* form styling */

  form {
    display: flex;
    align-items: center;
    flex-direction: column;
    padding-top: 7px;
  }
  .more-padding{
    padding-top: 35px;
    input {
      padding: 12px;
    }
    .submit {
      margin-top: 45px;
    }
  }
  .submit {
    margin-top: 25px;
    padding: 12px;
    border-color: $pink;
    &:hover {
      background: $lavender;
      border-color: darken($lavender, 5%);
    }
  }

  input {
    background: $pale;
    width: 65%;
    color: $pink;
    border: none;
    border-bottom: 1px solid rgba($white, 0.5);
    padding: 9px;
    margin: 7px;
    &::placeholder {
      color: rgba($white, 1);
      letter-spacing: 2px;
      font-size: 1.3em;
      font-weight: 100;
    }
    &:focus {
      color: $pink;
      outline: none;
      border-bottom: 1.2px solid rgba($pink, 0.7);
      font-size: 1em;
      transition: .8s all ease;
      &::placeholder {
        opacity: 0;
      }
    }
  }

  label {
    font-family: $sans-serif;
    color: $pink;
    font-size: 0.8em;
    letter-spacing: 1px;
  }

  .checkbox {
    display: inline;
    white-space: nowrap;
    position: relative;
    left: -62px;
    top: 5px;
  }

  input[type=checkbox] {
    width: 7px;
    background: $pink;
  }

  .checkbox input[type="checkbox"]:checked + label {
    color: $pink;
    transition: .5s all ease;
  }
</style>