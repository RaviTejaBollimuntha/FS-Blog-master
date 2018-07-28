;!function () {
    var layer = layui.layer,
        form = layui.form;
}();

/**
 * Send a get request to a specified url
 * @param href
 */
function c_location(href) {
    window.location = href;
}


/**
 * Layer confirmation box
 * Click "Confirm" to perform the callback function, click " Cancel” to do nothing
 *
 * @param msg confirmation message
 * @param callback function
 */
function c_confirm(msg, callback) {
    layer.confirm(msg, {icon: 3, title: 'Alert'}, function (index) {
        callback();
        layer.close(index);
    });
}

/**
 * Popup message mask layer
 *
 * @param msg message content
 */
function msg(msg) {
    layer.msg(msg);
}

/**
 * Time stamp to date string
 */
function formatDateTime(val, row, index) {
    var date = new Date(val);
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    var second = date.getSeconds();
    minute = minute < 10 ? ('0' + minute) : minute;
    second = second < 10 ? ('0' + second) : second;
    return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
}

/**
 * Intercept a string of the specified length
 * Add at the end “...”
 */
function formatStrLength(val, row, index) {
    val = val.substring(0,20);
    val += "...";
    return val;
}