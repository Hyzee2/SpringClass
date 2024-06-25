<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<link rel="shortcut icon" href="http://www.chungdamah.co.kr/theme/hp001/img/cd.ico"/>
<meta property="og:image" content="http://www.chungdamah.co.kr/theme/hp001/img/ch_main.jpg"/>
<meta property="og:site_name" content="청담우리동물병원"/>
<meta property="og:description" content="센터별 특화진료 시스템, 60여명의 분야별 전문의료진, 24시간 최선의 진료를 위한 노력, 슬개골/관절 센터, 심장센터, 내시경센터, 정형외과센터, 치과센터" />

<meta charset="utf-8">
<meta http-equiv="imagetoolbar" content="no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>청담우리동물병원</title>
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/default.css?ver=191202">
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/skin/latest/main/style.css?ver=191202">
<link rel="stylesheet" href="http://www.chungdamah.co.kr/skin/shop/basic/style.css?ver=191202">
<!--[if lte IE 8]>
<script src="http://www.chungdamah.co.kr/js/html5.js"></script>
<![endif]-->

<!-- 스타일시트 -->
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/reset.css" />
<!--폰트-->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/simple-line-icons.css" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/pe-icon-7-stroke.css" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/fontawesome_min.css" />
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=PT+Serif" rel="stylesheet">
<!--폰트-->

<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/layout.css?20240401" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/style.css?20240401" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/responsive.css" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/swiper.min.css" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/board.css" />
<link rel="stylesheet" href="http://www.chungdamah.co.kr/theme/hp001/css/headroom.css" />
<link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
<!-- 병원 스타일시트 -->

<script>
// 자바스크립트에서 사용하는 전역변수 선언
var g5_url       = "http://www.chungdamah.co.kr";
var g5_bbs_url   = "http://www.chungdamah.co.kr/bbs";
var g5_is_member = "";
var g5_is_admin  = "";
var g5_is_mobile = "";
var g5_bo_table  = "";
var g5_sca       = "";
var g5_editor    = "";
var g5_cookie_domain = "";
</script>

<script src="http://www.chungdamah.co.kr/theme/hp001/js/jquery-1.11.1.min.js?ver=170901"></script>
<script src="http://www.chungdamah.co.kr/js/jquery.menu.js?ver=191202"></script>
<script src="http://www.chungdamah.co.kr/js/common.js?ver=191202"></script>
<script src="http://www.chungdamah.co.kr/js/wrest.js?ver=191202"></script>
<script src="http://www.chungdamah.co.kr/js/placeholders.min.js"></script>
<link rel="stylesheet" href="http://www.chungdamah.co.kr/js/font-awesome/css/font-awesome.min.css">

<!-- 병원 스크립트 -->
<script src="http://www.chungdamah.co.kr/theme/hp001/js/easing.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/common.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/common.extend.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/swiper.min.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/TweenMax.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/headroom.js"></script>
<script src="http://www.chungdamah.co.kr/theme/hp001/js/jqueryheadroommin.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<!-- 병원 스크립트 -->

