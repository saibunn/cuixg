<template></template>
<script>
  export default {
    data () {
      return {}
    },
    methods: {
      buildSocialJSONParam (socialData) {
        let self = this
        let returnJSON = {
          social: [],
          fund: []
        }
        if (socialData !== null && socialData !== undefined) {
          socialData.forEach(item => {
            if (item.itemCode === 'DIT00057' || item.itemCode === 'DIT00058') {
              returnJSON.fund.push({
                itemCode: item.itemCode,
                comBase: item.companyBase,
                perBase: item.personalBase,
                effectiveMonth: self.$dateUtils.stdFormatMonth(new Date(item.startDate))
              })
            } else {
              returnJSON.social.push({
                itemCode: item.itemCode,
                comBase: item.companyBase,
                perBase: item.personalBase,
                effectiveMonth: self.$dateUtils.stdFormatMonth(new Date(item.startDate))
              })
            }
          })
        }
        return returnJSON
      },
      /**
       * paramJSON
       * @returns {Promise<*>}
       */
      async getSocialItemData(paramJSON) {
        let self = this
        let returnData
        await this.axios.post(this.$store.SITE_PORT + '/afCompanyCenter/empSocial/getMatchSocialNew', paramJSON).then(function (response) {
          if (response.data.code == 0 || response.data.errorCode) {
            self.$Notice.error({title: '系统提示', desc: response.data.errorMsg})
          } else if (response.data.code != 0 && response.data.list) {
            returnData = response.data
          }
        }).catch(function (error) {
          self.$Notice.error({
            title: '系统提示',
            desc: error
          })
        })
        return returnData
      }
    },
    mounted () {}
  }
</script>
