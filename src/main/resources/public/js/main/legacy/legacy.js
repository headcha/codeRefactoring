var Legacy =  function(legacyFile) {
	this.legacyCode = legacyFile.codeBody;
	this.name = legacyFile.fileName;
	this.adviceList = legacyFile.adviceList;
};

Legacy.prototype.getLegacyCode = function() {
	return this.legacyCode;
};



Legacy.prototype.getName = function() {
	return this.name;
};

Legacy.prototype.getAdviceList = function() {
	return this.adviceList;
};





