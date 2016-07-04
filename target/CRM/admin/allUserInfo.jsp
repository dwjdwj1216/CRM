<%--
  Created by IntelliJ IDEA.
  User: 顾梦超
  Date: 2016/4/26
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
    <meta charset="utf-8"/>
    <title>dwj租车</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <!-- basic styles -->
    <link href="./assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../assets/css/font-awesome.min.css"/>

    <!--[if IE 7]>
    <link rel="stylesheet" href="../assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300"/>

    <!-- ace styles -->
    <link rel="stylesheet" type="text/css" href="./ico/iconfont.css">
    <link rel="stylesheet" type="text/css" href="./css/mycss.css">
    <link rel="stylesheet" href="./assets/css/ace.min.css"/>
    <link rel="stylesheet" href="./assets/css/ace-rtl.min.css"/>
    <link rel="stylesheet" href="./assets/css/ace-skins.min.css"/>

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="./assets/css/ace-ie.min.css"/>
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


<style type="text/css">
    ol, ul, menu {
        list-style:none
    }

    .theme-price dfn {
        font-style: normal;
        font-size: 18px;
        margin-right: 2px;
    }

    .theme-popover-mask {
        z-index: 9998;
        position:fixed;
        top:0;
        left:0;
        width:100%;
        height:100%;
        background:#000;
        opacity:0.4;
        filter:alpha(opacity=40);
        display:none
    }
    .theme-popover {
        z-index:9999;
        position:fixed;
        top:50%;
        left:50%;
        width:660px;
        height:360px;
        margin:-180px 0 0 -330px;
        border-radius:5px;
        border:solid 2px #666;
        background-color:#fff;
        display:none;
        box-shadow: 0 0 10px #666;
    }
    .theme-poptit {
        border-bottom:1px solid #ddd;
        padding:12px;
        position: relative;
    }
    .theme-popbod {
        padding:60px 15px;
        color:#444;
        height: 148px;
    }

    .theme-popbom a {
        margin-left:8px
    }
    .theme-poptit .close {
        float:right;
        color:#999;
        padding:5px;
        margin:-2px -5px -5px;
        font:bold 14px/14px simsun;
        text-shadow:0 1px 0 #ddd
    }
    .theme-poptit .close:hover {
        color:#444;
    }
    .theme-signin {
        margin: -50px -20px -50px 90px;
        text-align:left;
        font-size: 14px;
    }
    .theme-signin h4 {
        color:#999;
        font-weight:100;
        margin-bottom: 20px;
        font-size: 12px;
    }
    .theme-signin li {
        padding-left: 80px;
        margin-bottom: 15px;
    }
    .theme-signin li strong {
        float: left;
        margin-left: -80px;
        width: 80px;
        text-align: right;
        line-height: 32px;
    }
    .theme-signin .btn {
        margin-bottom: 10px;
    }
    .theme-signin p {
        font-size: 12px;
        color: #999;
    }
    .theme-desc, .theme-version {
        padding-top: 0
    }
</style>
<script src="../assets/js/jquery.min.js"></script>
<script>
    jQuery(document).ready(function($) {
        $('.theme-login').click(function(){
            $('.theme-popover-mask').fadeIn(100);
            $('.theme-popover').slideDown(200);
        })
        $('.theme-poptit .close').click(function(){
            $('.theme-popover-mask').fadeOut(100);
            $('.theme-popover').slideUp(200);
        })

    })
</script>

<script>
    jQuery(document).ready(function($) {
        $('.theme-login1').click(function(){
            $('.theme-popover-mask1').fadeIn(100);
            $('.theme-popover1').slideDown(200);
        })
        $('.theme-poptit1 .close').click(function(){
            $('.theme-popover-mask1').fadeOut(100);
            $('.theme-popover1').slideUp(200);
        })

    })
</script>

