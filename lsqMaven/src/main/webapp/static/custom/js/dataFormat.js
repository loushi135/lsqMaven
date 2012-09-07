function parseDate(str){   
  if(typeof str == 'string'){   
    var results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) *$/);   
    if(results && results.length>3)   
      return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]));    
    results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2}) *$/);   
    if(results && results.length>6)   
      return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]));    
    results = str.match(/^ *(\d{4})-(\d{1,2})-(\d{1,2}) +(\d{1,2}):(\d{1,2}):(\d{1,2})\.(\d{1,9}) *$/);   
    if(results && results.length>7)   
      return new Date(parseInt(results[1]),parseInt(results[2]) -1,parseInt(results[3]),parseInt(results[4]),parseInt(results[5]),parseInt(results[6]),parseInt(results[7]));    
  } 
  return null;   
}

function formatDate(v){   

  if(typeof v == 'string') v = parseDate(v);   
  if(v instanceof Date){   
    var y = v.getFullYear();   
    var m = v.getMonth() + 1;   
    var d = v.getDate();
    if (m < 10) {
    	m = "0"+m;
    }
    if (d < 10) {
    	d = "0"+d;
    }
    return y + '-' + m + '-' + d;   
  }
  return '';   
}