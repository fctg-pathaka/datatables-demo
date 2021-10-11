$(document).ready(function () {
    $('#slider').DataTable({
        ajax: {
            contentType: 'application/json',
            url: '/datatables/get-all-data',
            type: 'POST',
            data: function (d) {
                return JSON.stringify(d);
            }
        },
        serverSide: true,
        stateSave: true,
        bDestroy: true,
        processing: true,
        language: {
            processing: "<div class=\"spinner-border text-primary\" role=\"status\">\n" +
                "  <span class=\"sr-only\">Loading...</span>\n" +
                "</div>"
        },
        columns: [
            {
                data: 'id'
            },
            {
                data: 'name'
            },
            {
                data: 'description'
            },
            {
                data: 'id',
                render: function (data) {
                    return `<a href="/datatables/delete-datatables?id=`
                        + data + `"><i class="fa fa-trash fa-lg" id=` + data + `></i></a>`
                }
            },
            {
                data: 'id',
                render: function (data) {
                    return `<a href="/datatables/update-datatables?id=`
                        + data + `"><i class="fa fa-edit fa-lg" id=` + data + `></i></a>`
                }
            },
        ]
    });
})