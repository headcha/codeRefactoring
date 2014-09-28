<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Headcha</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style media="screen">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}

.warning {
	background: rgba(255, 0, 0, 0.3);
	position: absolute;
	width: 100% !important;
	left: 0 !important;
}

#editor {
	text-align: left;
	height: 850px;
}
</style>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<button type="button" class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="brand" href="#">Headcha</a>
				<div class="nav-collapse collapse">
					<p class="navbar-text pull-right">${totalCount }</p>
					<ul class="nav">
						<li class="active"><a href="/index.cha">Advice</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<!--/span-->
			<div class="span2" id="wrap_upload_legacy" style="display: none;">
				<div class="row-fluid">
					<div class="well sidebar-nav">
						<ul class="nav nav-pills nav-stacked" id="wrap_upload_file_result">
							<li class="nav-header">분석한 파일 - 클릭 -</li>
						</ul>
					</div>
				</div>

				<!--/.well -->
			</div>
			<div class="span11" id="wrap_code_editor">
				<div>
					<span class="btn btn-success fileinput-button"
						style="float: right; margin-right: 10px; margin-top: 10px;">
						<i class="glyphicon glyphicon-plus"></i> <span>Add files...</span>
						<!-- The file input field used as target for the file upload widget -->
						<input id="fileupload" type="file" name="codeFile" multiple>
					</span>
				</div>
				<div class="hero-unit">

					<div id="editor" style="display: none;"></div>

					<div id="intro" style="text-align: center;">
						<h1>어서오세요.</h1>
						<p>사용중 개선 의견은 언제든 메일 주세요.</p>
						<p>chrome 에 최적화 되어있습니다.</p>

						<p class="text-left">2014.02.04 업데이트</p>
						<p class="text-left">
							<small>코드 포멧팅 적용 - 기존: nhn 표준 포멧 파일만 분석 가능  개선 : .java
								파일이기만 하면 어떤 양식이던 상관없이 분석 가능합니다.</small>
						</p>

						<p class="text-left">2014.02.10 업데이트</p>
						<p class="text-left">
							<small>파일 업로드 개선 - 기존: single file upload - 개선 : multi
								file upload</small>
						</p>
						<p class="text-left">
							<small>분석 알고리즘 개선 - japa parser 적용 , jdt core 적용</small>
						</p>
						<p class="text-left">2014.02.11 업데이트</p>
						<p class="text-left">
							<small>소스 코드 수정기능 추가</small>
						</p>
						<p class="text-left">
							<small>수정된 코드 재 리뷰 기능추가</small>
						</p>
					</div>

				</div>

			</div>
			<!--/span-->

			<div class="span2" id="wrap_result" style="display: none;">
				<div class="row-fluid" style="display: none;" id="wrap_hint">
					<button class="btn" data-toggle="modal"
						style="margin-bottom: 10px; float: right;">리펙터링 도움말</button>
				</div>
				<div class="row-fluid">
					<div class="well sidebar-nav">

						<ul class="nav nav-pills nav-stacked" id="wrap_advice">
							<li class="nav-header">분석결과 - 클릭 -</li>

						</ul>
					</div>
				</div>
				<div class="row-fluid">

					<button class="btn btn-success"
						style="float: right;  margin-left: 10px;"
						id="retryReview" data-loading-text="분석중...">다시 분석</button>
					<button class="btn" style="float: right;" id="codeEdit">소스
						편집</button>
				</div>
				<!--/.well -->
			</div>
		</div>
		<!--/row-->


		<!-- hint -->
		<div class="modal hide fade" id="LongMethod" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">메서드가 길어 복잡해 보입니다.</h4>
					</div>
					<div class="modal-body">
						<p>점검포인트1. 혹시 아래 코드처럼 추상화 레벨이 서로 다르지 않나요?</p>
						<br> <img alt="문제" src="/img/advice/longMethod/problem.PNG">
						<p>메서드는 의도를 명확히 나타내주는것이 좋습니다.</p>
						<p>이런 문제가 있다면 의도를 나타낼수 있는 메서드로 분리해보세요.</p>
						<br> <img alt="문제" src="/img/advice/longMethod/step1.PNG">
						<p>이렇게 분리해내면 전체 흐름을 담당하는 메서드와 기능을 담당하는 메서드로 분리할수 있어 가독성을 높이는데
							도움이 됩니다.</p>
						<br>
						<p>
							<strong>리펙터링 결과.</strong>
						</p>
						<img alt="문제" src="/img/advice/longMethod/complate.PNG">
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<!-- hint -->
		<div class="modal hide fade" id="CatchPrintLog" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">의미없는 예외처리가 있는것
							같습니다.</h4>
					</div>
					<div class="modal-body">
						<p>
							<strong>점검 포인트 1.</strong> StackTrace 정보 출력을 위한 예외처리를 한경우.
						</p>
						<br> <img alt="문제" src="/img/advice/catchPrint/exception.PNG">
						<p>이런 경우엔 그냥 throw 해주세요. JVM 이 출력해줍니다. 특히 printStackTrace 로</p>
						<p>로그를 출력후에 throw 하지 않았다면 시스템에 문제가 발생했다는것을 개발자가 알수 없습니다.</p>
						<p>문제가 발생했을땐 빨리 개발자에게 알려줄수 있어야 합니다.</p>
						<br> <span><strong>점검 포인트 2.</strong> 단순 로그출력을 위해
							예외처리를 한경우.</span><br> <img alt="문제"
							src="/img/advice/catchPrint/exception-2.PNG">
						<p>로그를 남기기 위한 예외 처리도 문제가 될수 있습니다.</p>
						<p>특히 로그 출력후에 throw 하지 않았다면 시스템에 문제가 발생했다는것을 개발자가 알수 없습니다.</p>
						<p>exception 객체는 생성비용이 비싼 객체 임으로 정보를 충분히 활용할수 있어야 합니다.</p>
						<p>아래와 같이 개선해보세요.</p>
						<br> <img alt="문제"
							src="/img/advice/catchPrint/unCheckedException.PNG">
						<p>미확인 예외로 치환해 throw 하면 다른 코드에 영향없이 처리할수 있습니다.</p>
						<p>예외를 종료시키지 않고 코드를 가져다 쓰는 개발자에게 처리를 위임 할수 있음으로</p>
						<p>단순히 로그를 출력하는 코드보다 유지보수하는데 더 도움이 될수 있습니다.</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide  fade" id="ConditionalComplexity" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">


						<h4 class="modal-title" id="myModalLabel">조건문이 복잡해 보입니다.</h4>
					</div>
					<div class="modal-body">
						<p>
							<strong>점검 포인트 1.</strong>if 문안에 다양한 조건이 있지 않나요?
						</p>
						<br> <img alt="문제"
							src="/img/advice/conditionalComplexity/if_problem.PNG">
						<p>조건문이 다양한 연산자와 만나면서 길어지면 코드를 읽는 사람이 의도를 파악하기 힘들어 집니다.</p>
						<p>조건문은 아주 민감하게 동작함으로 최대한 의도를 나타내주는것이 좋습니다.</p>
						<p>아래와 같이 개선해보세요.</p>
						<br> <img alt="문제"
							src="/img/advice/conditionalComplexity/if_complate.PNG">
						<p>간단한 1줄 조건문이라 하더라도 읽는 사람을 위해 의도를 나타낼수 있는 메서드로 분리해주는 것이 가독성
							향상에 도움이 됩니다.</p>
						<p>조건문은 요구사항의 변경에 가장 많은 영향을 받는 코드임으로 항상 간결하게 유지하는것이 좋습니다.</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="DeepNesting" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">코드 중첩이 깊어 복잡해 보입니다.</h4>
					</div>
					<div class="modal-body">
						<p>for ~ for ~ if 등으로 중첩된 코드는 코드를 읽는 사람이 모든 조건을 기억해야 함으로 가독성이
							떨업니다.</p>
						<p>아래와 같이 개선해보세요</p>
						<br>

						<p>
							<strong>case1. 조건문 반전을 통해 복잡도 개선</strong>
						</p>
						<img alt="문제" src="/img/advice/deepNesting/code_deep_problem1.PNG" /><br>
						<p>
							<strong>case2. 실행하지 말야아야 데이터를 미리 필터링</strong>
						</p>
						<img alt="문제" src="/img/advice/deepNesting/code_deep_problem2.PNG" /><br>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="LongParameter" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">메서드 파라메터가 너무 많습니다.</h4>
					</div>
					<div class="modal-body">
						<p>아무리 좋은 이름으로 지은 메서드도 파라메터를 이해할수 없다면 읽기 어려운 코드가 됩니다.</p>
						<p>또 메서드를 테스트 하기 위해 각 파라메터를 모두 이해해야 함으로 고려해야할 경우수가 기하급수로
							증가합니다.</p>
						<p>
							메소드에 파라메터가 3개 이상이라면 <strong>하나의 객체로 묶을 방법은 없는지</strong> 꼭 고민해보세요.
						</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="PublicField" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">Public 속성 필드가 있습니다.</h4>
					</div>
					<div class="modal-body">
						<p>
							<strong>점검 포인트 1.</strong>모바일 환경이 아니라면 getter , setter 를 이용하세요.
						</p>
						<br>

						<p>adroid 의 경우 성능을 위해 필드를 직접 참조할때가 있지만</p>
						<p>web 이라면 private 으로 공개레벨을 감추고 getter , setter 메소드를 이용하는것이
							좋습니다.</p>
						<p>tip.이클립스 단축키를 이용해 쉽게 getter , setter 를 만들수 있습니다.</p>
						<br>

						<p>
							<strong>step1. private 필드 선언</strong>
						</p>
						<img alt="문제" src="/img/advice/publicField/step1.PNG" /><br>

						<p>
							<strong>step2. 이클립스에서 alt+Shift+s 누른후 Generate 메뉴선택</strong>
						</p>
						<img alt="문제" src="/img/advice/publicField/step2_0.PNG" /><br>

						<p>
							<strong>step3. 다이얼로그에서 필드 선택후 확인</strong>
						</p>
						<img alt="문제" src="/img/advice/publicField/step3.PNG" /><br>

						<p>
							<strong>step4. 생성된 getter , setter</strong>
						</p>
						<img alt="문제" src="/img/advice/publicField/complate.PNG" /><br>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="SingleLineComments" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">주석위치가 애매합니다.</h4>
					</div>
					<div class="modal-body">
						<p>
							<strong>점검 포인트 1.</strong>한줄 주석위치를 확인해보세요
						</p>
						<br> <img alt="문제"
							src="/img/advice/singleLineComments/commentProblem.PNG">
						<p>한줄 주석은 범위코드를 나타내는것인지 한줄 코드를 나타내는것인지 의도가 애매할때가 많습니다.</p>
						<p>주석을 목적에 따라 나눠보세요.</p>
						<br>
						<p>
							<strong>범위코드를 보안할때</strong>
						</p>
						<img alt="문제"
							src="/img/advice/singleLineComments/rangeComment.PNG"><br>
						<p>
							<strong>한줄코드를 보안할때</strong>
						</p>
						<img alt="문제"
							src="/img/advice/singleLineComments/singleLineComments.PNG"><br>
						<p>한줄 코드를 보안하는 주석일때는 코드 옆에 기술하면 주석범위를 명확히 할수 있습니다.</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="StaticField" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">쓰기 가능한 static 필드가
							있습니다.</h4>
					</div>
					<div class="modal-body">
						<p>WAS 는 멀티 쓰레드 환경임으로 static 필드는 반드시 읽기 전용이여야 합니다.</p>
						<p>읽기 전용 이라면 반드시 final 을 붙여주세요.</p>
						<p>읽기 / 쓰기 속성이여야 한다면 lock 처리가 필요합니다.</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		<div class="modal hide fade" id="TryAdvice" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h4 class="modal-title" id="myModalLabel">예외 처리 코드가 복잡해 보입니다.</h4>
					</div>
					<div class="modal-body">
						<p>
							<strong>점검 포인트 1.</strong>try 안에 코드와 catch 코드는 분리하는것이 좋습니다.
						</p>
						<br>
						<p>
							<strong>정상흐름과 예외흐름이 뒤섞인 코드</strong>
						</p>
						<img alt="문제" src="/img/advice/try/try_problem.PNG">
						<p>try ~ catch 문은 기본적으로 복잡합니다.</p>
						<p>아래와 같이 개선해보세요.</p>
						<br>
						<p>
							<strong>정상흐름을 메서드로 분리한 코드</strong>
						</p>
						<img alt="문제" src="/img/advice/try/try_complate.PNG">
						<p>try ~ catch 로 예외를 처리 했을경우 위와 같이 정상흐름과 비정상 흐름을</p>
						<p>메서드로 분리하는것이 가독성과 유지보수성 향상에 도움이 됩니다.</p>
					</div>
					<div class="modal-footer"></div>
				</div>
			</div>
		</div>

		

		<hr>

		<footer style="float: right;">
			<p>
				©개발자. 차정현 <a href="mailto:headcha@naver.com" class="navbar-link">headcha@naver.com</a>
			</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<script type="text/javascript" src="/js/common/ServerProperty.js?version=20071207"></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js?version=20071207"></script>

	<!-- bootstrap -->
	<script src="/js/lib/bootstrap/bootstrap.min.js?version=20071207"></script>
	<!-- bootstrap -->


	<script src="/js/lib/editer/ace.js?version=20071207" type="text/javascript"
		charset="utf-8"></script>

	<!-- fileupload -->
	<script src="/js/lib/fileupload/vendor/jquery.ui.widget.js?version=20071207"></script>
	<script src="/js/lib/fileupload/jquery.iframe-transport.js?version=20071207"></script>
	<script src="/js/lib/fileupload/jquery.fileupload.js?version=20071207"></script>
	<!-- fileupload -->

	<!-- main -->
	<script src="/js/main/codeEditor.js?version=20071207"></script>
	<script src="/js/main/uploader/uploader.js?version=20071207"></script>
	<script src="/js/main/uploader/codeUploader.js?version=20071207"></script>
	<script src="/js/main/uploader/fileUploader.js?version=20071207"></script>

	<script src="/js/main/legacy/legacy.js?version=20071207"></script>
	<script src="/js/main/legacy/legacyViewContainer.js?version=20071207"></script>
	<script src="/js/main/advice/adviceViewContainer.js?version=20071207"></script>
	<script src="/js/main/advice/adviceFactory.js?version=20071207"></script>
	<script src="/js/main/advice/adviceType.js?version=20071207"></script>
	<script src="/js/main/advice/advice.js?version=20071207"></script>


	<script src="/js/main/main.js?version=20071207"></script>
</body>
</html>
