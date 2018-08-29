function show_user_long() {

    require.config({
        paths : {
            echarts : context_path + '/echarts/dist'
        }
    });

    require
    (
        [
            'echarts',
            'echarts/chart/line' ,
            // 'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
        ],
        function (ec)
        {
            var myChart = ec.init(document.getElementById('main'));
            var option = {
                title : {
                    text: '实时电压',
                    // subtext: '纯属虚构'
                },
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    data:['当前电压']
                },
                toolbox: {
                    show : true,
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        magicType : {show: true, type: ['line', 'bar']},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                dataZoom : {
                    show : true,
                    start : 0,
                    end : 100
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : true,
                        data : (function (){
                            var now = new Date();
                            var res = [];
                            var len = 30;
                            while (len--) {
                                res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
                                now = new Date(now - 30000);
                            }
                            return res;
                        })()
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        scale: true,
                        name : '电压(V)',
                        boundaryGap: [0.2, 0.2]
                    }
                ],
                series : [
                    {
                        name:'电压',
                        type:'line',
                        data:(function (){
                            var res = [];
                            var len = 30;
                            while (len--) {
                                res.push((Math.random()/300.000 + 2).toFixed(3) - 0);
                            }
                            return res;
                        })()
                    }
                ]
            };
            var lastData = 11;
            var axisData;
            var timeTicket;
            clearInterval(timeTicket);
            timeTicket = setInterval(function (){
                // lastData += Math.random() * ((Math.round(Math.random() * 10) % 2) == 0 ? 1 : -1);
                lastData = (Math.random()/300.000 + 2)
                lastData = lastData.toFixed(3) - 0;
                axisData = (new Date()).toLocaleTimeString().replace(/^\D*/,'');

                // 动态数据接口 addData
                myChart.addData([
                    [
                        0,        // 系列索引
                        lastData, // 新增数据
                        false,    // 新增数据是否从队列头部插入
                        false,    // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
                        axisData  // 坐标轴标签
                    ]
                ]);
            }, 30000);
            myChart.setOption(option);
            // setInterval(function () {
            //     for (var i = 0; i < 5; i++) {
            //         data.shift();
            //         data.push(randomData());
            //     }
            //     myChart.setOption({
            //         series: [{
            //             data: data
            //         }]
            //     });
            // }, 1000);
        }
    );
}
function show_battery_single_test(){
	// 路径配置
	require.config({
		paths : {
			echarts : context_path + '/echarts/dist'
		}
	});

	// 使用
	require([ 'echarts', 'echarts/chart/line', 'echarts/chart/line' ],
			function(ec) {
				var myChart = ec.init(document.getElementById('main'));
                var startu=[];    //起始电压数组
                var endu=[];    //终止电压数组
				var nums=[];    //（实际用来盛放X轴坐标值）
				myChart.showLoading();
                // $.ajax({
                //     type : "get",
                //     // async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
                //     url : context_path +" /rest/batterysingletest",    //请求发送到TestServlet处
                //     data : {},
                //     dataType : "json",        //返回数据形式为json
                //     success : function(result) {
                $.getJSON(context_path + "/rest/batterysingletest", function(result){
                        //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (result) {
                            for(var i=0;i<result.length;i++){
                                startu.push(result[i].startU);    //挨个取出类别并填入类别数组

                            }
                            for(var i=0;i<result.length;i++){
                                endu.push(result[i].endU);    //挨个取出销量并填入销量数组
                            }
                            for(var i=0;i<result.length;i++){
                                nums.push(result[i].serialNumber);    //挨个取出销量并填入销量数组
                            }
                            myChart.hideLoading();    //隐藏加载动画
                            myChart.setOption( {
                                tooltip : {
                                    trigger: 'axis'
                                },
                                legend: {
                                    data:['起始电压','终止电压']
                                },
                                toolbox: {
                                    show : true,
                                    feature : {
                                        dataZoom: {yAxisIndex: 'none'},
                                        mark : {show: true},
                                        dataView : {show: true, readOnly: false},
                                        magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                                        restore : {show: true},
                                        saveAsImage : {show: true}
                                    }
                                },
                                calculable : true,
                                xAxis : [
                                    {
                                        type : 'category',
                                        boundaryGap : false,
                                        data : nums,
                                        splitLine: {
                                            show: false
                                        }
                                    }
                                ],
                                yAxis : [
                                    {
                                        type : 'value',
                                        max : 2.07,
                                        min : 2.01,
                                        splitLine: {
                                            show: false
                                        }
                                    }
                                ],
                                dataZoom: {
                                    show: true,
                                    start : 0,
                                    end: 100
                                },
                                series : [
                                    {
                                        name:'起始电压',
                                        type:'line',
                                        data:startu,
                                        markPoint: {
                                            data: [
                                                {type: 'max', name: '最大值'},
                                                {type: 'min', name: '最小值'}
                                            ]
                                        },
                                        markLine: {
                                            data: [
                                                {type: 'average', name: '平均值'}
                                            ]
                                        }
                                    },
                                    {
                                        name:'终止电压',
                                        type:'line',
                                        data:endu,
                                        markPoint: {
                                            data: [
                                                {type: 'max', name: '最大值'},
                                                {type: 'min', name: '最小值'}
                                            ]
                                        },
                                        markLine: {
                                            data: [
                                                {type: 'average', name: '平均值'}
                                            ]
                                        }
                                    }
                                ]
                            });

                        }
                    // error : function(errorMsg) {
                    //     //请求失败时执行该函数
                    //     alert("图表请求数据失败!");
                    //     myChart.hideLoading();
                    // }
                })
				// 为echarts对象加载数据
				// myChart.setOption(option);
				window.onresize = myChart.resize;
			});
}
function show_send_email() {
    // $(document).ready(function() {
    //     $("#main").load("static/baobiao/docs/demo.html");
    // });
    // window.location.href="static/baobiao/docs/demo.html";
    window.open("static/baobiao/docs/demo.html");
}
function show_user_time() {
    $(document).ready(function() {
        $("#main").load("form.html");
    });
    // document.getElementById('main').load("${pageContext.request.contextPath}/error/error.jsp");
}
// function show_user_drr() {
//     $(document).ready(function() {
//         $("#main").load("test.html");
//     });
// }
function show_battery_location() {
    $(document).ready(function() {
        $("#main").load("map.html");
    });
}