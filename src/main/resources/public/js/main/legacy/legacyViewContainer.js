var LegacyViewContainer =  function() {
	this.selectedIndex = 0;
	this.welLegacyWrap = $("#wrap_upload_file_result");
	this.legacyArray = new Array();
};


LegacyViewContainer.prototype.append = function(legacyJsonArray , fnListner) {
	for (var indexI = 0; indexI < legacyJsonArray.length; indexI++) {
		var legacyJson = legacyJsonArray[indexI];
		var legacy = new Legacy(legacyJson);
		this.legacyArray.push(legacy);
		
		var welLegacy = createHtmlElement(legacy.getName());
		var that = this;
		
		welLegacy.click(function(event) {
			var $this = $(this);
			that.welLegacyWrap.find('.active').removeClass('active');
			$this.addClass("active");
			
			var legacyIndex = $this.index() - 1;
			fnListner(that.legacyArray[legacyIndex]);
		});
		
		this.welLegacyWrap.append(welLegacy);
	}
	
	function createHtmlElement(fileName) {
		var $a = $('<a>', {
			'href' : '#',
			'text' : fileName
		});
		return $('<li>').append($a);
	}
};


LegacyViewContainer.prototype.showLastAppend = function() {
	this.welLegacyWrap.children().last().trigger('click');
};

LegacyViewContainer.prototype.updateView = function(legacy) {
	var selectedIndex = this.welLegacyWrap.find('.active').index();
	this.legacyArray[selectedIndex - 1] = legacy;
	this.welLegacyWrap.children().eq(selectedIndex).trigger('click');
};