<script src="http://www.chungdamah.co.kr/js/jquery.bxslider.js?ver=191202"></script>
</head>
<body>
<body class="main">
	
	
<!-- 팝업레이어 시작 { -->
<div id="hd_pop">
    <h2>팝업레이어 알림</h2>

<span class="sound_only">팝업레이어 알림이 없습니다.</span></div>

<script>
$(function() {
    $(".hd_pops_reject").click(function() {
        var id = $(this).attr('class').split(' ');
        var ck_name = id[1];
        var exp_time = parseInt(id[2]);
        $("#"+id[1]).css("display", "none");
        set_cookie(ck_name, 1, exp_time, g5_cookie_domain);
    });
    $('.hd_pops_close').click(function() {
        var idb = $(this).attr('class').split(' ');
        $('#'+idb[1]).css('display','none');
    });
    $("#hd").css("z-index", 1000);
});
</script>
<!-- } 팝업레이어 끝 -->	<!-- 전체 감싸기 -->
	<div id="wrapper">
		
		<!-- 헤더 -->
						
		<div id="header">
        	<!-- 메뉴호출시 마스크 시작 -->
            <div class="mask"></div>
            <!-- 메뉴호출시 마스크 끝 -->
			<!-- 헤더 상단 -->
			<div class="top">
				<div class="mobile-tel"><span>예약전화</span><p><a href="tel:02-541-7515">02-541-7515</a></p></div>
                <!-- 로고 -->
                <h1 id="logo"><a href="/"><img src="http://www.chungdamah.co.kr/theme/hp001/img/logo.png" class="pc" alt="Logo" /><img src="http://www.chungdamah.co.kr/theme/hp001/img/logom.png" class="mobile" alt="Logo" /></a></h1>
                <!-- // 로고 -->

                <!-- 우측 링크 -->
                <div class="right-link clearfix">
                    
                    <ul>
                                                <!--<li><a href="http://www.chungdamah.co.kr/bbs/register.php">회원가입</a></li>
                        <li>|</li>-->
                        <li><a href="http://www.chungdamah.co.kr/bbs/login.php">로그인</a></li>
                                            </ul>

                    <!-- 전체메뉴 버튼 -->
                    <button class="btn-allmenu">
                        <span class="line1"></span>
                        <span class="line2"></span>
                        <span class="line3"></span>
                    </button>
                    <!-- // 전체메뉴 버튼 -->
                </div>
                <!-- // 우측 링크 -->
				
			</div>
			<!-- // 헤더 상단 -->
			
            
            
            <!-- 모바일메뉴 버튼 -->
            <button id="gnbTrigger">
                <span class="bar1"></span>
                <span class="bar2"></span>
                <span class="bar3"></span>
            </button>
            <!-- // 모바일메뉴 버튼 -->
        	
            <style>
			.btm::-webkit-scrollbar{display:none;}
			</style>
			<!-- 헤더 하단 -->
			<div class="btm" style="-ms-overflow-style:none;">
            	<!-- 모바일로그인 -->
                <div class="m_loginArea">
                    
                    <ul>
						                        <!--<li><a href="http://www.chungdamah.co.kr/bbs/register.php">회원가입</a></li>
                        <li>|</li>-->
                        <li><a href="http://www.chungdamah.co.kr/bbs/login.php">로그인</a></li>
                                            </ul>
                </div>
                <!-- // 모바일로그인 -->
				<!-- 상단메뉴 -->
				<ul id="nav">
                	<!-- 관리자연동시 주석해제 -->
					   <!--네비게이션 메뉴-->                 
                    <!-- 수동관리시 주석 -->
                    <li class="" style="z-index:999">
                        <a href="/page/woori01_01.php?top=1&sub=1" target="_self" >청담우리는</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>청담우리는</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
                                    <li><a href="/page/woori01_01.php?top=1&sub=1">대표원장 인사말</a></li>
                                    <li><a href="/page/woori01_02.php?top=1&sub=2" target="_self">원스탑 토탈 클리닉</a></li>
                                    <li><a href="/bbs/board.php?bo_table=celebrity&top=1&sub=3" target="_self">청담우리와 함께한 Star</a></li>
                                    <li><a href="/page/medical.php?top=1&sub=4">의료진 소개</a></li>
                                    <li><a href="/page/tour.php?top=1&sub=5">병원 미리보기</a></li>
                                   
                                </ul>
                            </div>
                        </div>
                    </li>
                      <li class="" style="z-index:998">
                        <a href="/page/woori02_01.php?top=2&sub=1" target="_self" >병원 이용안내</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>병원 이용안내</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
									<li><a href="/page/woori02_01.php?top=2&sub=1" target="_self" >예약 및 진료시간 안내</a></li>
									<li><a href="/page/woori02_02.php?top=2&sub=2" target="_self" >24시 응급진료 안내</a></li>
									<li><a href="/page/woori02_03.php?top=2&sub=3" target="_self">찾아오시는 길</a></li>
									<li><a href="/page/woori02_04.php?top=2&sub=4" target="_self" >주차 안내</a></li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li class="" style="z-index:997">
                        <a href="/page/woori03_05.php?top=3&sub=1" target="_self" >센터별 특화진료</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>센터별 특화진료</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
									<li><a href="/page/woori03_05.php?top=3&sub=1" target="_self">슬개골/관절 센터</a></li>
									<!----   <li><a href="/page/woori03_02.php?top=3&sub=2" target="_self">동물재활 센터</a></li>--->
									<li><a href="/page/woori03_06.php?top=3&sub=2" target="_self">영상/재활 센터</a></li>
									 <li><a href="/page/woori03_01.php?top=3&sub=3" target="_self">심장 센터</a></li>
									<li><a href="/page/woori03_02.php?top=3&sub=4" target="_self">내시경 센터</a></li>
									<li><a href="/page/woori03_03.php?top=3&sub=5" target="_self">정형외과 센터</a></li>
									<li><a href="/page/woori03_04.php?top=3&sub=6" target="_self">치과 센터</a></li>                                    
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li class="" style="z-index:996">
                        <a href="/page/woori04_01.php?top=4&sub=1" target="_self" >전문진료 소개</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>전문진료 소개</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
									<li><a href="/page/woori04_01.php?top=4&sub=1" target="_self">내과 클리닉</a></li>
									<li><a href="/page/woori04_02.php?top=4&sub=2" target="_self">안과 클리닉</a></li>
									<li><a href="/page/woori04_03.php?top=4&sub=3" target="_self">피부과 클리닉</a></li>
									<!---<li><a href="/page/woori04_04.php?top=4&sub=4" target="_self">건강검진 클리닉</a></li>-->
									<li><a href="/page/woori04_04.php?top=4&sub=4" target="_self">임상병리과</a></li>
									<li><a href="/page/woori04_05.php?top=4&sub=5" target="_self">영상진단과</a></li>
									<li><a href="/page/woori04_06.php?top=4&sub=6" target="_self">특수동물</a></li>                                         
                                </ul>
                            </div>
                        </div>
                    </li>
                   
                    
                    <li class="" style="z-index:994">
                        <a href="/page/tour.php?top=5&sub=1&department=D" target="_self">with 청담우리</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>with 청담우리</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
									<li><a href="/page/tour.php?top=5&sub=1&department=D" target="_self">호텔/놀이방</a></li>
									<!--<li><a href="/page/woori05_02.php?top=5&sub=2" target="_self">놀이방</a></li>-->
									<li><a href="/page/woori05_03.php?top=5&sub=2" target="_self">미용실</a></li>
									<li><a href="http://www.chungdamahm.co.kr/" target="_blank">청담우리몰 바로가기</a></li> 
                                </ul>
                            </div>
                        </div>
                    </li>
                 
                
                    <li class="" style="z-index:992">
                        <a href="/bbs/board.php?bo_table=notice01&top=6&sub=1" target="_self" >커뮤니티</a>
                        <div class="menu-item">
                            <div class="inner">
                                <!-- 대메뉴 이름 -->
                                <div class="titleArea"><span>커뮤니티</span></div>
                                <!-- // 대메뉴 이름 -->
                                <ul>
									<li><a href="/bbs/board.php?bo_table=notice01&top=6&sub=1" target="_self">공지사항</a></li>
									<li><a href="/bbs/board.php?bo_table=movie" target="_self">청담우리 미디어</a></li>
									<li><a href="/bbs/board.php?bo_table=petlib_1" target="_self">펫도서관</a></li>
									<li><a href="/bbs/board.php?bo_table=tl_review" target="_self">진료후기&지식백과</a></li>
									<!---<li><a href="/bbs/board.php?bo_table=counsel&top=6&sub=5" target="_self">진료상담</a></li>--->
                                </ul>
                            </div>
                        </div>
                    </li>
				</ul>
				<!-- // 상단메뉴 -->

				
			</div>
			<!-- // 헤더 하단 -->

			<!-- 전체 메뉴 -->
			<div id="all-menu">
				<!-- 메뉴 마스크 : 삭제 금지 -->
				<div class="mask_all"></div>
				<!-- // 메뉴 마스크 -->

				<!-- 메뉴 레이어 -->
				<div class="menu-layer">
                	<button type="button" class="btnClose">
                        <span class="line1"></span>
                        <span class="line2"></span>
                    </button>
					<!-- 타이틀 -->
					<div class="title-bar">
						<h2><img src="http://www.chungdamah.co.kr/theme/hp001/img/all_menu_logo.png" /></h2>
					</div>
					<!-- // 타이틀 -->

					<div class="menu-wrapper">
						<div class="inner">
							<ul class="depth1">
                            	<!-- 관리자연동시 주석해제 -->
								                                <!-- 수동관리시 주석 -->
                                <li class="" style="z-index:999">
									<div class="box">
										<h3 class="title">청담우리는</h3>
                                        <ul class=depth2>
                                            <li><a href="/page/woori01_01.php?top=1&sub=1" target="_self">대표원장 인사말</a></li>
                                            <li><a href="/page/woori01_02.php?top=1&sub=2" target="_self">원스탑 토탈 클리닉</a></li>
                                            <li><a href="/bbs/board.php?bo_table=celebrity&top=1&sub=3" target="_self">청담우리와 함께한 Star</a></li>
                                            <li><a href="/page/medical.php?top=1&sub=4" target="_self">의료진 소개</a></li>
                                            <li><a href="/page/tour.php?top=1&sub=5" target="_self">병원 미리보기</a></li>
                                        </ul>
                                    </div>
								</li>
                                <li class="" style="z-index:998">
                                	<div class="box">
										<h3 class="title">병원 이용안내</h3>
                                        <ul class=depth2>
                                            <li><a href="/page/woori02_01.php?top=2&sub=1" target="_self">예약 및 진료시간 안내</a></li>
                                            <li><a href="/page/woori02_02.php?top=2&sub=2" target="_self">24시 응급진료 안내</a></li>
                                            <li><a href="/page/woori02_03.php?top=2&sub=3" target="_self">찾아오시는 길</a></li>
                                            <li><a href="/page/woori02_04.php?top=2&sub=4" target="_self">주차 안내</a></li>
                                            
                                           
										</ul>
                                    </div>
								</li>
                                <li class="" style="z-index:997">
                                	<div class="box">
										<h3 class="title">센터별 특화진료</h3>
                                        <ul class=depth2>
											<li><a href="/page/woori03_05.php?top=3&sub=1" target="_self">슬개골/관절 센터</a></li>
											<li><a href="/page/woori03_06.php?top=3&sub=2" target="_self">영상/재활 센터</a></li>
											<li><a href="/page/woori03_01.php?top=3&sub=3" target="_self">심장 센터</a></li>
											<li><a href="/page/woori03_02.php?top=3&sub=4" target="_self">내시경 센터</a></li>
											<li><a href="/page/woori03_03.php?top=3&sub=5" target="_self">정형외과 센터</a></li>
											<li><a href="/page/woori03_04.php?top=3&sub=6" target="_self">치과 센터</a></li>
										</ul>
                                    </div>
								</li>
                                <li class="" style="z-index:996">
                                	<div class="box">
										<h3 class="title">전문진료 소개</h3>
                                        <ul class=depth2>
