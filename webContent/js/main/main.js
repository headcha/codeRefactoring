$(function() {

	var codeEditor = configEditor();
	var isEdit = false;
	var legacyViewContainer = new LegacyViewContainer();

	var uploader = new Uploader();
	uploader.uploadLegacyFile(fnUploadComplete);

	function fnUploadComplete(data) {
		$("#wrap_result").show();
		$("#wrap_code_editor").removeClass('span11').addClass('span8');
		$("#wrap_upload_legacy").show();
		$("#intro").hide();

		codeEditor.show();
		legacyViewContainer.append(data.result, fnOnLegacyClick);
		legacyViewContainer.showLastAppend();
	}

	function fnOnLegacyClick(legacy) {
		$("#wrap_hint").hide();
		var adviceViewContainer = new AdviceViewContainer(legacy.getAdviceList(), fnOnAdviceClick);
		adviceViewContainer.showAdvice();
		codeEditor.insertCode(legacy.getLegacyCode());
	}

	function fnOnAdviceClick(lines) {
		codeEditor.lineHilightBy(lines);
		codeEditor.scrollTo(lines[0]);
	}
	
	

	$('#reformation').click(function(event) {
		alert("준비중 입니다. 메일로 부탁드립니다~~~ headcha@naver.com");
	});

	$('#introduction').click(function(event) {
		alert("준비중입니다.");
	});

	
	$('#retryReview').click(function(event) {
		if ($("#codeEdit").hasClass('active')) {
			alert("코드 편집중에는 리뷰할수 없습니다. 편집을 완료한후 시도하세요.");
			return;
		}
		
		if (isEdit == false) {
			alert("수정된 코드가 없습니다.");
			return;
		}
		
		$(this).button('loading');
		uploader.uploadLegacyCode(codeEditor.getCodeBody(),fnCompleteRetryReview);
		codeEditor.readOnlyMode();
	});

	$("#codeEdit").click(function(event) {
		var $this = $(this);
		$this.button('toggle');
		isEdit = true;
		
		if ($this.hasClass('active')) {
			$this.text("편집 완료");
			codeEditor.initLineHilight();
			codeEditor.writeMode();
		} else {
			$this.text("소스 편집");
			codeEditor.readOnlyMode();
		}
		
	});

	
	function fnCompleteRetryReview(legacy) {
		$('#retryReview').button('reset');
		legacyViewContainer.updateView(legacy);
		isEdit = false;
	}

	function configEditor() {
		var codeEditor = new CodeEditor("editor");
		codeEditor.readOnlyMode();
		return codeEditor;
	}
});
