var Uploader =  function() {
	this.fileUploader = new FileUploader($('#fileupload'));
	this.codeUploader = new CodeUploader();
};

Uploader.prototype.uploadLegacyFile = function(fnComplete) {
	this.fileUploader.upload(fnComplete);
};

Uploader.prototype.uploadLegacyCode = function(legacyCode , fnComplete) {
	var fileName = $('#wrap_upload_file_result .active').text();
	this.codeUploader.upload(legacyCode ,fileName , fnComplete);
};
