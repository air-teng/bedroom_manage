//通过输入的时间获取包含datetime的时间
//Date转为datetimeLocal
function dateToDatetimeLocal(date){
	var now = new Date();
	now.setTime(date);
    var datetime = now.getFullYear() + "-" + fix((now.getMonth() + 1), 2) + "-" + fix(now.getDate(), 2) + "T" + fix(now.getHours(), 2) + ":" + fix(now.getMinutes(), 2);
    return datetime;
}

//datetimeLocal转为Date
function datetimeLocalToDate(datetime){
	//将datetime-local转换为Date
	var date = new Date();
    date.setFullYear(parseInt(datetime.substring(0, 4)));
    date.setMonth(parseInt(datetime.substring(5, 7)) - 1);
    date.setDate(parseInt(datetime.substring(8, 10)));
    date.setHours(parseInt(datetime.substring(11, 13)));
    date.setMinutes(parseInt(datetime.substring(14, 16)));
    return date;
}