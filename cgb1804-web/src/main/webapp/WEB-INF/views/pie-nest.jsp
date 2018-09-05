<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="nest" style="height: 100%"></div>
       <script type="text/javascript" src="js/echarts.js"></script>
       <script type="text/javascript">
       
       var myChart = echarts.init(document.getElementById('nest'));
 
       option = {
           tooltip: {
               trigger: 'item',
               formatter: "{a} <br/>{b}: {c} ({d}%)"
           },
           legend: {
               orient: 'vertical',
               x: 'left',
               data:['下沙地区', '萧山地区', '余杭地区', '富阳地区', '上城区', '下城区', '江干区', '滨江区', '拱墅区']
           },
           series: [
               {
                   name:'访问来源',
                   type:'pie',
                   selectedMode: 'single',
                   radius: [0, '30%'],

                   label: {
                       normal: {
                           position: 'inner'
                       }
                   },
                   labelLine: {
                       normal: {
                           show: false
                       }
                   },
                   data:[
                       {value:335, name:'58同城', selected:true},
                       {value:679, name:'链家'},
                       {value:1548, name:'我爱我家'}
                   ]
               },
               {
                   name:'访问来源',
                   type:'pie',
                   radius: ['40%', '55%'],
                   label: {
                       normal: {
                           formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                           backgroundColor: '#eee',
                           borderColor: '#aaa',
                           borderWidth: 1,
                           borderRadius: 4,
                           // shadowBlur:3,
                           // shadowOffsetX: 2,
                           // shadowOffsetY: 2,
                           // shadowColor: '#999',
                           // padding: [0, 7],
                           rich: {
                               a: {
                                   color: '#999',
                                   lineHeight: 22,
                                   align: 'center'
                               },
                               // abg: {
                               //     backgroundColor: '#333',
                               //     width: '100%',
                               //     align: 'right',
                               //     height: 22,
                               //     borderRadius: [4, 4, 0, 0]
                               // },
                               hr: {
                                   borderColor: '#aaa',
                                   width: '100%',
                                   borderWidth: 0.5,
                                   height: 0
                               },
                               b: {
                                   fontSize: 16,
                                   lineHeight: 33
                               },
                               per: {
                                   color: '#eee',
                                   backgroundColor: '#334455',
                                   padding: [2, 4],
                                   borderRadius: 2
                               }
                           }
                       }
                   },
                   data:[
                       {value:3000, name:'下沙地区'},
                       {value:3500, name:'萧山地区'},
                       {value:3000, name:'余杭地区'},
                       {value:2800, name:'富阳地区'},
                       {value:4000, name:'上城区'},
                       {value:4100, name:'下城区'},
                       {value:3500, name:'江干区'},
                       {value:5550, name:'滨江区'},
                       {value:4000, name:'拱墅区'}
                   ]
               }
           ]
       }; 
     myChart.setOption(option);

       </script>
   </body>
</html>