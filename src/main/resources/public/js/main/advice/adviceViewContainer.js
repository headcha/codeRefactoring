var AdviceViewContainer =  function(adviceJsonList , fnCallback) {
	this.$welAdviceArea = $("#wrap_advice");
	var adviceFactory = new AdviceFactory(adviceJsonList);
	this.adviceList = adviceFactory.getAdviceList();
	
	$.each(this.adviceList , function(index , advice) {
		advice.setOnClickListner(fnCallback);
	}); 
};

AdviceViewContainer.prototype.showAdvice = function() {
	var that = this;
	this.$welAdviceArea.find(".advice_li").remove();
	$.each(this.adviceList , function(index , advice) {
		that.$welAdviceArea.append(advice.getWel());
	});
};





