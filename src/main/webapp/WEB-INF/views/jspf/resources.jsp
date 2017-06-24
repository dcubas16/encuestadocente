<title>encuestadocente</title>

<meta charset="utf-8">
<meta name="format-detection" content="telephone=no" />
<link rel="icon" href="resources/images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="resources/css/grid.css">
<link rel="stylesheet" href="resources/css/camera.css">
<link rel="stylesheet" href="resources/css/newsletter.css">
<link rel="stylesheet" href="resources/css/style.css">

<script type="text/javascript" async="" src="http://www.google-analytics.com/ga.js"></script>
<script src="resources/js/jquery.js"></script>
<script src="resources/js/jquery-migrate-1.2.1.js"></script>
<script src="resources/js/camera.js"></script>
<script src="resources/js/sForm.js"></script>
<!--[if (gt IE 9)|!(IE)]><! -->
<script src="resources/js/jquery.mobile.customized.min.js"></script>
<script src="resources/js/wow/wow.js"></script>
<script>
	$(document).ready(function() {
		if ($('html').hasClass('desktop')) {
			new WOW().init();
		}
	});
</script>
<!--<![endif]-->
<script>
	$(document).ready(function() {
		$('#camera_wrap').camera({
			loader : true,
			pagination : false,
			minHeight : '',
			thumbnails : false,
			height : '43.1875%',
			caption : true,
			navigation : true,
			fx : 'simpleFade'
		});
		$('#form1').sForm({
			ownerEmail : '#',
			sitename : 'sitename.link'
		});
	});
</script>
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <link rel="stylesheet" type="text/css" media="screen" href="css/ie.css">
    <div id="ie6-alert" style="width: 100%; text-align:center;">
    <img src="http://beatie6.frontcube.com/images/ie6.jpg" alt="Upgrade IE 6" width="640" height="344" border="0" usemap="#Map" longdesc="http://die6.frontcube.com" />
      <map name="Map" id="Map"><area shape="rect" coords="496,201,604,329" href="http://www.microsoft.com/windows/internet-explorer/default.aspx" target="_blank" alt="Download Interent Explorer" /><area shape="rect" coords="380,201,488,329" href="http://www.apple.com/safari/download/" target="_blank" alt="Download Apple Safari" /><area shape="rect" coords="268,202,376,330" href="http://www.opera.com/download/" target="_blank" alt="Download Opera" /><area shape="rect" coords="155,202,263,330" href="http://www.mozilla.com/" target="_blank" alt="Download Firefox" />
        <area shape="rect" coords="35,201,143,329" href="http://www.google.com/chrome" target="_blank" alt="Download Google Chrome" />
      </map>
  </div>
    <![endif]-->
