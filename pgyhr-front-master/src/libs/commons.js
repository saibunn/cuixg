import _ from 'lodash'

// Vue插件
// localstorage
let local = {
  save (key, value) {
    localStorage.setItem(key, value);
  },
  fetch (key) {
    return localStorage.getItem(key) || {};
  },
  back (vm, step) {
    window.history.go(-1);
    //  window.history.back();
  },
  set(key, value){
    if (typeof(value) !== 'string') {
      value = JSON.stringify(value);
    }
    localStorage.setItem(key, value);
  },
  get(key){
    var value = localStorage.getItem(key);
    try {
      return JSON.parse(value)
    } catch (e) {
      console.error(e);
      return null;
    }
  }
};


export default{
  install: function (vm) {
    vm.prototype.$local = local;
    // vm.prototype.$utils = utils;
    vm.prototype._ = _;
  }
}
