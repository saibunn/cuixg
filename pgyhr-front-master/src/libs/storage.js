/**
 * 存储localStorage
 */
export const setStore = (name, content) => {
    if (!name) return;
    if (typeof content !== 'string') {
        content = JSON.stringify(content);
    }
    window.localStorage.setItem(name, content);
};
/**
 * 获取localStorage
 */
export const getStore = name => {
    if (!name) return;
    return window.localStorage.getItem(name);
};

/**
 * 删除localStorage
 */
export const removeStore = name => {
    if (!name) return;
    window.localStorage.removeItem(name);
};

let localStorage = {
  getItem: function(key) {
    var value = key !== 'userInfo' ? window.localStorage.getItem(`companyCenter_${key}`) : window.localStorage.getItem(key)
    return value
  },
  setItem: function(key, value) {
    if (key !== 'userInfo') {
      window.localStorage.setItem(`companyCenter_${key}`, value)
    } else {
      window.localStorage.setItem(key, value)
    }
  },
  removeItem: function(key) {
    if (key !== 'userInfo') {
      window.localStorage.removeItem(`companyCenter_${key}`)
    } else {
      window.localStorage.removeItem(key)
    }
  },
  clear: function() {
    window.localStorage.clear()
  }
}

let sessionStorage = {
  getItem: function(key) {
    var value = key !== 'userInfo' ? window.sessionStorage.getItem(`companyCenter_${key}`) : window.sessionStorage.getItem(key)
    return value
  },
  setItem: function(key, value) {
    if (key !== 'userInfo') {
      window.sessionStorage.setItem(`companyCenter_${key}`, value)
    } else {
      window.sessionStorage.setItem(key, value)
    }
  },
  removeItem: function(key) {
    if (key !== 'userInfo') {
      window.sessionStorage.removeItem(`companyCenter_${key}`)
    } else {
      window.localStorage.removeItem(key)
    }
  },
  clear: function() {
    window.sessionStorage.clear()
  }
}

export {
  localStorage,
  sessionStorage
}
