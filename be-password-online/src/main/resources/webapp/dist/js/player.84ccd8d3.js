(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["player"],{"16fc":function(t,e,s){"use strict";s("57e6")},"20d6":function(t,e,s){"use strict";s("76be")},"3dda":function(t,e,s){"use strict";var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"outSide"},[s("div",{staticClass:"sc-display moreinfo",staticStyle:{width:"100%",height:"60%"}},[s("span",{staticClass:"font24c"},[t._v(t._s(t.textinfo.name))])]),s("div",{staticStyle:{width:"100%",height:"40%"}},[s("div",{staticClass:"sc-display",staticStyle:{width:"50%",height:"100%",float:"left"}},[s("img",{staticStyle:{height:"16px",width:"24px"},attrs:{src:"imgs/classtext/icon-eye.png"}}),s("span",{staticClass:"font14c"},[t._v(t._s(t.textinfo.watch)+"次")])]),s("div",{staticClass:"sc-display",staticStyle:{width:"50%",height:"100%",float:"right"}},[s("img",{staticStyle:{height:"18px",width:"20px"},attrs:{src:"imgs/classtext/icon-note.png"}}),s("span",{staticClass:"font14c"},[t._v(t._s(t.textinfo.talk)+"次")])])])])},a=[],n={name:"ClassText",props:{textinfo:Object}},l=n,c=(s("16fc"),s("2877")),r=Object(c["a"])(l,i,a,!1,null,"68426b4b",null);e["a"]=r.exports},"413b":function(t,e,s){"use strict";s("aa31")},"57e6":function(t,e,s){},6208:function(t,e,s){},"6ae5":function(t,e,s){"use strict";s.r(e);var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("el-main",[s("PlayerWindow",{attrs:{msg:"PlayerWindow"}}),s("Introduce",{attrs:{msg:"Introduce"}}),s("ClassBrowse",{attrs:{msg:"ClassBrowse"}})],1)},a=[],n=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},l=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"videoWidow cc-display"},[s("video",{attrs:{width:"600",height:"400",align:"center",controls:""}},[s("source",{attrs:{src:"mp4/test.mp4",type:"video/mp4"}})])])}],c={name:"PlayerWindow",props:{msg:String}},r=c,o=(s("20d6"),s("2877")),d=Object(o["a"])(r,n,l,!1,null,"2dbe3544",null),u=d.exports,f=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cc-display",staticStyle:{width:"100%"}},[s("div",{staticClass:"boxOne cc-display so_middle"},[s("div",{staticStyle:{width:"30%",height:"100%"}},[s("ClassText",{attrs:{textinfo:{name:"考研英语第一讲",watch:"125",talk:"256"}}})],1),s("div",{staticClass:"cs-display",staticStyle:{width:"40%",height:"100%"}},[s("UserText",{attrs:{textinfo:{name:"张老师",order:"125"}}})],1),s("div",{staticClass:"es-display",staticStyle:{width:"30%",height:"100%"}},[s("CollectButton",{attrs:{textinfo:"collect"}})],1)])])},h=[],p=s("3dda"),v=s("842d"),m=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},g=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"outSide cc-display"},[s("img",{staticStyle:{width:"20px",height:"20px"},attrs:{src:"imgs/collectbutton/Icon-heart.png"}}),s("span",{staticClass:"font18b"},[t._v(" 收藏")])])}],x={name:"CollectButton",props:{textinfo:String}},y=x,w=(s("6c88"),Object(o["a"])(y,m,g,!1,null,"3bd8e7b8",null)),C=w.exports,_={name:"Introduce",components:{ClassText:p["a"],UserText:v["a"],CollectButton:C},props:{msg:String}},b=_,S=(s("f44f"),Object(o["a"])(b,f,h,!1,null,"14287451",null)),E=S.exports,O=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cc-display",staticStyle:{width:"100%"}},[s("div",{staticClass:"boxScroll so_middle",attrs:{id:"scrollDiv"}},[s("div",{style:{width:250*Math.round(t.videoChapter.length/2)-50+"px"}},t._l(t.videoChapter,(function(e,i){return s("div",{key:i,staticClass:"border-none classItem",style:[{float:"left",margin:"0 50px 30px 0"},i+1==Math.round(t.videoChapter.length/2)?{marginRight:"0"}:""]},[s("div",{staticClass:"cc-display",staticStyle:{width:"35%",height:"100%",float:"left"}},[s("span",{staticClass:"font26b"},[t._v(t._s(e.value))])]),s("div",{staticClass:"cc-display",staticStyle:{width:"65%",height:"100%",float:"left"}},[s("span",{staticClass:"font22b"},[t._v(t._s(e.title))])])])})),0)])])},$=[];function j(t,e){if(!(t instanceof e))throw new TypeError("Cannot call a class as a function")}function k(t,e){for(var s=0;s<e.length;s++){var i=e[s];i.enumerable=i.enumerable||!1,i.configurable=!0,"value"in i&&(i.writable=!0),Object.defineProperty(t,i.key,i)}}function D(t,e,s){return e&&k(t.prototype,e),s&&k(t,s),t}var T=function(){function t(e){j(this,t),this.scrollDiv=e,this.scrollCross()}return D(t,[{key:"scrollCross",value:function(){this.scrollDiv.addEventListener("DOMMouseScroll",this.handler,!1),this.scrollDiv.addEventListener("mousewheel",this.handler,!1)}},{key:"handler",value:function(t){var e=t.wheelDelta||t.detail,s=1,i=-1,a=0;a=e>0?100*s:100*i,this.scrollLeft+=a,t.preventDefault()}},{key:"explainText",value:function(){console.log("选集位置，设置鼠标滚轮横向滚动")}}]),t}(),B={name:"ClassBrowse",props:{msg:String},data:function(){return{videoChapter:[{title:"考研英语词汇解析",value:"01"},{title:"考研英语词汇解析2",value:"02"},{title:"考研英语词汇解析3",value:"03"},{title:"考研英语词汇解析4",value:"04"},{title:"考研英语词汇解析5",value:"05"},{title:"考研英语词汇解析5",value:"06"},{title:"考研英语词汇解析5",value:"07"},{title:"考研英语词汇解析5",value:"08"},{title:"考研英语词汇解析5",value:"09"},{title:"考研英语词汇解析5",value:"10"},{title:"考研英语词汇解析5",value:"11"}],scrollDiv:""}},mounted:function(){var t=new T(document.getElementById("scrollDiv"));t.explainText()}},I=B,P=(s("9ed9"),Object(o["a"])(I,O,$,!1,null,"7adb9d0d",null)),W=P.exports,M={name:"Player",components:{PlayerWindow:u,Introduce:E,ClassBrowse:W},data:function(){return{}}},L=M,U=(s("854f"),Object(o["a"])(L,i,a,!1,null,"a52d8342",null));e["default"]=U.exports},"6c88":function(t,e,s){"use strict";s("6fa4")},"6fa4":function(t,e,s){},"76be":function(t,e,s){},"842d":function(t,e,s){"use strict";var i=function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"outSide cc-display"},[t._m(0),s("div",{staticStyle:{width:"100px",height:"60px"}},[s("div",{staticClass:"sc-display border-none",staticStyle:{width:"100%",height:"50%","padding-left":"10px"}},[s("span",{staticClass:"font16c moreinfo"},[t._v(t._s(t.textinfo.name))])]),s("div",{staticClass:"sc-display",staticStyle:{width:"100%",height:"50%"}},[s("img",{staticStyle:{height:"14px",width:"14px",margin:"0 10px"},attrs:{src:"imgs/usertext/Icon-fire.png"}}),s("span",{staticClass:"font16e"},[t._v(t._s(t.textinfo.order))])])]),t._m(1)])},a=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cc-display",staticStyle:{width:"60px",height:"60px"}},[s("img",{staticStyle:{width:"46px",height:"46px","border-radius":"23px"},attrs:{src:"imgs/usertext/userexmple.png"}})])},function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"cc-display",staticStyle:{width:"120px",height:"60px"}},[s("button",{staticClass:"font16f moreinfo",staticStyle:{height:"36px",width:"100px","border-radius":"18px",border:"none","background-color":"#f5cf65"}},[t._v(" 了解详情 ")])])}],n={name:"UserText",props:{textinfo:Object}},l=n,c=(s("413b"),s("2877")),r=Object(c["a"])(l,i,a,!1,null,"0f53b9de",null);e["a"]=r.exports},"854f":function(t,e,s){"use strict";s("fb02")},"9ed9":function(t,e,s){"use strict";s("6208")},aa31:function(t,e,s){},e9b5:function(t,e,s){},f44f:function(t,e,s){"use strict";s("e9b5")},fb02:function(t,e,s){}}]);
//# sourceMappingURL=player.84ccd8d3.js.map