<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html style="height: 100%">
   <head>
       <meta charset="utf-8">
   </head>
   <body style="height: 100%; margin: 0">
       <div id="main" style="height: 100%"></div>
       <script type="text/javascript" src="js/echarts.js"></script>
       <script type="text/javascript">
       //基于准备好的DOM，初始化echarts实例
       var myChart = echarts.init(document.getElementById('main'));
         //指定图表的配置项和数据
       var option = {
           title:{
               text:'租房价格'
           },
           //提示框组件
           tooltip:{
               //坐标轴触发，主要用于柱状图，折线图等
               trigger:'axis'
           },
           //图例
           legend:{
               data:['房价']
           },
           //横轴
           xAxis:{
               data:['下沙地区', '萧山地区', '余杭地区', '富阳地区', '上城区', '下城区', '江干区', '滨江区', '拱墅区']
           },
           //纵轴
           yAxis:{},
           //系列列表。每个系列通过type决定自己的图表类型
           series:[{
               name:'房价',
               //折线图
               type:'line',
               data:[3000, 3500, 3000, 2800, 4000, 4100, 3500, 5550, 4000]
           }]
       };
       //使用刚指定的配置项和数据显示图表
       myChart.setOption(option);
       
       </script>
   </body>
</html>