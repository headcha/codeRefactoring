var FileUploader =  function(fileSelector) {
	this.$fileUpload = fileSelector.fileupload({
		url : ServerProperty.JAVA_FILE_UPLOAD_URL,
		dataType : 'json',
		singleFileUploads : false,
		maxFileSize : 20000000, 
	});
};

FileUploader.prototype.upload = function(fnComplete) {
	this.$fileUpload.on('fileuploadadd', function(e, data) {
		// TODO
	}).on('fileuploadadd', function (e, data) {
		for (var indexI = 0; indexI < data.files.length; indexI++) {
	        var fileName = data.files[indexI].name.split('.');
	        
	        if (fileName.length < 1) {
	        	alert(".java 파일만 업로드 할수 있습니다.");
	        	return false;
	        }
	        
	        if (fileName[1] != "java") {
	        	alert(".java 파일만 업로드 할수 있습니다.");
	        	return false;
	        }
		}
    }).on('fileuploadprocessalways', function(e, data) {
		// TODO
	}).on('fileuploadprogressall', function(e, data) {
		// TODO
	}).on('fileuploaddone', function(e, data) {
		fnComplete(data);
	}).on('fileuploadfail', function(e, data) {
		alert("분석할수 없는 파일입니다. 문법 오류가 없는지 다시 확인해주세요.");
	}).prop('disabled', !$.support.fileInput).parent().addClass(
			$.support.fileInput ? undefined : 'disabled');
};
