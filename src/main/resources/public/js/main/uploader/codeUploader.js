var CodeUploader = function() {
	this.codeFileUploader;

};

CodeUploader.prototype.upload = function(legacyCode, fileName, fnComplete) {
	$.post(ServerProperty.JAVA_CODE_UPLOAD_URL, {
		legacyCode : legacyCode,
		fileName : fileName
	}).done(function(legacyJson) {
		fnComplete(new Legacy(JSON.parse(legacyJson)));
	}).fail(function( data , ex ) {
		alert("분석할수 없는 파일입니다. 문법 오류가 없는지 다시 확인해주세요.");
		$('#retryReview').button('reset');
	});
};
