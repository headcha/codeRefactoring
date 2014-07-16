var AdviceFactory =  function(adviceJsonList) {
	this.adviceList = createAdviceList(adviceJsonList);
	
	function createAdviceList(adviceJsonList) {
		var adviceList = new Array();
		var adviceJSONArray = JSON.parse(adviceJsonList);
		
		adviceJSONArray.forEach(function(adviceJson, index, adviceArray) {
			var advice = new Advice(adviceJson);
			adviceList.push(advice);		
		});
		return adviceList;
	}
};

AdviceFactory.prototype.getAdviceList = function() {
	return this.adviceList;
};


