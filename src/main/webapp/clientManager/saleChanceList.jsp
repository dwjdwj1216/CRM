<%--
  Created by IntelliJ IDEA.
  User: 顾梦超
  Date: 2016/5/29
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">

    <title>Visitor</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <meta charset="utf-8" />
    <title>杨晴贺组CRM</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- basic styles -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="./assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="./assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="./assets/css/ace.min.css" />
    <link rel="stylesheet" href="./assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="./assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="./assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="./assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="./assets/js/html5shiv.js"></script>
    <script src="./assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    杨晴贺组CRM
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="./assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<small>欢迎光临,</small>
										${sessionScope.get("name")}
								</span>
                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="/personInfo">
                                <i class="icon-user"></i>
                                个人资料
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/Logout">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>

            <div class="sidebar-shortcuts" id="sidebar-shortcuts">

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li class="active">
                    <a href="#">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">杨晴贺组CRM</span>
                    </a>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-edit"></i>
                        <span class="menu-text"> 营销管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/client/saleChanceList/all/all">
                                <i class="icon-double-angle-right"></i>
                                营销管理
                            </a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text"> 客户管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/client/getClientList/all/all/1">
                                <i class="icon-double-angle-right"></i>
                                客户列表
                            </a>
                        </li>
                        <li>
                            <a href="/client/record/contactRecord">
                                <i class="icon-double-angle-right"></i>
                                来往记录
                            </a>
                        </li>

                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 服务管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/client/service/all/all/all">
                                <i class="icon-double-angle-right"></i>
                                服务管理
                            </a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 统计分析 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/client/statisticsCustomer">
                                <i class="icon-double-angle-right"></i>
                                客户数据分析
                            </a>
                        </li>
                        <li>
                            <a href="/client/statisticsService">
                                <i class="icon-double-angle-right"></i>
                                服务数据分析
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        首页->销售机会管理
                    </li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">


                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div style="width: 90%;position: absolute;left: 5%">
                            <div style="width: 90%; margin-left: 5%">
                                <form style="position:relative;top:10px;height:30px;width: 60%;">
                                    <input type="text" placeholder="请输入搜索内容" style="width: 80%;">
                                    <button style="margin-left: 8%">搜索</button>
                                </form>
                                <button style="position: relative;left: 70%;top:-17px;" onclick="javascript:window.location.href='/client/addSaleChance'">添加销售机会</button>
                            </div>

                            <select id="chanceStage" onchange="bao()" style="margin-left: 5%;">
                                <option value="all" <c:if test="${type=='all'}">selected="selected"</c:if>>全部</option>
                                <option value="talking" <c:if test="${type=='talking'}">selected="selected"</c:if>>商谈中</option>
                                <option value="completed" <c:if test="${type=='completed'}">selected="selected"</c:if> >已完成</option>
                                <option value="unfinished" <c:if test="${type=='unfinished'}">selected="selected"</c:if>>未完成</option>
                                <option value="unassigned" <c:if test="${type=='unassigned'}">selected="selected"</c:if>>未分配</option>
                            </select>
                            <select id="possibility" onchange="bao()">
                                <option value="all" <c:if test="${possibility=='all'}">selected="selected"</c:if>>全部</option>
                                <option value="3" <c:if test="${possibility=='3'}">selected="selected"</c:if>>大</option>
                                <option value="2" <c:if test="${possibility=='2'}">selected="selected"</c:if>>中</option>
                                <option value="1" <c:if test="${possibility=='1'}">selected="selected"</c:if>>小</option>
                            </select>

                            <div style="width: 90%;border: 1px solid #000;margin: 0 auto;font-size: 10px;">
                                <div style="width: 90%;margin: 10px auto; font-size: 10px">
                                    <c:forEach items="${saleChances}" var="saleChance">
                                        <br>
                                        <div >
                                            <span style="position:absolute;left:13%;font-size: 18px;">${saleChance.protentialCustomerName}</span>
                                            <span style="position:absolute;left:20%;font-size:18px">${saleChance.protencialCustomerPhone}</span>
                                            <span style="position:absolute;left:30%;font-size: 18px">
                                                <c:if test="${saleChance.chanceStage=='talking'}">
                                                    商谈中
                                                </c:if>
                                                <c:if test="${saleChance.chanceStage=='completed'}">
                                                    已完成
                                                </c:if>

                                                <c:if test="${saleChance.chanceStage=='unfinished'}">
                                                    未完成
                                                </c:if>
                                                 <c:if test="${saleChance.chanceStage=='unassigned'}">
                                                     未分配
                                                 </c:if>
                                            </span>
                                            <span style="margin-left:15%;top:10px;">
                                                <c:if test="${saleChance.possibility=='3'}">大</c:if>
                                            <c:if test="${saleChance.possibility=='2'}">中</c:if>
                                                <c:if test="${saleChance.possibility=='1'}">小</c:if>
                                            </span>
                                            <c:if test="${saleChance.chanceStage!='unassigned'}">
                                                <button style="position:absolute;left:50%;" onclick="javascript:window.location.href='/client/saleChanceInfo/${saleChance.chanceNumber}'">查看详细信息</button>
                                            </c:if>

                                            <%--<button>分配</button>--%>
                                            <span style="position:absolute;left: 70%">${saleChance.productName}&nbsp;&nbsp;${saleChance.productCount}</span>
                                            <span style="position:absolute;right: 13.5%">${saleChance.chanceTime}</span>
                                        </div>
                                        <br>
                                        <div style="border:1px solid #000;margin-left: 5%;width: 90%;height: 100px">
                                                ${saleChance.description}
                                                <span style="float: right;position: relative;top: 70px;right: 10px">${saleChance.account_name}</span>
                                        </div>
                                        <br>
                                    </c:forEach>

                                </div>
                            </div>
                            <br>


                        </div>


























                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->

        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>

            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; 选择皮肤</span>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                    <label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                    <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                    <label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                    <label class="lbl" for="ace-settings-rtl">切换到左边</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                    <label class="lbl" for="ace-settings-add-container">
                        切换窄屏
                        <b></b>
                    </label>
                </div>
            </div>
        </div><!-- /#ace-settings-container -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script src="./assets/js/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='./assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='./assets/js/jquery-1.10.2.min.js'>"+"<"+"script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='./assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>
