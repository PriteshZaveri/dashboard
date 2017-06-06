function addResource() {
  var resDrop = document.getElementById('resValues');
  var res = resDrop.options[resDrop.selectedIndex].value;
  var shiftDrop = document.getElementById('shiftVal');
  var sft = shiftDrop.options[shiftDrop.selectedIndex].value;


  if (sft=="A") {
    var shiftTable = document.getElementById('aShiftData');
    shiftTable.innerHTML = shiftTable.innerHTML + "<p>"+res+"</p>"
  }
  else if (sft=="General") {
    var shiftTable = document.getElementById('gShiftData');
    shiftTable.innerHTML = shiftTable.innerHTML + "<p>"+res+"</p>"
  }
  else if (sft=="B") {
    var shiftTable = document.getElementById('bShiftData');
    shiftTable.innerHTML = shiftTable.innerHTML + "<p>"+res+"</p>"
  }
  else if (sft=="C") {
    var shiftTable = document.getElementById('cShiftData');
    shiftTable.innerHTML = shiftTable.innerHTML + "<p>"+res+"</p>"
  }

}
