var CodeEditor =  function(editorId) {
	this.aceEditor = ace.edit(editorId);
	this.aceEditor.setTheme("ace/theme/eclipse");
	this.aceEditor.setFontSize(13);
	this.aceEditorSession = this.aceEditor.getSession();
	this.aceEditorSession.setMode("ace/mode/java");
	this.aceRange = ace.require('ace/range').Range;
	this.aceSelection = this.aceEditor.getSelection();
	
	var aceRange = ace.require('ace/range').Range;
	var startHileghtLineNumber = 0;
	var endHileghtLineNumber = 10;
	var hileghtRangeAce = new aceRange(startHileghtLineNumber , 0, endHileghtLineNumber , 1);


};

CodeEditor.prototype.insertCode = function(code) {
	this.clear();
	this.aceEditor.insert(code);
};

CodeEditor.prototype.clear = function() {
	this.initLineHilight();
	var endLineNumber = this.aceEditorSession.doc.$lines.length;
	this.aceEditorSession.doc.removeLines(0 , endLineNumber);
};

CodeEditor.prototype.show = function() {
	$('#editor').show();
};

CodeEditor.prototype.readOnlyMode = function() {
	this.aceEditor.setReadOnly(true); 
};

CodeEditor.prototype.writeMode = function() {
	this.aceEditor.setReadOnly(false); 
};

CodeEditor.prototype.scrollTo = function(lineNumber) {
	var count = this.aceEditorSession.getLength();
	this.aceEditor.gotoLine(lineNumber, count);
};

CodeEditor.prototype.getCodeBody = function() {
	return this.aceEditorSession.getValue();
};


CodeEditor.prototype.lineHilightBy = function(lines) {
	
	this.initLineHilight();
	
	for ( var indexI = 0; indexI < lines.length; indexI++) {
		var hileghtLineNumber = lines[indexI] - 1;
		var adjRangeAce = new this.aceRange(hileghtLineNumber, 0, hileghtLineNumber, 1);
		this.aceEditorSession.addMarker(adjRangeAce, "warning", "line", true);
	};
};

CodeEditor.prototype.initLineHilight = function() {
	var markers = this.aceEditorSession.$frontMarkers;
	
	for (markerId in markers) {
		this.aceEditorSession.removeMarker(markerId);
	}
};