<li><a href="/page/woori04_01.php?top=4&sub=1" target="_self">내과 클리닉</a></li>
<li><a href="/page/woori04_02.php?top=4&sub=2" target="_self">안과 클리닉</a></li>
<li><a href="/page/woori04_03.php?top=4&sub=3" target="_self">피부과 클리닉</a></li>
<!---<li><a href="/page/woori04_04.php?top=4&sub=4" target="_self">건강검진 클리닉</a></li>--->
<li><a href="/page/woori04_04.php?top=4&sub=4" target="_self">임상병리과</a></li>
<li><a href="/page/woori04_05.php?top=4&sub=5" target="_self">영상진단과</a></li>
<li><a href="/page/woori04_06.php?top=4&sub=6" target="_self">특수동물 클리닉</a></li>
                                         
                                             
                                             
                                             
										</ul>
                                    </div>
								</li>
                                <li class="" style="z-index:995">
                                    <div class="box">
                                        <h3 class="title">with 청담우리</h3>
                                        <ul class=depth2>
											<li><a href="/page/tour.php?top=5&sub=1&department=D" target="_self">호텔/놀이방</a></li>
                                            <!--<li><a href="/page/sub5_1_1.php?top=5&sub=1" target="_self">호텔</a></li>
                                            <li><a href="/page/sub5_2_1.php?top=5&sub=2" target="_self">놀이방</a></li>-->
                                            
                                            <li><a href="/page/woori05_03.php?top=5&sub=2" target="_self">미용실</a></li>
                                            
                                            <li><a href="http://www.chungdamahm.co.kr/" target="_blank">청담우리몰 바로가기</a></li>
                                        </ul>
                                    </div>
                                </li>
                              
                               

                                <li class="" style="z-index:992">
                                    <div class="box">
                                        <h3 class="title">커뮤니티</h3>
                                        <ul class=depth2>
                                            <li><a href="/bbs/board.php?bo_table=notice01&top=6&sub=1" target="_self">공지사항</a></li>
                                            <li><a href="/bbs/board.php?bo_table=movie&top=6&sub=2" target="_self">청담우리 미디어</a></li>
                                            <li><a href="/bbs/board.php?bo_table=petlib_1" target="_self">펫 도서관</a></li>
                                            <li><a href="/bbs/board.php?bo_table=tl_review" target="_self">진료후기&지식백과</a></li>
                                            
                                              <!---<li><a href="/bbs/board.php?bo_table=counsel&top=6&sub=5" target="_self">진료상담</a></li>--->
                                              
                                              

                                        </ul>
                                    </div>
                                </li>
							</ul>
						</div>
					</div>
				</div>
				<!-- // 메뉴 레이어 -->
			</div>
			<!-- // 전체 메뉴 -->
		</div>		<!-- // 헤더 -->
				
		<a href="#" class="go-to-top">TOP</a>

