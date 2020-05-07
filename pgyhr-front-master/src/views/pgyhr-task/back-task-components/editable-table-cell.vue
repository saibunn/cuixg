<template>
  <div>
    <template v-if="editFlg">
      <Col span="19"><Input v-model="value"  size="small" ></Input></Col>
      <Col span="4" offset="1">
        <div v-on:click="editComplete" style="cursor:pointer">
          <Icon type="checkmark-round" />
        </div>
      </Col>
    </template>
    <template v-else>
      <Row>
        <Col span="20">{{value}}</Col>
        <Col span="4">
          <div v-on:click="edit" v-if="editable" style="cursor:pointer">
            <Icon type="edit" />
          </div>
        </Col>
      </Row>
    </template>
  </div>
</template>

<script>
export default {
  name: 'editableTableCell',
  props: {
    originValue: {
      default: 0
    },
    editable: {
      type: Boolean,
      default: true,
    },
  },
  data() {
    return {
      editFlg: false,
      value: 0,
    }
  },

  methods: {
    edit() {
      this.editFlg = true;
    },
    editComplete() {
      if(!this.isMoney(this.value)){
        this.$Modal.error({
          title: "<p><h3>错误</h3></p>",
          content: "<p><h3>请输入正确的金额！</h3></p>",
        });
      }else{
        this.editFlg = false;
        console.log("row.value ==="+this.value );
        this.value = this.value==''?0:this.value;
        this.$emit("on-edit-complete", this.value);
      }
    },
//    keUpEvent(event){
//    @on-change="editComplete"
//      this.value = Number(event.target.value.replace(/[^\d]/g,''));
//    }

    isMoney(s) {
      //var regu = "^[0-9]+[\.][0-9]{0,3}$";
      var regu  = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
      var re = new RegExp(regu);
      if (re.test(s)) {
        return true;
      } else {
        return false;
      }
    }
  },

  created() {
    this.value = this.originValue;
  }
}
</script>
