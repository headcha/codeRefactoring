var Advice = function(adviceJson) {
	this.type = adviceJson.type;
	this.legacyLineArray = adviceJson.legacyCodeLines;
	this.$welHtmlElement = createHtmlElement(this.type);

	function createHtmlElement(type) {
		var $a = $('<a>', {
			'href' : '#',
			'text' : TYPE_STRING[type]
		});
		return $('<li class="advice_li">').append($a);
	}
};

Advice.prototype.getWel = function() {
	return this.$welHtmlElement;
};

Advice.prototype.setOnClickListner = function(fnListner) {
	if (this.type == "NoAdvice") {
		return;
	}

	var legacyLineArray = this.legacyLineArray;
	var type = this.type;
	this.$welHtmlElement.click(function() {
		$("#wrap_advice .active").removeClass("active");
		$(this).addClass("active");
		fnListner(legacyLineArray);

		$("#wrap_hint").show().find('button').attr('data-target', '#' + type);
	});
};
