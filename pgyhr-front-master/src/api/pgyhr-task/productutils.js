import moment from 'moment'
import math from 'mathjs'

export default {
  createPackageSubProduct,
  setDateFormat,
  newSetDateFormatMonth,
  setDateFormatMonth,
  productTypeKey,
  setTaxRate,
  sortSocialData
}

/**
 * 套餐详情数据组装
 */
function createPackageSubProduct (productList) {
  let subProduct = []
  if (productList) {
    productList.forEach(item => {
      let itemArray = []
      let serviceItems = JSON.parse(item.serviceItems)
      if (serviceItems && serviceItems.length > 0) {
        serviceItems.forEach(si => {
          let showItems = []
          if (si.options && si.options.length > 0) {
            si.options.forEach((content) => {
              let values = content.optionValueName
              for (let k of Object.keys(values)) {
                showItems.push(content.optionName + ':' + values[k])
              }
            })
          } else {
            showItems = ['']
          }
          itemArray.push(
            {itemName: si.itemName, showItems: showItems}
          )
        })
      } else {
        itemArray = [{itemName: '', showItems: ['']}]
      }
      subProduct.push({productName: item.productName, itemArray: itemArray})
    })
  }
  return subProduct
}

function setDateFormat (h, date) {
  if (date) {
    return h('div', [h('span', new Date(date).pattern('yyyy-MM-dd'))])
  } else {
    return ''
  }
}

function newSetDateFormatMonth (date) {
  if (date) {
    return new Date(date).pattern('yyyy-MM')
  } else {
    return ''
  }
}

function setDateFormatMonth (h, date) {
  if (date) {
    return h('div', [h('span', new Date(date).pattern('yyyy-MM'))])
  } else {
    return ''
  }
}

function productTypeKey(h, params) {
  let showLabel
  if (params.row.productType === 5) {
    showLabel = '是'
  } else {
    showLabel = '否'
  }
  return h('div', {style: {textAlign: 'productType'}}, [
    h('span', showLabel)
  ])
}

function setTaxRate(h, params) {
  if (params.row.empCompanyId || params.row.taxRate) {
    if (params.row.taxRate) {
      let mathTaxRate = math.multiply(params.row.taxRate, 100) + '%'
      return h('div', [
        h('span', mathTaxRate)
      ])
    } else {
      return h('div', [h('span', '-')])
    }
  } else {
    if (params.row.isTax === 0) {
      let taxRateDispatch = math.multiply(params.row.taxRateDispatch, 100) + '%'
      let taxRateAgent = math.multiply(params.row.taxRateAgent, 100) + '%'
      switch (params.row.productProperty) {
        case 0:
          return h('div', [
            h('span', '派遣:' + taxRateDispatch + ',代理:' + taxRateAgent)
          ])
        case 1:
          return h('div', [
            h('span', taxRateDispatch)
          ])
        case 2:
          return h('div', [
            h('span', taxRateAgent)
          ])
      }
    } else {
      return h('div', [h('span', '-')])
    }
  }
}

/**
 * 为社保数据排序(排序规则: 养老 失业 医疗 工伤 生育 公积金 补充公积金)
 */
function sortSocialData(socialData) {
  let newSocialData = []
  if (socialData) {
    let itemCodes = ['DIT00042', 'DIT00046', 'DIT00043', 'DIT00044', 'DIT00045', 'DIT00057', 'DIT00058']
    itemCodes.forEach(code => {
      socialData.forEach(item => {
        if (code === item.itemCode) {
          newSocialData.push(item)
        }
      })
    })
  }
  return newSocialData
}