<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
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
                        <img class="nav-user-photo" src="../assets/avatars/user.jpg" alt="Jason's Photo"/>
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
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'fixed')
                } catch (e) {
                }
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
                        <span class="menu-text"> 系统数据管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/admin/getCustomerList/all/all/1">
                                <i class="icon-double-angle-right"></i>
                                客户管理
                            </a>

                        </li>

                        <li>
                            <a href="/admin/record/contactRecord">
                                <i class="icon-double-angle-right"></i>
                                记录管理
                            </a>

                        </li>
                        <li>
                            <a href="/admin/saleChanceList/all/all">
                                <i class="icon-double-angle-right"></i>
                                销售机会管理
                            </a>

                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text"> 用户管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/admin/userinformation/all/1">
                                <i class="icon-double-angle-right"></i>
                                用户管理
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
                            <a href="/admin/service/all/all/all">
                                <i class="icon-double-angle-right"></i>
                                服务管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 产品管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="/admin/getProductList">
                                <i class="icon-double-angle-right"></i>
                                产品管理
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
                   data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try {
                    ace.settings.check('sidebar', 'collapsed')
                } catch (e) {
                }
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        首页->员工管理->查看详细信息
                    </li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">


                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!--
                        <div class="alert alert-block alert-success">
                            <button type="button" class="close" data-dismiss="alert">
                                <i class="icon-remove"></i>
                            </button>

                            <i class="icon-ok green"></i>

                            欢迎使用
                            <strong class="green">
                                杨晴贺组CRM
                            <small>(v1.2)</small>
                            </strong>
                                ,这里为你提供更更全面的CRM.
                          </div>
                        -->
                        <div class="main_body">
                            <form action="/admin/fuzzyquery" method="post">
                                <input type="text" name="find" size="35%"> </input>
                                <input type="submit" value="搜索"/>

                            </form>
                            <br>
                            <button onclick="javascript:window.location.href='/admin/userinformation/all/1'">全部用户
                            </button>
                            <button onclick="javascript:window.location.href='/admin/userinformation/ROLE_CLIENT/1'">
                                客户经理
                            </button>
                            <button onclick="javascript:window.location.href='/admin/userinformation/ROLE_SALE/1'">
                                销售主管
                            </button>

                            <table class="myTable" border="1">
                                <tr>
                                    <td>编号</td>
                                    <td>工号</td>
                                    <td>姓名</td>
                                    <td>身份</td>
                                    <td>状态</td>
                                    <td>操作</td>
                                </tr>
                                <c:forEach items="${users}" var="user" varStatus="status">
                                    <tr>
                                        <td>${user.index}</td>
                                        <td><c:out value="${user.account}"/></td>
                                        <td><c:out value="${user.name}"/></td>
                                        <td><c:if test="${user.role=='ROLE_CLIENT'}">客户经理</c:if>
                                            <c:if test="${user.role=='ROLE_SALE'}">销售经理</c:if></td>
                                        <td><c:if test="${user.status==1}">已启用</c:if>
                                            <c:if test="${user.status==0}">已停用</c:if></td>
                                        <td>
                                            <a href="/admin/editpersoninfo/${user.account}">
                                                <i class="Hui-iconfont Hui-iconfont-edit2"></i>
                                            </a>
                                            <a href="/admin/changestatus/${user.account}/${user.status}" class="theme-login">
                                                <i class="Hui-iconfont Hui-iconfont-shenhe-tingyong"></i>
                                            </a>
                                            <a href="/admin/handover/${user.account_suffix}" class="theme-login">
                                                <i class="Hui-iconfont Hui-iconfont-manage2"></i>
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>


                        </div>
                        <table>
                            <tbody>
                            <tr>
                                <td>
                                    <button onclick="javascript:window.location.href='/admin/userinformation/${group}/1'">首页</button>
                                </td>
                                <c:if test="${page-1>=1}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page-1}'">上一页</button>
                                    </td>
                                </c:if>

                                <c:if test="${page-2>=1}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page-2}'">${page-2}</button>
                                    </td>
                                </c:if>
                                <c:if test="${page-1>=1}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page-1}'">${page-1}</button>
                                    </td>
                                </c:if>
                                <td>
                                    <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page}'" autofocus>${page}</button>
                                </td>


                                <c:if test="${page+1<=count}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page+1}'">${page+1}</button>
                                    </td>
                                </c:if>
                                <c:if test="${page+2<=count}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page+2}'">${page+2}</button>
                                    </td>
                                </c:if>
                                <c:if test="${page+1<=count}">
                                    <td>
                                        <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${page+1}'">下一页</button>
                                    </td>
                                </c:if>

                                <td>
                                    <button onclick="javascript:window.location.href='/admin/userinformation/${group}/${count}'">尾页</button>
                                </td>
                            </tr>
                            </tbody>
                            </table>
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
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
                    <label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
                    <label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
                    <label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
                    <label class="lbl" for="ace-settings-rtl">切换到左边</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
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
    window.jQuery || document.write("<script src='../assets/js/jquery-2.0.3.min.js'>" + "<" + "script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='./assets/js/jquery-1.10.2.min.js'>" + "<" + "script>");
