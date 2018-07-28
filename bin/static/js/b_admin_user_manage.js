/ * Background user management */
$(function () {
    //1.Initialize Table
    var oTable = new TableInit();
    oTable.Init();

    //2.Initialize button's Click event
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

    //3.Initialize table events
    var oEventInit = new EventInit();
    oEventInit.Init();
});


var TableInit = function () {
    var oTableInit = new Object();
    // Initialize Table
    oTableInit.Init = function () {
        // Load background user list
        $('#id_table_blog').bootstrapTable({
            url: '/admin/admin_user.j',          // Request the URL of the background（*）
            method: 'get', //request method（*）
            toolbar: '#toolbar', // which container to use for the toolbutton
            striped: true, //whether to display the color of the line interval
            cache: false, //whether to use the cache, the default is true,so in general need to set this property（*）
            pagination: true, //whether to display pagination（*）
            sortable: true, // whether to enable sorting
            sortOrder: "asc", //Sort by
            sidePagination: "client", // paging method: client client paging, server server paging（*）
            pageNumber: 1, // initialize load first page, default first page
            pageSize: 50, // number of rows per page（*）
            pageList.: [10, 25, 50, 100, 200, 500], // The number of rows per page to choose from（*）
            search: true, // whether to display the table search, this search is a client-side Search, will not enter the server
            strict search: false, //whether to make an exact match
            showColumns: true, //does show all columns
            showRefresh: true, //whether to display the Refresh button
            minimumCountColumns: 2, //minimum allowed columns
            clickToSelect: true, // whether to enable click on the selected row
            height: 650, // line height, if the height attribute is not set, the table automatically according to the number of records that form height
            uniqueId: "id",  // uniquely identifies each row, usually the primary key column
            showToggle: true, //whether to display the toggle button for detailed view and list view
            cardView: false, //whether to show the detail view
            detailView: false, //whether to display the parent-child table
            showHeader: true,
            columns: [{
                checkbox: true
            }, {
                field: 'id',
                title: 'Serial number',
                align: 'center',
                sortable: true
            }, {
                field: 'username',
                title: 'Username',
                align: 'center'
            }, {
                field: 'nickname',
                title: 'Nickname',
                align: 'center'
            }, {
                field: 'gmtCreate',
                title: 'Creation time',
                align: 'center',
                formatter: formatDateTime,
                sortable: true
            }, {
                field: 'gmtModified',
                title: 'Last modified time',
                align: 'center',
                formatter: formatDateTime,
                sortable: true
            }]
        });
    };

    // get query parameters
    oTableInit.queryParams = function (params) {
        var temp = {
            // The name of the key and the variable name of the controller must have been here, change, the controller also need to change the same
            // limit: params.limit,   // Page size
            // offset: params.offset,  // Page number
            // title: $("#txt_search_departmentname").val(),
        };
        return temp;
    };

    return oTableInit;
};

/**
 * Reload table
 */
function flushTable() {
    $('#id_table_blog').bootstrapTable('refresh');
}

/**
 * Button Click event
 */
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        // Initialize the button event above the page
        $('#id_btn_delete').on('click', function () {
            c_confirm("Do you want to delete all users selected?After the deletion can not be restored!", deleteAdminUserInBulk);
        });

        $('#id_btn_add').on('click', function () {
            addAdminUser();
        });

        $('#id_btn_edit').on('click', function () {
            modifyAdminUser();
        });
    };

    return oInit;
};

/**
 * Form events
 */
var EventInit = function () {
    var oInit = new Object();

    oInit.Init = function () {
        $('#id_table_blog').bootstrapTable({
            onAll: function (name, args) {

            }
        });
    };
    return oInit;
};

/**
 * Bulk delete
 */
function deleteAdminUserInBulk() {
    idsArr = [];
    dataSel = $('#id_table_blog').bootstrapTable('getSelections');
    if(dataSel.length<1){
        msg("At least choose a line.");
        return;
    }
    for (i = 0; i < dataSel.length; i++) {
        var tmp = dataSel[i];
        var id = tmp.id;
        idsArr.push(id);
    }

    var dataObj = new Object();
    dataObj.ids = idsArr;

    // Note: contentType: 'application/json'must be added, otherwise JSON cannot be converted directly into an object in the controller
    $.ajax({
        type: "DELETE",
        url: "/admin/admin_use_delete.j",
        contentType: 'application/json',
        data: JSON.stringify(dataObj),
        success: function (result) {
            msg("Complete the Delete, just the user forever away from you");
            flushTable();
        },
        error:function () {
            msg("Delete failed");
        }
    });
}

/**
 * Add users
 */
function addAdminUser() {
    c_location("/admin/blogadd");
}

/**
 * Modify User
 */
function modifyAdminUser() {
    dataSel = $('#id_table_blog').bootstrapTable('getSelections');
    if (dataSel.length < 1) {
        msg("You haven't told me who to change.");
        return;
    }
    if (dataSel.length > 1) {
        msg("One is not enough for you to change?More options.");
    } else {
        id = dataSel[0].id;
        c_location("/admin/blogmodify/" + id);
    }
}