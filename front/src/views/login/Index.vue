
<script>
  // Extensions
  import View from '@/views/View'

  // Mixins
  import LoadSections from '@/mixins/load-sections'

  export default {
    name: 'Login',

    metaInfo: { title: 'Login' },

    extends: View,

    mixins: [
      LoadSections([
        'Login',
      ]),
    ],

    props: {
      id: {
        type: String,
        default: 'Login',
      },
    },
  }
</script>