</script>
<![endif]-->

<script type="text/javascript">
    if ("ontouchend" in document) document.write("<script src='../assets/js/jquery.mobile.custom.min.js'>" + "<" + "script>");
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
    jQuery(function ($) {
        $('.easy-pie-chart.percentage').each(function () {
            var $box = $(this).closest('.infobox');
            var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
            var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
            var size = parseInt($(this).data('size')) || 50;
            $(this).easyPieChart({
                barColor: barColor,
                trackColor: trackColor,
                scaleColor: false,
                lineCap: 'butt',
                lineWidth: parseInt(size / 10),
                animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
                size: size
            });
        })

        $('.sparkline').each(function () {
            var $box = $(this).closest('.infobox');
            var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
            $(this).sparkline('html', {
                tagValuesAttribute: 'data-values',
                type: 'bar',
                barColor: barColor,
                chartRangeMin: $(this).data('min') || 0
            });
        });


        var placeholder = $('#piechart-placeholder').css({'width': '90%', 'min-height': '150px'});
        var data = [
            {label: "social networks", data: 38.7, color: "#68BC31"},
            {label: "search engines", data: 24.5, color: "#2091CF"},
            {label: "ad campaigns", data: 8.2, color: "#AF4E96"},
            {label: "direct traffic", data: 18.6, color: "#DA5430"},
            {label: "other", data: 10, color: "#FEE074"}
        ]

        function drawPieChart(placeholder, data, position) {
            $.plot(placeholder, data, {
                series: {
                    pie: {
                        show: true,
                        tilt: 0.8,
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
                    margin: [-30, 15]
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
            if (item) {
                if (previousPoint != item.seriesIndex) {
                    previousPoint = item.seriesIndex;
                    var tip = item.series['label'] + " : " + item.series['percent'] + '%';
                    $tooltip.show().children(0).text(tip);
                }
                $tooltip.css({top: pos.pageY + 10, left: pos.pageX + 10});
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


        var sales_charts = $('#sales-charts').css({'width': '100%', 'height': '220px'});
        $.plot("#sales-charts", [
            {label: "Domains", data: d1},
            {label: "Hosting", data: d2},
            {label: "Services", data: d3}
        ], {
            hoverable: true,
            shadowSize: 0,
            series: {
                lines: {show: true},
                points: {show: true}
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
                backgroundColor: {colors: ["#fff", "#fff"]},
                borderWidth: 1,
                borderColor: '#555'
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

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }


        $('.dialogs,.comments').slimScroll({
            height: '300px'
        });


        //Android's default browser somehow is confused when tapping on label which will lead to dragging the task
        //so disable dragging when clicking on label
        var agent = navigator.userAgent.toLowerCase();
        if ("ontouchstart" in document && /applewebkit/.test(agent) && /android/.test(agent))
            $('#tasks').on('touchstart', function (e) {
                var li = $(e.target).closest('#tasks li');
                if (li.length == 0)return;
                var label = li.find('label.inline').get(0);
                if (label == e.target || $.contains(label, e.target)) e.stopImmediatePropagation();
            });

        $('#tasks').sortable({
                    opacity: 0.8,
                    revert: true,
                    forceHelperSize: true,
                    placeholder: 'draggable-placeholder',
                    forcePlaceholderSize: true,
                    tolerance: 'pointer',
                    stop: function (event, ui) {//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
                        $(ui.item).css('z-index', 'auto');
                    }
                }
        );
        $('#tasks').disableSelection();
        $('#tasks input:checkbox').removeAttr('checked').on('click', function () {
            if (this.checked) $(this).closest('li').addClass('selected');
            else $(this).closest('li').removeClass('selected');
        });


    })
</script>

${result}
</body>
</html>

