$("#nomecolaborador").autocomplete({
    position: { my : "left center", at: "left bottom", of:"#nomecolaborador" },
    source: function (request, response) {
        $.ajax({
            url: '/disponibilidadeHorario/get-usuario/'+$('#nomecolaborador').val(),
            method: 'GET',
            dataType: "json",
            success: function (data) {

                var arr = [];

                // Armazena no array
                $(data).each(function (key, value) {

                    arr.push({id: value.id, label: value.nome}); //Guardo apenas o nome,
                    //porém preciso passar o id para posterior resgate
                });
                response(arr);

            }
        });
    },
    minLength: 2,
    select: function (event, ui) {
        $("#usuario").val(ui.item.id);
        $("#nomecolaborador").val(ui.item.nome);

    },
    _resizeMenu: function() {
        var ul = this.menu.element;
        ul.outerWidth($("#nomecolaborador").outerWidth());
    }
});

$("#btn-carga").click(function () {
    if((!$.trim($("#hora_ini").val()).length)){
        $("#aviso").html(
            "<div class=\"alert alert-danger alert-dismissable\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>Informe o horário de início</div>"
    )
    }
    else if((!$.trim($("#hora_fim").val()).length)){
        $("#aviso").html(
            "<div class=\"alert alert-danger alert-dismissable\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>Informe o horário de término</div>"
        )
    }
    else if(!isHoraInicialMenorHoraFinal($("#hora_ini").val(),$("#hora_fim").val())){
        $("#aviso").html(
            "<div class=\"alert alert-danger alert-dismissable\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>A hora de início é maior que a de término</div>"
        );
    }
    else{
        $("#carga_horaria").val(diferencaHoras($("#hora_ini").val(),$("#hora_fim").val()))
    }
});

$("#form_disponibilidade").submit(function () {
    var tamanho = $("#usuario").val();
    if ((!$.trim(tamanho).length)) {
        $("#aviso").html(
            "<div class=\"alert alert-danger alert-dismissable\"><a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>Selecione o usuário</div>"
        )
        return false;
    }
})
function diferencaHoras(horaInicial, horaFinal)
{
    hIni = horaInicial.split(':');
    hFim = horaFinal.split(':');
    horasTotal = parseInt(hFim[0], 10) - parseInt(hIni[0], 10);
    minutosTotal = parseInt(hFim[1], 10) - parseInt(hIni[1], 10);
    if(minutosTotal < 0)
    {
        minutosTotal += 60; horasTotal -= 1;
    }
    horaFinal = completaZeroEsquerda(horasTotal) + ":" + completaZeroEsquerda(minutosTotal);
    return horaFinal;
}
function completaZeroEsquerda(total) {
    total = ("00" + total).slice(-2);
    return total;
}
/** * Verifica se a hora inicial é menor que a final. */
function isHoraInicialMenorHoraFinal(horaInicial, horaFinal)
{
    horaIni = horaInicial.split(':'); horaFim = horaFinal.split(':');

    // Verifica as horas. Se forem diferentes, é só ver se a inicial
    // é menor que a final.
    hIni = parseInt(horaIni[0], 10);
    hFim = parseInt(horaFim[0], 10);
    if(hIni !== hFim)
        return hIni < hFim;

    // Se as horas são iguais, verifica os minutos então.
    mIni = parseInt(horaIni[1], 10);
    mFim = parseInt(horaFim[1], 10);
    if(mIni !== mFim)
        return mIni < mFim;
}