<script>
$(document).ready(function(){	
    var oldPosition;	
    var easingStyle;
    var floatTarget = $("a.go-to-top");
    var floatSpeed = 1000;
    
    $(window).load(function(){
        oldPosition = floatTarget.position().top;
        floating();
    });
    
    $(window).scroll(function(){
        floating();
    });
    
    function floating(){
        var newPosition = oldPosition+$(document).scrollTop();
        floatTarget.stop().animate({top:newPosition},floatSpeed);
    }
    
    floatTarget.click(function(){
        $("html, body").animate({scrollTop:0},1000);
        return false;
    });
    
});
</script>		        <!--// 헤더 -->
        
		        
        
        
        

		
     
    
    
		<!-- 메인비주얼 -->
        <div id="mainVisual" class="clearfix">
            <style>
            .swiper-container {width:100%;height:100%;}
            .swiper-slide {background-position: center;background-size: cover;}
            .swiper-container-horizontal>.swiper-pagination-bullets, .swiper-pagination-custom, .swiper-pagination-fraction {position:absolute; bottom:150px; left:50%; width:1200px; margin-left:-600px; text-align:left;font-size:0; z-index:30}
            
            .swiper-pagination-white .swiper-pagination-bullet-active {background:#3085e1;width:37px;border-radius:50px;}
            .swiper-pagination-bullet {width:17px;height:17px;background:#fff;border-radius:30px;transition:all .3s ease;opacity:1;}
            .swiper-slide img {position:relative;left:50%;margin-left:-600px;top:200px;}
            .swiper-button-next {right:20px;}
            .swiper-button-prev {left:20px;}
            .swiper-slide a.tvlink {display:block; width:200px; height:45px; line-height:25px; background-color:#ce171f; padding:10px; text-align:center; color:#fff!important; font-size:16px; position:absolute; bottom:40%; left:18%; z-index:70000;}
            .swiper-slide a.tvlink:hover {background-color:#a41319; }
            @media screen and (max-width:1600px) {
                .swiper-slide a.tvlink {left:10%;}
            }
            @media screen and (max-width:1200px) {
                .swiper-container-horizontal>.swiper-pagination-bullets {left:20px;margin-left:auto;}
                .swiper-slide img {position:relative;left:20px;margin-left:0px;top:200px;}
                .swiper-slide a.tvlink {left:0%;}
            }
            @media screen and (max-width:1024px) {
				 #mainVisual {height:300px;}
               /* .swiper-slide {background:none !important;} */
                .swiper-slide img.mobile {left:0px;top:0px;width:100%;}
                .swiper-button-next, .swiper-button-prev,.swiper-pagination-bullet  {display:none;}
                .swiper-slide a.tvlink {left:10%; bottom:30%;}
            }
            @media screen and (max-width:768px) {
                /*.swiper-slide a {left:8%; bottom:30%; font-size:8px;  width:100px; height:20px; line-height:22px; padding:0px;}*/
                .swiper-slide a.tvlink {display:none;}
            }
            </style>
            <div class="swiper-container pc">
                <div class="swiper-wrapper">
                   

                
    <div class="swiper-slide" style="background-image:url(http://www.chungdamah.co.kr/theme/hp001/img/main_visual2.jpg)">
      
      
    
      
             
                
                    	<div class="cd_main_title">
                    		<ul>
                            	<li class="cd_01_1">청담우리의 특별함 -</li>
                            	<li class="cd_02_1">ONE STOP TOTAL CLINIC</li>
                            	<li class="cd_03_1">보호자분들이 청담우리를 방문하셨을때 원하시는 일을 쉽게 처리하고 편하게 쉬고 가실 수 있도록 One stop total clinic을 제공하고 있습니다.</li>
                                <li>
                                	<a href="/page/woori01_02.php?top=1&sub=2"><div class="g_button_1">자세히 보기</div></a>
                                </li>
                            </ul>
                        </div>
                   
                
                
                </div>
                
     
     
     
                   
    <div class="swiper-slide" style="background-image:url(http://www.chungdamah.co.kr/theme/hp001/img/main_visual3.jpg)">
     
                    	<div class="cd_main_title">
                    		<ul>
                            	<li class="cd_01_1">끊임없이 연구하고 노력하는 -</li>
                            	<li class="cd_02_1"><font class="cd_02_b">20인</font>의 수의사와 <font class="cd_02_b">70여명</font>의 의료진</li>
                            	<li class="cd_03_1">임상경험이 풍부한 분과별 박사, 석사를 포함한 20인의 수의사들과 70여명의 병원 스탭들이 반려가족의 눈높이에 맞는 전문 의료서비스를 제공합니다. </li>
                                <li>
                                	<a href="/page/woori01_01.php?top=1&sub=1"><div class="g_button_1">대표원장 인사말</div></a>
                                </li>
                            </ul>
                        </div>
                  </div>           
                    
                    
                               
                
                
          
      <div class="swiper-slide" style="background-image:url(http://www.chungdamah.co.kr/theme/hp001/img/main_visual1.jpg)">
       
                    	<div class="cd_main_title">
                    		<ul>
                            	<li class="cd_01">청담우리동물병원은 -</li>
                            	<li class="cd_02">반려동물 가족의 <font class="cd_02_b">행복</font>을 위해</li>
                            	<li class="cd_03">조그만 소리에도 귀 기울이며, 항상 좋은 친구처럼, 늘 편안한 이웃처럼 여러분 곁에서 반려동물의 건강과 행복을 위해 최고를 지향하며 노력하겠습니다.</li>
                                <li>
                                	<a href="/bbs/board.php?bo_table=petlib_1"><div class="g_button">펫도서관 바로가기</div></a>
                                </li>
                            </ul>
                        </div>
                  </div>           
              
               
               
               
               
               
               
                
                
                
                
                    
                </div>
                <!-- Add Pagination -->
                <div class="swiper-pagination swiper-pagination-white"></div>
                <!-- Add Arrows -->
                <div class="swiper-button-next swiper-button-white"></div>
                <div class="swiper-button-prev swiper-button-white"></div>
            </div>
            <script>
                var swiper = new Swiper('.swiper-container', {
                    autoplay: {
                        delay: 5500,
                        disableOnInteraction: false,
                    },
                    spaceBetween: 0,
                    effect: 'slide',
                    loop: true,
                    pagination: {
                        el: '.swiper-pagination',
                        clickable: true,
                    },
                    navigation: {
                        nextEl: '.swiper-button-next',
                        prevEl: '.swiper-button-prev',
                    },
                });
            </script>
        </div>
        <!-- // 메인비주얼 -->
        
        
        
        
        
         <!-- 빅배너 -->
        <div id="section8">
            <div class="be_left1">
                <div class="text_area">
                    <h1><span>청담우리와 함께한</span><br/>CELEBRITY</h1>
                    <p>본원과 함께한 많은 스타분들,<br/>그리고 스타의 반려동물을 소개합니다.</p>
                    <a class="more" href="/bbs/board.php?bo_table=celebrity&top=1&sub=3">자세히보기</a>
                </div>
            </div>
            <div class="be_right1">
                <div class="text_area">
                    <h1><span>반려동물의 건강을 책임지는</span><br/>의료진 소개</h1>
                    <p>분과별 박사·석사를 포함한<br/>
                      70명의 의료진을 소개합니다.</p>
                    <a class="more" href="/page/medical.php?top=1&sub=4">자세히보기</a>
                </div>
            </div>
           
        </div>
        <!-- 빅배너 -->
        
        
        
 
        
    
        <!-- 컨테이너 -->
      
           
    
            <!-- 유튜브 -->
            <div id="section2" class="section">
                <div class="innerContainer">
                    <div id="main_cancer">
                        <div class="play_mov">
                            <div class="play_left">
                                <iframe id="tviframe" width="100%" height="95%" src="" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                            </div>
                            <div class="play_right">
                                <p class="tit"><img src="http://www.chungdamah.co.kr/theme/hp001/img/youtube_title.jpg"> <span>청담우리동물병원 유튜브</span></p>
                                <!--<h1>성형 수술 후 주의사항 이것만 체크하자! <br/>회복기간에 꼭~지켜야 할 주의사항 10가지<br/>(feat.성형수술 성공하세요 ♡)</h1>-->
                                <h1 class="txt_title" id="tv_title"><span></span></h1>
                                <p class="txt">반려동물에 대한 건강정보를 알려드립니다.</p>
                                <a href="https://www.youtube.com/channel/UCrcOQ17ToaezHar5lp4iH6w" target="_blank">유튜브 채널로 이동 -</a>
                            </div>
                        </div>
                        <div class="process">
                            <ul id="tvList_link">
                                <li class="tvList_li" id="tvList_li202662" seq="202662">
                                    <div>
                                        <ul>
                                            <li class="tvList_li" id="tvList_li202662" seq="202662">
                                                <a href="javascript:changeTv('202662');"><img src="http://www.chungdamah.co.kr/data/youtube/5?20230629140632"></a>
                                                <input type="hidden" id="tvList_link202662" value="https://www.youtube.com/embed/VjWokaream0" >
                                                <input type="hidden" id="tvList_title202662" value="강아지 입냄새 여러가지 원인! 치아 문제가 아닐 수 있어요" >
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="tvList_li" id="tvList_li202663" seq="202663">
                                    <div>
                                        <ul>
                                            <li class="tvList_li" id="tvList_li202663" seq="202663">
                                                <a href="javascript:changeTv('202663');"><img src="http://www.chungdamah.co.kr/data/youtube/4?20230629140524"></a>
                                                <input type="hidden" id="tvList_link202663" value="https://www.youtube.com/embed/R7R7DNo_o64" >
                                                <input type="hidden" id="tvList_title202663" value="슬개골탈구는 한국수의사만 수술하라고 한다?! 과연 진실은?" >
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="tvList_li" id="tvList_li202664" seq="202664">
                                    <div>
                                        <ul>
                                            <li class="tvList_li" id="tvList_li202664" seq="202664">
                                                <a href="javascript:changeTv('202664');"><img src="http://www.chungdamah.co.kr/data/youtube/3?20230629140610"></a>
                                                <input type="hidden" id="tvList_link202664" value="https://www.youtube.com/embed//ILx01OZJ9Yg" >
                                                <input type="hidden" id="tvList_title202664" value="꾸륵꾸륵 복명음 배탈이 잦다면 강아지 혈자리마사지! 소화잘됨주의!" >
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="tvList_li" id="tvList_li202665" seq="202665">
                                    <div>
                                        <ul>
                                            <li class="tvList_li" id="tvList_li202665" seq="202665">
                                                <a href="javascript:changeTv('202665');"><img src="http://www.chungdamah.co.kr/data/youtube/2?20230629140725"></a>
                                                <input type="hidden" id="tvList_link202665" value="https://www.youtube.com/embed/ZHxOr4YaDHQ" >
                                                <input type="hidden" id="tvList_title202665" value="무덥고 뜨거운 여름! 우리 강아지들 열사병 주의해주세요 산책할땐 꼭꼭 기억하기!" >
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                <li class="tvList_li" id="tvList_li202666" seq="202666">
                                    <div>
                                        <ul>
                                            <li class="tvList_li" id="tvList_li202666" seq="202666">
                                                <a href="javascript:changeTv('202666');"><img src="http://www.chungdamah.co.kr/data/youtube/1?20230629143212"></a>
                                                <input type="hidden" id="tvList_link202666" value="https://www.youtube.com/embed/8ByA6k0o0J0" >
                                                <input type="hidden" id="tvList_title202666" value="강아지 슬개골탈구 촉진 진단과정이 궁금하시죠? 다 보여드릴께요! 이거 정말 중요해요!" >
                                            </li>
                                        </ul>
                                    </div>
                                </li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 유튜브 -->
    
            <script>
                $(document).ready(function() {
                    var tmp = $("#tvList_link").find("ul>li").filter(':first-child').attr("seq");
                    changeTv(tmp);
                });
    
                function changeTv(seq){
                    $("#tviframe").attr("src", $("#tvList_link"+seq).val());
                    $("#tv_title").find("span").html($("#tvList_title"+seq).val());
                    $(".tvList_li").removeClass("on");
                    $("#tvList_li"+seq).addClass("on");
                }
            </script>
       
    
    
    <div id="section6" class="section">
                <div class="innerContainer">
                    <h1><span>청담우리의 특화진료를 소개합니다</span><br><strong>센터별 특화진료 바로가기</strong></h1>
                    </div>
                    </div>
    
    
   
    
        <!-- 멤버 -->
        <div id="section4" class="section">
            <div class="innerContainer">
                <div id="main_cancer">
                    <div class="profile">
                        <div class="profile_left"><img id="dociframe" src=""></div>
                        <div class="profile_right">
                            <p class="tit">01</p>
                            <h1 class="doc_title" id="doc_title"><span>청담우리의 특화진료에<br /> 대한 간단한 설명 삽입</span></h1>
                            <div class="name">
                                <h2>인터뷰 <span>소개</span></h2>                              
                            </div>
							<div class="link">
                                <h2>바로가기 &gt;</h2>                              
                            </div>
                        </div>
                    </div>
                    <div class="pro_list" id="docList_link">
                        <ul>                       
                        
							<li class="docList_li" id="docList_li14" seq="14">
								<a href="javascript:changeDoc('14');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_5_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_5_sum_off.jpg" class="sum_off"><span>슬개골/관절</span></a>
								<input type="hidden" id="docList_link14" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_5.jpg">
								<input type="hidden" id="docList_title14" value="청담우리의 특화진료<br /> 슬개골/관절 센터란?">
								<input type="hidden" id="docList_name14" value="윤병국 대표원장">
								<input type="hidden" id="docList_go14" value="<a href='/page/woori03_05.php?top=3&sub=1'>바로가기 &gt;</a>"><!--바로가기5-->
								<input type="hidden" id="docList_num14" value="01">
							</li>


							<li class="docList_li" id="docList_li15" seq="15">
								<a href="javascript:changeDoc('15');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_7_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_7_sum_off.jpg" class="sum_off"><span>영상/재활</span></a>
								<input type="hidden" id="docList_link15" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_7.jpg">
								<input type="hidden" id="docList_title15" value="청담우리의 특화진료<br /> 영상/재활 센터란?">
								<input type="hidden" id="docList_name15" value="이노희 영상의학과 과장">
								<input type="hidden" id="docList_go15" value="<a href='/page/woori03_06.php?top=3&sub=2'>바로가기 &gt;</a>"><!--바로가기5-->
								<input type="hidden" id="docList_num15" value="02">
							</li>


                            <li class="docList_li" id="docList_li10" seq="10">
                                <a href="javascript:changeDoc('10');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_1_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_1_sum_off.jpg" class="sum_off"><span>심장센터</span></a>
                                <input type="hidden" id="docList_link10" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_1.jpg">
                                <input type="hidden" id="docList_title10" value="청담우리의 특화진료<br /> 심장 센터란?">
                                <input type="hidden" id="docList_name10" value="김승곤 내과부원장">
								<input type="hidden" id="docList_go10" value="<a href='/page/woori03_01.php?top=3&sub=3'>바로가기 &gt;</a>"><!--바로가기1-->
                                <input type="hidden" id="docList_num10" value="03">                               
                            </li>
                            <li class="docList_li" id="docList_li11" seq="11">
                                <a href="javascript:changeDoc('11');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_2_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_2_sum_off.jpg" class="sum_off"><span>내시경센터</span></a>
                                <input type="hidden" id="docList_link11" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_2.jpg">
                                <input type="hidden" id="docList_title11" value="청담우리의 특화진료<br /> 내시경 센터란?">
                                <input type="hidden" id="docList_name11" value="허원석 외과부원장">
								<input type="hidden" id="docList_go11" value="<a href='/page/woori03_02.php?top=3&sub=4'>바로가기 &gt;</a>"><!--바로가기2-->
                                <input type="hidden" id="docList_num11" value="04">
                            </li>
                            <li class="docList_li" id="docList_li12" seq="12">
                                <a href="javascript:changeDoc('12');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_3_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_3_sum_off.jpg" class="sum_off"><span>정형외과센터</span></a>
                                <input type="hidden" id="docList_link12" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_3.jpg">
                                <input type="hidden" id="docList_title12" value="청담우리의 특화진료<br /> 정형외과 센터란?">
                                <input type="hidden" id="docList_name12" value="서정철 외과부원장">
								<input type="hidden" id="docList_go12" value="<a href='/page/woori03_03.php?top=3&sub=5'>바로가기 &gt;</a>"><!--바로가기3-->
                                <input type="hidden" id="docList_num12" value="05">
                            </li>                         
                            
                            
                            <li class="docList_li" id="docList_li13" seq="13">
                                <a href="javascript:changeDoc('13');"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_4_sum.jpg" class="sum_on"><img src="http://www.chungdamah.co.kr/theme/hp001/img/main_member_4_sum_off.jpg" class="sum_off"><span>치과 센터</span></a>
                                <input type="hidden" id="docList_link13" value="http://www.chungdamah.co.kr/theme/hp001/img/main_member_4.jpg">
                                <input type="hidden" id="docList_title13" value="청담우리의 특화진료<br /> 치과 센터란?">
                                <input type="hidden" id="docList_name13" value="김한석 내과&치과부원장">
								<input type="hidden" id="docList_go13" value="<a href='/page/woori03_04.php?top=3&sub=5'>바로가기 &gt;</a>"><!--바로가기4-->
                                <input type="hidden" id="docList_num13" value="06">
                            </li>                            
                        </ul>
                    </div>
                </div>
            </div>
            <script>
                $(document).ready(function() {
                    var tmp = $("#docList_link").find("ul>li").filter(':first-child').attr("seq");
                    changeDoc(tmp);
                });
    
                function changeDoc(seq){
					//alert(seq);
                    $("#dociframe").attr("src", $("#docList_link"+seq).val());
                    $("#doc_title").find("span").html($("#docList_title"+seq).val());
                    $(".profile_right .name h2").find("span").html($("#docList_name"+seq).val());
                    $(".profile_right").find("p.tit").html($("#docList_num"+seq).val());
					$(".profile_right .link h2").html($("#docList_go"+seq).val());
                    $(".docList_li").removeClass("on");
                    $("#docList_li"+seq).addClass("on");
                }
            </script>
        </div>
        <!-- 멤버 -->
    
 
 
 
 
 
  <!-- 프로그램 종류 -->
            <div id="section1" class="section">
                <div class="innerContainer">
                    <h1><span>청담우리의 전문진료를 소개합니다</span><br>
                      <strong>진료과목 안내</strong></h1>
                    <div class="main_clinic">
                        <ul class="">
                            <li class="">
                                <img src="http://www.chungdamah.co.kr/theme/hp001/img/main_type_1.jpg">
                                <!--<span>과목</span>-->
                                <h1>내과 클리닉</h1>
                                <p>호흡기계, 순환기계 등</p>
                                <a href="/page/woori04_01.php?top=4&sub=1">바로가기</a>
                            </li>
                            <li class="">
                                <img src="http://www.chungdamah.co.kr/theme/hp001/img/main_type_2.jpg">
                                <!--<span>과목</span>-->
                                <h1>안과 클리닉</h1>
                                <p>건성 각결막염, 눈물착색 등</p>
                                <a href="/page/woori04_02.php?top=4&sub=2">바로가기</a>
                            </li>
                            <li class="">
                                <img src="http://www.chungdamah.co.kr/theme/hp001/img/main_type_3.jpg">
                                <!--<span>과목</span>-->
                                <h1>피부과 클리닉</h1>
                                <p>귀질환, 피부질환 등</p>
                                <a href="/page/woori04_03.php?top=4&sub=3">바로가기</a>
                            </li>
                            <li class="">
                                <img src="http://www.chungdamah.co.kr/theme/hp001/img/main_type_4.jpg">
                                <!--<span>과목</span>-->
                                <h1>임상병리과</h1>
                                <p>혈액검사, 유전자 검사 등</p>
                                <a href="/page/woori04_04.php?top=4&sub=4">바로가기</a>
                            </li>
                            <li class="last">
                                <img src="http://www.chungdamah.co.kr/theme/hp001/img/main_type_5.jpg">
                               <!--<span>과목</span>-->
                                <h1>특수동물 클리닉</h1>
                               <p>토끼, 이구아나, 고슴도치 등</p>
                                <a href="/page/woori04_07.php?top=4&sub=7">바로가기</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- 프로그램 종류 -->
 
 
 
 
 
  
  
     <!-- 빅배너 -->
        <div id="section7" class="section">
          
            <div class="be_big">
                <div class="text_area"> 
                    <span>Chungdam Woori Animal Hospital</span>
                    <h1>특별함이 가득한 곳<br/>여기는 청담우리 입니다</h1>
                    <p>고품격 진료와 고객감동 서비스로 모든 반려동물과 보호자의 행복을 함께하는 청담우리동물병원,<br />
앞으로도 대한민국 반려동물 의료문화의 선두에 서서 최선을 다해 헌신하겠습니다.</p>
                </div>
            </div>
        </div>
        <!-- 빅배너 -->        
        
        
             
    
        <!-- 배너 섹션 -->
        <div id="section3" class="section">
            <div class="innerContainer">
                <ul class="grid clearfix">
                    <li class="banner1">
                     <h1>공지사항</h1>
                        <div class="content">
                        	
<div class="hp002">
    <ul>
        <li>
			<div class="add-contentb">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=243"> 청담우리동물병원과 닥터뉴토, 영양제 공동 개발…</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=243"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2024-06-24                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=242"> 메디코펫 ‘해빗큐브 조인트·스킨&코트’ 재출시</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=242"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2024-05-27                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=241"> [CEO 인터뷰] 사업가로 성장한 ㈜메디코펫 …</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=241"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2024-05-27                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=240"> 가수분해 새우 주원료…해빗큐브 관절·피부 영양…</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=notice01&amp;wr_id=240"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2024-05-20                 </li>-->
             </ul>
			</div>
        </li>
    </ul>
    
</div>
                        </div>
                        <span><a href="/bbs/board.php?bo_table=notice01"><i class="xi-plus"></i></a></span>
                    </li>
                    
                    
                     <li class="banner1">
                     <h1>펫도서관</h1>
                        <div class="content">
                        	
<div class="hp002">
    <ul>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_4&amp;wr_id=14"> 임신한 반려묘를 돌볼 때, 이것만 기억하자!</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_4&amp;wr_id=14"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2022-01-04                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_3&amp;wr_id=115"> 강아지가 초콜릿을 섭취했을 때</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_3&amp;wr_id=115"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2022-01-04                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_3&amp;wr_id=114"> 겨울철 반려동물 피부질환 보습에 신경써야</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_3&amp;wr_id=114"> &nbsp;</a>	
           		 </li>
				<!--<li class="add_right">
					2021-12-20                 </li>-->
             </ul>
			</div>
        </li>
        <li>
			<div class="add-content">
            <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_4&amp;wr_id=12"> 고양이의 사회생활</a>	
			
            </div>
            
            <div class="add-content02">
          	  <ul>
          		  <li class="add_left">
         		   <a href="http://www.chungdamah.co.kr/bbs/board.php?bo_table=petlib_4&amp;wr_id=12"> 고양이의 사회생활&nbsp;&nbsp;&nbs</a>	
           		 </li>
				<!--<li class="add_right">
					2021-09-15                 </li>-->
             </ul>
			</div>
        </li>
    </ul>
    
</div>
														<!--<div class="hp002">
								<ul>
									<li>0</li>
									<li>1</li>
									<li>2</li>
									<li>3</li>
								</ul>
    
</div>-->
                        </div>
                        <span><a href="/bbs/board.php?bo_table=petlib_1"><i class="xi-plus"></i></a></span>
                    </li>
                    
                    
                    
                    <li class="banner2">
                     <h1>Contact us</h1>
                        <div class="content" style="padding-top:80px;">
                            <h2>02.541.7515</h2>
                            <p>청담우리는 365일 24시간 연중무휴<br class="displaybrnone">
    서울특별시 강남구 삼성로 614</p>
                            <span>
                                <a href="https://www.instagram.com/5417515wr" target="_blank"><i class="xi-instagram"></i></a>
                                <a href="https://www.facebook.com/cwamc" target="_blank"><i class="xi-facebook"></i></a>
                                <a href="https://www.youtube.com/channel/UCrcOQ17ToaezHar5lp4iH6w" target="_blank"><i class="xi-youtube"></i></a>
                                <a href="https://blog.naver.com/cdwoori" target="_blank"><i class="xi-naver"></i></a>
                              
                            </span>
                        </div>
                        
                        <div class="cd_banner">    
<a href="http://www.chungdamah.co.kr/shop/bannerhit.php?bn_id=1" target="_blank"><img src="http://www.chungdamah.co.kr/data/banner/1?20210914230301" alt="베너" width="100%"></a>
</div>
                        
                        <!---<span><a href="/page/woori02_03.php?top=2&sub=3"><i class="xi-plus"></i></a></span>--->
                    </li>
                  
                </ul>
                
            </div>
            
        </div>
         
        <!-- // 그리드 배너 섹션 2 -->
        <script>
        // 폼메일 placehold 추가
        $(function() {
            if ($(".main_form").length > 0) {
                var $form = $(".main_form");
                $form.find('input[name=name]').attr('placeholder', '이름');
                $form.find('input[name=mobile_no1]').attr('placeholder', '010');
                $form.find('textarea[name=description]').attr('placeholder', 'Message');
            }
        });
        </script>

		
<div class="cd_banner01">    
<a href="http://www.chungdamah.co.kr/shop/bannerhit.php?bn_id=1" target="_blank"><img src="http://www.chungdamah.co.kr/data/banner/1?20210914230301" alt="베너" width="100%"></a>
</div>

		
                
 
		



       
    	<!-- 우측 퀵메뉴 -->
		<!--< include "module/quickmenu.html"; ?>-->
		<!-- // 우측 퀵메뉴 -->

		<!-- 푸터 -->
<div id="footer">
    <div class="inner">
    <!-- 그리드 감싸기 -->
   
        <div class="foot_wrap">
        	<div class="foot_logo"><a href="/"><img src="http://www.chungdamah.co.kr/theme/hp001/img/foot_logo.jpg" /></a></div>
            <div class="foot_info">
            	<div class="address">
            		<span>청담우리동물병원</span>
                    <span>서울특별시 강남구 삼성로 614  &nbsp; | &nbsp;   Tel. 02-541-7515  &nbsp; | &nbsp; Fax. 02-541-7518  &nbsp; | &nbsp; e-mail. 5417515wr@chungdamah.co.kr  </span>
                    <span>사업자등록번호 : 120-11-81-206</span>
                    <span>Copyright 2021 CHUNGDAMWOORIAH. All Rights Reserved.</span>
                </div>
                <h3><a href="/page/userule.php">이용약관</a> &nbsp;·&nbsp; <a href="/page/privacy.php">개인정보 취급방침</a> &nbsp;·&nbsp; <a href="/page/woori01_01.php?top=1&sub=1">청담우리소개</a></h3>
            </div>
            <div class="foot_customer">
            	<h1>02.541.7515</h1>
               
                <span>
                	<a href="https://www.instagram.com/5417515wr/" target="_blank"><i class="xi-instagram"></i></a>
                    <a href="https://www.youtube.com/channel/UCrcOQ17ToaezHar5lp4iH6w" target="_blank"><i class="xi-youtube"></i></a>
                    <a href="https://blog.naver.com/cdwoori" target="_blank"><i class="xi-naver"></i></a>
                    
                </span>
            </div>
        </div>
    <!-- // 그리드 감싸기 -->
    </div>
</div>  <!-- // 푸터 -->

	</div>
	<!-- // 전체 감싸기 -->



<!-- } 하단 끝 -->

<script>
$(function() {
    // 폰트 리사이즈 쿠키있으면 실행
    font_resize("container", get_cookie("ck_font_resize_rmv_class"), get_cookie("ck_font_resize_add_class"));
});
</script>



<!-- ie6,7에서 사이드뷰가 게시판 목록에서 아래 사이드뷰에 가려지는 현상 수정 -->
<!--[if lte IE 7]>
<script>
$(function() {
    var $sv_use = $(".sv_use");
    var count = $sv_use.length;

    $sv_use.each(function() {
        $(this).css("z-index", count);
        $(this).css("position", "relative");
        count = count - 1;
    });
});
</script>
<![endif]-->

</body>
</html>
