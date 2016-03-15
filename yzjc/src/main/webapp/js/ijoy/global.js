	function dateFormat(dd){
				var d=new Date(dd);
				var year=d.getFullYear().toString();
				var month=d.getMonth()+1;
				if(month.toString().length==1){
					month="0"+month.toString();
				}
				var day=d.getDate();
				if(day.toString().length==1){
					day="0"+day.toString();
				}
				return year+"-"+month+"-"+day;
			}
 function GenerateJson(jsonObj,s,v){
		if(!jsValidateIsNull(jsonObj)){
			if(!jsValidateIsNull(s) && !jsValidateIsNull(v)){
				jsonObj[""+s+""]=v;
				console.debug("GenerateJson=====  "+jsonObj);
				return jsonObj;
			}
		}
	}
 
 /*
  * jsValidateIsNull
  */
 function  jsValidateIsNull(ntt){
	
	 return ntt===null|ntt===""|ntt===undefined;
 }