<script src="./assets/js/bootstrap.min.js"></script>
<script src="./assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="./assets/js/excanvas.min.js"></script>
<![endif]-->

<script src="./assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="./assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="./assets/js/jquery.slimscroll.min.js"></script>
<script src="./assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="./assets/js/jquery.sparkline.min.js"></script>
<script src="./assets/js/flot/jquery.flot.min.js"></script>
<script src="./assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="./assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->

<script src="./assets/js/ace-elements.min.js"></script>
<script src="./assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function($) {
        $('.easy-pie-chart.percentage').each(function(){
            var $box = $(this).closest('.infobox');
            var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
            var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
            var size = parseInt($(this).data('size')) || 50;
            $(this).easyPieChart({
                barColor: barColor,
                trackColor: trackColor,
                scaleColor: false,
                lineCap: 'butt',
                lineWidth: parseInt(size/10),
                animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                size: size
            });
        })

        $('.sparkline').each(function(){
            var $box = $(this).closest('.infobox');
            var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
            $(this).sparkline('html', {tagValuesAttribute:'data-values', type: 'bar', barColor: barColor , chartRangeMin:$(this).data('min') || 0} );
        });




        var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
        var data = [
            { label: "social networks",  data: 38.7, color: "#68BC31"},
            { label: "search engines",  data: 24.5, color: "#2091CF"},
            { label: "ad campaigns",  data: 8.2, color: "#AF4E96"},
            { label: "direct traffic",  data: 18.6, color: "#DA5430"},
            { label: "other",  data: 10, color: "#FEE074"}
        ]
        function drawPieChart(placeholder, data, position) {
            $.plot(placeholder, data, {
                series: {
                    pie: {
                        show: true,
                        tilt:0.8,
                        highlight: {
                            opacity: 0.25
                        },
                        stroke: {
                            color: '#fff',
                            width: 2
                        },
                        startAngle: 2
                    }
                },
                legend: {
                    show: true,
                    position: position || "ne",
                    labelBoxBorderColor: null,
                    margin:[-30,15]
                }
                ,
                grid: {
                    hoverable: true,
                    clickable: true
                }
            })
        }
        drawPieChart(placeholder, data);

        /**
         we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
         so that's not needed actually.
         */
        placeholder.data('chart', data);
        placeholder.data('draw', drawPieChart);



        var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
        var previousPoint = null;

        placeholder.on('plothover', function (event, pos, item) {
            if(item) {
                if (previousPoint != item.seriesIndex) {
                    previousPoint = item.seriesIndex;
                    var tip = item.series['label'] + " : " + item.series['percent']+'%';
                    $tooltip.show().children(0).text(tip);
                }
                $tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
            } else {
                $tooltip.hide();
                previousPoint = null;
            }

        });






        var d1 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d1.push([i, Math.sin(i)]);
        }

        var d2 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.5) {
            d2.push([i, Math.cos(i)]);
        }

        var d3 = [];
        for (var i = 0; i < Math.PI * 2; i += 0.2) {
            d3.push([i, Math.tan(i)]);
        }


        var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'220px'});
        $.plot("#sales-charts", [
            { label: "Domains", data: d1 },
            { label: "Hosting", data: d2 },
            { label: "Services", data: d3 }
        ], {
            hoverable: true,
            shadowSize: 0,
            series: {
                lines: { show: true },
                points: { show: true }
            },
            xaxis: {
                tickLength: 0
            },
            yaxis: {
                ticks: 10,
                min: -2,
                max: 2,
                tickDecimals: 3
            },
            grid: {
                backgroundColor: { colors: [ "#fff", "#fff" ] },
                borderWidth: 1,
                borderColor:'#555'
            }
        });


        $('#recent-box [data-rel="tooltip"]').tooltip({placement: tooltip_placement});
        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('.tab-content')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
            return 'left';
        }


        $('.dialogs,.comments').slimScroll({
            height: '300px'
        });


        //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
        //so disable dragging when clicking on label
        var agent = navigator.userAgent.toLowerCase();
        if("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
            $('#tasks').on('touchstart', function(e){
                var li = $(e.target).closest('#tasks li');
                if(li.length == 0)return;
                var label = li.find('label.inline').get(0);
                if(label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation() ;
            });

        $('#tasks').sortable({
                    opacity:0.8,
                    revert:true,
                    forceHelperSize:true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize:true,
                    tolerance:'pointer',
                    stop: function( event, ui ) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                }
        );
        $('#tasks').disableSelection();
        $('#tasks input:checkbox').removeAttr('checked').on('click', function(){
            if(this.checked) $(this).closest('li').addClass('selected');
            else $(this).closest('li').removeClass('selected');
        });


    })
</script>
<script type="text/javascript">
    function bao() {
        var a = document.getElementById('chanceStage');
        var group = a.options[a.options.selectedIndex].value;
        var b = document.getElementById('possibility');
        var state = b.options[b.options.selectedIndex].value;
        var url = "/client/saleChanceList/" + group + "/" + state;
        window.location.href = url;
    }

</script>
</body>
</html>
