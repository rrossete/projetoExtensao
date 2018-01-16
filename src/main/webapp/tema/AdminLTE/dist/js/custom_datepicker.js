//Date picker
$(function () {

    $('input[name="idade"]').attr('disabled', true);

    // $("input[name='nascimento'], input[name='dataInicial'], input[name='dataFinal']").daterangepicker({
    //         singleDatePicker: true,
    //         showDropdowns: true,
    //         drops: "down",
    //         opens: "center",
    //         locale: {
    //             format: 'DD/MM/YYYY',
    //             daysOfWeek: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
    //             monthNames: ['Janeiro', 'Fevereiro', 'Março', 'April', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    //             firstDay: 1
    //         }
    //     },
    //     function (start, end, label) {
    //         var years = moment().diff(start, 'years');
    //         $('input[name=idade]').val(years);
    //     }
    // );

    //Flat red color scheme for iCheck
    // $('input[type="checkbox"], input[type="radio"]').iCheck({
    $('input').iCheck({
        checkboxClass: 'icheckbox_flat-blue'

    });


});