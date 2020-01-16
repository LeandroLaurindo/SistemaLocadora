/* global moment */

$(document).ready(function () {
    moment.locale('pt-BR');
    var table = $("#tabela-usuario").DataTable({
        searching: true;
                order: [[1, "asc"]],
        lengthMenu: [5, 10],
        processing: true,
        serverSide: true,
        reponsive: true,
        ajax: {
            url: "/usuarios/datatables/server",
            data: "data"
        },
        columns: [
            {data: "id"},
            {data: "login"},
            {orderable: false,
                data: "id",
                "render": function (id) {
                    return '<a class="btn btn-success btn-sm btn-block" href="/usuarios/editar/' +
                            id + '" role="button"><i class="fas fa-edit"></i></a>';
                }
            },
            {orderable: false,
                data: 'id',
                "render": function (id) {
                    return '<a class="btn btn-danger btn-sm btn-block" href="/usuarios/excluir/' +
                            id + '" role="button" data-toggle="modal" data-target="#confirm-modal"><i class="fas fa-times-circle"></i></a>';
                }
            }
        ]
    });
});