$(document).ready(function () {
    var $j = jQuery.noConflict();
    $j("#boxServicos").hide();
    $j("#boxCadastro").hide();
    $j("#boxPrecos").hide();
    
    $j("#menuCadastro").on('click', function () {
        if ($j("#boxCadastro").attr("class") === "boxaberto") {
            $j("#boxCadastro").hide();
            $j("#boxPrecos").hide();
            $j("#boxCadastro").removeClass("boxaberto");
        } else {
            $j("#boxCadastro").show();
            $j("#boxCadastro").addClass("boxaberto");
        }
    });
    $j("#menuServicos").on('click', function () {
        if ($j("#boxServicos").attr("class") === "boxaberto") {
            $j("#boxServicos").hide();
            $j("#boxServicos").removeClass("boxaberto");
        } else {$j("#boxPrecos").hide();
            $j("#boxServicos").show();
            $j("#boxServicos").addClass("boxaberto");
        }
    });
    $j("#menuPreco").on('click', function () {
        if ($j("#boxPrecos").attr("class") === "boxaberto") {
            $j("#boxPrecos").hide();
            $j("#boxPrecos").removeClass("boxaberto");
        } else {
            $j("#boxPrecos").show();
            $j("#boxPrecos").addClass("boxaberto");
        }
    });
    
 //codigo do modal excluir objeto  
 var url = '';
$j('button[id*="btn_"]').on('click', function () {
    url = "http://localhost:8080/" + $j(this).attr('id').split("_")[1];
        alert(url);
});

$j('#ok_confirm').on('click', function () {
    document.location.href = url;
});

});



         