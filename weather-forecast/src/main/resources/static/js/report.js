$(function() {
    $("#selectCity").change(function() {
       var cityId = $("#selectCity").val();
       var url = "/report/city/id/" + cityId;
       window.location.href = url;
    });
});