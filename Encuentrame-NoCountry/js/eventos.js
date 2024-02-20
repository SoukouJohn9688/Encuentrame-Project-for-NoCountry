document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendario');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        locale: 'es',
        initialView: 'dayGridMonth',
        events: [
            {
                title: 'Vacunación Gratuita',
                start: '2023-10-20',
                end: '2023-10-12',
            },
            {
                title: 'Peluquería Canina',
                start: '2023-11-05',
                end: '2023-12-07',
            }
        ],
        buttonText: {
            today: 'Hoy'
        },
        fixedWeekCount: false,
        height: 'auto',
    });
    calendar.render();

    

    var listaEventos = document.getElementById('lista-eventos');
    calendar.getEvents().forEach(function(event) {
        var eventoItem = document.createElement('li');
        eventoItem.textContent = event.title + ' - ' + event.start.toLocaleDateString();
        listaEventos.appendChild(eventoItem);
    });

    // document.querySelector('.fc-header-toolbar .fc-toolbar-chunk h2').style.textAlign = 'center';

});

