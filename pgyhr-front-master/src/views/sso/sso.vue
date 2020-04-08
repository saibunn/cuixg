<template>
  <div>
    <Card style="min-height:85vh">
      <div class="sso">
      </div>
    </Card>
  </div>
</template>

<script>
export default {
  name: "sso",
  data() {
    return {};
  },
  methods: {},
  created() {}
};
</script>

<style lang="less">
.sso {
  height: 50vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  .icon {
    width: 100px;
  }
}
</style>
