<template>
  <div id="form-main">
    <div id="form-div">
      <p class="name">
        <input name="name" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Title" id="name" v-model="blogData.title"/>
      </p>

      <p class="text">
        <textarea name="text" class="validate[required,length[6,300]] feedback-input" id="description" placeholder="description" v-model="blogData.description"></textarea>
      </p>

      <p>
        메인 이미지 : <input name="userfile" type="file" @change="fileChange($event)" />
      </p>

      <p class="text">
        <editor
          ref="toastuiEditor"
          :inital-value="Text"
          height="600px"
        />
      </p>

      <div class="submit" @click="createBlog">
        <input type="submit" value="SEND" id="button-blue"/>
        <div class="ease" @click="createBlog"></div>
      </div>

    </div>
  </div>
</template>

<script>
  import axios from 'axios'
  import 'codemirror/lib/codemirror.css'
  import '@toast-ui/editor/dist/toastui-editor.css'
  import { Editor, Viewer } from '@toast-ui/vue-editor'
  import '@toast-ui/editor/dist/toastui-editor-viewer.css'

  const API_URL = 'http://127.0.0.1:4000/api/blog'

  export default {
    name: 'ArticleCreate',

    components: {
      editor: Editor,
    },
    data () {
      return {
        Text: 'text',

        config: {
          headers: {
            enctype: "application/json",
          },
        },
       
        blogData : {
          user_id: null,
          title: null,
          description: null,
          content: null,
          img: null,
          tageId: 1,
        },
      }
    },
    methods: {
      createBlog () {
        this.blogData.content = this.$refs.toastuiEditor.invoke('getHtml')
        axios.post(API_URL,this.blogData)
          .then((res) => {
            console.log(res)
          })
          
      },
      fileChange (event) {
        // this.blogData.img = event.target.files[0]
        // console.log(this.blogData.img)
      },
    },
  }
</script>

<style scoped>
@import url(https://fonts.googleapis.com/css?family=Montserrat:400,700);

html{    background:url(http://thekitemap.com/images/feedback-img.jpg) no-repeat;
  background-size: cover;
  height:100%;
}

#feedback-page{
	text-align:center;
}

#form-main{
	width:100%;
	float:left;
	padding-top:0px;
}

#form-div {
	background-color: #eaf9ff;
	padding-left:35px;
	padding-right:35px;
	padding-top:35px;
	padding-bottom:50px;
  width: 90%;
  margin: auto;
	left: 50%;
  margin-top:30px;
}

.feedback-input {
	color:#7c7575;
	font-family: Helvetica, Arial, sans-serif;
  font-weight:500;
	font-size: 18px;
	border-radius: 0;
	line-height: 22px;
	background-color: #fbfbfb;
	padding: 13px 13px 13px 54px;
	margin-bottom: 10px;
	width:100%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	box-sizing: border-box;
  border: 3px solid rgba(0,0,0,0);
}

.feedback-input:focus{
	background: #fff;
	box-shadow: 0;
	border: 3px solid #3498db;
	color: #3498db;
	outline: none;
  padding: 13px 13px 13px 54px;
}

.focused{
	color:#30aed6;
	border:#30aed6 solid 3px;
}

/* Icons ---------------------------------- */
#Title{
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

#Title:focus{
	background-size: 30px 30px;
	background-position: 8px 5px;
  background-position: 11px 8px;
	background-repeat: no-repeat;
}

#description{
	background-size: 30px 30px;
	background-position: 11px 8px;
	background-repeat: no-repeat;
}

textarea {
    width: 100%;
    height: 150px;
    line-height: 150%;
    resize:vertical;
}

input:hover, textarea:hover,
input:focus, textarea:focus {
	background-color:white;
}

#button-blue{
	font-family: 'Montserrat', Arial, Helvetica, sans-serif;
	float:left;
	width: 100%;
	border: #fbfbfb solid 4px;
	cursor:pointer;
	background-color: #CC5163;
	color:white;
	font-size:24px;
	padding-top:22px;
	padding-bottom:22px;
	-webkit-transition: all 0.3s;
	-moz-transition: all 0.3s;
	transition: all 0.3s;
  margin-top:-4px;
  font-weight:700;
}

#button-blue:hover{
	background-color: rgba(0,0,0,0);
	color: #CC5163;
}
	
.submit:hover {
	color: #3498db;
}
	
.ease {
	width: 0px;
	height: 74px;
	background-color: #fbfbfb;
	-webkit-transition: .3s ease;
	-moz-transition: .3s ease;
	-o-transition: .3s ease;
	-ms-transition: .3s ease;
	transition: .3s ease;
}

.submit:hover .ease{
  width:100%;
  background-color:white;
}

@media only screen and (max-width: 580px) {
	#form-div{
		left: 3%;
		margin-right: 3%;
		width: 88%;
		margin-left: 0;
		padding-left: 3%;
		padding-right: 3%;
	}
}
</style>
