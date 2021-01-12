//var s = {
//    "integer": "@integer(10, 30)",  //随机生成一个10～30之间的正整数
//    "float": "@float(60, 100, 2, 2)",  //随机生成浮点数，参数分别为整数部分最小值和最大值、小数部分保留最小位数和最大位数
//    "boolean": "@boolean",       //随机生成boolean
//    "string|1-2": "@string",     //随机生成字符串
//    "name": "@cname",             //随机生成名字
//    "date": "@date(yyyy-MM-dd)", //按照格式随机生成时间
//    "datetime": "@datetime",     //随机生成时间
//    "now": "@now",               //当前时间
//    "id": "@id",                 //随机生成一个 18 位身份证
//    "guid": "@guid",             //随机生成一个 GUID
//    "url": "@url",               //随机生成url字符串
//    "email": "@email",           //随机生成邮箱
//    "image": "@image(200x200)",  //随机生成一个大小为200x200的图片链接
//    "title": "@title",           //随机生成一句标题，其中每个单词的首字母大写
//    "upper": "@upper(@title)",   //把生随机成的标题全部转为大写
//    "cparagraph": "@cparagraph", //随机生成一段中文文本
//    "csentence": "@csentence",   //随机生成一段中文文本
//    "range": "@range(2, 10)",   //返回一个内容从2开始到9的整型数组
//    "region": "@region",         //随机生成地区 华中
//    "province": "@province",     //随机生成省会 省
//    "city": "@city",             //随机生成城市 市
//    "county": "@county",         //随机生成一个（中国）县
//}


import {mockBasicPermissions, mockBasicRoles, mockLogin, mockLoginDetail} from "@/mockjs/login";
import {mockManagerDetail, mockManagers, mockRestPassword} from "@/mockjs/manager";
import {mockRoles} from "@/mockjs/role";


const Mock = require("mockjs");
const baseUrl = process.env.VUE_APP_REMOTE_URL;

Mock.mock(baseUrl + "/login.html", "post", mockLogin);

Mock.mock(baseUrl + "/basic/managerDetail.html", "post", mockLoginDetail);

Mock.mock(baseUrl + "/basic/roles.html", "post", mockBasicRoles);

Mock.mock(baseUrl + "/basic/permissions.html", "post", mockBasicPermissions);

Mock.mock(baseUrl + "/manager/search.html", "post", mockManagers);

Mock.mock(baseUrl + "/manager/detail.html", "post", mockManagerDetail);

Mock.mock(baseUrl + "/manager/rest-password.html", "post", mockRestPassword);

Mock.mock(baseUrl + "/role/search.html", "post", mockRoles());






















