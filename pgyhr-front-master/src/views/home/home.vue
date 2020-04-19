<style lang="less">
@import "./home.less";
@import "../../styles/common.less";
</style>

<template>
  <div>
    <div v-show="currNav=='pgyhr'" class="home">
      <Row :gutter="10">
        <Col :lg="24" :xl="8">
          <Row :gutter="10">
            <Col :lg="12" :xl="24" :style="{marginBottom: '10px'}">
              <Card>
                <Row type="flex" class="user-info">
                  <Col span="8">
                    <Row class-name="made-child-con-middle" type="flex" align="middle">
                      <img class="avator-img" :src="avatarPath" />
                    </Row>
                  </Col>
                  <Col span="16" style="padding-left:6px;">
                    <Row class-name="made-child-con-middle" type="flex" align="middle">
                      <div>
                        <b class="card-user-info-name">{{ username }}</b>
                        <p>欢迎您的使用</p>
                      </div>
                    </Row>
                  </Col>
                </Row>
                <div class="line-gray"></div>
                <Row class="margin-top-8">
                  <Col span="8">
                    <p class="notwrap">本次登录地点:</p>
                  </Col>
                  <Col span="16" class="padding-left-8">{{city}}</Col>
                </Row>
              </Card>
            </Col>
          </Row>
        </Col>
        <Col :lg="24" :xl="16">
          <Row :gutter="5">
            <Col :sm="24" :md="12" :lg="6" :style="{marginBottom: '10px'}">
              <info-card
                id-name="user_created_count"
                :end-val="count.createUser"
                iconType="md-person-add"
                color="#2d8cf0"
                intro-text="今日新增用户"
              ></info-card>
            </Col>
            <Col :sm="24" :md="12" :lg="6" :style="{marginBottom: '10px'}">
              <info-card
                id-name="visit_count"
                :end-val="count.visit"
                iconType="ios-eye"
                color="#64d572"
                :iconSize="50"
                intro-text="今日浏览量"
              ></info-card>
            </Col>
            <Col :sm="24" :md="12" :lg="6" :style="{marginBottom: '10px'}">
              <info-card
                id-name="collection_count"
                :end-val="count.collection"
                iconType="md-cloud-upload"
                color="#ffd572"
                intro-text="今日数据采集量"
              ></info-card>
            </Col>
            <Col :sm="24" :md="12" :lg="6" :style="{marginBottom: '10px'}">
              <info-card
                id-name="transfer_count"
                :end-val="count.transfer"
                iconType="md-shuffle"
                color="#f25e43"
                intro-text="今日服务调用量"
              ></info-card>
            </Col>
          </Row>
        </Col>
      </Row>
      <Row :gutter="10">
        <Col :lg="24" :xl="16" :style="{marginBottom: '10px'}">
          <visit-volume/>
        </Col>
        <Col :lg="24" :xl="8" :style="{marginBottom: '10px'}">
          <visit-separation/>
        </Col>
      </Row>
    </div>
    <div v-show="currNav=='doc'||currNav=='pgyhr-show'||currNav=='xpay'||currNav=='xmall'">
      <show />
    </div>
    <div v-show="currNav=='app'">
      <h1>⬅️ 我是小程序与Flutter App的首页，点击左侧菜单查看详情</h1>
    </div>

  </div>
</template>

<script>
import { ipInfo } from "@/api/index";
import visitVolume from "./components/visitVolume.vue";
import visitSeparation from "./components/visitSeparation.vue";
import infoCard from "./components/infoCard.vue";
import show from "./show.vue";
import Cookies from "js-cookie";
import "gitalk/dist/gitalk.css";
import Gitalk from "gitalk";
import {mapState, mapGetters, mapActions} from 'vuex';
import areaTypes from "../../store/event-types/common/area_types.js";
import countryTypes from "../../store/event-types/common/country_types.js";

export default {
  name: "home",
  components: {
    visitVolume,
    visitSeparation,
    infoCard,
    show
  },
  data() {
    return {
      showVideo: false,
      count: {
        createUser: 496,
        visit: 3264,
        collection: 24389305,
        transfer: 39503498
      },
      city: "",
      username: ""
    };
  },
  computed: {

    currNav() {
      return this.$store.state.app.currNav;
    },
    avatarPath() {
      return localStorage.avatorImgPath;
    }
  },
  methods: {
    ...mapActions('areaModule', [areaTypes.AREA_DATA,areaTypes.ALL_AREA_DATA]),
    ...mapActions('countryModule', [countryTypes.COUNTRY_DATA]),

    init() {
      let userInfo = JSON.parse(Cookies.get("userInfo"));
      this.username = userInfo.username;
      ipInfo().then(res => {
        if (res.success) {
          this.city = res.result;
        }
      });


    },

    async initData(){
      await this[areaTypes.AREA_DATA]("CN");
      await this[areaTypes.ALL_AREA_DATA]("CN");
      await this[countryTypes.COUNTRY_DATA]("");
    }
  },
  mounted() {
    this.init();
    this.initData();
  }
};
</script>
